package com.example.data.repository

import com.example.data.model.*

object Math1Data {
    fun getChapters(): List<Chapter> = listOf(
        Chapter(
            id = "m1_ch1",
            chapterNumber = 1,
            title = "Linear Equations in Two Variables",
            marathiTitle = "दोन चलांमधील रेषीय समीकरणे",
            subjectType = SubjectType.MATH_1,
            summary = "General form ax + by + c = 0, methods of solving: Elimination method, Graphical method, and Determinant method (Cramer's Rule). Equations reducible to a pair of linear equations in two variables, and real-world word problems.",
            keyFormulas = listOf(
                "General Form: ax + by + c = 0 (where a, b, c are real numbers and a, b ≠ 0)",
                "Determinant D = |a₁  b₁| / |a₂  b₂| = a₁b₂ - a₂b₁",
                "Cramer's Rule: x = D_x / D,  y = D_y / D (provided D ≠ 0)",
                "Conditions: Unique solution if a₁/a₂ ≠ b₁/b₂; Infinite if a₁/a₂ = b₁/b₂ = c₁/c₂; No solution if a₁/a₂ = b₁/b₂ ≠ c₁/c₂"
            ),
            importantLawsOrTheorems = listOf(
                "Cramer's Rule: Used to find solutions of linear systems directly using 2x2 determinants.",
                "Graphical Representation: Every linear equation in two variables represents a straight line on Cartesian plane."
            ),
            fullNotesMarkdown = """
# Linear Equations in Two Variables

## 1. Methods of Solving
* **Elimination by equating coefficients:** Multiply equations to make coefficients of one variable equal, then add or subtract.
* **Substitution Method:** Express one variable in terms of the other and substitute.
* **Cramer's Rule (Determinant Method):**
  Given:
  a₁x + b₁y = c₁
  a₂x + b₂y = c₂
  
  D = |a₁  b₁| = a₁b₂ - a₂b₁
      |a₂  b₂|
      
  D_x = |c₁  b₁| = c₁b₂ - c₂b₁
        |c₂  b₂|
        
  D_y = |a₁  c₁| = a₁c₂ - a₂c₁
        |a₂  c₂|
        
  x = D_x / D, y = D_y / D (D ≠ 0).

## 2. Word Problem Categories
* Age related problems
* Two-digit number problems (Original number = 10x + y, Reversed = 10y + x)
* Upstream / Downstream speed problems (Upstream speed = x - y, Downstream speed = x + y)
* Fraction problems (Numerator x, Denominator y)
            """.trimIndent(),
            htmlContent = """
<div style="font-family:sans-serif; padding:12px; color:#1e293b;">
  <h2 style="color:#2563eb;">Linear Equations in Two Variables</h2>
  <div style="background:#eff6ff; padding:10px; border-left:4px solid #3b82f6;">
    <strong>Cramer's Rule:</strong><br/>
    x = D_x / D &nbsp;&nbsp;|&nbsp;&nbsp; y = D_y / D &nbsp;(when D ≠ 0)
  </div>
  <h3>Speed in Water Problems:</h3>
  <p>Let boat speed in still water = x km/h, stream speed = y km/h.</p>
  <ul>
    <li>Downstream speed = (x + y) km/h</li>
    <li>Upstream speed = (x - y) km/h</li>
  </ul>
</div>
            """.trimIndent(),
            mindMapRoot = MindMapNode("mm_le1", "Linear Equations", "ax + by + c = 0", listOf(
                MindMapNode("mm_le2", "Solving Methods", "Elimination\nSubstitution\nGraphical\nCramer's Determinant Rule"),
                MindMapNode("mm_le3", "Determinants", "D = a₁b₂ - a₂b₁\nx = Dx/D, y = Dy/D"),
                MindMapNode("mm_le4", "Applications", "Age, Digit reversing, Fractions, Upstream/Downstream")
            )),
            questions = listOf(
                PracticeQuestion("q_le1", "Find the value of determinant D = | 5  3 | / | -7  -4 |", listOf("1", "-1", "41", "-41"), 0, "D = (5 × -4) - (3 × -7) = -20 - (-21) = -20 + 21 = 1.")
            ),
            flashcards = listOf(
                Flashcard("fc_le1", "Condition for Parallel Lines", "What is the condition for a system of linear equations to have no solution (parallel lines)?", "a₁/a₂ = b₁/b₂ ≠ c₁/c₂")
            ),
            topperTips = listOf("For Cramer's Rule, always arrange both equations in the standard form ax + by = c before calculating D, Dx, Dy.")
        ),
        Chapter(
            id = "m1_ch2",
            chapterNumber = 2,
            title = "Quadratic Equations",
            marathiTitle = "वर्गसमीकरणे",
            subjectType = SubjectType.MATH_1,
            summary = "Standard form ax² + bx + c = 0 (a ≠ 0), Solutions by Factorization method, Completing the square method, and Formula method. Nature of roots using Discriminant (Δ = b² - 4ac), Relation between roots (α, β) and coefficients.",
            keyFormulas = listOf(
                "Standard Form: ax² + bx + c = 0 (a ≠ 0)",
                "Quadratic Formula: x = [-b ± √(b² - 4ac)] / (2a)",
                "Discriminant: Δ = b² - 4ac",
                "Nature of roots: If Δ > 0 (real and unequal), If Δ = 0 (real and equal), If Δ < 0 (not real)",
                "Roots relations: α + β = -b / a,  α · β = c / a",
                "Equation from roots: x² - (α + β)x + αβ = 0"
            ),
            importantLawsOrTheorems = listOf(
                "Discriminant Test: Nature of roots is completely determined by the sign of Δ = b² - 4ac."
            ),
            fullNotesMarkdown = "Complete notes on Factorization, Formula method, Discriminant conditions, and application word problems.",
            htmlContent = "<h3>Quadratic Equations</h3><p>Formula: x = (-b ± √(b² - 4ac)) / 2a. Nature of roots depends on discriminant Δ.</p>",
            mindMapRoot = MindMapNode("mm_qe1", "Quadratic Equations", "ax² + bx + c = 0", listOf(
                MindMapNode("mm_qe2", "Solving Methods", "Factorization (splitting middle term)\nCompleting the square\nQuadratic formula"),
                MindMapNode("mm_qe3", "Discriminant Δ", "Δ = b² - 4ac\nΔ > 0: Real & unequal\nΔ = 0: Real & equal\nΔ < 0: Roots not real"),
                MindMapNode("mm_qe4", "Roots (α, β)", "α + β = -b/a\nαβ = c/a\nx² - (α+β)x + αβ = 0")
            )),
            questions = listOf(PracticeQuestion("q_qe1", "If the roots of quadratic equation 2x² - kx + 2 = 0 are real and equal, find the value of k.", listOf("±4", "±2", "±8", "0"), 0, "For real and equal roots, Δ = b² - 4ac = 0. (-k)² - 4(2)(2) = 0 => k² - 16 = 0 => k = ±4.")),
            flashcards = listOf(Flashcard("fc_qe1", "Sum and Product of Roots", "State the formulas for sum and product of roots of ax² + bx + c = 0.", "Sum: α + β = -b/a. Product: αβ = c/a.")),
            topperTips = listOf("Always verify the discriminant value carefully before declaring roots cannot be real.")
        ),
        Chapter(
            id = "m1_ch3",
            chapterNumber = 3,
            title = "Arithmetic Progression",
            marathiTitle = "अंकगणिती श्रेढी",
            subjectType = SubjectType.MATH_1,
            summary = "Sequence, Arithmetic Progression (A.P.), first term (a), common difference (d = t_(n) - t_(n-1)), finding the n-th term (t_n), and sum of first n terms (S_n). Practical word problems on saving schemes, seating rows, and installment payments.",
            keyFormulas = listOf(
                "n-th term: t_n = a + (n - 1)d",
                "Sum of n terms: S_n = n/2 · [2a + (n - 1)d]",
                "Sum using first and last terms: S_n = n/2 · (t₁ + t_n)",
                "Three terms in A.P.: (a - d), a, (a + d)",
                "Four terms in A.P.: (a - 3d), (a - d), (a + d), (a + 3d)"
            ),
            importantLawsOrTheorems = listOf(
                "Common Difference Constant: A sequence is an A.P. if and only if the difference between any two consecutive terms (d) remains constant."
            ),
            fullNotesMarkdown = "Notes on identifying A.P., calculating t_n, evaluating S_n, and solving word problems.",
            htmlContent = "<h3>Arithmetic Progression</h3><p>t_n = a + (n-1)d and S_n = n/2 · [2a + (n-1)d].</p>",
            mindMapRoot = MindMapNode("mm_ap1", "Arithmetic Progression", "Sequence with constant d", listOf(
                MindMapNode("mm_ap2", "Definitions", "First term = a, Common difference d = t_n - t_(n-1)"),
                MindMapNode("mm_ap3", "n-th Term", "t_n = a + (n - 1)d"),
                MindMapNode("mm_ap4", "Sum of Terms", "S_n = n/2 [2a + (n-1)d] = n/2 [t₁ + t_n]")
            )),
            questions = listOf(PracticeQuestion("q_ap1", "In an A.P., if a = 3.5, d = 0, n = 101, then what is t_n?", listOf("3.5", "0", "104.5", "101"), 0, "Since d = 0, every term is identical to first term: t_n = 3.5.")),
            flashcards = listOf(Flashcard("fc_ap1", "Sum of first n natural numbers", "What is the formula for sum of first n natural numbers?", "S_n = [n(n + 1)] / 2")),
            topperTips = listOf("Check if d is negative when the sequence is decreasing!")
        ),
        Chapter(
            id = "m1_ch4",
            chapterNumber = 4,
            title = "Financial Planning",
            marathiTitle = "अर्थनियोजन",
            subjectType = SubjectType.MATH_1,
            summary = "Goods and Services Tax (GST: CGST + SGST), Tax Invoice, GSTIN (15-digit alphanumeric code), Input Tax Credit (ITC) and GST payable, Shares, Face Value (FV), Market Value (MV), Dividend, Brokerage, and Mutual Funds (NAV, SIP).",
            keyFormulas = listOf(
                "GST = CGST + SGST (where CGST = SGST = GST / 2)",
                "GST Payable = Output Tax - Input Tax Credit (ITC)",
                "Shares at Par: MV = FV; At Premium: MV > FV; At Discount: MV < FV",
                "Total Investment = Number of shares × MV + Brokerage + GST on brokerage",
                "Rate of Return = (Dividend earned / Total investment) × 100%"
            ),
            importantLawsOrTheorems = listOf(
                "GSTIN: 15-digit structure containing 2-digit State code + 10-digit PAN + 1 entity code + 1 default Z + 1 checksum digit."
            ),
            fullNotesMarkdown = "Detailed guide on calculating GST, CGST, SGST, ITC tax credit, shares, brokerage, and SIP returns.",
            htmlContent = "<h3>Financial Planning</h3><p>GST Payable = Output Tax - Input Tax Credit (ITC). CGST rate = SGST rate = half of GST rate.</p>",
            mindMapRoot = MindMapNode("mm_fp1", "Financial Planning", "Taxes & Investments", listOf(
                MindMapNode("mm_fp2", "GST System", "CGST + SGST\nTax Invoice & GSTIN\nITC credit: Payable = Output Tax - ITC"),
                MindMapNode("mm_fp3", "Share Market", "FV, MV (At par, premium, discount)\nDividend = Rate% × FV\nBrokerage & GST"),
                MindMapNode("mm_fp4", "Mutual Funds", "NAV (Net Asset Value)\nSIP (Systematic Investment Plan)")
            )),
            questions = listOf(PracticeQuestion("q_fp1", "If the rate of GST on an air-conditioner is 28%, then the rate of CGST is:", listOf("14%", "28%", "7%", "0%"), 0, "CGST is always equal to half of total GST: 28% / 2 = 14%.")),
            flashcards = listOf(Flashcard("fc_fp1", "GSTIN Length", "How many alphanumeric digits does a GSTIN have?", "15 digits (e.g. 27AAAAA0000A1Z5 for Maharashtra).")),
            topperTips = listOf("Remember: Dividend is always calculated on the Face Value (FV), never on the Market Value (MV)!")
        ),
        Chapter(
            id = "m1_ch5",
            chapterNumber = 5,
            title = "Probability",
            marathiTitle = "संभाव्यता",
            subjectType = SubjectType.MATH_1,
            summary = "Random experiment, Outcomes, Sample space (S) and number of sample points n(S), Events and types of events (Certain, Impossible, Complementary, Mutually exclusive), and Probability of an event P(A) = n(A) / n(S).",
            keyFormulas = listOf(
                "Sample space of 1 coin: S = {H, T}, n(S) = 2",
                "Sample space of 2 coins: S = {HH, HT, TH, TT}, n(S) = 4",
                "Sample space of 3 coins: n(S) = 2³ = 8",
                "Sample space of 1 die: S = {1, 2, 3, 4, 5, 6}, n(S) = 6",
                "Sample space of 2 dice: n(S) = 6 × 6 = 36",
                "Probability: P(A) = n(A) / n(S), where 0 ≤ P(A) ≤ 1"
            ),
            importantLawsOrTheorems = listOf(
                "Range of Probability: The probability of any event is always between 0 and 1 inclusive (or 0% to 100%). P(Impossible) = 0, P(Certain) = 1."
            ),
            fullNotesMarkdown = "Complete notes on pack of 52 playing cards (26 red, 26 black, 4 suits, 12 face cards), coin tossing, and dice rolling.",
            htmlContent = "<h3>Probability</h3><p>P(A) = n(A) / n(S). Pack of 52 cards: 13 Spades, 13 Clubs, 13 Hearts, 13 Diamonds (12 Face cards: 4 King, 4 Queen, 4 Jack).</p>",
            mindMapRoot = MindMapNode("mm_pr1", "Probability", "Chance of occurrence", listOf(
                MindMapNode("mm_pr2", "Sample Space S", "Coins (1: 2, 2: 4, 3: 8)\nDice (1: 6, 2: 36)\nCards (52 cards: 26 Red, 26 Black)"),
                MindMapNode("mm_pr3", "Events", "Subset of S\nCertain, Impossible, Mutually Exclusive"),
                MindMapNode("mm_pr4", "Calculation", "P(A) = n(A) / n(S)\nAlways 0 ≤ P(A) ≤ 1")
            )),
            questions = listOf(PracticeQuestion("q_pr1", "What is the probability of drawing a face card from a well-shuffled standard pack of 52 cards?", listOf("3/13 (12/52)", "1/13", "4/13", "1/4"), 0, "There are 12 face cards (4 Kings, 4 Queens, 4 Jacks). P = 12/52 = 3/13.")),
            flashcards = listOf(Flashcard("fc_pr1", "Sum of complementary probabilities", "What is P(A) + P(A') equal to?", "1. The sum of the probability of an event and its complement is always 1.")),
            topperTips = listOf("Always write the full sample space S and count n(S) clearly in step 1 of your solution.")
        ),
        Chapter(
            id = "m1_ch6",
            chapterNumber = 6,
            title = "Statistics",
            marathiTitle = "सांख्यिकी",
            subjectType = SubjectType.MATH_1,
            summary = "Measures of central tendency: Mean (Direct method, Assumed mean method, Step deviation method), Median (using cumulative frequency), Mode (modal class formula), and Graphical representations: Histogram, Frequency polygon, and Pie chart.",
            keyFormulas = listOf(
                "Direct Mean: x̄ = (∑ f_i x_i) / (∑ f_i)",
                "Assumed Mean: x̄ = A + d̄ = A + (∑ f_i d_i) / N",
                "Step Deviation Mean: x̄ = A + [ (∑ f_i u_i) / N ] × g",
                "Median = L + [ (N/2 - cf) / f ] × h",
                "Mode = L + [ (f₁ - f₀) / (2f₁ - f₀ - f₂) ] × h",
                "Pie Chart Central Angle: θ = (Value of component / Total value) × 360°"
            ),
            importantLawsOrTheorems = listOf(
                "Continuous Class Intervals: Before calculating Median or Mode, class intervals must be continuous. If discontinuous, subtract 0.5 from lower limit and add 0.5 to upper limit."
            ),
            fullNotesMarkdown = "Step-by-step calculation methods for Mean, Median, Mode, Histograms, and Pie chart angles.",
            htmlContent = "<h3>Statistics</h3><p>Central angle θ = (Component / Total) × 360°. Mode formula: L + [(f₁ - f₀)/(2f₁ - f₀ - f₂)] × h.</p>",
            mindMapRoot = MindMapNode("mm_st1", "Statistics", "Data analysis", listOf(
                MindMapNode("mm_st2", "Mean (3 Methods)", "Direct: ∑fx / ∑f\nAssumed Mean: A + ∑fd/N\nStep-deviation: A + (∑fu/N)·h"),
                MindMapNode("mm_st3", "Median & Mode", "Median = L + [(N/2 - cf)/f]·h\nMode = L + [(f₁ - f₀)/(2f₁ - f₀ - f₂)]·h"),
                MindMapNode("mm_st4", "Graphs", "Histogram\nFrequency polygon\nPie chart: θ = (Val/Total) × 360°")
            )),
            questions = listOf(PracticeQuestion("q_st1", "In a pie chart, if the total expenditure is ₹72,000 and expenditure on education is ₹18,000, what is the central angle for education?", listOf("90°", "60°", "120°", "45°"), 0, "θ = (18,000 / 72,000) × 360° = (1/4) × 360° = 90°.")),
            flashcards = listOf(Flashcard("fc_st1", "Empirical Relationship", "What is the empirical relation between Mean, Median, and Mode?", "Mode ≈ 3 × Median - 2 × Mean")),
            topperTips = listOf("Ensure classes are made continuous before choosing the modal class or median class!")
        )
    )
}
