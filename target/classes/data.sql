INSERT INTO Waste_classification(waste_classification, description)
VALUES
    ('Hazardous', 'Pose a risk to health or the environment.'),
    ('NON-HAZARDOUS', 'Does not pose a risk to health or the environment.'),
    ('RECYCLABLE', 'Waste that can be processed for reuse'),
    ('NON-RECYCLABLE', 'Waste that cannot be processed for reuse'),
    ('E-WASTE', 'Electronic waste'),
    ('ORGANIC WASTE', 'Biodegradable material'),
    ('SPECIAL WASTE', 'Materials that require specific handling'),
    ('CONSTRUCTION AND DEMOLITION WASTE', 'Debris and materials generated during the construction, renovation, or demolition of buildings and infrastructure');

-- INSERT INTO Hazardous_waste(waste_id, type_of_waste, waste_examples)
-- VALUES
--     (1, 'Chemicals', 'Solvents (e.g., acetone, turpentine), Pesticides and herbicides, Industrial cleaners (e.g., chlorine, ammonia)'),
--     (2, 'Heavy Metals', 'Lead (from old paints or contaminated soil), Mercury (from thermometers or old switches), Cadmium (often found in certain batteries or metal alloys)'),
--     (3, 'Acids and Bases', 'Sulfuric acid (from industrial processes), Hydrochloric acid (from cleaning agents), Sodium hydroxide (used in cleaning and manufacturing)'),
--     (4, 'Contaminated Oil', 'Used motor oil, Used oils from industrial machinery'),
--     (5, 'Paints and Varnishes', 'Paint with lead or other toxic pigments, Solvent-based paints and coatings'),
--     (6, 'Radioactive Waste', 'Spent nuclear fuel, Radioactive medical equipment');
--
-- INSERT INTO Non_hazardous_waste(waste_id, type_of_waste, waste_examples)
-- VALUES
--     (1, 'Non-toxic Cleaning Products', 'Mild household cleaners (e.g., all-purpose cleaners without harsh chemicals), Soap (liquid or bar soap)'),
--     (2, 'Packaging Materials', 'Non-toxic plastic wrapping (not contaminated), Cardboard boxes (if not contaminated with hazardous substances)'),
--     (3, 'Textiles', 'Used clothing or fabrics that are not contaminated with hazardous materials, Towels, sheets, or blankets without chemical treatments'),
--     (4, 'Wood Waste', 'Untreated wood (not painted or stained with hazardous chemicals), Untreated wood (not painted or stained with hazardous chemicals)'),
--     (5, 'Furniture', 'Old furniture made of untreated wood, plastic, or fabric (not contaminated or treated with hazardous substances)'),
--     (6, 'Household Items', 'Empty containers that previously held non-hazardous items, Non-contaminated packaging foam (e.g., packing peanuts)'),
--     (7, 'Non-toxic Paint', 'Water-based paints that do not contain heavy metals or toxic solvents');
--
-- INSERT INTO Recyclable_waste(waste_id, type_of_waste, waste_examples)
-- VALUES
--     (1, 'Plastics', 'PET (Polyethylene Terephthalate) bottles and containers, HDPE (High-Density Polyethylene) bottles (e.g., milk cartons, detergent bottles)'),
--     (2, 'Metals', 'Aluminum cans (e.g., soda cans), Steel food cans (e.g., soup cans), Tin cans'),
--     (3, 'Glass', 'Glass bottles (e.g., wine or beer bottles), Glass jars (e.g., jam jars), Glass containers (if not contaminated with hazardous substances)'),
--     (4, 'Paper', 'Newspapers, Magazines'),
--     (5, 'Cardboard', 'Corrugated boxes (from shipping), Cardboard packaging (without hazardous or food contamination)'),
--     (6, 'Non-hazardous textiles', 'Clothes (that are not contaminated or treated with hazardous chemicals), Towels, sheets, and other fabrics made from cotton, polyester, or similar materials'),
--     (7, 'Tetra Paks and Cartons', 'Beverage cartons (e.g., juice boxes, milk cartons), Food packaging that can be recycled into new products');
--
-- INSERT INTO Non_recyclable_waste(waste_id, type_of_waste, waste_examples)
-- VALUES
--     (1, 'Plastic Bags', 'Single-use plastic bags (often not accepted by recycling programs)'),
--     (2, 'Food Contaminated Paper', 'Pizza boxes with grease or food waste, Napkins or paper towels with food residue'),
--     (3, 'Styrofoam', 'Polystyrene foam (e.g., foam cups, packaging peanuts)'),
--     (4, 'Ceramics and Pottery', 'Broken plates, mugs, or ceramic items that cannot be recycled through standard processes'),
--     (5, 'Tissues and Paper Towels', 'Used tissues or paper towels that have been contaminated with bodily fluids or other waste'),
--     (6, 'Soiled Cardboard', 'Cardboard that has been stained with oils, food, or hazardous materials that make it unsuitable for recycling'),
--     (7, 'Light Bulbs (non-fluorescent)', 'Incandescent bulbs (not including fluorescent or LED, which have special disposal methods)'),
--     (8, 'Wax-Coated Paper', 'Waxed paper used for wrapping or food packaging, which cannot be processed by most recycling systems'),
--     (9, 'Plastic Wrap', 'Cling film or plastic wrap often used for packaging that cannot be recycled with standard plastics');
--
-- INSERT INTO E_waste(waste_id, type_of_waste, waste_examples)
-- VALUES
--     (1, 'Old Computers', 'Desktops, Laptops, Computer monitors (CRT and flat screen)'),
--     (2, 'Mobile Phones', 'Old smartphones, Feature phones, Tablets'),
--     (3, 'Printers and Scanners', 'Inkjet or laser printers, Fax machines, Scanners'),
--     (4, 'Televisions', 'CRT TVs, Flat-screen or LED televisions'),
--     (5, 'Home Appliances', 'Microwaves, Refrigerators, Washing machines, Dishwashers'),
--     (6, 'VCRs and DVD Players', 'Old VCR players, DVD or Blu-ray players'),
--     (7, 'Batteries', 'Rechargeable batteries (e.g., from mobile phones, laptops), Old power tool batteries'),
--     (8, 'Cables and Chargers', 'Electrical cords, USB cables, Power adapters and chargers');
--
-- INSERT INTO Organic_waste(waste_id, type_of_waste, waste_examples)
-- VALUES
--     (1, 'Food Scraps', 'Fruit and vegetable peels, Coffee grounds, Eggshells, Leftover food (e.g., bread, rice, pasta)'),
--     (2, 'Yard Waste', 'Grass clippings, Leaves, Twigs and branches, Plant trimmings (flowers, bushes, etc.)'),
--     (3, 'Wood Waste', 'Untreated wood from trimming trees or bushes, Sawdust (from untreated wood)'),
--     (4, 'Manure', 'Animal waste from farms (e.g., cow, chicken, or horse manure)'),
--     (5, 'Biodegradable Packaging', 'Compostable food containers made from plant fibers (e.g., sugarcane or bamboo)'),
--     (6, 'Garden Waste', 'Dead plants or flowers, Weeds'),
--     (7, 'Compostable Items', 'Compostable plates, cups, and utensils (if made from biodegradable materials)');
--
-- INSERT INTO Special_waste(waste_id, type_of_waste, waste_examples)
-- VALUES
--     (1, 'Medical Waste', 'Contaminated needles and syringes, Bandages, gloves, and other medical supplies contaminated with bodily fluids, Expired medications or pharmaceutical products'),
--     (2, 'Industrial Byproducts', 'Sludge from wastewater treatment plants, Foundry sand from metal casting operations, Industrial oils and lubricants (if not classified as hazardous)'),
--     (3, 'Radioactive Waste', 'Spent nuclear fuel, Radioactive medical waste (e.g., from cancer treatment), Low-level radioactive waste from industrial or scientific equipment'),
--     (4, 'Construction Asbestos', 'Asbestos-containing materials from buildings or demolition sites (e.g., insulation, flooring)'),
--     (5, 'Waste from Hazardous Chemical Manufacturing', 'Residual waste from the production of chemicals that cannot be classified as hazardous but require special handling'),
--     (6, 'Contaminated Soil', 'Soil contaminated with hazardous chemicals, pesticides, or petroleum products (when it requires special treatment but does not meet hazardous waste criteria)'),
--     (7, 'Lead-Containing Waste', 'Lead-based paints and materials (in certain circumstances, especially in construction sites or older buildings)');
--
-- INSERT INTO Construction_and_demolition_waste(waste_id, type_of_waste, waste_examples)
-- VALUES
--     (1, 'Concrete', 'Broken concrete slabs, Concrete blocks, Concrete rubble from demolition'),
--     (2, 'Bricks', 'Old, unused, or broken bricks from construction or demolition sites'),
--     (3, 'Wood', 'Wood framing materials, Untreated wood from structures or furniture, Wooden doors and window frames'),
--     (4, 'Drywall', 'Gypsum boards from walls or ceilings (not containing hazardous materials like asbestos)'),
--     (5, 'Metal Scraps', 'Steel and iron beams, Metal roofing panels, Rebar from construction sites'),
--     (6, 'Glass', 'Window glass from old buildings, Glass panes from windows and doors'),
--     (7, 'Roofing Materials', 'Asphalt shingles, Tiles or ceramic roof materials'),
--     (8, 'Plumbing Materials', 'Old pipes (if not containing hazardous substances like lead), Fittings and fixtures from plumbing systems'),
--     (9, 'Insulation Materials', 'Non-toxic or non-asbestos insulation material (e.g., fiberglass, cellulose)'),
--     (10, 'Flooring Materials', 'Old tile flooring, Wood flooring, Carpet remnants');


