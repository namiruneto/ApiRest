package com.example.demo.repository;

import com.example.demo.model.Company;
import com.example.demo.dto.CompanyVersionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    // Método para encontrar una empresa por su código
    Optional<Company> findByCodigoCompany(String codigoCompany);

    // Método para verificar si ya existe una empresa con ese nombre
    boolean existsByNameCompany(String nameCompany);

    // Método para buscar empresas cuyo nombre contenga el texto proporcionado, ignorando mayúsculas/minúsculas
    List<Company> findByNameCompanyContainingIgnoreCase(String nameCompany);

    // Consulta personalizada para obtener la versión de la empresa y la aplicación asociada
    @Query("SELECT new com.example.demo.dto.CompanyVersionDTO(c.codigoCompany, c.nameCompany, a.appName, v.version) " +
           "FROM Company c " +
           "INNER JOIN VersionCompany vc ON vc.company.id = c.id " +
           "INNER JOIN Version v ON v.versionId = vc.version.id " +
           "INNER JOIN Application a ON a.appId = v.application.appId " +
           "WHERE c.id = :id")
    List<CompanyVersionDTO> findCompanyVersionById(@Param("id") Long id);
}
