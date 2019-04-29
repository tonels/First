## 该包用于测试，开发级联关系的表结构，总结表设计时用到级联关系时的场景

## 还有关于一些自定义pojo映射，原生SQL和Hsql的映射关系处理，以及自定义输出映射，基于配置和注解两个方面的实现。

### 一、数据库到底用不用外键

1.1、大家共同观点：主键和索引是不可少的，不仅可以优化数据检索速度，开发人员还省不其它的工作;

1.2、矛盾焦点：数据库设计是否需要外键。这里有两个问题：一个是如何保证数据库数据的完整性和一致性；二是第一条对性能的影响。 


正方观点： 
1，由数据库自身保证数据一致性，完整性，更可靠，因为程序很难100％保证数据的完整性，而用外键即使在数据库服务器宕机或者出现其他问题的时候，也能够最大限度的保证数据的一致性和完整性。

eg：

1、数据库和应用是一对多的关系，Ａ应用会维护他那部分数据的完整性，系统一变大时，增加了Ｂ应用，Ａ和Ｂ两个应用也许是不同的开发团队来做的。他们如何协调保证数据的完整性，而且一年以后如果又增加了C应用呢？ 

2，有主外键的数据库设计可以增加ER图的可读性，这点在数据库设计时非常重要。 

3，外键在一定程度上说明的业务逻辑，会使设计周到具体全面。

反方观点： 
1，可以用触发器或应用程序保证数据的完整性 
2，过分强调或者说使用主键／外键会平添开发难度，导致表过多等问题 
3，不用外键时数据管理简单，操作方便，性能高（导入导出等操作，在insert, update, delete 数据的时候更快）eg:在海量的数据库中想都不要去想外键，试想，一个程序每天要insert数百万条记录，当存在外键约束的时候，每次要去扫描此记录是否合格，一般还不止一个字段有外键，这样扫描的数量是成级数的增长！我的一个程序入库在3个小时做完，如果加上外键，需要28个小时！ 

#### 结论
1、在大型系统中（性能要求不高，安全要求高），使用外键；在大型系统中（性能要求高，安全自己控制），不用外键；小系统随便，最好用外键；

2、用外键要适当，不能过分追求3，不用外键而用程序控制数据一致性和完整性时，应该写一层来保证，然后个个应用通过这个层来访问数据库；

3、外键设计时，对数据的保护更好，但也同时增加维护的难度，外键对应着一定的逻辑关系，维护相对复杂，还有会级联扫描，影响性能等原因，在表设计时，要充分考虑全面。

### 二、关于自定义pojo的映射关系


- 1.1、基于注解的方式，不推荐pojoz中，引入逻辑，依赖相关的东西。
```java
package com.aust.two.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Version;

import com.aust.two.value.BookValue;

@SqlResultSetMappings({
    @SqlResultSetMapping(
            name = "BookAuthorMapping",
            entities = {
                @EntityResult(
                        entityClass = Book.class,
                        fields = {
                            @FieldResult(name = "id", column = "id"),
                            @FieldResult(name = "title", column = "title"),
                            @FieldResult(name = "author", column = "author_id"),
                            @FieldResult(name = "version", column = "version")}),
                @EntityResult(
                        entityClass = Author.class,
                        fields = {
                            @FieldResult(name = "id", column = "authorId"),
                            @FieldResult(name = "firstName", column = "firstName"),
                            @FieldResult(name = "lastName", column = "lastName"),
                            @FieldResult(name = "version", column = "authorVersion")})}),
    @SqlResultSetMapping(
            name = "AuthorMapping",
            entities = @EntityResult(
                    entityClass = Author.class,
                    fields = {
                        @FieldResult(name = "id", column = "authorId"),
                        @FieldResult(name = "firstName", column = "firstName"),
                        @FieldResult(name = "lastName", column = "lastName"),
                        @FieldResult(name = "version", column = "version")})),
    @SqlResultSetMapping(
            name = "AuthorBookCountMapping",
            entities = @EntityResult(
                    entityClass = Author.class,
                    fields = {
                        @FieldResult(name = "id", column = "id"),
                        @FieldResult(name = "firstName", column = "firstName"),
                        @FieldResult(name = "lastName", column = "lastName"),
                        @FieldResult(name = "version", column = "version")}),
            columns = @ColumnResult(name = "bookCount", type = Long.class)),
    @SqlResultSetMapping(
            name = "BookValueMapping",
            classes = @ConstructorResult(
                    targetClass = BookValue.class,
                    columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "title"),
                        @ColumnResult(name = "version", type = Long.class),
                        @ColumnResult(name = "authorName")})),
    @SqlResultSetMapping(
            name = "BookValueAndEntityMapping",
            entities = {
                @EntityResult(
                        entityClass = Book.class,
                        fields = {
                            @FieldResult(name = "id", column = "id"),
                            @FieldResult(name = "title", column = "title"),
                            @FieldResult(name = "author", column = "author_id"),
                            @FieldResult(name = "version", column = "version")})},
            classes = @ConstructorResult(
                    targetClass = BookValue.class,
                    columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "title"),
                        @ColumnResult(name = "version", type = Long.class),
                        @ColumnResult(name = "authorName")}))
})
@Entity
public class Author implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
	
    @Version
    @Column(name = "version")
    private int version;

    @Column
    private String firstName;

    @Column
    private String lastName;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(final int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Author)) {
            return false;
        }
        Author other = (Author) obj;
        if (id != null) {
            if (!id.equals(other.id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (firstName != null && !firstName.trim().isEmpty()) {
            result += "firstName: " + firstName;
        }
        if (lastName != null && !lastName.trim().isEmpty()) {
            result += ", lastName: " + lastName;
        }
        return result;
    }
}

```

- 二、配置.xml映射文件，加载映射

- 三、是个有点复杂的东西