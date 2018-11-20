package com.kelvin.how2jPractice.AnnotationSample.MimicHibernate;


//参考hibernate的 注解配置方式 ，自定义5个注解，分别对应hibernate中用到的注解：
//hibernate_annotation.MyEntity 对应 javax.persistence.Entity
//hibernate_annotation.MyTable 对应 javax.persistence.Table
//hibernate_annotation.MyId 对应 javax.persistence.Id
//hibernate_annotation.MyGeneratedValue 对应 javax.persistence.GeneratedValue
//hibernate_annotation.MyColumn 对应 javax.persistence.Column



//像以注解方式配置Product类 那样，在Hero类上运用这些自定义注解：
//当注解的方法是value的时候，给这个注解赋值时，本来应该是：
// 
//@MyColumn(value="name_")
// 
//
//现在可以简略一点，写为
// 
//@MyColumn("name_")
// 
//
//只有当名称是value的时候可以这样，其他名称如name,stratgy等不行

@MyEntity
@MyTable(name="hero_")
public class HibernateHero {
    private int id;
    private String name;
    private int damage;
    private int armor;
     
    @MyId
    @MyGeneratedValue(strategy = "identity")
    @MyColumn("id_")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @MyColumn("name_")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @MyColumn("damage_")
    public int getttttDamage() {
        return damage;
    }
    public void sethhhDamage(int damage) {
        this.damage = damage;
    }
    @MyColumn("armor_")
    public int getArmor() {
        return armor;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }
     
}
