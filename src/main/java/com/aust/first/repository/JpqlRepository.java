package com.aust.first.repository;

import com.aust.first.entity.Student;
import com.aust.first.jpql.StuAndScore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpqlRepository extends JpaRepository<Student,Long>, JpaSpecificationExecutor<Student> {


 //JPQL 的查询示例
    @Query("SELECT s FROM Student s") // 常返回List<Student>
    List<Student> s1();

    @Query("SELECT s FROM Student s") // 常返回Page<Student>,按年龄排序
    Page<Student> s1_1(Pageable pageable);

    @Query("SELECT s FROM Student s where s.age > ?1") // 返回List<Student>,按照 Age 条件
    List<Student> s1_2(Integer age);

    @Query("SELECT s FROM Student s where s.age > :age") // List<Student>,按年龄排序,和 s1_2 一样的实现
    List<Student> s1_3(@Param("age") Integer age);

    @Query("SELECT s FROM Student s where s.age in ?1") // IN 查询，List<Student>
    List<Student> s1_4(List<Integer> age);

//    @Query("SELECT new com.aust.first.vo.JpqlVo.SnameVo(s.sname) FROM Student s") //调不通
//    List<SnameVo> s1_5();

    @Query("select st as Student, sc as Score from Student st left join Score sc on st.sid = sc.sid")
    List<StuAndScore> s1_6();

//    @Query("select st as Student, sc as Score from Student st left join Score sc on st.sid = sc.sid")
//    List<Object[]> s1_61();

    @Query("select st.sname,sc.grade from Student st left join Score sc on st.sid = sc.sid")
    List<Object[]> s1_61();

   @Query("select st.sid,st.sname,st.age,sc.grade from Student st left join Score sc on st.sid = sc.sid")
    List<Object[]> s1_62();

// 返回这个，没有映射字段名
// {
//        "code": "0",
//            "msg": "成功",
//            "result": [
//        [
//        2011,
//                "张三",
//                17,
//                68
//        ],
//        [
//        2011,
//                "张三",
//                17,
//                78
//        ]
//    ],
//        "success": true
//    }




    @Query("SELECT s FROM Student s") // 也是可以正常返回List<Student>
    List<String> s2();

//nativeQuery 的查询示例
    @Query(value = "SELECT *  FROM Student",nativeQuery = true) // 正常返回List<Student>
    List<Student> s3();

    @Query(value = "SELECT s.* FROM student s LEFT JOIN score sc ON s.sid = sc.sid ",nativeQuery = true) // 正常返回List<Student>
    List<Student> s3_1();

    @Query(value = "SELECT s.* FROM student s LEFT JOIN score sc ON s.sid = sc.sid ",nativeQuery = true) // 正常返回List<Student>
    List<Object[]> s3_2();   // 用 Object[] 数组接收只会接收字段的值的数组，没有字段信息，用Vo接收会报错




}
