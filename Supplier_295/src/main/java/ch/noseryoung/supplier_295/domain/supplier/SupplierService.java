package ch.noseryoung.supplier_295.domain.supplier;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.List;
@Log4j2
@Service
public class SupplierService {
    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(int id) {
        return supplierRepository.findById(id).orElseThrow();
    }

    public void deleteSupplier(int id) {
        supplierRepository.deleteById(id);
    }

    public Supplier updateSupplier(int id, Supplier supplier) {
        Supplier existingProduct = supplierRepository.findById(id).orElseThrow();
        existingProduct.setName(supplier.getName());
        existingProduct.setPhonenumber(supplier.getPhonenumber());
        return supplierRepository.save(existingProduct);
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
}
