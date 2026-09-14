package com.example.data.repository

import com.example.data.model.*

object Math2Data {
    fun getChapters(): List<Chapter> = listOf(
        Chapter(
            id = "m2_ch1",
            chapterNumber = 1,
            title = "Similarity",
            marathiTitle = "समरूपता",
            subjectType = SubjectType.MATH_2,
            summary = "Ratio of areas of two triangles, Basic Proportionality Theorem (BPT) and its converse, Angle Bisector Theorem, Property of three parallel lines and their transversals, Tests of similarity (AAA, SAS, SSS), and Theorem of areas of similar triangles.",
            keyFormulas = listOf(
                "Ratio of areas: (A₁ / A₂) = (b₁ × h₁) / (b₂ × h₂)",
                "Equal height: (A₁ / A₂) = b₁ / b₂; Equal base: (A₁ / A₂) = h₁ / h₂",
                "Basic Proportionality Theorem (BPT): In ΔABC, if line l ∥ seg BC, then AP / PB = AQ / QC",
                "Angle Bisector Property: In ΔABC, if ray BD bisects ∠B, then AB / BC = AD / DC",
                "Three parallel lines: AB / BC = XY / YZ",
                "Theorem of Areas of Similar Triangles: If ΔABC ~ ΔPQR, then A(ΔABC) / A(ΔPQR) = AB² / PQ² = BC² / QR² = AC² / PR²"
            ),
            importantLawsOrTheorems = listOf(
                "Basic Proportionality Theorem (Thales' Theorem): If a line parallel to a side of a triangle intersects the other two sides in distinct points, then the line divides the sides in the same ratio.",
                "Theorem of Areas of Similar Triangles: The ratio of the areas of two similar triangles is equal to the ratio of the squares of their corresponding sides."
            ),
            fullNotesMarkdown = """
# Similarity - Maharashtra State Board

## 1. Basic Proportionality Theorem (B.P.T.)
**Statement:** If a line parallel to a side of a triangle intersects the other two sides in distinct points, then the line divides the sides in the same ratio.
In ΔABC, line l ∥ side BC intersecting AB in P and AC in Q:
AP / PB = AQ / QC.

## 2. Property of Angle Bisector of a Triangle
The bisector of an angle of a triangle divides the side opposite to the angle in the ratio of the remaining sides.
In ΔABC, if ray BD is bisector of ∠ABC, then:
AB / BC = AD / DC.

## 3. Areas of Similar Triangles
When two triangles are similar, the ratio of areas of those triangles is equal to the ratio of the squares of their corresponding sides:
A(ΔABC) / A(ΔPQR) = (AB / PQ)² = (BC / QR)² = (AC / PR)².
            """.trimIndent(),
            htmlContent = """
<div style="font-family:sans-serif; padding:12px; color:#1e293b;">
  <h2 style="color:#0284c7;">Similarity (समरूपता)</h2>
  <div style="background:#f0f9ff; border-left:4px solid #0284c7; padding:10px;">
    <strong>Theorem of Areas of Similar Triangles:</strong><br/>
    If ΔABC ~ ΔPQR, then:<br/>
    A(ΔABC) / A(ΔPQR) = AB² / PQ² = BC² / QR² = AC² / PR²
  </div>
  <h3>B.P.T. Formula:</h3>
  <p>If line ∥ base: <strong>AP / PB = AQ / QC</strong></p>
</div>
            """.trimIndent(),
            mindMapRoot = MindMapNode("mm_sim1", "Similarity", "Proportions & Similar Shapes", listOf(
                MindMapNode("mm_sim2", "Area Ratios", "General: (b₁h₁)/(b₂h₂)\nEqual height: b₁/b₂\nEqual base: h₁/h₂"),
                MindMapNode("mm_sim3", "Theorems", "Basic Proportionality Theorem (BPT)\nAngle bisector theorem\nThree parallel lines"),
                MindMapNode("mm_sim4", "Similarity Tests", "AAA test, SAS test, SSS test\nArea of similar triangles = Side₁² / Side₂²")
            )),
            questions = listOf(
                PracticeQuestion("q_sim1", "If ΔABC ~ ΔPQR and A(ΔABC) : A(ΔPQR) = 81 : 49, find the ratio of their corresponding sides AB : PQ.", listOf("9 : 7", "81 : 49", "3 : √7", "18 : 14"), 0, "Ratio of areas = (Ratio of sides)². So AB/PQ = √(81/49) = 9/7.")
            ),
            flashcards = listOf(
                Flashcard("fc_sim1", "BPT Converse", "State the Converse of Basic Proportionality Theorem.", "If a line divides any two sides of a triangle in the same ratio, then the line must be parallel to the third side.")
            ),
            topperTips = listOf("Memorize the step-by-step proofs of BPT and Areas of Similar Triangles theorem - very frequently asked for 4 marks!")
        ),
        Chapter(
            id = "m2_ch2",
            chapterNumber = 2,
            title = "Pythagoras Theorem",
            marathiTitle = "पायथागोरसचे प्रमेय",
            subjectType = SubjectType.MATH_2,
            summary = "Pythagoras theorem, Converse of Pythagoras theorem, Similarity in right-angled triangles, Theorem of Geometric Mean, 30°-60°-90° and 45°-45°-90° triangle theorems, Application of Pythagoras theorem (Acute & Obtuse angle theorems), and Apollonius theorem.",
            keyFormulas = listOf(
                "Pythagoras: In right triangle, Hypotenuse² = Base² + Height²",
                "Theorem of Geometric Mean: In right ΔABC with altitude BD on hypotenuse AC: BD² = AD × DC",
                "30°-60°-90° Triangle: Side opposite 30° = ½ × Hypotenuse; Side opposite 60° = (√3 / 2) × Hypotenuse",
                "45°-45°-90° Triangle: Side opposite 45° = (1 / √2) × Hypotenuse",
                "Apollonius Theorem: In ΔABC with median AM: AB² + AC² = 2(AM² + BM²)"
            ),
            importantLawsOrTheorems = listOf(
                "Pythagoras Theorem: In a right angled triangle, the square of the hypotenuse is equal to the sum of the squares of remaining two sides.",
                "Theorem of Geometric Mean: In a right angled triangle, the perpendicular segment to the hypotenuse from the opposite vertex is the geometric mean of the segments into which the hypotenuse is divided.",
                "Apollonius Theorem: Relates the sum of squares of two sides of a triangle to its median."
            ),
            fullNotesMarkdown = "Complete proofs and applications of Pythagoras Theorem, Geometric Mean, and Apollonius theorem.",
            htmlContent = "<h3>Pythagoras Theorem</h3><p>Hyp² = Side₁² + Side₂². Apollonius: AB² + AC² = 2(AM² + BM²) where AM is median.</p>",
            mindMapRoot = MindMapNode("mm_pyt1", "Pythagoras", "Right Triangle Geometry", listOf(
                MindMapNode("mm_pyt2", "Core Theorem", "Hyp² = Base² + Perpendicular²\nGeometric Mean: BD² = AD · DC"),
                MindMapNode("mm_pyt3", "Special Triangles", "30-60-90: Opp 30° = ½ Hyp, Opp 60° = (√3/2) Hyp\n45-45-90: Opp 45° = (1/√2) Hyp"),
                MindMapNode("mm_pyt4", "Apollonius Theorem", "Median relation: AB² + AC² = 2(AM² + BM²)")
            )),
            questions = listOf(PracticeQuestion("q_pyt1", "In right ΔABC, ∠B = 90°, BD ⊥ AC. If AD = 4 cm and DC = 9 cm, find BD.", listOf("6 cm", "6.5 cm", "36 cm", "5 cm"), 0, "By Geometric Mean Theorem: BD² = AD × DC = 4 × 9 = 36 => BD = 6 cm.")),
            flashcards = listOf(Flashcard("fc_pyt1", "Apollonius Formula", "Write the Apollonius theorem equation for ΔABC where M is the midpoint of BC.", "AB² + AC² = 2(AM² + BM²)")),
            topperTips = listOf("Whenever a question mentions 'median of a triangle', immediately think of Apollonius Theorem!")
        ),
        Chapter(
            id = "m2_ch3",
            chapterNumber = 3,
            title = "Circle",
            marathiTitle = "वर्तुळ",
            subjectType = SubjectType.MATH_2,
            summary = "Circles passing through points, Tangent theorem, Converse of Tangent theorem, Tangent segment theorem, Touching circles (Internal & External), Inscribed angle theorem, Corollaries, Cyclic quadrilateral theorem and its converse, Tangent secant theorem.",
            keyFormulas = listOf(
                "Tangent Theorem: Tangent at any point of a circle is perpendicular to radius through point of contact (Radius ⊥ Tangent)",
                "Tangent Segment Theorem: Lengths of two tangent segments drawn from an external point to a circle are equal (PA = PB)",
                "Inscribed Angle Theorem: Measure of an inscribed angle is half of the measure of its intercepted arc (∠ABC = ½ m(arc AC))",
                "Cyclic Quadrilateral: Opposite angles are supplementary (∠A + ∠C = 180°, ∠B + ∠D = 180°)",
                "Tangent Secant Theorem: PT² = PA × PB (where PT is tangent segment and PAB is secant)"
            ),
            importantLawsOrTheorems = listOf(
                "Theorem of Cyclic Quadrilateral: Opposite angles of a cyclic quadrilateral are supplementary.",
                "Tangent Secant Segments Theorem: If tangent PT and secant PAB intersect outside circle, then PT² = PA × PB."
            ),
            fullNotesMarkdown = "Detailed theorems, proofs, and properties of circles, tangents, arcs, and inscribed angles.",
            htmlContent = "<h3>Circle (वर्तुळ)</h3><p>Tangent segment theorem: PA = PB. Cyclic quadrilateral: ∠A + ∠C = 180°.</p>",
            mindMapRoot = MindMapNode("mm_circ1", "Circle", "Geometry of Curves", listOf(
                MindMapNode("mm_circ2", "Tangents", "Tangent ⊥ Radius\nExternal tangents: PA = PB\nTouching circles: Dist = R + r or R - r"),
                MindMapNode("mm_circ3", "Angles & Arcs", "Inscribed angle = ½ intercepted arc\nAngles in same segment are equal"),
                MindMapNode("mm_circ4", "Cyclic Quadrilateral", "Opposite angles sum to 180°\nTangent Secant Theorem: PT² = PA · PB")
            )),
            questions = listOf(PracticeQuestion("q_circ1", "If quadrilateral ABCD is cyclic and ∠A = 70°, find the measure of ∠C.", listOf("110°", "70°", "20°", "90°"), 0, "Opposite angles of a cyclic quadrilateral are supplementary: ∠C = 180° - 70° = 110°.")),
            flashcards = listOf(Flashcard("fc_circ1", "Angle in Semicircle", "What is the measure of an angle inscribed in a semicircle?", "90° (Right angle).")),
            topperTips = listOf("In Touching circles problems: if circles touch externally, distance between centers = r₁ + r₂; if internally = |r₁ - r₂|.")
        ),
        Chapter(
            id = "m2_ch4",
            chapterNumber = 4,
            title = "Geometric Constructions",
            marathiTitle = "भौमितिक रचना",
            subjectType = SubjectType.MATH_2,
            summary = "Construction of similar triangles (when vertices are distinct vs when one vertex is common), Construction of tangent to a circle at a point on the circle (using center and without using center), and Construction of tangents to a circle from a point outside the circle.",
            keyFormulas = listOf(
                "Tangent from external point: Perpendicular bisector of segment joining center and external point",
                "Scale Factor: If ratio of corresponding sides is > 1, constructed triangle is larger; if < 1, constructed triangle is smaller"
            ),
            importantLawsOrTheorems = listOf(
                "Construction using Alternate Segment Theorem: Tangent without using center is drawn using the inscribed angle property."
            ),
            fullNotesMarkdown = "Step-by-step drafting guidelines, scale factor analysis, and common mistakes to avoid in compass drawing.",
            htmlContent = "<h3>Geometric Constructions</h3><p>Scale factor m/n: Divide the ray into max(m, n) equal parts with compass.</p>",
            mindMapRoot = MindMapNode("mm_gc1", "Constructions", "Precision drafting", listOf(
                MindMapNode("mm_gc2", "Similar Triangles", "Distinct vertices: Construct separately using side ratios\nCommon vertex: Use ray method with equal arcs"),
                MindMapNode("mm_gc3", "Tangents", "At point on circle (with center)\nAt point on circle (without center using inscribed angle)\nFrom external point using perpendicular bisector")
            )),
            questions = listOf(PracticeQuestion("q_gc1", "To construct a tangent from an external point P to a circle with center O, which segment is bisected?", listOf("Segment OP", "Radius of circle", "Tangent length", "Chord of contact"), 0, "Perpendicular bisector of OP is drawn to find the midpoint M as center for the arc.")),
            flashcards = listOf(Flashcard("fc_gc1", "Tangent angle with radius", "What angle does the tangent make with the radius at point of contact?", "90° (Right angle).")),
            topperTips = listOf("Do not erase construction arcs! Always draw a neat rough figure with given measurements first.")
        ),
        Chapter(
            id = "m2_ch5",
            chapterNumber = 5,
            title = "Co-ordinate Geometry",
            marathiTitle = "निर्देशांक भूमिती",
            subjectType = SubjectType.MATH_2,
            summary = "Distance formula, Section formula, Midpoint formula, Centroid formula of a triangle, and Slope of a line (m = tan θ = (y₂ - y₁) / (x₂ - x₁)). Conditions for parallel and perpendicular lines, and collinearity test.",
            keyFormulas = listOf(
                "Distance Formula: d = √[(x₂ - x₁)² + (y₂ - y₁)²]",
                "Distance from Origin: d = √(x² + y²)",
                "Section Formula: x = (mx₂ + nx₁) / (m + n),  y = (my₂ + ny₁) / (m + n)",
                "Midpoint Formula: x = (x₁ + x₂) / 2,  y = (y₁ + y₂) / 2",
                "Centroid of Triangle: G = ( (x₁ + x₂ + x₃)/3 , (y₁ + y₂ + y₃)/3 )",
                "Slope of a line: m = (y₂ - y₁) / (x₂ - x₁) = tan θ",
                "Parallel lines have equal slopes: m₁ = m₂"
            ),
            importantLawsOrTheorems = listOf(
                "Collinear Points Test: Points A, B, C are collinear if Slope of AB = Slope of BC."
            ),
            fullNotesMarkdown = "Complete notes on Coordinate geometry formulas, derivation of distance & section formulas, and slope applications.",
            htmlContent = "<h3>Coordinate Geometry</h3><p>Distance d = √[(x₂-x₁)² + (y₂-y₁)²]. Centroid G = ((x₁+x₂+x₃)/3, (y₁+y₂+y₃)/3).</p>",
            mindMapRoot = MindMapNode("mm_cg1", "Coordinate Geometry", "Cartesian Plane", listOf(
                MindMapNode("mm_cg2", "Distance", "d = √[(x₂-x₁)² + (y₂-y₁)²]\nFrom origin: √(x² + y²)"),
                MindMapNode("mm_cg3", "Division of Segments", "Section: (mx₂+nx₁)/(m+n), (my₂+ny₁)/(m+n)\nMidpoint: (x₁+x₂)/2, (y₁+y₂)/2\nCentroid: ∑x/3, ∑y/3"),
                MindMapNode("mm_cg4", "Slope of Line", "m = tan θ = (y₂-y₁)/(x₂-x₁)\nCollinear if slopes match\nParallel lines: m₁ = m₂")
            )),
            questions = listOf(PracticeQuestion("q_cg1", "Find the coordinates of centroid of a triangle whose vertices are (3, -5), (4, 3), and (11, -4).", listOf("(6, -2)", "(6, 2)", "(9, -3)", "(18, -6)"), 0, "x = (3+4+11)/3 = 18/3 = 6; y = (-5+3-4)/3 = -6/3 = -2. Centroid = (6, -2).")),
            flashcards = listOf(Flashcard("fc_cg1", "Slope of X-axis", "What is the slope of X-axis and any line parallel to X-axis?", "0 (Since θ = 0°, tan 0° = 0).")),
            topperTips = listOf("For finding collinearity, calculating slopes is much faster than using distance formula!")
        ),
        Chapter(
            id = "m2_ch6",
            chapterNumber = 6,
            title = "Trigonometry",
            marathiTitle = "त्रिकोणमिती",
            subjectType = SubjectType.MATH_2,
            summary = "Trigonometric ratios (sin, cos, tan, cosec, sec, cot), Trigonometric identities, Relations between ratios, Values for standard angles (0°, 30°, 45°, 60°, 90°), and Applications of Trigonometry: Line of vision, Angle of elevation, Angle of depression, Height and distance problems.",
            keyFormulas = listOf(
                "sin²θ + cos²θ = 1",
                "1 + tan²θ = sec²θ  (or sec²θ - tan²θ = 1)",
                "1 + cot²θ = cosec²θ  (or cosec²θ - cot²θ = 1)",
                "tan θ = sin θ / cos θ; cot θ = cos θ / sin θ",
                "cosec θ = 1/sin θ; sec θ = 1/cos θ; cot θ = 1/tan θ",
                "Values of tan θ: tan 0° = 0, tan 30° = 1/√3, tan 45° = 1, tan 60° = √3, tan 90° = not defined"
            ),
            importantLawsOrTheorems = listOf(
                "Three Fundamental Identities: sin²θ + cos²θ = 1; 1 + tan²θ = sec²θ; 1 + cot²θ = cosec²θ.",
                "Angle of Elevation: Angle made by line of sight with horizontal when looking up.",
                "Angle of Depression: Angle made by line of sight with horizontal when looking down."
            ),
            fullNotesMarkdown = "Complete notes on Trigonometric identities proofs, table of values, and height and distance word problems.",
            htmlContent = "<h3>Trigonometry</h3><p>Identities: sin²θ + cos²θ = 1, 1 + tan²θ = sec²θ, 1 + cot²θ = cosec²θ.</p>",
            mindMapRoot = MindMapNode("mm_trig1", "Trigonometry", "Right Triangle Ratios", listOf(
                MindMapNode("mm_trig2", "Six Ratios", "sin = Opp/Hyp, cos = Adj/Hyp, tan = Opp/Adj\ncosec = 1/sin, sec = 1/cos, cot = 1/tan"),
                MindMapNode("mm_trig3", "Identities", "sin²θ + cos²θ = 1\n1 + tan²θ = sec²θ\n1 + cot²θ = cosec²θ"),
                MindMapNode("mm_trig4", "Applications", "Line of sight\nAngle of elevation (upward)\nAngle of depression (downward)\nBuilding/Tree height")
            )),
            questions = listOf(PracticeQuestion("q_trig1", "If tan θ = 1, then what is the value of (sin θ + cos θ)?", listOf("√2", "1", "2", "1/√2"), 0, "Since tan θ = 1, θ = 45°. sin 45° = 1/√2, cos 45° = 1/√2. Sum = 2/√2 = √2.")),
            flashcards = listOf(Flashcard("fc_trig1", "Value of sin 30° and cos 60°", "What are the values of sin 30° and cos 60°?", "Both equal 1/2 (0.5).")),
            topperTips = listOf("For heights and distances problems, draw a neat labeled right triangle with the horizontal ground line!")
        ),
        Chapter(
            id = "m2_ch7",
            chapterNumber = 7,
            title = "Mensuration",
            marathiTitle = "महत्त्वमापन",
            subjectType = SubjectType.MATH_2,
            summary = "Surface area and volume of 3D solids: Cuboid, Cube, Cylinder, Cone, Sphere, Hemisphere, and Frustum of a cone. Length of an arc of a circle (l = θ/360 × 2πr), Area of a sector (A = θ/360 × πr²), and Area of a segment of a circle.",
            keyFormulas = listOf(
                "Cylinder: CSA = 2πrh, TSA = 2πr(r + h), Volume = πr²h",
                "Cone: Slant height l = √(r² + h²), CSA = πrl, TSA = πr(r + l), Volume = ⅓ πr²h",
                "Sphere: Surface Area = 4πr², Volume = 4/3 πr³",
                "Hemisphere: CSA = 2πr², TSA = 3πr², Volume = 2/3 πr³",
                "Frustum of Cone: Slant height l = √[h² + (r₁ - r₂)²], CSA = π(r₁ + r₂)l, Volume = ⅓ πh(r₁² + r₂² + r₁r₂)",
                "Arc Length: l = (θ / 360°) × 2πr",
                "Area of Sector: A = (θ / 360°) × πr² = (l × r) / 2",
                "Area of Segment = Area of Sector - Area of corresponding triangle = r² [ (πθ/360) - (sin θ/2) ]"
            ),
            importantLawsOrTheorems = listOf(
                "Relation between Sector Area and Arc Length: Area of Sector = (l × r) / 2.",
                "Frustum of a Cone: Formed when a cone is sliced by a plane parallel to its base."
            ),
            fullNotesMarkdown = "Complete compilation of 3D formulas, diagrams, frustum problems, and sector calculations.",
            htmlContent = "<h3>Mensuration (महत्त्वमापन)</h3><p>Cone: CSA = πrl, Vol = ⅓πr²h. Sector Area = (θ/360) × πr² = (l × r) / 2.</p>",
            mindMapRoot = MindMapNode("mm_mens1", "Mensuration", "3D Volumes & Sector Areas", listOf(
                MindMapNode("mm_mens2", "Cylinder & Cone", "Cylinder: CSA = 2πrh, Vol = πr²h\nCone: CSA = πrl, Vol = ⅓πr²h (l = √(r²+h²))"),
                MindMapNode("mm_mens3", "Sphere & Frustum", "Sphere: Area = 4πr², Vol = 4/3 πr³\nFrustum: Slant l = √[h²+(r₁-r₂)²]"),
                MindMapNode("mm_mens4", "Circle Sectors", "Arc length l = (θ/360)·2πr\nSector area = (θ/360)·πr² = lr/2\nSegment = Sector - Triangle")
            )),
            questions = listOf(PracticeQuestion("q_mens1", "If the radius of a sector is 6 cm and length of its arc is 15 cm, what is the area of the sector?", listOf("45 cm²", "90 cm²", "30 cm²", "60 cm²"), 0, "Area of sector = (l × r) / 2 = (15 × 6) / 2 = 45 cm².")),
            flashcards = listOf(Flashcard("fc_mens1", "TSA of Hemisphere", "What is the Total Surface Area (TSA) of a solid hemisphere of radius r?", "TSA = 3πr² (Curved area 2πr² + circular base πr²).")),
            topperTips = listOf("Check if the problem asks for π = 22/7 or 3.14, and always remember to write cubic units (cm³, m³) for volume and square units (cm², m²) for area.")
        )
    )
}
