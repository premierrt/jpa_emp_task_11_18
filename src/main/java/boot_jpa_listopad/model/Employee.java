package boot_jpa_listopad.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Employee {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;

	public  Employee(String fN, String lN) {
		// TODO Auto-generated constructor stub
		firstName=fN;
		lastName=lN;
	}
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                })
	@JoinTable(
			name = "emp_task",
			joinColumns = {@JoinColumn(name="employee_id")},
			inverseJoinColumns= {@JoinColumn(name="task_id")}
			)
	private Collection<Task> tasks = new ArrayList<Task>();
	
}
