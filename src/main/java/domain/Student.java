package domain;

import javax.persistence.*;

/**
 * Created on 2016/5/5 14:07
 */

@Table(name = "ooo_student")
@Entity
public class Student {

	private Integer id;
	private String examNo;
	private String name;
	private String schoolName;
	private Integer chinese, math, physics, chemistry, biology, politis, history, geography, englishHear, english, totalScore;


	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getExamNo() {
		return examNo;
	}

	public void setExamNo(String examNo) {
		this.examNo = examNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}


	@Column(length = 10, columnDefinition = "int default 0", nullable = false)
	public Integer getChinese() {
		return chinese;
	}

	public void setChinese(Integer chinese) {
		this.chinese = chinese;
	}

	@Column(length = 10, columnDefinition = "int default 0", nullable = false)
	public Integer getMath() {
		return math;
	}

	public void setMath(Integer math) {
		this.math = math;
	}

	@Column(length = 10, columnDefinition = "int default 0", nullable = false)
	public Integer getPhysics() {
		return physics;
	}

	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	@Column(length = 10, columnDefinition = "int default 0", nullable = false)
	public Integer getChemistry() {
		return chemistry;
	}

	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	@Column(length = 10, columnDefinition = "int default 0", nullable = false)
	public Integer getBiology() {
		return biology;
	}

	public void setBiology(Integer biology) {
		this.biology = biology;
	}


	@Column(length = 10, columnDefinition = "int default 0", nullable = false)
	public Integer getPolitis() {
		return politis;
	}

	public void setPolitis(Integer politis) {
		this.politis = politis;
	}


	@Column(length = 10, columnDefinition = "int default 0", nullable = false)
	public Integer getHistory() {
		return history;
	}

	public void setHistory(Integer history) {
		this.history = history;
	}


	@Column(length = 10, columnDefinition = "int default 0", nullable = false)
	public Integer getGeography() {
		return geography;
	}

	public void setGeography(Integer geography) {
		this.geography = geography;
	}


	@Column(length = 10, columnDefinition = "int default 0", nullable = false)
	public Integer getEnglishHear() {
		return englishHear;
	}

	public void setEnglishHear(Integer englishHear) {
		this.englishHear = englishHear;
	}


	@Column(length = 10, columnDefinition = "int default 0", nullable = false)
	public Integer getEnglish() {
		return english;
	}

	public void setEnglish(Integer english) {
		this.english = english;
	}


	@Column(length = 10, columnDefinition = "int default 0", nullable = false)
	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Student() {
	}


	public Student(String examNo, String name, String schoolName, Integer chinese, Integer math, Integer physics, Integer chemistry, Integer biology, Integer politis, Integer history, Integer geography, Integer englishHear, Integer english, Integer totalScore) {
		this.examNo = examNo;
		this.name = name;
		this.schoolName = schoolName;
		this.chinese = chinese;
		this.math = math;
		this.physics = physics;
		this.chemistry = chemistry;
		this.biology = biology;
		this.politis = politis;
		this.history = history;
		this.geography = geography;
		this.englishHear = englishHear;
		this.english = english;
		this.totalScore = totalScore;
	}
}