INSERT INTO Waste_Types(type_of_waste, waste_examples, classification_id)
VALUES
    ('Chemicals', 'Solvents (e.g., acetone, turpentine), Pesticides and herbicides, Industrial cleaners (e.g., chlorine, ammonia)', 1),
    ('Heavy Metals', 'Lead (from old paints or contaminated soil), Mercury (from thermometers or old switches), Cadmium (often found in certain batteries or metal alloys)', 1),
    ('Acids and Bases', 'Sulfuric acid (from industrial processes), Hydrochloric acid (from cleaning agents), Sodium hydroxide (used in cleaning and manufacturing)', 1),
    ('Contaminated Oil', 'Used motor oil, Used oils from industrial machinery', 1),
    ('Paints and Varnishes', 'Paint with lead or other toxic pigments, Solvent-based paints and coatings', 1),
    ('Radioactive Waste', 'Spent nuclear fuel, Radioactive medical equipment', 1),
    ('Non-toxic Cleaning Products', 'Mild household cleaners (e.g., all-purpose cleaners without harsh chemicals), Soap (liquid or bar soap)', 2),
    ('Packaging Materials', 'Non-toxic plastic wrapping (not contaminated), Cardboard boxes (if not contaminated with hazardous substances)', 2),
    ('Textiles', 'Used clothing or fabrics that are not contaminated with hazardous materials, Towels, sheets, or blankets without chemical treatments', 2),
    ('Wood Waste', 'Untreated wood (not painted or stained with hazardous chemicals), Untreated wood (not painted or stained with hazardous chemicals)', 2),
    ('Furniture', 'Old furniture made of untreated wood, plastic, or fabric (not contaminated or treated with hazardous substances)', 2),
    ('Household Items', 'Empty containers that previously held non-hazardous items, Non-contaminated packaging foam (e.g., packing peanuts)', 2),
    ('Non-toxic Paint', 'Water-based paints that do not contain heavy metals or toxic solvents', 2),
    ('Plastics', 'PET (Polyethylene Terephthalate) bottles and containers, HDPE (High-Density Polyethylene) bottles (e.g., milk cartons, detergent bottles)', 3),
    ('Metals', 'Aluminum cans (e.g., soda cans), Steel food cans (e.g., soup cans), Tin cans', 3),
    ('Glass', 'Glass bottles (e.g., wine or beer bottles), Glass jars (e.g., jam jars), Glass containers (if not contaminated with hazardous substances)', 3),
    ('Paper', 'Newspapers, Magazines', 3),
    ('Cardboard', 'Corrugated boxes (from shipping), Cardboard packaging (without hazardous or food contamination)', 3),
    ('Non-hazardous textiles', 'Clothes (that are not contaminated or treated with hazardous chemicals), Towels, sheets, and other fabrics made from cotton, polyester, or similar materials', 3),
    ('Tetra Paks and Cartons', 'Beverage cartons (e.g., juice boxes, milk cartons), Food packaging that can be recycled into new products', 3),
    ('Plastic Bags', 'Single-use plastic bags (often not accepted by recycling programs)', 4),
    ('Food Contaminated Paper', 'Pizza boxes with grease or food waste, Napkins or paper towels with food residue', 4),
    ('Styrofoam', 'Polystyrene foam (e.g., foam cups, packaging peanuts)', 4),
    ('Ceramics and Pottery', 'Broken plates, mugs, or ceramic items that cannot be recycled through standard processes', 4),
    ('Tissues and Paper Towels', 'Used tissues or paper towels that have been contaminated with bodily fluids or other waste', 4),
    ('Soiled Cardboard', 'Cardboard that has been stained with oils, food, or hazardous materials that make it unsuitable for recycling', 4),
    ('Light Bulbs (non-fluorescent)', 'Incandescent bulbs (not including fluorescent or LED, which have special disposal methods)', 4),
    ('Wax-Coated Paper', 'Waxed paper used for wrapping or food packaging, which cannot be processed by most recycling systems', 4),
    ('Plastic Wrap', 'Cling film or plastic wrap often used for packaging that cannot be recycled with standard plastics', 4),
    ('Old Computers', 'Desktops, Laptops, Computer monitors (CRT and flat screen)', 5),
    ('Mobile Phones', 'Old smartphones, Feature phones, Tablets', 5),
    ('Printers and Scanners', 'Inkjet or laser printers, Fax machines, Scanners', 5),
    ('Televisions', 'CRT TVs, Flat-screen or LED televisions', 5),
    ('Home Appliances', 'Microwaves, Refrigerators, Washing machines, Dishwashers', 5),
    ('VCRs and DVD Players', 'Old VCR players, DVD or Blu-ray players', 5),
    ('Batteries', 'Rechargeable batteries (e.g., from mobile phones, laptops), Old power tool batteries', 5),
    ('Cables and Chargers', 'Electrical cords, USB cables, Power adapters and chargers', 5),
    ('Food Scraps', 'Fruit and vegetable peels, Coffee grounds, Eggshells, Leftover food (e.g., bread, rice, pasta)', 6),
    ('Yard Waste', 'Grass clippings, Leaves, Twigs and branches, Plant trimmings (flowers, bushes, etc.)', 6),
    ('Wood Waste', 'Untreated wood from trimming trees or bushes, Sawdust (from untreated wood)', 6),
    ('Manure', 'Animal waste from farms (e.g., cow, chicken, or horse manure)', 6),
    ('Biodegradable Packaging', 'Compostable food containers made from plant fibers (e.g., sugarcane or bamboo)', 6),
    ('Garden Waste', 'Dead plants or flowers, Weeds', 6),
    ('Compostable Items', 'Compostable plates, cups, and utensils (if made from biodegradable materials)', 6),
    ('Medical Waste', 'Contaminated needles and syringes, Bandages, gloves, and other medical supplies contaminated with bodily fluids, Expired medications or pharmaceutical products',7),
    ('Industrial Byproducts', 'Sludge from wastewater treatment plants, Foundry sand from metal casting operations, Industrial oils and lubricants (if not classified as hazardous)', 7),
    ('Radioactive Waste', 'Spent nuclear fuel, Radioactive medical waste (e.g., from cancer treatment), Low-level radioactive waste from industrial or scientific equipment', 7),
    ('Construction Asbestos', 'Asbestos-containing materials from buildings or demolition sites (e.g., insulation, flooring)', 7),
    ('Waste from Hazardous Chemical Manufacturing', 'Residual waste from the production of chemicals that cannot be classified as hazardous but require special handling', 7),
    ('Contaminated Soil', 'Soil contaminated with hazardous chemicals, pesticides, or petroleum products (when it requires special treatment but does not meet hazardous waste criteria)', 7),
    ('Lead-Containing Waste', 'Lead-based paints and materials (in certain circumstances, especially in construction sites or older buildings)', 7),
    ('Concrete', 'Broken concrete slabs, Concrete blocks, Concrete rubble from demolition', 8),
    ('Bricks', 'Old, unused, or broken bricks from construction or demolition sites', 8),
    ('Wood', 'Wood framing materials, Untreated wood from structures or furniture, Wooden doors and window frames', 8),
    ('Drywall', 'Gypsum boards from walls or ceilings (not containing hazardous materials like asbestos)', 8),
    ('Metal Scraps', 'Steel and iron beams, Metal roofing panels, Rebar from construction sites', 8),
    ('Glass', 'Window glass from old buildings, Glass panes from windows and doors', 8),
    ('Roofing Materials', 'Asphalt shingles, Tiles or ceramic roof materials', 8),
    ('Plumbing Materials', 'Old pipes (if not containing hazardous substances like lead), Fittings and fixtures from plumbing systems', 8),
    ('Insulation Materials', 'Non-toxic or non-asbestos insulation material (e.g., fiberglass, cellulose)', 8),
    ('Flooring Materials', 'Old tile flooring, Wood flooring, Carpet remnants', 8);


