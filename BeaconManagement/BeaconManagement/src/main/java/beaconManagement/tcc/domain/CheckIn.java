package beaconManagement.tcc.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "checkin", schema = "management")
public class CheckIn implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank
	private Calendar checkCalendar;

	private boolean status;

	public CheckIn() {
		super();
	}

	public CheckIn(Long id, Calendar checkCalendar, boolean status) {
		super();
		this.id = id;
		this.checkCalendar = checkCalendar;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_checkin_id")
	@SequenceGenerator(name = "sq_checkin_id", sequenceName = "management.SQ_CHECKIN_ID", initialValue = 1, allocationSize = 1)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getCheckCalendar() {
		return checkCalendar;
	}

	public void setCheckCalendar(Calendar checkCalendar) {
		this.checkCalendar = checkCalendar;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((checkCalendar == null) ? 0 : checkCalendar.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckIn other = (CheckIn) obj;
		if (checkCalendar == null) {
			if (other.checkCalendar != null)
				return false;
		} else if (!checkCalendar.equals(other.checkCalendar))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Check [id=" + id + ", checkCalendar=" + checkCalendar
				+ ", status=" + status + "]";
	}

}
