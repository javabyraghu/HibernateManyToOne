package in.nit.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="depttab")
public class Dept {
	@Id
	@Column(name="dpt_id")
	@NonNull
	private Integer deptId;
	
	@Column(name="dpt_code")
	@NonNull
	private String deptCode;
	
	@Column(name="dpt_adm_name")
	@NonNull
	private String deptAdmin;
	
	@OneToMany(mappedBy = "deptOb",fetch = FetchType.EAGER)
	private List<Employee> emps;
}
