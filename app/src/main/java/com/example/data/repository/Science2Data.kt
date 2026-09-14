package com.example.data.repository

import com.example.data.model.*

object Science2Data {
    fun getChapters(): List<Chapter> = listOf(
        Chapter(
            id = "sci2_ch1",
            chapterNumber = 1,
            title = "Heredity and Evolution",
            marathiTitle = "आनुवंशिकता व उत्क्रांती",
            subjectType = SubjectType.SCIENCE_2,
            summary = "Heredity and hereditary changes, Transcription, Translation and Translocation (Central Dogma), Evolution, Evidences of evolution (Morphological, Anatomical, Vestigial organs, Paleontological, Connecting links, Embryological), Darwin's theory of natural selection, Lamarckism, Speciation, and Human evolution.",
            keyFormulas = listOf(
                "Central Dogma: DNA ---Transcription---> mRNA ---Translation---> Proteins",
                "Start Codon: AUG (Methionine), Stop Codons: UAA, UAG, UGA",
                "Carbon Dating: Ratio between C-14 and C-12 in dead remains (Willard Libby)"
            ),
            importantLawsOrTheorems = listOf(
                "Darwin's Theory of Natural Selection: Survival of the fittest; organisms with favorable adaptations survive and reproduce.",
                "Lamarckism: Principle of use or disuse of organs and inheritance of acquired characters."
            ),
            fullNotesMarkdown = """
# Heredity and Evolution

## 1. Protein Synthesis
* **Transcription:** Synthesis of mRNA from DNA strand using RNA polymerase in cell nucleus.
* **Translation:** tRNA with complementary anticodon brings amino acids corresponding to triplet codons on mRNA.
* **Translocation:** Ribosome moves along mRNA from one end to other by distance of one triplet codon.

## 2. Evidences of Evolution
1. **Morphological:** Similarities in structure of mouth, nostrils, ear pinnae, hair.
2. **Anatomical:** Similar bone joints in human hand, cat's foreleg, whale flipper, bat wing.
3. **Vestigial Organs:** Degenerated or underdeveloped non-functional organs (e.g. Appendix, tail bone/coccyx, wisdom teeth, ear muscles).
4. **Paleontological:** Fossils preserved under earth. Carbon dating (C-14 / C-12 ratio).
5. **Connecting Links:** Peripatus (Annelida & Arthropoda), Duck-billed platypus (Reptiles & Mammals), Lungfish (Pisces & Amphibia).
6. **Embryological:** Extreme similarity in initial stages of vertebrate embryos.
            """.trimIndent(),
            htmlContent = """
<div style="font-family:sans-serif; padding:12px; color:#1e293b;">
  <h2 style="color:#059669;">Heredity & Evolution</h2>
  <div style="background:#ecfdf5; border-left:4px solid #10b981; padding:8px;">
    <strong>Central Dogma:</strong> DNA → mRNA → Amino Acid Chain (Protein)
  </div>
  <h3>Connecting Links Examples</h3>
  <ul>
    <li><strong>Duck-billed Platypus:</strong> Lays eggs like reptiles; has mammary glands and hair like mammals.</li>
    <li><strong>Lungfish:</strong> Fish that respires with lungs like amphibians.</li>
    <li><strong>Peripatus:</strong> Segmented body & thin cuticle (Annelida); tracheal respiration (Arthropoda).</li>
  </ul>
</div>
            """.trimIndent(),
            mindMapRoot = MindMapNode("mm_he1", "Heredity & Evolution", "Genetics & Origin", listOf(
                MindMapNode("mm_he2", "Protein Synthesis", "Transcription (DNA->mRNA)\nTranslation (mRNA->tRNA)\nTranslocation (Ribosome shift)"),
                MindMapNode("mm_he3", "Evidences of Evolution", "Morphological & Anatomical\nVestigial organs (Appendix)\nPaleontological (Fossils/C-14)\nConnecting links"),
                MindMapNode("mm_he4", "Theories & Human", "Darwin (Natural Selection)\nLamarckism (Acquired traits)\nHuman stages: Dryopithecus to Homo sapiens")
            )),
            questions = listOf(
                PracticeQuestion("q_he1", "Which of the following is a vestigial organ in humans?", listOf("Vermiform Appendix", "Heart", "Liver", "Kidney"), 0, "Appendix is non-functional in humans but functional in ruminants.")
            ),
            flashcards = listOf(
                Flashcard("fc_he1", "Triplet Codon Definition", "What is a triplet codon?", "The sequence of three nucleotides on mRNA that codes for a specific amino acid.")
            ),
            topperTips = listOf("Remember connecting links and their paired phyla: Peripatus, Platypus, and Lungfish!")
        ),
        Chapter(
            id = "sci2_ch2",
            chapterNumber = 2,
            title = "Life Processes in Living Organisms Part - 1",
            marathiTitle = "सजीवांमधील जीवनप्रक्रिया भाग - १",
            subjectType = SubjectType.SCIENCE_2,
            summary = "Living organisms and life processes, Living organisms and energy production (Cellular respiration: Glycolysis, TCA cycle/Krebs cycle, ETC), Energy from different food components, Cell division: an essential life process (Mitosis & Meiosis).",
            keyFormulas = listOf(
                "Energy from Carbohydrates: 4 kcal/g",
                "Energy from Proteins: 4 kcal/g",
                "Energy from Lipids/Fats: 9 kcal/g",
                "1 Molecule of Glucose on Aerobic Respiration yields 38 ATP molecules"
            ),
            importantLawsOrTheorems = listOf(
                "Cellular Respiration Stages: 1. Glycolysis (EMP pathway in Cytoplasm) 2. Krebs Cycle (TCA in Mitochondria) 3. Electron Transfer Chain Reaction.",
                "Mitosis produces 2 diploid (2n) identical daughter cells. Meiosis produces 4 haploid (n) genetically varied cells with crossing over."
            ),
            fullNotesMarkdown = "Detailed notes on Aerobic & Anaerobic respiration, ATP yield, and stages of Mitosis (Prophase, Metaphase, Anaphase, Telophase).",
            htmlContent = "<h3>Life Processes Part 1</h3><p>Glycolysis converts 1 glucose molecule into 2 pyruvic acid, 2 ATP, 2 NADH₂, and 2 H₂O.</p>",
            mindMapRoot = MindMapNode("mm_lp1", "Life Processes 1", "Energy & Cell Division", listOf(
                MindMapNode("mm_lp1_1", "Respiration", "Glycolysis (Cytoplasm)\nKrebs Cycle (Mitochondria)\nETC reaction -> 38 ATP"),
                MindMapNode("mm_lp1_2", "Food Nutrients", "Carbohydrates & Proteins: 4 kcal/g\nFats: 9 kcal/g"),
                MindMapNode("mm_lp1_3", "Cell Division", "Mitosis: PMAT (Somatic growth & repair)\nMeiosis: Gamete formation (Crossing over)")
            )),
            questions = listOf(PracticeQuestion("q_lp1", "In which phase of mitosis do chromosomes align at the equatorial plane?", listOf("Metaphase", "Prophase", "Anaphase", "Telophase"), 0, "During Metaphase, chromosomes arrange themselves completely along the equatorial plane.")),
            flashcards = listOf(Flashcard("fc_lp1", "Full form of ATP", "What is ATP?", "Adenosine Triphosphate, known as the energy currency of the cell.")),
            topperTips = listOf("Learn the flow chart of aerobic vs anaerobic respiration steps.")
        ),
        Chapter(
            id = "sci2_ch3",
            chapterNumber = 3,
            title = "Life Processes in Living Organisms Part - 2",
            marathiTitle = "सजीवांमधील जीवनप्रक्रिया भाग - २",
            subjectType = SubjectType.SCIENCE_2,
            summary = "Reproduction: Asexual reproduction (Binary fission, Multiple fission, Budding, Fragmentation, Regeneration, Vegetative propagation, Spore formation) and Sexual reproduction in plants & humans. Menstrual cycle, Gamete formation, IVF, Surrogacy, Sperm bank, and Reproductive health.",
            keyFormulas = listOf(
                "Male sex chromosome: XY (Determines gender of child)",
                "Female sex chromosome: XX",
                "Menstrual Cycle length: approx 28 to 30 days (controlled by FSH, LH, Estrogen, Progesterone)"
            ),
            importantLawsOrTheorems = listOf(
                "Double Fertilization in Angiosperms: One male gamete fuses with egg cell to form diploid zygote; second male gamete fuses with two polar nuclei to form triploid endosperm (3n)."
            ),
            fullNotesMarkdown = "Comprehensive notes on Plant reproduction (flower anatomy, pollination, fertilization) and Human male/female reproductive systems.",
            htmlContent = "<h3>Life Processes Part 2</h3><p>Double fertilization in plants: Syngamy (Zygote) + Triple fusion (Endosperm 3n).</p>",
            mindMapRoot = MindMapNode("mm_lp2_1", "Reproduction", "Asexual & Sexual", listOf(
                MindMapNode("mm_lp2_2", "Asexual", "Fission (Amoeba/Paramoecium)\nBudding (Yeast/Hydra)\nVegetative (Bryophyllum/Potato)"),
                MindMapNode("mm_lp2_3", "Sexual in Plants", "Calyx, Corolla, Androecium, Gynoecium\nPollination & Double fertilization"),
                MindMapNode("mm_lp2_4", "Sexual in Humans", "Male & Female reproductive systems\nMenstrual cycle hormones\nAssisted reproductive tech: IVF, Surrogacy")
            )),
            questions = listOf(PracticeQuestion("q_lp2", "Which hormones regulate the menstrual cycle?", listOf("FSH, LH, Estrogen, Progesterone", "Insulin, Glucagon", "Adrenaline, Thyroxine", "Testosterone, Melatonin"), 0, "FSH and LH from pituitary; Estrogen and Progesterone from ovary.")),
            flashcards = listOf(Flashcard("fc_lp2", "Pollination Definition", "What is pollination?", "Transfer of pollen grains from anther of a stamen to stigma of a carpel.")),
            topperTips = listOf("Be ready with labeled diagrams of a typical flower and female reproductive system.")
        ),
        Chapter(
            id = "sci2_ch4",
            chapterNumber = 4,
            title = "Environmental Management",
            marathiTitle = "पर्यावरणीय व्यवस्थापन",
            subjectType = SubjectType.SCIENCE_2,
            summary = "Ecosystem review, Environmental conservation, Relationship between environment and ecosystem, Biodiversity, Hotspots of biodiversity, Classification of threatened species (Endangered, Rare, Vulnerable, Indeterminate), Sacred Groves (Devrai), and Environmental laws.",
            keyFormulas = listOf(
                "Global biodiversity hotspots: 34 hotspots worldwide",
                "Hotspots in India: Western Ghats and Eastern Himalayas (Indo-Burma region)"
            ),
            importantLawsOrTheorems = listOf(
                "IUCN Red List Categories: Extinct, Critically Endangered, Endangered, Vulnerable, Rare, Indeterminate.",
                "Sacred Groves: Forest conserved in the name of God and considered sacred by indigenous communities."
            ),
            fullNotesMarkdown = "Notes on ecosystems, abiotic & biotic factors, environmental pollution, and biodiversity conservation.",
            htmlContent = "<h3>Environmental Management</h3><p>Sacred Groves (Devrai in Maharashtra) are traditional community protected forest sanctuaries.</p>",
            mindMapRoot = MindMapNode("mm_em1", "Environmental Mgmt", "Conservation & Ecology", listOf(
                MindMapNode("mm_em2", "Ecosystem", "Biotic & Abiotic components\nFood chain & Food web"),
                MindMapNode("mm_em3", "Threatened Species", "Endangered (Lion-tailed macaque)\nRare (Red panda)\nVulnerable (Tiger, Lion)"),
                MindMapNode("mm_em4", "Action", "Sacred Groves (Devrai)\nForest Conservation Act\nJadav Molai Payeng's Molai Forest")
            )),
            questions = listOf(PracticeQuestion("q_em1", "In Maharashtra, traditional sacred protected forest sanctuaries are known as:", listOf("Devrai", "Van Mahotsav", "Abhayaranya", "Gram Van"), 0, "Devrai are sacred groves conserved by local communities.")),
            flashcards = listOf(Flashcard("fc_em1", "Jadav Molai Payeng", "Who is Jadav Molai Payeng?", "The Forest Man of India, who single-handedly transformed a 1360-acre barren sandbar into a thriving forest (Molai jungle) in Assam.")),
            topperTips = listOf("Cite real examples like Jadav Payeng and Chipko movement in long answer conservation questions.")
        ),
        Chapter(
            id = "sci2_ch5",
            chapterNumber = 5,
            title = "Towards Green Energy",
            marathiTitle = "हरित ऊर्जेच्या दिशेने",
            subjectType = SubjectType.SCIENCE_2,
            summary = "Energy generation using thermal power, nuclear power, natural gas, hydroelectric power, wind energy, solar photovoltaic energy, and solar thermal power. Comparing green vs non-green energy sources and their environmental impacts.",
            keyFormulas = listOf(
                "Electromagnetic Induction: Michael Faraday",
                "Solar cell output: A silicon solar cell of area 1 cm² produces ~30 mA current and ~0.5 V potential difference"
            ),
            importantLawsOrTheorems = listOf(
                "Principle of Electromagnetic Induction: Whenever magnetic field around a conductor changes, a potential difference is induced across it.",
                "Green Energy: Energy from sources that are renewable and do not cause carbon pollution or greenhouse gas emissions."
            ),
            fullNotesMarkdown = "Detailed comparison of Thermal, Nuclear, Hydro, Wind, and Solar power plants with stage-by-stage energy transformation diagrams.",
            htmlContent = "<h3>Towards Green Energy</h3><p>Solar cells are made of Silicon semiconductors converting sunlight directly to electricity via photovoltaic effect.</p>",
            mindMapRoot = MindMapNode("mm_ge1", "Green Energy", "Sustainable Power", listOf(
                MindMapNode("mm_ge2", "Non-Green", "Thermal (Coal -> CO₂)\nNuclear (Uranium -> radioactive waste)"),
                MindMapNode("mm_ge3", "Green Renewable", "Hydroelectric (Potential energy of water)\nWind energy (Kinetic energy)\nSolar energy (Photovoltaic & Thermal)"),
                MindMapNode("mm_ge4", "Principle", "Turbine -> Generator -> Transformer -> Grid")
            )),
            questions = listOf(PracticeQuestion("q_ge1", "Which fuel is used in nuclear power stations for fission?", listOf("Uranium-235 or Plutonium-239", "Coal", "Natural Gas", "Thorium only"), 0, "U-235 undergoes controlled chain reaction fission in nuclear reactors.")),
            flashcards = listOf(Flashcard("fc_ge1", "Solar Cell Material", "What semiconductor material is predominantly used in solar photovoltaic cells?", "Silicon (Si).")),
            topperTips = listOf("Draw flow diagrams showing sequential energy conversion for each type of power station.")
        ),
        Chapter(
            id = "sci2_ch6",
            chapterNumber = 6,
            title = "Animal Classification",
            marathiTitle = "प्राण्यांचे वर्गीकरण",
            subjectType = SubjectType.SCIENCE_2,
            summary = "History of animal classification, Traditional vs New system (Robert Whittaker & Karl Woese), Criteria for new system (Organization levels, Symmetry, Coelom, Germ layers, Segmentation), 10 Phyla of non-chordates and Phylum Chordata subphyla and classes.",
            keyFormulas = listOf(
                "Non-Chordate Phyla: Porifera, Coelenterata, Platyhelminthes, Aschelminthes, Annelida, Arthropoda, Mollusca, Echinodermata, Hemichordata",
                "Chordata Classes: Cyclostomata, Pisces, Amphibia, Reptilia, Aves, Mammalia"
            ),
            importantLawsOrTheorems = listOf(
                "Coelom Types: Acoelomate (Platyhelminthes), Pseudocoelomate (Aschelminthes), Eucoelomate (Annelida onwards).",
                "Germ layers: Diploblastic (Porifera, Cnidaria) vs Triploblastic (Platyhelminthes onwards: Ectoderm, Mesoderm, Endoderm)."
            ),
            fullNotesMarkdown = "Classification criteria and characteristics of all 10 non-chordate phyla and classes of chordates with representative examples.",
            htmlContent = "<h3>Animal Classification</h3><p>Arthropoda is the largest animal phylum with chitinous exoskeleton and jointed appendages.</p>",
            mindMapRoot = MindMapNode("mm_ac1", "Animal Classification", "Kingdom Animalia", listOf(
                MindMapNode("mm_ac2", "Criteria", "Levels of organization\nSymmetry (Asymmetry, Radial, Bilateral)\nCoelom & Germ layers"),
                MindMapNode("mm_ac3", "Non-Chordates (10 Phyla)", "Porifera (Sponges)\nCnidaria (Hydra/Jellyfish)\nPlatyhelminthes (Tapeworm)\nAnnelida (Earthworm)\nArthropoda (Insects)\nMollusca (Octopus/Snail)\nEchinodermata (Starfish)"),
                MindMapNode("mm_ac4", "Chordates", "Notochord present\nClasses: Pisces, Amphibia, Reptilia, Aves, Mammalia")
            )),
            questions = listOf(PracticeQuestion("q_ac1", "Which is the largest phylum in the animal kingdom?", listOf("Arthropoda", "Mollusca", "Annelida", "Chordata"), 0, "Phylum Arthropoda contains the largest number of species (insects, crabs, spiders).")),
            flashcards = listOf(Flashcard("fc_ac1", "Bilateral Symmetry", "Define Bilateral Symmetry with an example.", "An imaginary single axis dividing the body into two equal identical halves (left and right). E.g., Humans, Earthworm, Fish.")),
            topperTips = listOf("Remember: Echinodermata has water vascular system and tube feet for locomotion!")
        ),
        Chapter(
            id = "sci2_ch7",
            chapterNumber = 7,
            title = "Introduction to Microbiology",
            marathiTitle = "ओळख सूक्ष्मजीवशास्त्राची",
            subjectType = SubjectType.SCIENCE_2,
            summary = "Applied microbiology, Industrial microbiology, Dairy products (Yogurt, Cheese), Probiotics, Bread making, Microbial enzymes, Bio-fuels, Microbial pollution control (Oil spills: Alcanivorax borkumensis), Bio-fertilizers, and Antibiotics.",
            keyFormulas = listOf(
                "Yogurt bacteria: Streptococcus thermophilus and Lactobacillus delbrueckii (1:1 ratio)",
                "Bacterium clearing marine oil spills: Alcanivorax borkumensis and Pseudomonas"
            ),
            importantLawsOrTheorems = listOf(
                "Probiotics: Active microbial food supplements (containing beneficial Lactobacillus, Bifidobacterium) that balance intestinal microflora."
            ),
            fullNotesMarkdown = "Detailed study of industrial fermentation, probiotics, microbial enzymes, and environmental bioremediation.",
            htmlContent = "<h3>Introduction to Microbiology</h3><p>Alcanivorax borkumensis bacteria are used to clean up oceanic hydrocarbon oil spills.</p>",
            mindMapRoot = MindMapNode("mm_mb1", "Microbiology", "Microbial Biotechnology", listOf(
                MindMapNode("mm_mb2", "Dairy & Food", "Yogurt (Lactobacillus)\nCheese (Rennet/Microbial protease)\nProbiotics & Bread (Saccharomyces)"),
                MindMapNode("mm_mb3", "Industrial Enzymes", "Eco-friendly biocatalysts replacing harsh chemicals"),
                MindMapNode("mm_mb4", "Bioremediation", "Sewage treatment\nOil spills (Alcanivorax borkumensis)\nMining bio-leaching")
            )),
            questions = listOf(PracticeQuestion("q_mb1", "Which bacterium is widely used to degrade marine crude oil spills?", listOf("Alcanivorax borkumensis", "Lactobacillus acidophilus", "Streptomyces", "Saccharomyces cerevisiae"), 0, "Alcanivorax borkumensis feeds on hydrocarbons and decomposes oil spills.")),
            flashcards = listOf(Flashcard("fc_mb1", "Probiotics Function", "Why are probiotics good for human health?", "They maintain the balance of intestinal microorganisms, increase good gut bacteria, and boost immunity.")),
            topperTips = listOf("Learn the table of organic acids, their producing microbes, and their food applications.")
        ),
        Chapter(
            id = "sci2_ch8",
            chapterNumber = 8,
            title = "Cell Biology and Biotechnology",
            marathiTitle = "पेशीविज्ञान आणि जैवतंत्रज्ञान",
            subjectType = SubjectType.SCIENCE_2,
            summary = "Cytology, Stem cells (Embryonic & Adult stem cells, Stem cell banks, Organ transplantation), Biotechnology and its applications in Agriculture (Bt Cotton, Golden Rice, Biofertilizers), Animal husbandry, Human health (Insulin, Vaccines, Gene therapy), White, Blue, and Green Revolutions.",
            keyFormulas = listOf(
                "Golden Rice: Gene for Beta-carotene (Vitamin A precursor) introduced",
                "Bt Cotton: Bacillus thuringiensis toxin gene against bollworm"
            ),
            importantLawsOrTheorems = listOf(
                "Pluripotency of Stem Cells: Ability of embryonic stem cells to differentiate into all 220 different specialized cell types of the human body.",
                "Organ Donation & Transplantation: Brain-dead person can donate cornea, kidneys, heart, liver, lungs to save lives."
            ),
            fullNotesMarkdown = "Notes on Stem cell therapy, cloning, recombinant DNA technology, and Agricultural revolutions.",
            htmlContent = "<h3>Cell Biology & Biotechnology</h3><p>Bt Cotton produces endotoxin lethal to bollworm pests, drastically cutting chemical pesticide usage.</p>",
            mindMapRoot = MindMapNode("mm_bt1", "Cell Bio & Biotech", "Modern Medical & Agro Science", listOf(
                MindMapNode("mm_bt2", "Stem Cells", "Embryonic (Pluripotent) & Adult\nStem cell therapy & Organ transplantation"),
                MindMapNode("mm_bt3", "Agri-Biotech", "Bt Cotton (Pest resistant)\nGolden Rice (Vitamin A enriched)\nBiofertilizers: Rhizobium & Azotobacter"),
                MindMapNode("mm_bt4", "Revolutions", "Green (Dr. Norman Borlaug & Dr. M.S. Swaminathan)\nWhite (Dr. Verghese Kurien)\nBlue (Aquaculture/Dr. Arun Krishnan)")
            )),
            questions = listOf(PracticeQuestion("q_bt1", "Golden rice was genetically engineered to synthesize high levels of:", listOf("Beta-carotene (Vitamin A)", "Vitamin C", "Iron", "Vitamin D"), 0, "Golden rice contains genes for beta-carotene synthesis to prevent night blindness.")),
            flashcards = listOf(Flashcard("fc_bt1", "Father of Green Revolution in India", "Who is revered as the Father of Green Revolution in India?", "Dr. M.S. Swaminathan.")),
            topperTips = listOf("Questions on uses of stem cells and principles of Green/White/Blue revolutions are frequent in Board exams.")
        ),
        Chapter(
            id = "sci2_ch9",
            chapterNumber = 9,
            title = "Social Health",
            marathiTitle = "सामाजिक आरोग्य",
            subjectType = SubjectType.SCIENCE_2,
            summary = "Factors affecting social health, Mental stress and management, Factors endangering social health (Addiction, Cyber crime, Incurable diseases), Communication media and excessive use of modern technology (Cyber addiction, selfie-cide), Stress management methods and helpline organizations.",
            keyFormulas = listOf(
                "IT Act: Information Technology Act 2000 (Amended 2008) Section 66 for cyber crimes",
                "Salem / Salaam Bombay Foundation & Childline: 1098"
            ),
            importantLawsOrTheorems = listOf(
                "WHO Definition of Health: A state of complete physical, mental, and social well-being, and not merely the absence of disease or infirmity."
            ),
            fullNotesMarkdown = "Notes on social health factors, cyber security, phone addiction, and positive stress busters (laughter clubs, hobbies, exercise).",
            htmlContent = "<h3>Social Health</h3><p>Laughter clubs, sports, and outdoor activities increase endorphin secretion, relieving mental stress.</p>",
            mindMapRoot = MindMapNode("mm_sh1", "Social Health", "Mental & Community Well-being", listOf(
                MindMapNode("mm_sh2", "Health Factors", "Financial status, clean surroundings, education, social relationships"),
                MindMapNode("mm_sh3", "Threats", "Substance abuse & addiction\nCyber crime & excessive screen time\nDepression & isolation"),
                MindMapNode("mm_sh4", "Stress Management", "Sports, music, yoga, counseling\nLaughter clubs\nHelpline: 1098")
            )),
            questions = listOf(PracticeQuestion("q_sh1", "Under which act are cyber crimes like unauthorized hacking and trolling penalized in India?", listOf("Information Technology Act 2000", "Consumer Protection Act", "Indian Penal Code 1860 only", "Right to Education Act"), 0, "IT Act 2000 (Section 66) covers electronic and cyber offenses.")),
            flashcards = listOf(Flashcard("fc_sh1", "Stress Busters", "Name three effective natural stress relievers.", "Physical exercise, outdoor games, pursuing hobbies (music, art, reading), and open communication with family.")),
            topperTips = listOf("Value-based questions are common from this chapter; give practical, thoughtful answers.")
        ),
        Chapter(
            id = "sci2_ch10",
            chapterNumber = 10,
            title = "Disaster Management",
            marathiTitle = "आपत्ती व्यवस्थापन",
            subjectType = SubjectType.SCIENCE_2,
            summary = "Disaster types (Natural vs Man-made, Geological, Biological), Effects of disaster, Scope and phases of disaster management (Pre-disaster preparedness & Post-disaster rehabilitation), First aid principles (RICE, ABC), Mock drills, and Disaster management authority structure (NDMA, SDMA, DDMA).",
            keyFormulas = listOf(
                "First Aid ABC: Airway, Breathing, Circulation",
                "Sprain Management RICE: Rest, Ice, Compression, Elevation",
                "Emergency Phone Numbers: Police 100, Fire 101, Ambulance 102, Disaster Helpline 108"
            ),
            importantLawsOrTheorems = listOf(
                "Disaster Management Act 2005: Established National Disaster Management Authority (NDMA) headed by the Prime Minister."
            ),
            fullNotesMarkdown = "Detailed guide on First Aid procedures, mock drills in schools, earthquake safety, and disaster response phases.",
            htmlContent = "<h3>Disaster Management</h3><p>First Aid rule for sprains is R.I.C.E.: Rest, Ice, Compression, Elevation.</p>",
            mindMapRoot = MindMapNode("mm_dm1", "Disaster Mgmt", "Preparedness & Relief", listOf(
                MindMapNode("mm_dm2", "Disaster Types", "Natural (Earthquake, Flood, Cyclone)\nMan-made (Industrial leakage, fire, wars)"),
                MindMapNode("mm_dm3", "Management Cycle", "Pre-disaster: Planning, Training, Mock drills\nPost-disaster: Rescue, Relief, Rehabilitation"),
                MindMapNode("mm_dm4", "First Aid", "ABC: Airway, Breathing, Circulation\nRICE: Rest, Ice, Compression, Elevation\nHelplines: 108 / 112")
            )),
            questions = listOf(PracticeQuestion("q_dm1", "What does 'RICE' stand for in immediate first aid for muscle sprain?", listOf("Rest, Ice, Compression, Elevation", "Run, Inhale, Calm, Eat", "Respiration, Injection, Clean, Exit", "Recovery, Immobilization, Cure, Emergency"), 0, "RICE = Rest the limb, Ice application, Compression bandage, Elevation above heart level.")),
            flashcards = listOf(Flashcard("fc_dm1", "Mock Drill Objective", "What is the primary purpose of conducting a Mock Drill?", "To evaluate the actual readiness and response time of people and emergency rescue teams during a simulated disaster.")),
            topperTips = listOf("Learn the administrative hierarchy: Prime Minister (NDMA) -> Chief Minister (SDMA) -> District Collector (DDMA).")
        )
    )
}
