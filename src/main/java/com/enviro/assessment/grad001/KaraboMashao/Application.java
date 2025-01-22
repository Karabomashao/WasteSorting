package com.enviro.assessment.grad001.KaraboMashao;

import com.enviro.assessment.grad001.KaraboMashao.model.Category;
import com.enviro.assessment.grad001.KaraboMashao.model.DisposalGuideline;
import com.enviro.assessment.grad001.KaraboMashao.model.WasteType;
import com.enviro.assessment.grad001.KaraboMashao.repository.CategoryRepository;
import com.enviro.assessment.grad001.KaraboMashao.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.KaraboMashao.repository.WasteTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	CommandLineRunner initializeDatabase(
			CategoryRepository categoryRepository,
			WasteTypeRepository wasteTypeRepository){
//			DisposalGuidelineRepository disposalGuidelineRepository) {
		return args -> {


			Category recyclable = categoryRepository.save(new Category("Recyclable", "test"));
			Category hazardous = categoryRepository.save(new Category("Hazardous", "test"));
			Category organic = categoryRepository.save(new Category("Organic", "test"));

			WasteType plastic = new WasteType();
			plastic.setTypeOfWaste("Plastic");
			plastic.setWasteExample("Plastic bottles");
			plastic.setCategory(recyclable); // Link to category

			WasteType glass = new WasteType();
			glass.setTypeOfWaste("Glass");
			glass.setWasteExample("Glass bottles");
			glass.setCategory(hazardous); // Link to category

			WasteType paper = new WasteType();
			paper.setTypeOfWaste("Paper");
			paper.setWasteExample("Newspapers");
			paper.setCategory(organic); // Link to category

			// Save the waste types
			wasteTypeRepository.save(plastic);
			wasteTypeRepository.save(glass);
			wasteTypeRepository.save(paper);

//			WasteType glass_ = new WasteType("Glass", "Glass bottles");
//
//			DisposalGuideline glassDisposal = new DisposalGuideline();
//			glassDisposal.setDisposalMethod("Throw in bin");
//			glassDisposal.setLocation("Glass centres");
//			glassDisposal.setCategory(recyclable);
//			glassDisposal.setWasteType(glass);

//			disposalGuidelineRepository.save(glassDisposal);

		};
	}
}
