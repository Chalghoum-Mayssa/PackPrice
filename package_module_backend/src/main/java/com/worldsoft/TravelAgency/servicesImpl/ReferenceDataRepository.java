package com.worldsoft.TravelAgency.servicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class ReferenceDataRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getCountries() {
        String sql = "SELECT id_pays AS id, l_pays AS name FROM prm_pays";
        return jdbcTemplate.queryForList(sql);
    }
    public List<Map<String, Object>> getEntite(Long id) {
        String sql = "SELECT id_entite AS id, ent_manager AS name FROM ref_entite WHERE id_pays = ?";
        return jdbcTemplate.queryForList(sql, id);
    }

    public List<Map<String, Object>> getRegions(Long id) {
        String sql = "SELECT id_region AS id, l_region AS name FROM prm_package_region WHERE id_pays = ?";
        return jdbcTemplate.queryForList(sql, id);
    }
    public List<Map<String, Object>> getMaxTourId() {
        String sql = "SELECT MAX(id_pack) AS id FROM pck_prm_package_tour";
        return jdbcTemplate.queryForList(sql);
    }



    public List<Map<String, Object>> getSuppliers() {
        String sql = "SELECT id_tiers AS id, tiers_name AS name FROM ref_tiers WHERE id_entite = 1 AND tiers_type = 'F'";
        return jdbcTemplate.queryForList(sql);
    }

    public List<Map<String, Object>> getPackageCategories() {
        String sql = "SELECT id_catpack AS id, cat_name AS name FROM prm_package_categorie";
        return jdbcTemplate.queryForList(sql);
    }
}