package com.aust.first.dao;

import com.aust.first.util.StringUtil;
import com.aust.first.vo.StudentDTO;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StuDao {
    @Resource
    private EntityManager entityManager;

    private static Map<String, Type> typeMap = new HashMap<String, Type>(16);

    static{
        typeMap.put("sid", StandardBasicTypes.LONG);
        typeMap.put("sname", StandardBasicTypes.STRING);
        typeMap.put("totalgrade", StandardBasicTypes.INTEGER);
    }

    public List<StudentDTO> queryVO() {
        StringBuilder sb = new StringBuilder();

        String sql = "SELECT student.sid , student.sname , a.grade as totalgrade FROM "
                + "student LEFT JOIN( SELECT student.sid, SUM(score.grade) grade FROM "
                + "student LEFT JOIN score ON student.sid = score.sid GROUP BY student.sid) a ON student.sid = a.sid";

        sb.append(sql);

        Query createNativeQuery = this.entityManager.createNativeQuery(sb.toString());
        NativeQuery query = createNativeQuery.unwrap(NativeQuery.class);

        typeMap.forEach(query::addScalar);

        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(StudentDTO.class));

        return query.getResultList();
    }

}
