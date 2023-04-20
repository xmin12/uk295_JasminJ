package ch.noseryoung.supplier_295.domain.supplier;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    private SupplierService service;

    @Autowired
    public SupplierController(SupplierService service){
        this.service = service;
    }
    @GetMapping
    @PreAuthorize("hasAuthority('READ')")
    @Operation(summary = "Gets all suppliers", description = "This endpoint will get all of the suppliers in the database.")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok().body(service.getAllSuppliers());
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('READ')")
    @Operation(summary = "Gets supplier from given ID", description = "This endpoint will only return one supplier by the given ID")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok().body(service.getSupplierById(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE')")
    @Operation(summary = "Deletes supplier from given ID", description = "This endpoint deletes the supplier with the given ID")
    public void deleteSupplier(@PathVariable int id) {
        service.deleteSupplier(id);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException){
        return ResponseEntity.status(404).body("This product does not exist!");
    }
    @PostMapping
    @PreAuthorize("hasAuthority('CREATE')")
    @Operation(summary = "Creates supplier with data", description = "This endpoint creates a new supplier with the given information")
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return service.createSupplier(supplier);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE')")
    @Operation(summary = "Updates changes to supplier", description = "This endpoint only makes changes to the supplier by the given ID")
    public Supplier updateSupplier(@PathVariable int id, @RequestBody Supplier supplier) {
        supplier.setId(id);
        return service.updateSupplier(id, supplier);
    }

}
