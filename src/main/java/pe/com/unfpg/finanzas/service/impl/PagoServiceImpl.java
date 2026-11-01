
package pe.com.unfpg.finanzas.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.unfpg.finanzas.entity.PagoEntity;
import pe.com.unfpg.finanzas.repository.PagoRepository;
import pe.com.unfpg.finanzas.repository.OrdenPagoRepository;
import pe.com.unfpg.finanzas.service.PagoService;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepository repositorio;
    private final OrdenPagoRepository ordenPagoRepository;

    public PagoServiceImpl(
            PagoRepository repositorio,
            OrdenPagoRepository ordenPagoRepository) {

        this.repositorio = repositorio;
        this.ordenPagoRepository = ordenPagoRepository;
    }

    @Override
    public List<PagoEntity> findAll() {
        List<PagoEntity> pagos = repositorio.findAll();

        for (PagoEntity pago : pagos) {
            pago.setOrdenPago(
                ordenPagoRepository.findById(pago.getCodordpag()).get()
            );
        }

        return pagos;
    }

    @Override
    public List<PagoEntity> findAllCustom() {
        List<PagoEntity> pagos = repositorio.findAllCustom();

        for (PagoEntity pago : pagos) {
            pago.setOrdenPago(
                ordenPagoRepository.findById(pago.getCodordpag()).get()
            );
        }

        return pagos;
    }

    @Override
    public PagoEntity findById(Long id) {
        PagoEntity pago = repositorio.findById(id).get();

        pago.setOrdenPago(
            ordenPagoRepository.findById(pago.getCodordpag()).get()
        );

        return pago;
    }

    @Override
    public PagoEntity add(PagoEntity obj) {
        return repositorio.save(obj);
    }

    @Override
    public PagoEntity update(PagoEntity obj, Long id) {
        // Buscar el valor que se va a actualizar
        PagoEntity objpag = repositorio.findById(id).get();

        // Actualizamos los valores, sin pisar el codigo
        BeanUtils.copyProperties(obj, objpag, "codigo");

        return repositorio.save(objpag);
    }

    @Override
    public PagoEntity delete(Long id) {
        // Borrado logico: cambiamos el estado
        PagoEntity objpag = repositorio.findById(id).get();

        objpag.setEstado(false);

        return repositorio.save(objpag);
    }

    @Override
    public PagoEntity enable(Long id) {
        // Habilitar: cambiamos el estado
        PagoEntity objpag = repositorio.findById(id).get();

        objpag.setEstado(true);

        return repositorio.save(objpag);
    }
}
