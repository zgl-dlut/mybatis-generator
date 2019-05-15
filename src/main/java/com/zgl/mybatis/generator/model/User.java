package com.zgl.mybatis.generator.model;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user")
public class User implements Serializable {
	@Id
	private String id;

	@Column(name = "user_name")
	private String userName;

	private String password;

	private String name;

	private Integer age;

	private Date birthday;

	private String sex;

	private static final long serialVersionUID = 1L;

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return user_name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", userName=").append(userName);
		sb.append(", password=").append(password);
		sb.append(", name=").append(name);
		sb.append(", age=").append(age);
		sb.append(", birthday=").append(birthday);
		sb.append(", sex=").append(sex);
		sb.append("]");
		return sb.toString();
	}

	public User(String id, String userName, String password, String name, Integer age, Date birthday, String sex) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.sex = sex;
	}

	public static void main(String[] args) {
		User user = new User("123", "zgl", "123", "zzz", 28, new Date(), "male");
		Class userClass = user.getClass();
		Field[] fields = userClass.getDeclaredFields();
		for (Field field : fields) {
			String key = field.getName();
			try {
				PropertyDescriptor descriptor = new PropertyDescriptor(key, userClass);
				Method method = descriptor.getReadMethod();
				Object value = method.invoke(userClass);
				System.out.println(key + ":" + value);
			} catch (IntrospectionException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
}