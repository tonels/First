package com.aust.first.service.impl;

import com.aust.first.dao.StuDao;
import com.aust.first.entity.Score;
import com.aust.first.entity.Student;
import com.aust.first.jpql.StuAndScore;
import com.aust.first.repository.JpqlRepository;
import com.aust.first.service.JpqlService;
import com.aust.first.util.StringUtil;
import com.aust.first.vo.StudentDTO;
import com.google.common.collect.Lists;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class JpqlServiceImpl implements JpqlService {

    @Autowired
    private JpqlRepository jpqlRepository;
    @Resource
    private StuDao stuDao;

    @Override
    public List<Student> s1() {
        return jpqlRepository.s1();
    }

    @Override
    public Page<Student> s1_1() {
        return jpqlRepository.s1_1(PageRequest.of(0, 2, Sort.Direction.ASC, "age"));
    }

    @Override
    public List<Student> s1_2(Integer age) {
        return jpqlRepository.s1_2(age);
    }

//    @Override
//    public List<Student> s1_4(String ages) {
//        String[] ageS = ages.split(",");
//        ArrayList<String> list = Lists.newArrayList();
//        for(String age:ageS){
//            list.add(age);
//        }
//        return jpqlRepository.s1_4(list);
//    }

    @Override
    public List<Student> s1_4(String ages) {
        String[] ageS = ages.split(",");
        List<Integer> list = new ArrayList<>();
        for (String age : ageS) {
            list.add(Integer.valueOf(age));
        }
        return jpqlRepository.s1_4(list);
    }

    @Override    //Lamda表达式
    public List<Student> s1_4_1(String ages) {
        List<Integer> list = Arrays.asList(ages.split(",")).stream()
                .map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        return jpqlRepository.s1_4(list);
    }

    //    @Override
//    public List<SnameVo> s1_5() {
//        return jpqlRepository.s1_5();
//    }

    @Override
    public List<StuAndScore> s1_6() {
        return jpqlRepository.s1_6();
    }

    @Override
    public List<Object[]> s1_61() {
        return jpqlRepository.s1_61();
    }

    @Override
    public List<Object[]> s1_62() {
        return jpqlRepository.s1_62();
    }


    @Override
    public List<String> s2() {
        return jpqlRepository.s2();
    }

    @Override
    public List<Student> s3() {
        return jpqlRepository.s3();
    }

    @Override
    public List<Student> s3_1() {
        return jpqlRepository.s3_1();
    }

    @Override
    public List<Object[]> s3_2() {
        return jpqlRepository.s3_2();
    }

    @Override
    public List<Student> s4() {         // 查全部的信息，没有组装条件
        Specification<Student> specification = new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                ArrayList<Predicate> predicates = Lists.newArrayList();
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return jpqlRepository.findAll(specification);
    }

    @Override
    public List<Student> s4_1(String sex) {
        Specification<Student> specification = new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {

                ArrayList<Predicate> predicates = Lists.newArrayList();
                if (!StringUtil.isNullStr(sex)) {
                    predicates.add(cb.like(root.get("sex"), sex));
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return jpqlRepository.findAll(specification);
    }

    @Override
    public List<Student> s4_2() {
        Specification<Student> specification = new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
                ArrayList<Predicate> predicates = Lists.newArrayList();
                Root<Score> root1 = query.from(Score.class);
                Predicate p1 = cb.equal(root.get("sid"), root1.get("sid"));
                predicates.add(p1);
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return jpqlRepository.findAll(specification);
        //select student0_.* from student student0_ cross join score score1_ where student0_.sid=score1_.sid
    }

    @Override
    public List<StudentDTO> s5() {
        return stuDao.queryVO();
    }
}
