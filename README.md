# JavaWeb20230206
JavaWeb20230206 東認 Java Web

# Web-JPA-MySQL
# 建立資料庫
CREATE DATABASE jpa CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

# 預設 JPA 設定檔路徑
src/main/resources/META-INF/persistence.xml
<pre>
&lt;?xml version="1.0" encoding="UTF-8"?&gt;
&lt;persistence version="1.0" xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/persistence  http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd"&gt;
    &lt;persistence-unit name="demo" transaction-type="RESOURCE_LOCAL"&gt;
        &lt;class&gt;ajax.entity.Employee&lt;/class&gt;
        &lt;!--這個元素指定是否排除未在配置文件中明確列出的實體類。如果設置為false（默認值），則未在persistence.xml中明確列出的實體類也會被JPA管理器自動掃描並添加到持久化單元中。--&gt;
        &lt;!--&lt;exclude-unlisted-classes&gt;false&lt;/exclude-unlisted-classes&gt;--&gt;
        &lt;properties&gt;
            &lt;property name="openjpa.jdbc.SynchronizeMappings" value="buildSchema(ForeignKeys=true)"/&gt;
            &lt;property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/&gt;
            &lt;property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/web?useSSL=false&amp;serverTimezone=Asia/Taipei"/&gt;
            &lt;property name="javax.persistence.jdbc.user" value="root"/&gt;
            &lt;property name="javax.persistence.jdbc.password" value="12345678"/&gt;
            &lt;property name="eclipselink.ddl-generation" value="create-or-extend-tables"/&gt;
        &lt;/properties&gt;
    &lt;/persistence-unit&gt;
&lt;/persistence&gt;
</pre>
