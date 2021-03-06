package beaconManagement.tcc.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Wagner
 */
@Entity
@Table(name = "checkin", schema = "management")
public class CheckIn implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property name="id"
	 */
	private Long id;

	/**
	 * @uml.property name="checkDateMillis"
	 */
	@NotNull
	private BigDecimal checkDateMillis;

	/**
	 * @uml.property name="beaconEvent"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	private BeaconEvent beaconEvent;

	/**
	 * @uml.property name="beaconDetector"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	private BeaconDetector beaconDetector;

	/**
	 * @uml.property name="beacon"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	private Beacon beacon;

	public CheckIn() {
		super();
	}

	public CheckIn(Long id, BigDecimal checkDateMillis,
			BeaconEvent beaconEvent, BeaconDetector beaconDetector,
			Beacon beacon) {
		super();
		this.id = id;
		this.checkDateMillis = checkDateMillis;
		this.beaconEvent = beaconEvent;
		this.beaconDetector = beaconDetector;
		this.beacon = beacon;
	}

	/**
	 * @return
	 * @uml.property name="id"
	 */
	@Id
	@Column(name = "checkin_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_checkin_id")
	@SequenceGenerator(name = "sq_checkin_id", sequenceName = "management.SQ_CHECKIN_ID", initialValue = 1, allocationSize = 1)
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 * @uml.property name="id"
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return
	 * @uml.property name="checkDateMillis"
	 */
	public BigDecimal getCheckDateMillis() {
		return checkDateMillis;
	}

	public void setCheckDateMillis(BigDecimal checkDateMillis) {
		this.checkDateMillis = checkDateMillis;
	}

	/**
	 * @return
	 * @uml.property name="beaconEvent"
	 */
	@ManyToOne
	@JoinColumn(name = "beaconevent_id")
	public BeaconEvent getBeaconEvent() {
		return beaconEvent;
	}

	/**
	 * @param beaconEvent
	 * @uml.property name="beaconEvent"
	 */
	public void setBeaconEvent(BeaconEvent beaconEvent) {
		this.beaconEvent = beaconEvent;
	}

	/**
	 * @return
	 * @uml.property name="beaconDetector"
	 */
	@ManyToOne
	@JoinColumn(name = "beacondetector_id")
	public BeaconDetector getBeaconDetector() {
		return beaconDetector;
	}

	/**
	 * @param beaconDetector
	 * @uml.property name="beaconDetector"
	 */
	public void setBeaconDetector(BeaconDetector beaconDetector) {
		this.beaconDetector = beaconDetector;
	}

	/**
	 * @return
	 * @uml.property name="beacon"
	 */
	@ManyToOne
	@JoinColumn(name = "beacon_id")
	public Beacon getBeacon() {
		return beacon;
	}

	/**
	 * @param beacon
	 * @uml.property name="beacon"
	 */
	public void setBeacon(Beacon beacon) {
		this.beacon = beacon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beacon == null) ? 0 : beacon.hashCode());
		result = prime * result
				+ ((beaconDetector == null) ? 0 : beaconDetector.hashCode());
		result = prime * result
				+ ((beaconEvent == null) ? 0 : beaconEvent.hashCode());
		result = prime * result
				+ ((checkDateMillis == null) ? 0 : checkDateMillis.hashCode());
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
		if (beacon == null) {
			if (other.beacon != null)
				return false;
		} else if (!beacon.equals(other.beacon))
			return false;
		if (beaconDetector == null) {
			if (other.beaconDetector != null)
				return false;
		} else if (!beaconDetector.equals(other.beaconDetector))
			return false;
		if (beaconEvent == null) {
			if (other.beaconEvent != null)
				return false;
		} else if (!beaconEvent.equals(other.beaconEvent))
			return false;
		if (checkDateMillis == null) {
			if (other.checkDateMillis != null)
				return false;
		} else if (!checkDateMillis.equals(other.checkDateMillis))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CheckIn [id=" + id + ", checkDateMillis=" + checkDateMillis
				+ ", beaconEvent=" + beaconEvent + ", beaconDetector="
				+ beaconDetector + ", beacon=" + beacon + "]";
	}

}
