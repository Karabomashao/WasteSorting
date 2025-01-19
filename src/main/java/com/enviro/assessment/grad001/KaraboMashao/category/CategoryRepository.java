package com.enviro.assessment.grad001.KaraboMashao.category;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

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
                wt.classification_id AS classificationId, 
                wc.waste_classification AS wasteClassification
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
                wt.classification_id AS classificationId,
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

    public void deleteCategory(int id){
        var updated = jdbcClient.sql("DELETE FROM Waste_classification WHERE classification_id = :id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "Failed to delete category " + id);
    }

    public void createCategory(Category category){
        var updated = jdbcClient.sql("INSERT INTO Waste_classification(waste_classification, description) " +
                "VALUES(?, ?)")
                .params(List.of(category.waste_classification(), category.description()))
                .update();

        Assert.state(updated == 1, "Failed to create category " + category.waste_classification());
    }

    public void createWasteType(WasteType wasteType){

        var updated = jdbcClient.sql("INSERT INTO Waste_Types(type_of_waste, waste_examples, classification_id) " +
                        "VALUES(?, ?, ?)")
                .params(List.of(wasteType.type_of_waste(), wasteType.waste_examples(), wasteType.classification_id()))
                .update();

        Assert.state(updated == 1, "Failed to insert WasteType: " + wasteType.type_of_waste());
    }

    public void deleteWasteType(int id){
        var updated = jdbcClient.sql("DELETE FROM Waste_Types WHERE waste_id = :id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "Failed to delete waste type: " + id);
    }

    public void updateCategory(Category category, int id){
        var updated = jdbcClient.sql("UPDATE Waste_classification SET waste_classification = ?, description = ? WHERE classification_id = ?")
                .params(List.of(category.waste_classification(), category.description(), id))
                .update();

        Assert.state(updated == 1, "Failed to updated category: " + id);
    }

    public void updateWasteType(WasteType wasteType, int id){
        var updated = jdbcClient.sql("UPDATE Waste_Types SET type_of_waste = ?, waste_examples = ?, classification_id = ? WHERE waste_id = ?")
                .params(List.of(wasteType.type_of_waste(), wasteType.waste_examples(), wasteType.classification_id(), id))
                .update();

        Assert.state(updated == 1, "Failed to updated WasteType: " + id);
    }
}
