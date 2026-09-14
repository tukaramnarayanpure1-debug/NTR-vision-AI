package com.example.data.repository

import com.example.data.model.*

object Science1Data {
    fun getChapters(): List<Chapter> = listOf(
        Chapter(
            id = "sci1_ch1",
            chapterNumber = 1,
            title = "Gravitation",
            marathiTitle = "गुरुत्वाकर्षण",
            subjectType = SubjectType.SCIENCE_1,
            summary = "Discovery of gravitation by Sir Isaac Newton, circular motion and centripetal force, Kepler's laws of planetary motion, Newton's universal law of gravitation, acceleration due to gravity (g), free fall, and escape velocity.",
            keyFormulas = listOf(
                "Universal Gravitation: F = G · (m₁ · m₂) / r²",
                "Value of G: 6.673 × 10⁻¹¹ N·m²/kg²",
                "Acceleration due to gravity: g = GM / R² ≈ 9.8 m/s²",
                "Kinematic Equations: v = u + gt, s = ut + ½gt², v² = u² + 2gs",
                "Escape Velocity: v_esc = √(2GM / R) = √(2gR) ≈ 11.2 km/s"
            ),
            importantLawsOrTheorems = listOf(
                "Kepler's 1st Law: Orbit of a planet is an ellipse with the Sun at one focus.",
                "Kepler's 2nd Law: Line joining planet and Sun sweeps equal areas in equal intervals of time.",
                "Kepler's 3rd Law: T² ∝ r³ (Square of orbital period is proportional to cube of mean distance).",
                "Newton's Law: Every object attracts every other object with a force directly proportional to product of masses and inversely proportional to square of distance."
            ),
            fullNotesMarkdown = """
# Gravitation - Class 10 Maharashtra State Board

## 1. Centripetal Force
A force that acts on any object moving along a circle and directed towards the center of the circle is called Centripetal Force (Center-seeking).
Formula: F = mv² / r.

## 2. Kepler's Laws
* **Law of Orbits:** Planetary orbits are elliptical with Sun at one focus.
* **Law of Areas:** A line joining planet and Sun sweeps out equal areas in equal times.
* **Law of Periods:** T² / r³ = constant (K).

## 3. Acceleration due to Gravity (g)
Value on Earth surface = 9.8 m/s².
* **Variation along surface:** Maximum at Poles (9.832 m/s²), Minimum at Equator (9.78 m/s²).
* **Variation with altitude:** Decreases as altitude increases.
* **Variation with depth:** Decreases as depth inside Earth increases, becoming 0 at Earth's center.

## 4. Mass vs Weight
* **Mass:** Amount of matter in an object. SI unit: kg. Scalar quantity, constant everywhere.
* **Weight:** Gravitational force exerted on the object. W = mg. SI unit: Newton (N). Vector quantity, varies with location.

## 5. Free Fall & Escape Velocity
During free fall, initial velocity u = 0. Acceleration a = g.
Escape velocity is the minimum speed needed for an object to escape Earth's gravitational pull permanently. For Earth, v_esc = 11.2 km/s.
            """.trimIndent(),
            htmlContent = """
<div style="font-family:sans-serif; padding:12px; color:#1e293b;">
  <h2 style="color:#2563eb; border-bottom:2px solid #3b82f6;">Gravitation (गुरुत्वाकर्षण)</h2>
  <div style="background:#f1f5f9; padding:10px; border-radius:8px; margin-bottom:12px;">
    <strong>Newton's Universal Law:</strong> F = G(m₁m₂)/r²<br/>
    <strong>G constant:</strong> 6.67 × 10⁻¹¹ N m²/kg²
  </div>
  <h3 style="color:#0f172a;">Kepler's Laws of Planetary Motion</h3>
  <ul>
    <li><strong>1st:</strong> Orbit is elliptical with Sun at one focus.</li>
    <li><strong>2nd:</strong> Sweeps equal areas in equal intervals of time.</li>
    <li><strong>3rd:</strong> T² ∝ r³ &nbsp;⇒&nbsp; T²/r³ = Constant</li>
  </ul>
  <h3 style="color:#0f172a;">Variation of 'g'</h3>
  <table style="width:100%; border-collapse:collapse; margin-top:8px;">
    <tr style="background:#e2e8f0;"><th style="border:1px solid #cbd5e1; padding:6px;">Place</th><th style="border:1px solid #cbd5e1; padding:6px;">Value of g</th></tr>
    <tr><td style="border:1px solid #cbd5e1; padding:6px;">Poles</td><td style="border:1px solid #cbd5e1; padding:6px;">9.832 m/s² (Max)</td></tr>
    <tr><td style="border:1px solid #cbd5e1; padding:6px;">Equator</td><td style="border:1px solid #cbd5e1; padding:6px;">9.78 m/s² (Min)</td></tr>
    <tr><td style="border:1px solid #cbd5e1; padding:6px;">Earth's Center</td><td style="border:1px solid #cbd5e1; padding:6px;">0 m/s²</td></tr>
  </table>
</div>
            """.trimIndent(),
            mindMapRoot = MindMapNode(
                id = "mm_g1",
                title = "Gravitation",
                description = "Center of Universal Attraction",
                children = listOf(
                    MindMapNode("mm_g2", "Kepler's Laws", "1. Elliptical orbit\n2. Equal areas\n3. T² ∝ r³"),
                    MindMapNode("mm_g3", "Universal Law", "F = G m₁m₂/r²\nInverse square law"),
                    MindMapNode("mm_g4", "Gravity 'g'", "Surface: 9.8 m/s²\nPole max, Equator min\nCenter = 0"),
                    MindMapNode("mm_g5", "Free Fall & Escape", "v_esc = √(2GM/R) = 11.2 km/s\nWeightlessness in orbit")
                )
            ),
            questions = listOf(
                PracticeQuestion(
                    id = "q_g1",
                    question = "If the distance between two bodies is tripled, by what factor does the gravitational force between them change?",
                    options = listOf("Decreases by 9 times (1/9)", "Increases by 3 times", "Decreases by 3 times", "Remains unchanged"),
                    correctOptionIndex = 0,
                    explanation = "By Newton's Law of Gravitation, F ∝ 1/r². If r becomes 3r, F becomes 1/(3)² = 1/9 of initial force."
                ),
                PracticeQuestion(
                    id = "q_g2",
                    question = "Scientific Reason: Why is value of 'g' zero at the center of the Earth?",
                    options = listOf("Net gravitational pull from surrounding mass cancels in all directions", "Mass of Earth vanishes", "Radius becomes infinity", "Centrifugal force is infinite"),
                    correctOptionIndex = 0,
                    explanation = "At the center, mass enclosing the point is zero and the pull from all surrounding spherical shells cancels out symmetrically.",
                    isPuzzle = true
                )
            ),
            flashcards = listOf(
                Flashcard("fc_g1", "Escape Velocity Formula", "What is the escape velocity formula and its value for Earth?", "v_esc = √(2gR) = √(2GM/R) ≈ 11.2 km/s", listOf("Independent of mass of object", "Depends on mass and radius of Earth")),
                Flashcard("fc_g2", "Mass vs Weight", "State the core difference between Mass and Weight.", "Mass is quantity of matter (constant, scalar, kg). Weight is force of gravity W = mg (variable, vector, N).")
            ),
            topperTips = listOf(
                "Write Kepler's 3 laws in exact sequence with neat diagram of elliptical orbit.",
                "Remember to specify SI units: G is N·m²/kg², g is m/s².",
                "In numericals of free fall, take g = +9.8 when falling downward, and g = -9.8 when thrown vertically upward."
            )
        ),
        Chapter(
            id = "sci1_ch2",
            chapterNumber = 2,
            title = "Periodic Classification of Elements",
            marathiTitle = "मूलद्रव्यांचे आवर्ती वर्गीकरण",
            subjectType = SubjectType.SCIENCE_1,
            summary = "Dobereiner's Triads, Newlands' Law of Octaves, Mendeleev's Periodic Table, and Modern Periodic Table (Henry Moseley). Periodic trends in atomic size, valency, metallic and non-metallic character.",
            keyFormulas = listOf(
                "Modern Periodic Law: Properties of elements are a periodic function of their Atomic Numbers (Z)",
                "Number of periods: 7 (Horizontal rows)",
                "Number of groups: 18 (Vertical columns)",
                "Blocks: s-block (Gr 1-2), p-block (Gr 13-18), d-block (Gr 3-12), f-block (Lanthanides/Actinides)"
            ),
            importantLawsOrTheorems = listOf(
                "Dobereiner's Triad: Atomic mass of middle element is approximately the arithmetic mean of the other two.",
                "Newlands' Law of Octaves: Every eighth element had properties similar to those of the first.",
                "Mendeleev's Periodic Law: Properties are periodic function of their atomic masses.",
                "Modern Periodic Law: Properties are periodic function of their atomic numbers."
            ),
            fullNotesMarkdown = """
# Periodic Classification of Elements

## 1. Early Attempts
* **Dobereiner's Triads:** Li (6.9), Na (23.0), K (39.1) -> (6.9 + 39.1)/2 = 23.
* **Newlands' Octaves:** Failed beyond Calcium (Ca).
* **Mendeleev's Table:** 63 elements arranged by atomic mass. Predicted undiscovered elements like Eka-boron (Scandium), Eka-aluminium (Gallium), Eka-silicon (Germanium).

## 2. Modern Periodic Table
Discovered by Henry Moseley in 1913 using X-ray spectrometry.
* 18 Groups, 7 Periods.
* Group 1: Alkali metals, Group 2: Alkaline earth metals, Group 17: Halogens, Group 18: Noble gases.

## 3. Periodic Trends
* **Atomic Size / Radius:** Decreases across a period (left to right) due to increasing nuclear charge. Increases down a group due to addition of new shells.
* **Metallic Character:** Decreases across a period, increases down a group.
* **Non-metallic Character:** Increases across a period, decreases down a group.
            """.trimIndent(),
            htmlContent = """
<div style="font-family:sans-serif; padding:12px; color:#1e293b;">
  <h2 style="color:#059669;">Periodic Classification of Elements</h2>
  <div style="background:#ecfdf5; border-left:4px solid #10b981; padding:8px; margin:8px 0;">
    <strong>Modern Periodic Law:</strong> Properties of elements are a periodic function of their <u>Atomic Number (Z)</u>.
  </div>
  <table style="width:100%; border-collapse:collapse; margin-top:8px;">
    <tr style="background:#d1fae5;"><th>Trend</th><th>Across Period (L → R)</th><th>Down Group (Top → Bottom)</th></tr>
    <tr><td style="border:1px solid #a7f3d0; padding:6px;">Atomic Radius</td><td style="border:1px solid #a7f3d0; padding:6px;">Decreases</td><td style="border:1px solid #a7f3d0; padding:6px;">Increases</td></tr>
    <tr><td style="border:1px solid #a7f3d0; padding:6px;">Valency</td><td style="border:1px solid #a7f3d0; padding:6px;">1 to 4 then 4 to 0</td><td style="border:1px solid #a7f3d0; padding:6px;">Remains same</td></tr>
    <tr><td style="border:1px solid #a7f3d0; padding:6px;">Metallic Character</td><td style="border:1px solid #a7f3d0; padding:6px;">Decreases</td><td style="border:1px solid #a7f3d0; padding:6px;">Increases</td></tr>
  </table>
</div>
            """.trimIndent(),
            mindMapRoot = MindMapNode(
                id = "mm_pt1",
                title = "Periodic Table",
                description = "Classification of Elements",
                children = listOf(
                    MindMapNode("mm_pt2", "Mendeleev", "Atomic mass basis\n63 elements\nPredicted Ga, Sc, Ge"),
                    MindMapNode("mm_pt3", "Modern Table", "Atomic number basis (Z)\n7 Periods, 18 Groups\ns, p, d, f blocks"),
                    MindMapNode("mm_pt4", "Trends", "Radius: L->R dec, Top->Down inc\nMetallic: L->R dec, Top->Down inc")
                )
            ),
            questions = listOf(
                PracticeQuestion(
                    id = "q_pt1",
                    question = "Which element predicted by Mendeleev as 'Eka-Aluminium' was later discovered?",
                    options = listOf("Gallium (Ga)", "Germanium (Ge)", "Scandium (Sc)", "Indium (In)"),
                    correctOptionIndex = 0,
                    explanation = "Mendeleev predicted Eka-Boron = Scandium, Eka-Aluminium = Gallium, Eka-Silicon = Germanium."
                )
            ),
            flashcards = listOf(
                Flashcard("fc_pt1", "Halogens Group", "Which group contains halogens and what is their valence?", "Group 17, Valence is 1 (7 valence electrons: F, Cl, Br, I, At).")
            ),
            topperTips = listOf(
                "Memorize the pairs: Eka-boron -> Scandium, Eka-aluminium -> Gallium, Eka-silicon -> Germanium.",
                "For reasons questions on atomic radius, mention: nuclear charge increases while shells remain same across period."
            )
        ),
        Chapter(
            id = "sci1_ch3",
            chapterNumber = 3,
            title = "Chemical Reactions and Equations",
            marathiTitle = "रासायनिक अभिक्रिया आणि समीकरणे",
            subjectType = SubjectType.SCIENCE_1,
            summary = "Chemical equations, balancing chemical equations, types of reactions (Combination, Decomposition, Displacement, Double Displacement), endothermic and exothermic processes, rate of chemical reactions, oxidation, reduction, redox reactions, corrosion and rancidity.",
            keyFormulas = listOf(
                "Combination: A + B → AB",
                "Decomposition: AB → A + B",
                "Displacement: A + BC → AC + B",
                "Double Displacement: AB + CD → AD + CB",
                "Redox: Oxidation = Loss of electrons / Gain of Oxygen. Reduction = Gain of electrons / Loss of Oxygen"
            ),
            importantLawsOrTheorems = listOf(
                "Law of Conservation of Mass: Total mass of reactants equals total mass of products in a balanced chemical equation."
            ),
            fullNotesMarkdown = """
# Chemical Reactions and Equations

## Types of Reactions
1. **Combination Reaction:** Two or more reactants combine to form a single product. (e.g. 2Mg + O₂ → 2MgO).
2. **Decomposition Reaction:** Single reactant breaks into two or more products. (e.g. CaCO₃ → CaO + CO₂).
3. **Displacement Reaction:** More reactive element displaces less reactive element from its compound. (e.g. Fe + CuSO₄ → FeSO₄ + Cu).
4. **Double Displacement Reaction:** Mutual exchange of ions occurs to form precipitate. (e.g. AgNO₃ + NaCl → AgCl↓ + NaNO₃).

## Factors Affecting Reaction Rate
* Nature of reactants, size of reactant particles, concentration of reactants, temperature, and catalyst.

## Corrosion & Rancidity
* **Corrosion:** Rust on iron is Fe₂O₃·xH₂O (reddish brown).
* **Rancidity:** Oxidation of oils/fats producing foul odor and taste. Prevented by antioxidants and packaging with Nitrogen gas.
            """.trimIndent(),
            htmlContent = """
<div style="font-family:sans-serif; padding:12px; color:#1e293b;">
  <h2 style="color:#d97706;">Chemical Reactions & Equations</h2>
  <div style="background:#fffbeb; border-left:4px solid #f59e0b; padding:8px;">
    <strong>Rust Formula:</strong> Fe₂O₃·xH₂O (Hydrated ferric oxide)
  </div>
  <ul>
    <li><strong>Endothermic:</strong> Heat is absorbed (e.g., Photosynthesis, melting of ice).</li>
    <li><strong>Exothermic:</strong> Heat is liberated (e.g., Respiration, burning of natural gas).</li>
  </ul>
</div>
            """.trimIndent(),
            mindMapRoot = MindMapNode("mm_cr1", "Chemical Reactions", "Transformations of matter", listOf(
                MindMapNode("mm_cr2", "Types", "Combination, Decomposition, Displacement, Double Displacement"),
                MindMapNode("mm_cr3", "Redox", "Oxidation: +O / -H / -e⁻\nReduction: -O / +H / +e⁻"),
                MindMapNode("mm_cr4", "Corrosion", "Rusting of iron: Fe₂O₃·xH₂O\nPrevention: Galvanizing, Tinning")
            )),
            questions = listOf(
                PracticeQuestion("q_cr1", "What type of reaction is: 2H₂O (l) → 2H₂ (g) + O₂ (g) by electric current?", listOf("Electrolytic Decomposition", "Combination", "Displacement", "Neutralization"), 0, "Water decomposes into hydrogen and oxygen through electrolysis.")
            ),
            flashcards = listOf(
                Flashcard("fc_cr1", "Catalyst Definition", "What is a catalyst?", "A substance in whose presence the rate of a chemical reaction changes without causing any chemical change to it.")
            ),
            topperTips = listOf("Always balance both mass and charge. Indicate physical states (s, l, g, aq) and gas release (↑) or precipitate (↓).")
        ),
        Chapter(
            id = "sci1_ch4",
            chapterNumber = 4,
            title = "Effects of Electric Current",
            marathiTitle = "विद्युतधारेचे परिणाम",
            subjectType = SubjectType.SCIENCE_1,
            summary = "Heating effect of electric current (Joule's Law), Electric power, Magnetic effect of electric current, Right Hand Thumb Rule, Fleming's Left Hand Rule (Electric Motor), Fleming's Right Hand Rule (Electric Generator), AC vs DC.",
            keyFormulas = listOf(
                "Joule's Law of Heating: H = I²Rt",
                "Electric Power: P = V · I = I²R = V² / R",
                "1 Kilowatt-hour (kWh) = 1 Unit = 3.6 × 10⁶ Joules",
                "Frequency of AC in India: 50 Hz (changes direction every 1/100 second)"
            ),
            importantLawsOrTheorems = listOf(
                "Joule's Law of Heating: Heat produced is directly proportional to square of current, resistance, and time.",
                "Right-Hand Thumb Rule: Thumb points along current, fingers curl along magnetic lines of force.",
                "Fleming's Left-Hand Rule: Thumb = Force/Motion, Forefinger = Magnetic Field, Middle finger = Current (Used for Electric Motor).",
                "Fleming's Right-Hand Rule: Thumb = Motion, Forefinger = Magnetic Field, Middle finger = Induced Current (Used for Generator)."
            ),
            fullNotesMarkdown = """
# Effects of Electric Current

## 1. Heating Effect
When current passes through a conductor having resistance, heat is generated.
H = VIt = I²Rt = (V²/R)t.
* Appliances: Electric iron, heater, toaster use alloys like Nichrome (high resistivity and high melting point).
* Electric Bulb: Tungsten filament (melting point ~3422°C) in inert Argon/Nitrogen gas.
* Fuse Wire: Alloy of lead and tin (low melting point) to prevent overload and short circuits.

## 2. Magnetic Effect
Discovered by Hans Christian Oersted.
* Solenoid: Insulated copper wire in continuous cylindrical loops. Inside solenoid, magnetic field is uniform.
* Electric Motor: Converts electrical energy into mechanical energy.
* Electric Generator: Converts mechanical energy into electrical energy based on Electromagnetic Induction (Michael Faraday).
            """.trimIndent(),
            htmlContent = """
<div style="font-family:sans-serif; padding:12px; color:#1e293b;">
  <h2 style="color:#7c3aed;">Effects of Electric Current</h2>
  <div style="background:#f5f3ff; border:1px solid #ddd6fe; padding:10px; border-radius:8px;">
    <strong>Joule's Law:</strong> H = I²Rt Joules<br/>
    <strong>Commercial Unit:</strong> 1 Unit = 1 kWh = 3.6 × 10⁶ J
  </div>
  <h3>Fleming's Rules Mnemonic</h3>
  <p><strong>Left Hand:</strong> Motor (Father = Force, Mother = Magnetic Field, Child = Current)</p>
  <p><strong>Right Hand:</strong> Generator (Induced current)</p>
</div>
            """.trimIndent(),
            mindMapRoot = MindMapNode("mm_ec1", "Electric Current Effects", "Heating & Magnetic", listOf(
                MindMapNode("mm_ec2", "Heating Effect", "H = I²Rt\nNichrome coil\nTungsten bulb\nSafety fuse"),
                MindMapNode("mm_ec3", "Magnetic Effect", "Right hand thumb rule\nSolenoid magnetic field"),
                MindMapNode("mm_ec4", "Motor vs Generator", "Motor: Electrical -> Mechanical (Left hand)\nGen: Mechanical -> Electrical (Right hand)")
            )),
            questions = listOf(
                PracticeQuestion("q_ec1", "In an electric motor, which component reverses the direction of current in the coil every half rotation?", listOf("Split-ring commutator", "Slip rings", "Carbon brushes", "Armature core"), 0, "Split rings act as a commutator, reversing current flow every half turn.")
            ),
            flashcards = listOf(
                Flashcard("fc_ec1", "1 kWh in Joules", "Convert 1 kilowatt-hour into Joules.", "1 kWh = 1000 W × 3600 s = 3.6 × 10⁶ J = 3.6 MJ")
            ),
            topperTips = listOf("Practice drawing the labeled diagrams of Electric Motor and AC Generator - guaranteed 5-mark question!")
        ),
        Chapter(
            id = "sci1_ch5",
            chapterNumber = 5,
            title = "Heat",
            marathiTitle = "उष्णता",
            subjectType = SubjectType.SCIENCE_1,
            summary = "Latent heat of fusion and vaporization, regelation, anomalous behavior of water, Hope's apparatus, dew point and humidity, absolute humidity, relative humidity, and specific heat capacity (Principle of heat exchange).",
            keyFormulas = listOf(
                "Heat gained/lost: Q = m · c · ΔT",
                "Latent Heat: Q = m · L",
                "Relative Humidity = (Actual mass of water vapor / Mass needed for saturation) × 100%",
                "Principle of Heat Exchange: Heat lost by hot object = Heat gained by cold object"
            ),
            importantLawsOrTheorems = listOf(
                "Anomalous Behavior of Water: Between 0°C and 4°C, water contracts on heating and expands on cooling. Maximum density of water is at 4°C (1000 kg/m³).",
                "Regelation: The phenomenon in which ice converts to liquid under pressure and reconverts to ice when pressure is removed."
            ),
            fullNotesMarkdown = "Detailed notes on Heat, Latent Heat, Hope's apparatus, and Specific Heat Capacity.",
            htmlContent = "<h3>Heat & Anomalous Behavior of Water</h3><p>At 4°C water has minimum volume and maximum density, allowing aquatic life to survive in frozen lakes.</p>",
            mindMapRoot = MindMapNode("mm_h1", "Heat", "Thermal Physics", listOf(
                MindMapNode("mm_h2", "Latent Heat", "Fusion (Ice -> Water: 80 cal/g)\nVaporization (Water -> Steam: 540 cal/g)"),
                MindMapNode("mm_h3", "Anomalous Water", "0°C to 4°C expansion\nHope's apparatus\nProtects aquatic life"),
                MindMapNode("mm_h4", "Heat Exchange", "Q = mcΔT\nCalorimeter method")
            )),
            questions = listOf(PracticeQuestion("q_h1", "At what temperature does water have its maximum density?", listOf("4°C", "0°C", "100°C", "-4°C"), 0, "Water reaches maximum density at 4°C.")),
            flashcards = listOf(Flashcard("fc_h1", "Specific heat of water", "What is specific heat capacity of water?", "c = 1 cal/g·°C = 4184 J/kg·°C")),
            topperTips = listOf("Remember explanation for 'Why aquatic animals survive in polar winter' uses anomalous behavior of water!")
        ),
        Chapter(
            id = "sci1_ch6",
            chapterNumber = 6,
            title = "Refraction of Light",
            marathiTitle = "प्रकाशाचे अपवर्तन",
            subjectType = SubjectType.SCIENCE_1,
            summary = "Refraction of light, laws of refraction, refractive index, Snell's law, twinkling of stars, advanced sunrise and delayed sunset, dispersion of light, and total internal reflection (mirage & rainbow formation).",
            keyFormulas = listOf(
                "Snell's Law: sin(i) / sin(r) = constant = ₁n₂",
                "Refractive index: n = c / v (Speed in vacuum / Speed in medium)",
                "Relative refractive index: ₁n₂ = v₁ / v₂"
            ),
            importantLawsOrTheorems = listOf(
                "Snell's Law: For a given pair of media, the ratio of sin(i) to sin(r) is constant.",
                "Total Internal Reflection: When light travels from denser to rarer medium at an angle of incidence greater than the critical angle, all light reflects back."
            ),
            fullNotesMarkdown = "Notes on Refraction of Light, Snell's Law, and Atmospheric Refraction.",
            htmlContent = "<h3>Refraction of Light</h3><p>Snell's Law: sin i / sin r = n. Twinkling of stars is due to atmospheric refraction.</p>",
            mindMapRoot = MindMapNode("mm_ref1", "Refraction", "Bending of light", listOf(
                MindMapNode("mm_ref2", "Laws", "Snell's Law: sin i / sin r = constant"),
                MindMapNode("mm_ref3", "Atmospheric Refraction", "Twinkling of stars\nAdvanced sunrise (2 min) / Delayed sunset (2 min)\nMirage"),
                MindMapNode("mm_ref4", "Dispersion & Rainbow", "VIBGYOR\nTotal internal reflection")
            )),
            questions = listOf(PracticeQuestion("q_ref1", "Why do stars twinkle while planets do not?", listOf("Stars are point sources far away; fluctuating atmospheric density refracts their light continuously", "Planets have internal lights", "Planets are outside atmosphere", "Stars move faster"), 0, "Atmospheric refraction causes apparent position and brightness of distant point stars to flicker.")),
            flashcards = listOf(Flashcard("fc_ref1", "Rainbow Formation", "What three optical phenomena produce a rainbow?", "Refraction, Dispersion, and Total Internal Reflection of sunlight by water droplets.")),
            topperTips = listOf("Draw ray diagram for light passing through rectangular glass slab showing lateral shift.")
        ),
        Chapter(
            id = "sci1_ch7",
            chapterNumber = 7,
            title = "Lenses",
            marathiTitle = "भिंगे आणि त्यांचे उपयोग",
            subjectType = SubjectType.SCIENCE_1,
            summary = "Convex and concave lenses, optical center, focus, focal length, ray diagrams for image formation, Cartesian sign convention, lens formula, magnification, power of lens, and defects of vision (Myopia, Hypermetropia, Presbyopia) with corrections.",
            keyFormulas = listOf(
                "Lens Formula: 1/v - 1/u = 1/f",
                "Magnification: M = v / u = h₂ / h₁",
                "Power of a Lens: P = 1 / f (in meters) Dioptres (D)",
                "Combined Power: P = P₁ + P₂"
            ),
            importantLawsOrTheorems = listOf(
                "Myopia (Nearsightedness): Corrected by Concave lens of suitable focal length.",
                "Hypermetropia (Farsightedness): Corrected by Convex lens of suitable focal length."
            ),
            fullNotesMarkdown = "Complete notes on Lenses, ray diagrams, and vision defects.",
            htmlContent = "<h3>Lenses & Defects of Vision</h3><p>Power P = 1/f(m) in Dioptres. Concave lens power is negative, convex lens power is positive.</p>",
            mindMapRoot = MindMapNode("mm_len1", "Lenses", "Optical devices", listOf(
                MindMapNode("mm_len2", "Convex vs Concave", "Convex: Converging, real/virtual images\nConcave: Diverging, always virtual erect"),
                MindMapNode("mm_len3", "Lens Formula", "1/v - 1/u = 1/f\nP = 1/f(m) Dioptres"),
                MindMapNode("mm_len4", "Defects of Eye", "Myopia (near clear, far blur -> Concave)\nHypermetropia (far clear, near blur -> Convex)\nPresbyopia (aging)")
            )),
            questions = listOf(PracticeQuestion("q_len1", "A person cannot see nearby objects clearly. What defect does he have and how is it corrected?", listOf("Hypermetropia, corrected by convex lens", "Myopia, corrected by concave lens", "Presbyopia, corrected by cylindrical lens", "Astigmatism"), 0, "In hypermetropia, nearby image forms behind retina, corrected with convex lens.")),
            flashcards = listOf(Flashcard("fc_len1", "Power of Lens unit", "What is the SI unit of power of a lens?", "Dioptre (D). 1 D = 1 m⁻¹.")),
            topperTips = listOf("Remember: u is always negative in Cartesian sign conventions for lenses!")
        ),
        Chapter(
            id = "sci1_ch8",
            chapterNumber = 8,
            title = "Metallurgy",
            marathiTitle = "धातूविज्ञान",
            subjectType = SubjectType.SCIENCE_1,
            summary = "Physical and chemical properties of metals and non-metals, reactivity series, ionic compounds and properties, concentration of ores (gravity separation, magnetic separation, froth floatation, leaching), extraction of metals, and prevention of corrosion.",
            keyFormulas = listOf(
                "Reactivity Series: K > Na > Ca > Mg > Al > Zn > Fe > Sn > Pb > [H] > Cu > Hg > Ag > Au",
                "Amphoteric Oxides: Al₂O₃ + 6HCl → 2AlCl₃ + 3H₂O, Al₂O₃ + 2NaOH → 2NaAlO₂ + H₂O"
            ),
            importantLawsOrTheorems = listOf(
                "Hall-Heroult's Process: Electrolytic reduction of Alumina (Al₂O₃) with Cryolite (Na₃AlF₆) and Fluorspar (CaF₂) to extract pure Aluminium.",
                "Bayer's Process: Leaching bauxite ore with concentrated aqueous NaOH."
            ),
            fullNotesMarkdown = "Comprehensive notes on extraction of reactive metals and refining.",
            htmlContent = "<h3>Metallurgy</h3><p>Froth floatation process concentrates sulphide ores based on hydrophilic and hydrophobic properties.</p>",
            mindMapRoot = MindMapNode("mm_met1", "Metallurgy", "Extraction of metals", listOf(
                MindMapNode("mm_met2", "Concentration of Ores", "Gravity separation\nMagnetic separation\nFroth floatation\nLeaching (Bayer's)"),
                MindMapNode("mm_met3", "Extraction", "High reactivity: Electrolysis (Al)\nMedium: Roasting & Calcination\nLow: Heating alone"),
                MindMapNode("mm_met4", "Corrosion Prevention", "Galvanizing (Zn coating)\nTinning (Sn coating)\nAnodizing & Electroplating")
            )),
            questions = listOf(PracticeQuestion("q_met1", "Which method is used for concentration of zinc blende (ZnS) ore?", listOf("Froth floatation", "Magnetic separation", "Leaching", "Hydraulic washing"), 0, "Sulphide ores like ZnS are concentrated by froth floatation method.")),
            flashcards = listOf(Flashcard("fc_met1", "Amphoteric Oxides", "What are amphoteric oxides? Give examples.", "Oxides that react with both acids and bases to form salt and water. Examples: Al₂O₃ and ZnO.")),
            topperTips = listOf("Study Hall-Heroult electrolytic cell diagram with graphite anode and cathode lining.")
        ),
        Chapter(
            id = "sci1_ch9",
            chapterNumber = 9,
            title = "Carbon Compounds",
            marathiTitle = "कार्बनची संयुगे",
            subjectType = SubjectType.SCIENCE_1,
            summary = "Bonds in carbon (covalent bonds), versatile nature of carbon (catenation, tetravalency), hydrocarbons (saturated & unsaturated), homologous series, IUPAC nomenclature, functional groups, chemical properties (combustion, oxidation, addition, substitution), ethanol and ethanoic acid.",
            keyFormulas = listOf(
                "Alkane: C_n H_(2n+2) (Methane, Ethane, Propane)",
                "Alkene: C_n H_(2n) (Ethene, Propene)",
                "Alkyne: C_n H_(2n-2) (Ethyne, Propyne)",
                "Saponification: Ester + NaOH → Soap (Sodium salt of fatty acid) + Alcohol"
            ),
            importantLawsOrTheorems = listOf(
                "Catenation: Carbon has the unique ability to form bonds with other carbon atoms to form large molecules.",
                "Homologous Series: A series of compounds with same functional group where adjacent members differ by -CH₂- unit and 14 u mass."
            ),
            fullNotesMarkdown = "Complete notes on Carbon compounds, covalent bonding, isomerism, and functional groups.",
            htmlContent = "<h3>Carbon Compounds</h3><p>Tetravalency & Catenation make carbon form millions of stable organic compounds.</p>",
            mindMapRoot = MindMapNode("mm_carb1", "Carbon Compounds", "Organic Chemistry", listOf(
                MindMapNode("mm_carb2", "Hydrocarbons", "Saturated: Alkanes (single bond)\nUnsaturated: Alkenes (=) & Alkynes (≡)"),
                MindMapNode("mm_carb3", "Functional Groups", "-OH (Alcohol), -CHO (Aldehyde), -COOH (Carboxylic Acid), -CO- (Ketone)"),
                MindMapNode("mm_carb4", "Important Chemicals", "Ethanol (C₂H₅OH)\nEthanoic acid (Glacial acetic acid)\nSoap & Detergent micelle")
            )),
            questions = listOf(PracticeQuestion("q_carb1", "What is the general molecular formula for Alkynes?", listOf("CₙH₂ₙ₋₂", "CₙH₂ₙ₊₂", "CₙH₂ₙ", "CₙH₂ₙ₊₁"), 0, "Alkynes contain triple bonds and have formula CₙH₂ₙ₋₂.")),
            flashcards = listOf(Flashcard("fc_carb1", "Vinegar Composition", "What is vinegar?", "A 5% to 8% aqueous solution of acetic acid (ethanoic acid) is called vinegar.")),
            topperTips = listOf("Master IUPAC naming rules for alcohol, carboxylic acid, ketone, and halogen substituents.")
        ),
        Chapter(
            id = "sci1_ch10",
            chapterNumber = 10,
            title = "Space Missions",
            marathiTitle = "अवकाश मोहिमा",
            subjectType = SubjectType.SCIENCE_1,
            summary = "Need and importance of space missions, artificial satellites and their orbits (LEO, MEO, GEO/HEO), satellite launch vehicles (PSLV), space missions beyond Earth (Moon, Mars), space research and debris management.",
            keyFormulas = listOf(
                "Critical Velocity: v_c = √(GM / (R + h))",
                "High Earth Orbit (GEO): Altitude > 35780 km (Orbital period = 24 hours)",
                "Low Earth Orbit (LEO): Altitude 180 km to 2000 km",
                "Medium Earth Orbit (MEO): Altitude 2000 km to 35780 km"
            ),
            importantLawsOrTheorems = listOf(
                "Geostationary Satellite: Revolve in equatorial plane with period equal to Earth rotation (24 hours), appearing stationary relative to Earth."
            ),
            fullNotesMarkdown = "Complete notes on Space Missions, satellite classifications, and launch physics.",
            htmlContent = "<h3>Space Missions</h3><p>Critical velocity formula: v_c = √(GM / (R+h)). Geostationary satellites orbit at 35,780 km.</p>",
            mindMapRoot = MindMapNode("mm_sp1", "Space Missions", "Exploring Cosmos", listOf(
                MindMapNode("mm_sp2", "Satellites", "Weather, Navigational, Communication, Earth observation"),
                MindMapNode("mm_sp3", "Orbits", "GEO (> 35,780 km, T = 24 hrs)\nMEO (2000 - 35,780 km)\nLEO (180 - 2000 km)"),
                MindMapNode("mm_sp4", "Launchers", "PSLV (Polar Satellite Launch Vehicle)\nMulti-stage rockets")
            )),
            questions = listOf(PracticeQuestion("q_sp1", "What is the orbital period of a geostationary satellite?", listOf("24 hours", "12 hours", "90 minutes", "365 days"), 0, "Geostationary satellites rotate in synchronization with Earth's 24-hour day.")),
            flashcards = listOf(Flashcard("fc_sp1", "First Artificial Satellite", "Which was the world's first artificial satellite?", "Sputnik-1 launched by Soviet Union in 1957.")),
            topperTips = listOf("Remember formulas for critical velocity and heights of LEO, MEO, GEO for short answer questions.")
        )
    )
}
