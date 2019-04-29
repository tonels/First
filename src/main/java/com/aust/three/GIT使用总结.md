## 一、JPA的@ID生成策略(https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/jpa-primary-key.html)

@Table Table用来定义entity主表的name，catalog，schema等属性。 
属性说明： 

name：表名
catalog：对应关系数据库中的catalog
schema：对应关系数据库中的schema
UniqueConstraints：定义一个UniqueConstraint数组，指定需要建唯一约束的列.UniqueConstraint定义在Table或SecondaryTable元数据里，用来指定建表时需要建唯一约束的列。下面是指定2个字段要唯一约束.
通过annotation来映射hibernate实体的,基于annotation的hibernate主键标识为@Id, 
其生成规则由@GeneratedValue设定的.这里的@id和@GeneratedValue都是JPA的标准用法, 
JPA提供四种标准用法,由@GeneratedValue的源代码可以明显看出.

其中GenerationType:

### JPA提供的四种标准用法为TABLE,SEQUENCE,IDENTITY,AUTO.

- 1、TABLE：使用一个特定的数据库表格来保存主键。
- 2、SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列，会生成一个hibernate_sequence表，val = 1。
- 3、IDENTITY：主键由数据库自动生成（主要是自动增长型）
- 4、AUTO：主键由程序控制(也是默认的,在指定主键时，如果不指定主键生成策略，默认为AUTO)
四种数据库的支持情况如下：
 

数据库名称

支持的id策略

mysql

GenerationType.TABLE
GenerationType.AUTO
GenerationType.IDENTITY
不支持GenerationType.SEQUENCE

oracle

strategy=GenerationType.AUTO
GenerationType.SEQUENCE
GenerationType.TABLE
不支持GenerationType.IDENTITY

postgreSQL

GenerationType.TABLE
GenerationType.AUTO
GenerationType.IDENTITY
GenerationType.SEQUENCE
都支持

@GeneratedValue:主键的产生策略，通过strategy属性指定。

　　主键产生策略通过GenerationType来指定。GenerationType是一个枚举，它定义了主键产生策略的类型。

　　1、AUTO　自动选择一个最适合底层数据库的主键生成策略。如MySQL会自动对应auto increment。这个是默认选项，即如果只写@GeneratedValue，等价于@GeneratedValue(strategy=GenerationType.AUTO)。

　　2、IDENTITY　表自增长字段，Oracle不支持这种方式。

　　3、SEQUENCE　通过序列产生主键，MySQL不支持这种方式。

　　4、TABLE　通过表产生主键，框架借由表模拟序列产生主键，使用该策略可以使应用更易于数据库移植。不同的JPA实现商生成的表名是不同的，如 OpenJPA生成openjpa_sequence_table表，Hibernate生成一个hibernate_sequences表，而TopLink则生成sequence表。这些表都具有一个序列名和对应值两个字段，如SEQ_NAME和SEQ_COUNT。

　　在我们的应用中，一般选用@GeneratedValue(strategy=GenerationType.AUTO)这种方式，自动选择主键生成策略，以适应不同的数据库移植。

　　如果使用Hibernate对JPA的实现，可以使用Hibernate对主键生成策略的扩展，通过Hibernate的@GenericGenerator实现。

　　@GenericGenerator(name = "system-uuid", strategy = "uuid")　声明一个策略通用生成器，name为"system-uuid",策略strategy为"uuid"。

　　@GeneratedValue(generator = "system-uuid")　用generator属性指定要使用的策略生成器。

　　这是我在项目中使用的一种方式，生成32位的字符串，是唯一的值。最通用的，适用于所有数据库。


## 二、IDEA上GIT的相关操作