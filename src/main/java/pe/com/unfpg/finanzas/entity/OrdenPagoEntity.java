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
@Entity(name = "OrdenPagoEntity")
@Table(name = "ordenpago")
public class OrdenPagoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codordpag")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "fecordpag", nullable = false)
	private LocalDateTime fecha;

	@Column(name = "monto", precision = 10, scale = 2, nullable = false)
	private BigDecimal monto;

	@Column(name = "estordpag", nullable = false)
	private Boolean estado;

	// claves foraneas

	@Column(name = "codconp", nullable = false)
	private Long codconp;

	@Column(name = "nummat", nullable = false)
	private Long nummat;

	
	@Column(name = "codmetp", nullable = false)
	private Long codmetp;

	@Column(name = "codestp", nullable = false)
	private Long codestp;
	
	
	@Transient
	private Object conceptoPago;

	@Transient
	private Object matricula;

	@Transient
	private Object metodoPago;

	@Transient
	private Object estadoPago;
}