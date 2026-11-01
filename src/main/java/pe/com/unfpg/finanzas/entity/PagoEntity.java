package pe.com.unfpg.finanzas.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "PagoEntity")
@Table(name = "pago")
public class PagoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codpag")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "fecpag", nullable = false)
	private LocalDateTime fecha;

	@Column(name = "montopag", precision = 10, scale = 2, nullable = false)
	private BigDecimal monto;

	@Column(name = "estpag", nullable = false)
	private Boolean estado;

	// claves foraneas
	@Column(name = "codordpag", nullable = false)
	private Long codordpag;
	
	
	@Transient
	private Object ordenPago;
}