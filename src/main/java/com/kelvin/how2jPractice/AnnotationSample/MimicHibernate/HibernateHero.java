package com.kelvin.how2jPractice.AnnotationSample.MimicHibernate;


//�ο�hibernate�� ע�����÷�ʽ ���Զ���5��ע�⣬�ֱ��Ӧhibernate���õ���ע�⣺
//hibernate_annotation.MyEntity ��Ӧ javax.persistence.Entity
//hibernate_annotation.MyTable ��Ӧ javax.persistence.Table
//hibernate_annotation.MyId ��Ӧ javax.persistence.Id
//hibernate_annotation.MyGeneratedValue ��Ӧ javax.persistence.GeneratedValue
//hibernate_annotation.MyColumn ��Ӧ javax.persistence.Column



//����ע�ⷽʽ����Product�� ��������Hero����������Щ�Զ���ע�⣺
//��ע��ķ�����value��ʱ�򣬸����ע�⸳ֵʱ������Ӧ���ǣ�
// 
//@MyColumn(value="name_")
// 
//
//���ڿ��Լ���һ�㣬дΪ
// 
//@MyColumn("name_")
// 
//
//ֻ�е�������value��ʱ���������������������name,stratgy�Ȳ���

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
