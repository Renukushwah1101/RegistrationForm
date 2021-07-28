package com.renu.hibernate.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity(name="file")
	@Table(name="file")
	public class Files {
		@Id
		@Column(name = "id")
		int id;
		@Column(name=" userid")
		String userid;
		@Column(name="name ")
		String name;
		@Column(name="file ")
		String file;
		@Column(name="gender ")
		String gender;
		@Column(name="address ")
		String address;
		@Column(name="city ")
		String city;
		@Column(name="pin")
		String pin;
		@Column(name="state ")
		String state;
		@Column(name="email")
		String email;
		@Column(name=" contact")
		String contact;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getFile() {
			return file;
		}
		public void setFile(String file) {
			this.file = file;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getPin() {
			return pin;
		}
		public void setPin(String pin) {
			this.pin = pin;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		
		@Override
		public String toString() {
			return "Files [id=" + id + ", userid=" + userid + ", name=" + name + ", file=" + file + ", gender=" + gender
					+ ", address=" + address + ", city=" + city + ", pin=" + pin + ", state=" + state + ", email="
					+ email + ", contact=" + contact + "]";
		}

	
		public Files() {
		}
		public Files(String userid, String name, String file, String gender, String address, String city, String pin,
				String state, String email, String contact) {
			super();
			this.userid = userid;
			this.name = name;
			this.file = file;
			this.gender = gender;
			this.address = address;
			this.city = city;
			this.pin = pin;
			this.state = state;
			this.email = email;
			this.contact = contact;
		}
		public Files(int id, String userid, String name, String file, String gender, String address, String city,
				String pin, String state, String email, String contact) {
			super();
			this.id = id;
			this.userid = userid;
			this.name = name;
			this.file = file;
			this.gender = gender;
			this.address = address;
			this.city = city;
			this.pin = pin;
			this.state = state;
			this.email = email;
			this.contact = contact;
		}
		
		
		
	}

