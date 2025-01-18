package com.enviro.assessment.grad001.KaraboMashao.category;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    private final JdbcClient jdbcClient;
    public CategoryRepository(JdbcClient jdbcClient){
        this.jdbcClient= jdbcClient;
    }

    public List<Category> findAll(){
        return jdbcClient.sql("SELECT * FROM Waste_classification")
                .query(Category.class)
                .list();
    }

    public Optional<Category> findById(int id){
        return jdbcClient.sql("SELECT classification_id, waste_classification, description " +
                "FROM Waste_classification WHERE classification_id = :id")
                .param("id", id)
                .query(Category.class)
                .optional();
    }

    public List<WasteType> findAllTypes() {
        return jdbcClient.sql("""
            SELECT 
                wt.waste_id AS wasteId,
                wt.type_of_waste AS typeOfWaste,
                wt.waste_examples AS wasteExamples,
                wc.waste_classification AS wasteClassification,
                wc.description AS description
            FROM 
                Waste_Types wt
            INNER JOIN 
                Waste_classification wc
            ON 
                wt.classification_id = wc.classification_id
            """)
                .query(WasteType.class)
                .list();
    }

    public List<WasteType> search(String category) {
        return jdbcClient.sql("""
            SELECT
                wt.waste_id AS wasteId,
                wt.type_of_waste AS typeOfWaste,
                wt.waste_examples AS wasteExamples,
                wc.waste_classification AS wasteClassification,
                wc.description AS description
            FROM
                Waste_Types wt
            INNER JOIN
                 Waste_classification wc
            ON
                wt.classification_id = wc.classification_id
            WHERE
                wc.waste_classification = :category;
            """)
                .param("category", category)
                .query(WasteType.class)
                .list();
    }
}
