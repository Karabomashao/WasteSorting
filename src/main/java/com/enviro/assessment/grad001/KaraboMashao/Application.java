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
			WasteTypeRepository wasteTypeRepository,
			DisposalGuidelineRepository disposalGuidelineRepository){
		return args -> {


			Category recyclable = categoryRepository.save(new Category("Recyclable",
					"Materials that can be processed and reused"));
			Category hazardous = categoryRepository.save(new Category("Hazardous",
					"Waste that poses substantial or potential threats to public health or the environment"));
			Category organic = categoryRepository.save(new Category("Organic",
					"Biodegradable waste that comes from living organisms, such as food scraps, yard clippings, and paper."));

			WasteType paper = new WasteType();
			paper.setTypeOfWaste("Paper");
			paper.setWasteExample("newspapers, magazines, cardboard");
			paper.setCategory(recyclable); // Link to category

			WasteType battery = new WasteType();
			battery.setTypeOfWaste("Batteries");
			battery.setWasteExample("lithium-ion");
			battery.setCategory(hazardous); // Link to category

			WasteType yard_trimmings = new WasteType();
			yard_trimmings.setTypeOfWaste("Yard trimmings");
			yard_trimmings.setWasteExample("grass");
			yard_trimmings.setCategory(organic); // Link to category

			// Save the waste types
			wasteTypeRepository.save(battery);
			wasteTypeRepository.save(yard_trimmings);
			wasteTypeRepository.save(paper);

//
			DisposalGuideline batteryDisposal = new DisposalGuideline();
			batteryDisposal.setDisposalMethod("Should not be thrown in regular trash");
			batteryDisposal.setLocation("Dedicated recycling centers");
			batteryDisposal.setWasteType(battery);

			disposalGuidelineRepository.save(batteryDisposal);

		};
	}
}
