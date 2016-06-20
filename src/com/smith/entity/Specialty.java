package com.smith.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Specialty")
public class Specialty {

	public Specialty()
	 {
		 users = new ArrayList<User>();
	 }
	 private static final long serialVersionUID = -7988799579036225137L;
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;
	    
	    @Column
	    private String name;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "area_ID", nullable = false)
	    private Area area;
	    
	    @OneToMany(fetch = FetchType.LAZY, mappedBy = "specialty")
		private List<User> users;

		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}

		public Area getArea() {
			return area;
		}

		public void setArea(Area area) {
			this.area = area;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
}
