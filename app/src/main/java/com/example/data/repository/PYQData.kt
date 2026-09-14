package com.example.data.repository

import com.example.data.model.*

object PYQData {
    fun getPapers(): List<PreviousYearPaper> = listOf(
        PreviousYearPaper(
            id = "pyq_sci1_2024",
            year = "March 2024",
            subjectType = SubjectType.SCIENCE_1,
            title = "Maharashtra SSC Board Science & Technology Part 1",
            totalMarks = 40,
            timeAllowed = "2 Hours",
            questionSets = listOf(
                PaperSection(
                    sectionName = "Question 1 (A) - Choose Correct Alternative (5 Marks)",
                    totalMarks = 5,
                    instructions = "Choose the correct alternative and write its alphabet only.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "Q.1 (A)(i)",
                            questionText = "The value of acceleration due to gravity (g) is ________ at the poles.",
                            marks = 1,
                            modelAnswer = "Option (A): Maximum (9.832 m/s²)",
                            markingScheme = "1 mark for correct option letter and answer."
                        ),
                        PaperQuestion(
                            qNum = "Q.1 (A)(ii)",
                            questionText = "The device used for producing electric current is called a ________.",
                            marks = 1,
                            modelAnswer = "Option (B): Generator",
                            markingScheme = "1 mark."
                        ),
                        PaperQuestion(
                            qNum = "Q.1 (A)(iii)",
                            questionText = "Rusting of iron is an example of ________.",
                            marks = 1,
                            modelAnswer = "Option (C): Slow oxidation reaction / Corrosion",
                            markingScheme = "1 mark."
                        ),
                        PaperQuestion(
                            qNum = "Q.1 (A)(iv)",
                            questionText = "What is the SI unit of power of a lens?",
                            marks = 1,
                            modelAnswer = "Option (D): Dioptre (D)",
                            markingScheme = "1 mark."
                        ),
                        PaperQuestion(
                            qNum = "Q.1 (A)(v)",
                            questionText = "General molecular formula of Alkynes is ________.",
                            marks = 1,
                            modelAnswer = "Option (A): CₙH₂ₙ₋₂",
                            markingScheme = "1 mark."
                        )
                    )
                ),
                PaperSection(
                    sectionName = "Question 2 (A) - Give Scientific Reasons (Any 2) (4 Marks)",
                    totalMarks = 4,
                    instructions = "Solve any two questions. 2 marks each.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "Q.2 (A)(i)",
                            questionText = "Scientific Reason: Stars twinkle, but planets do not twinkle.",
                            marks = 2,
                            modelAnswer = "1. Stars are very distant and act as point sources of light. As their light passes through constantly moving layers of atmosphere of changing temperature and density, continuous atmospheric refraction causes the apparent position and intensity of light entering the eye to fluctuate, leading to twinkling.\n2. In contrast, planets are much closer to Earth and act as an extended collection of point sources. The fluctuations from individual points average out to zero, so overall brightness remains steady.",
                            markingScheme = "1 mark for explaining point source & refractive index change of stars; 1 mark for explaining extended source nature of planets."
                        ),
                        PaperQuestion(
                            qNum = "Q.2 (A)(ii)",
                            questionText = "Scientific Reason: Simple microscope is used for watch repairers.",
                            marks = 2,
                            modelAnswer = "1. A simple microscope consists of a convex lens of short focal length.\n2. When a small object is placed within the focal length (between optical center O and principal focus F₁), an erect, virtual, and magnified image is formed on the same side, allowing watchmakers to clearly see tiny screws and gears without straining their eyes.",
                            markingScheme = "1 mark for position between O and F; 1 mark for nature of image (erect, virtual, magnified)."
                        )
                    )
                ),
                PaperSection(
                    sectionName = "Question 3 - Answer Any Five (15 Marks)",
                    totalMarks = 15,
                    instructions = "Solve any five questions. 3 marks each.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "Q.3 (i)",
                            questionText = "State Kepler's three laws of planetary motion with the help of a neat diagram.",
                            marks = 3,
                            modelAnswer = "1. Kepler's First Law (Law of Orbits): The orbit of a planet is an ellipse with the Sun at one of the foci.\n2. Kepler's Second Law (Law of Areas): The line joining the planet and the Sun sweeps equal areas in equal intervals of time (A₁ = A₂ if t₁ = t₂).\n3. Kepler's Third Law (Law of Periods): The square of its period of revolution around the Sun is directly proportional to the cube of the mean distance of a planet from the Sun (T² ∝ r³ => T²/r³ = constant K).",
                            markingScheme = "1 mark each for statement of all three laws with mathematical expression."
                        ),
                        PaperQuestion(
                            qNum = "Q.3 (ii)",
                            questionText = "Explain the principle, construction, and working of an Electric Motor with a labeled diagram.",
                            marks = 3,
                            modelAnswer = "Principle: An electric motor operates on the principle that when a rectangular coil carrying current is placed in a magnetic field, a force acts on it which rotates the coil continuously (Fleming's Left Hand Rule).\nParts: Armature coil (ABCD), Strong Horseshoe Magnet (N-S), Split rings / Commutator (R₁, R₂), Carbon brushes (B₁, B₂), and DC battery.\nWorking: Current flows from A to B in one arm and C to D in other. Force on AB is downward and on CD is upward, creating torque that rotates coil anticlockwise. Split rings reverse current every half cycle, ensuring continuous unidirectional rotation.",
                            markingScheme = "1 mark for principle, 1 mark for components/construction, 1 mark for working explanation."
                        )
                    )
                )
            )
        ),
        PreviousYearPaper(
            id = "pyq_sci2_2024",
            year = "March 2024",
            subjectType = SubjectType.SCIENCE_2,
            title = "Maharashtra SSC Board Science & Technology Part 2",
            totalMarks = 40,
            timeAllowed = "2 Hours",
            questionSets = listOf(
                PaperSection(
                    sectionName = "Question 1 (A) - Objectives (5 Marks)",
                    totalMarks = 5,
                    instructions = "Choose the correct alternative.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "Q.1 (A)(i)",
                            questionText = "Transfer of genetic information from DNA to mRNA is called ________.",
                            marks = 1,
                            modelAnswer = "Transcription",
                            markingScheme = "1 mark."
                        ),
                        PaperQuestion(
                            qNum = "Q.1 (A)(ii)",
                            questionText = "At the end of glycolysis, ________ molecules of pyruvic acid are formed.",
                            marks = 1,
                            modelAnswer = "2 (Two)",
                            markingScheme = "1 mark."
                        ),
                        PaperQuestion(
                            qNum = "Q.1 (A)(iii)",
                            questionText = "Which bacterium decomposes oceanic hydrocarbon oil spills?",
                            marks = 1,
                            modelAnswer = "Alcanivorax borkumensis",
                            markingScheme = "1 mark."
                        )
                    )
                ),
                PaperSection(
                    sectionName = "Question 2 - Short Answers & Differences (6 Marks)",
                    totalMarks = 6,
                    instructions = "Solve any three.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "Q.2 (i)",
                            questionText = "Distinguish between: Mitosis and Meiosis.",
                            marks = 2,
                            modelAnswer = "1. Mitosis occurs in somatic cells and stem cells, producing 2 diploid (2n) identical daughter cells for growth and repair.\n2. Meiosis occurs in germ cells, producing 4 haploid (n) daughter cells with crossing over and genetic variation for gamete formation.",
                            markingScheme = "1 mark for each valid distinguishing point."
                        ),
                        PaperQuestion(
                            qNum = "Q.2 (ii)",
                            questionText = "Explain the role of Sacred Groves (Devrai) in environmental conservation.",
                            marks = 2,
                            modelAnswer = "Devrai are patches of forests preserved by tribal communities in the name of local deities. Since hunting, tree felling, and grazing are strictly prohibited by social and religious tradition, they act as natural biodiversity sanctuaries harboring rare flora and fauna.",
                            markingScheme = "2 marks for clear explanation."
                        )
                    )
                )
            )
        ),
        PreviousYearPaper(
            id = "pyq_math1_2024",
            year = "March 2024",
            subjectType = SubjectType.MATH_1,
            title = "Maharashtra SSC Board Mathematics Part 1 (Algebra)",
            totalMarks = 40,
            timeAllowed = "2 Hours",
            questionSets = listOf(
                PaperSection(
                    sectionName = "Question 1 (A) - Four Alternative Questions (4 Marks)",
                    totalMarks = 4,
                    instructions = "Choose correct alternative.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "Q.1 (A)(i)",
                            questionText = "For simultaneous equations in x and y, if D_x = 49, D_y = -63, D = 7, then what is x?",
                            marks = 1,
                            modelAnswer = "x = D_x / D = 49 / 7 = 7. Option (A): 7",
                            markingScheme = "1 mark for x = 7."
                        ),
                        PaperQuestion(
                            qNum = "Q.1 (A)(ii)",
                            questionText = "Which of the following is a quadratic equation?",
                            marks = 1,
                            modelAnswer = "x(x + 5) = 2  => x² + 5x - 2 = 0 (Degree is 2)",
                            markingScheme = "1 mark."
                        )
                    )
                ),
                PaperSection(
                    sectionName = "Question 2 - Activity & Problem Solving (8 Marks)",
                    totalMarks = 8,
                    instructions = "Complete the activities.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "Q.2 (i)",
                            questionText = "Find the 19th term of the A.P.: 7, 13, 19, 25, ...",
                            marks = 2,
                            modelAnswer = "Here a = 7, d = 13 - 7 = 6, n = 19.\nt_n = a + (n - 1)d\nt₁₉ = 7 + (19 - 1) × 6\nt₁₉ = 7 + 18 × 6 = 7 + 108 = 115.\nAnswer: 19th term is 115.",
                            markingScheme = "1 mark for formula & substitution, 1 mark for correct final answer 115."
                        )
                    )
                )
            )
        ),
        PreviousYearPaper(
            id = "pyq_math2_2024",
            year = "March 2024",
            subjectType = SubjectType.MATH_2,
            title = "Maharashtra SSC Board Mathematics Part 2 (Geometry)",
            totalMarks = 40,
            timeAllowed = "2 Hours",
            questionSets = listOf(
                PaperSection(
                    sectionName = "Question 1 (A) - MCQs (4 Marks)",
                    totalMarks = 4,
                    instructions = "Choose the correct alternative.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "Q.1 (A)(i)",
                            questionText = "If ΔABC ~ ΔPQR and AB : PQ = 4 : 5, then A(ΔABC) : A(ΔPQR) is:",
                            marks = 1,
                            modelAnswer = "A(ΔABC) / A(ΔPQR) = AB² / PQ² = 4² / 5² = 16 / 25. Option (B): 16 : 25",
                            markingScheme = "1 mark."
                        ),
                        PaperQuestion(
                            qNum = "Q.1 (A)(ii)",
                            questionText = "Find the distance of point P(-6, 8) from the origin.",
                            marks = 1,
                            modelAnswer = "d = √(x² + y²) = √((-6)² + 8²) = √(36 + 64) = √100 = 10 units. Option (C): 10",
                            markingScheme = "1 mark."
                        )
                    )
                ),
                PaperSection(
                    sectionName = "Question 3 - Theorems & Word Problems (9 Marks)",
                    totalMarks = 9,
                    instructions = "Solve with neat proofs.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "Q.3 (i)",
                            questionText = "Prove that: Lengths of two tangent segments drawn from an external point to a circle are equal.",
                            marks = 3,
                            modelAnswer = "Given: A circle with center O. P is an external point. PA and PB are tangents contacting at A and B.\nTo prove: PA = PB.\nConstruction: Draw seg OA, seg OB, and seg OP.\nProof: In right ΔOAP and right ΔOBP:\n1. seg OA ≅ seg OB (Radii of the same circle)\n2. seg OP ≅ seg OP (Common hypotenuse)\n3. ∠OAP = ∠OBP = 90° (Tangent theorem)\nTherefore, ΔOAP ≅ ΔOBP (Hypotenuse-side theorem)\nHence, seg PA ≅ seg PB (c.s.c.t.) => PA = PB. [Hence Proved]",
                            markingScheme = "1 mark for Given, To Prove & neat diagram; 1 mark for congruency of triangles; 1 mark for conclusion."
                        )
                    )
                )
            )
        ),
        // 2023 Marathi Paper
        PreviousYearPaper(
            id = "pyq_mar_2023",
            year = "March 2023",
            subjectType = SubjectType.MARATHI,
            title = "महाराष्ट्र राज्य मंडळ १० वी मराठी (कुमारभारती) बोर्ड पेपर",
            totalMarks = 80,
            timeAllowed = "3 Hours",
            questionSets = listOf(
                PaperSection(
                    sectionName = "विभाग ४ : भाषाभ्यास (व्याकरण व शब्दसंपत्ती)",
                    totalMarks = 16,
                    instructions = "सर्व व्याकरण कृती सोडवा.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "प्र. ४ (अ)(१)",
                            questionText = "समास ओळखा: 'पंचवटी'",
                            marks = 1,
                            modelAnswer = "द्विगु समास (पाच वडांचा समूह)",
                            markingScheme = "१ गुण."
                        ),
                        PaperQuestion(
                            qNum = "प्र. ४ (अ)(२)",
                            questionText = "अलंकार ओळखा: 'अमृताहुनि गोड नाम तुझे देवा.'",
                            marks = 2,
                            modelAnswer = "व्यतिरेक अलंकार (उपमेय देवाचे नाव हे उपमान अमृतापेक्षा श्रेष्ठ आहे).",
                            markingScheme = "२ गुण."
                        )
                    )
                )
            )
        ),
        // 2023 English Paper
        PreviousYearPaper(
            id = "pyq_eng_2023",
            year = "March 2023",
            subjectType = SubjectType.ENGLISH,
            title = "Maharashtra SSC Board English (Kumarbharati)",
            totalMarks = 80,
            timeAllowed = "3 Hours",
            questionSets = listOf(
                PaperSection(
                    sectionName = "Section I: Language Study & Grammar",
                    totalMarks = 10,
                    instructions = "Do as directed.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "Q.1 (A)",
                            questionText = "Change into indirect speech: The teacher said, 'Honesty is the best policy.'",
                            marks = 2,
                            modelAnswer = "The teacher said that honesty is the best policy. (Universal truth does not change tense).",
                            markingScheme = "2 marks."
                        )
                    )
                )
            )
        ),
        // 2022 History & Political Science
        PreviousYearPaper(
            id = "pyq_hist_2022",
            year = "March 2022",
            subjectType = SubjectType.HISTORY,
            title = "Maharashtra SSC Board History & Political Science",
            totalMarks = 40,
            timeAllowed = "2 Hours",
            questionSets = listOf(
                PaperSection(
                    sectionName = "Question 1 - Historiography & Media",
                    totalMarks = 5,
                    instructions = "Solve objective and short note questions.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "Q.1 (i)",
                            questionText = "Who is known as the father of modern historiography?",
                            marks = 1,
                            modelAnswer = "Voltaire",
                            markingScheme = "1 mark."
                        ),
                        PaperQuestion(
                            qNum = "Q.2",
                            questionText = "Explain the concept of Annales School of Historiography.",
                            marks = 2,
                            modelAnswer = "The Annales School was established by French historians at the beginning of the 20th century. It gave a new direction to historiography by asserting that history is not solely about great kings, wars, and politics, but also about climate, local people, agriculture, technology, trade, and psychology of historical periods.",
                            markingScheme = "2 marks for 2 structured points."
                        )
                    )
                )
            )
        ),
        // 2021 Geography (India & Brazil)
        PreviousYearPaper(
            id = "pyq_geo_2021",
            year = "March 2021",
            subjectType = SubjectType.GEOGRAPHY,
            title = "Maharashtra SSC Board Geography (India & Brazil)",
            totalMarks = 40,
            timeAllowed = "2 Hours",
            questionSets = listOf(
                PaperSection(
                    sectionName = "Question 1 - Physical Geography & Rivers",
                    totalMarks = 6,
                    instructions = "Give geographical reasons.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "Q.1",
                            questionText = "Why do dense evergreen forests thrive in the Amazon basin?",
                            marks = 3,
                            modelAnswer = "1. The Amazon basin lies directly in the equatorial belt where high temperature and intense convectional rainfall occur year-round.\n2. Abundant moisture and perennial sunshine stimulate dense, multi-layered vegetation called 'Selvas'.\n3. Because trees do not shed all their leaves simultaneously, the canopy remains eternally green.",
                            markingScheme = "1 mark per clear geographical reason."
                        )
                    )
                )
            )
        ),
        // 2020 10-Year Decadal Archive: Science 1
        PreviousYearPaper(
            id = "pyq_sci1_2020",
            year = "March 2020",
            subjectType = SubjectType.SCIENCE_1,
            title = "Maharashtra SSC Board Science 1 (Board Archives 2020)",
            totalMarks = 40,
            timeAllowed = "2 Hours",
            questionSets = listOf(
                PaperSection(
                    sectionName = "Physics & Chemistry Core",
                    totalMarks = 5,
                    instructions = "Solve numericals and laws.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "Q.1",
                            questionText = "State Dobereiner's Law of Triads with an example.",
                            marks = 2,
                            modelAnswer = "When three elements having similar chemical properties are arranged in increasing order of atomic masses, the atomic mass of the middle element is approximately equal to the mean atomic mass of the other two elements. Example: Li (6.9), Na (23), K (39.1). Mean = (6.9 + 39.1)/2 = 23 = Atomic mass of Na.",
                            markingScheme = "1 mark for statement, 1 mark for example with values."
                        )
                    )
                )
            )
        ),
        // 2019 10-Year Decadal Archive: Mathematics 1
        PreviousYearPaper(
            id = "pyq_math1_2019",
            year = "March 2019",
            subjectType = SubjectType.MATH_1,
            title = "Maharashtra SSC Board Algebra (Board Archives 2019)",
            totalMarks = 40,
            timeAllowed = "2 Hours",
            questionSets = listOf(
                PaperSection(
                    sectionName = "Linear Equations & Probability",
                    totalMarks = 5,
                    instructions = "Solve step-by-step.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "Q.1",
                            questionText = "Two coins are tossed simultaneously. Find the probability of getting at least one head.",
                            marks = 2,
                            modelAnswer = "Sample space S = {HH, HT, TH, TT}, n(S) = 4.\nEvent A: Getting at least one head = {HH, HT, TH}, n(A) = 3.\nP(A) = n(A) / n(S) = 3/4.",
                            markingScheme = "0.5 mark for S, 0.5 for A, 1 mark for formula & answer 3/4."
                        )
                    )
                )
            )
        ),
        // 2018 10-Year Decadal Archive: History
        PreviousYearPaper(
            id = "pyq_hist_2018",
            year = "March 2018",
            subjectType = SubjectType.HISTORY,
            title = "Maharashtra SSC Board History & Political Science (Decade 2018)",
            totalMarks = 40,
            timeAllowed = "2 Hours",
            questionSets = listOf(
                PaperSection(
                    sectionName = "Constitution & Social Movements",
                    totalMarks = 4,
                    instructions = "Answer the following.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "Q.1",
                            questionText = "Explain the objectives of the Right to Information (RTI) Act 2005.",
                            marks = 2,
                            modelAnswer = "1. To empower citizens to inspect governmental decisions and documents.\n2. To bring transparency, eliminate corruption, and make government accountable to public in democratic governance.",
                            markingScheme = "1 mark per clear point."
                        )
                    )
                )
            )
        ),
        // 2017 10-Year Decadal Archive: Geography
        PreviousYearPaper(
            id = "pyq_geo_2017",
            year = "March 2017",
            subjectType = SubjectType.GEOGRAPHY,
            title = "Maharashtra SSC Board Geography (Decade 2017)",
            totalMarks = 40,
            timeAllowed = "2 Hours",
            questionSets = listOf(
                PaperSection(
                    sectionName = "Population & Settlement",
                    totalMarks = 4,
                    instructions = "Distinguish between.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "Q.1",
                            questionText = "Distinguish between Nucleated and Dispersed Settlements in India.",
                            marks = 2,
                            modelAnswer = "1. Nucleated settlements are compact clusters of houses found in fertile river plains (Ganga plain), coastal tracts, and industrial centers with abundant water.\n2. Dispersed settlements consist of isolated, scattered homesteads found in rugged mountainous terrains (Himalayas, Rajasthan desert) with poor connectivity.",
                            markingScheme = "1 mark for each valid distinction."
                        )
                    )
                )
            )
        ),
        // 2016 10-Year Decadal Archive: Math 2
        PreviousYearPaper(
            id = "pyq_math2_2016",
            year = "March 2016",
            subjectType = SubjectType.MATH_2,
            title = "Maharashtra SSC Board Geometry (Decade 2016)",
            totalMarks = 40,
            timeAllowed = "2 Hours",
            questionSets = listOf(
                PaperSection(
                    sectionName = "Similarity & Geometric Mean",
                    totalMarks = 4,
                    instructions = "State and prove property.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "Q.1",
                            questionText = "State Property of Geometric Mean in a right-angled triangle.",
                            marks = 2,
                            modelAnswer = "In a right-angled triangle, the perpendicular segment to the hypotenuse from the opposite vertex is the geometric mean of the segments into which the hypotenuse is divided: BD² = AD × DC or BD = √(AD × DC).",
                            markingScheme = "1 mark for statement, 1 mark for formula."
                        )
                    )
                )
            )
        ),
        // 2015 10-Year Decadal Archive: Science 2
        PreviousYearPaper(
            id = "pyq_sci2_2015",
            year = "March 2015",
            subjectType = SubjectType.SCIENCE_2,
            title = "Maharashtra SSC Board Science 2 (Decade 2015)",
            totalMarks = 40,
            timeAllowed = "2 Hours",
            questionSets = listOf(
                PaperSection(
                    sectionName = "Genetics & Evolution Milestone",
                    totalMarks = 4,
                    instructions = "Answer the following.",
                    questions = listOf(
                        PaperQuestion(
                            qNum = "Q.1",
                            questionText = "State Lamarck's theory of evolution and give reasons why it was rejected.",
                            marks = 2,
                            modelAnswer = "Theory: Morphological changes occur due to use or disuse of organs, and acquired characters are transferred to subsequent generations.\nRejection: Although individual traits may be acquired during lifetime through exercise or environment, they are not incorporated into reproductive germ cell DNA; hence acquired characters cannot be inherited.",
                            markingScheme = "1 mark for principle, 1 mark for reason of rejection."
                        )
                    )
                )
            )
        )
    )
}
