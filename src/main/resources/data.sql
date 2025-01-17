INSERT INTO Waste_classification(classification_id, waste_classification, description)
VALUES
    (1, 'Hazardous', 'Pose a risk to health or the environment.'),
    (2, 'NON-HAZARDOUS', 'Does not pose a risk to health or the environment.'),
    (3, 'RECYCLABLE', 'Waste that can be processed for reuse'),
    (4, 'NON-RECYCLABLE', 'Waste that cannot be processed for reuse'),
    (5, 'E-WASTE', 'Electronic waste'),
    (6, 'ORGANIC WASTE', 'Biodegradable material'),
    (7, 'SPECIAL WASTE', 'Materials that require specific handling'),
    (8, 'CONSTRUCTION AND DEMOLITION WASTE', 'Debris and materials generated during the construction, renovation, or demolition of buildings and infrastructure');

INSERT INTO Hazardous_waste(waste_id, type_of_waste, waste_examples)
VALUES
    (1, 'Chemicals', 'Solvents (e.g., acetone, turpentine), Pesticides and herbicides, Industrial cleaners (e.g., chlorine, ammonia)'),
    (2, 'Heavy Metals', 'Lead (from old paints or contaminated soil), Mercury (from thermometers or old switches), Cadmium (often found in certain batteries or metal alloys)'),
    (3, 'Acids and Bases', 'Sulfuric acid (from industrial processes), Hydrochloric acid (from cleaning agents), Sodium hydroxide (used in cleaning and manufacturing)'),
    (4, 'Contaminated Oil', 'Used motor oil, Used oils from industrial machinery'),
    (5, 'Paints and Varnishes', 'Paint with lead or other toxic pigments, Solvent-based paints and coatings'),
    (6, 'Radioactive Waste', 'Spent nuclear fuel, Radioactive medical equipment');