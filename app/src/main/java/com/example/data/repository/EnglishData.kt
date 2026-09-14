package com.example.data.repository

import com.example.data.model.*

object EnglishData {
    fun getChapters(): List<Chapter> = listOf(
        // Chapter 1: A Teenager's Prayer (Poem)
        Chapter(
            id = "eng_ch_1",
            chapterNumber = 1,
            title = "A Teenager's Prayer",
            marathiTitle = "एका किशोरवयीन मुलाची प्रार्थना (जे. मोर्स)",
            subjectType = SubjectType.ENGLISH,
            summary = "The poet J. Morse reflects on the crucial transitional teenage years, praying to God for wisdom to choose the right path, avoid darkness, and live life to the fullest.",
            keyFormulas = listOf(
                "Rhyme Scheme: abcb throughout the poem",
                "Theme: A teenager seeking divine guidance to make morally upright decisions",
                "Central Quote: 'Help, Lord, to just say 'no' / When temptation comes my way'",
                "Figures of Speech: Apostrophe ('Please open up my eyes, dear Lord'), Alliteration, Metaphor ('Travel down the darkened road')"
            ),
            importantLawsOrTheorems = listOf(
                "Poem Appreciation Scheme: Title (0.5), Poet (0.5), Rhyme Scheme (1), Figures of Speech (1), Theme/Central Idea (2)",
                "Total appreciation marks: 5 Marks in SSC Board"
            ),
            fullNotesMarkdown = """
                # A Teenager's Prayer - J. Morse

                ### Critical Appreciation (5 Marks Board Blueprint):
                - **Title:** The title 'A Teenager's Prayer' is very appropriate as it depicts the emotional needs of adolescents standing at the threshold of adult life.
                - **Poet:** Written by J. Morse.
                - **Rhyme Scheme:** The rhyme scheme of each stanza is **abcb** (e.g., make - take, road - lead, day - way).
                - **Figures of Speech:**
                  1. **Apostrophe:** The teenager addresses God directly as though He were physically present ('Please open up my eyes, dear Lord').
                  2. **Alliteration:** 'Travel down the darkened road' (Repetition of the 'd' sound).
                  3. **Metaphor:** 'Darkened road' represents an evil, dishonest, or destructive way of life.
                - **Theme / Central Idea:** Teenagers face pivotal choices and dilemmas every day. The poet prays to the Almighty to grant wisdom to navigate temptations, say 'no' to vices, and walk on the road of success and peace.
            """.trimIndent(),
            htmlContent = """
                <div style="font-family:sans-serif;line-height:1.6;color:#1e293b;padding:12px;">
                    <h2 style="color:#0284c7;border-bottom:2px solid #0284c7;padding-bottom:6px;">A Teenager's Prayer</h2>
                    <p><strong>Poet:</strong> J. Morse | <strong>Rhyme Scheme:</strong> abcb</p>
                    <div style="background:#f0f9ff;border-left:4px solid #0284c7;padding:12px;border-radius:6px;">
                        <h4 style="margin:0 0 6px 0;color:#0369a1;">Key Figures of Speech:</h4>
                        <ul>
                            <li><strong>Apostrophe:</strong> Direct address to Almighty God.</li>
                            <li><strong>Metaphor:</strong> 'Darkened road' equals evil path.</li>
                            <li><strong>Alliteration:</strong> Pleasant repetition of consonant sounds.</li>
                        </ul>
                    </div>
                </div>
            """.trimIndent(),
            mindMapRoot = MindMapNode(
                id = "m_eng1",
                title = "A Teenager's Prayer",
                description = "Poetic blueprint for 5/5 appreciation",
                children = listOf(
                    MindMapNode("m_e1_1", "Rhyme Scheme", "abcb format in all 5 stanzas"),
                    MindMapNode("m_e1_2", "Key Prayer", "Guidance, clarity, moral strength"),
                    MindMapNode("m_e1_3", "Figures of Speech", "Apostrophe, Metaphor, Alliteration"),
                    MindMapNode("m_e1_4", "Central Message", "Choose success & shun dark temptations")
                )
            ),
            questions = listOf(
                PracticeQuestion(
                    id = "q_eng1_1",
                    question = "What is the rhyme scheme of 'A Teenager's Prayer'?",
                    options = listOf("abcb", "aabb", "abab", "abba"),
                    correctOptionIndex = 0,
                    explanation = "In each four-line stanza, the second and fourth lines rhyme, making the scheme abcb."
                ),
                PracticeQuestion(
                    id = "q_eng1_2",
                    question = "Identify the figure of speech in: 'Please open up my eyes, dear Lord':",
                    options = listOf("Apostrophe", "Hyperbole", "Oxymoron", "Onomatopoeia"),
                    correctOptionIndex = 0,
                    explanation = "Apostrophe is when an absent, dead, or abstract entity (God here) is addressed directly as present."
                )
            ),
            flashcards = listOf(
                Flashcard("fc_eng1_1", "Appreciation Marks", "What is the weightage of Poetic Appreciation?", "Total 5 marks: Title (0.5), Poet (0.5), Rhyme Scheme (1), Figures of Speech (1), Theme (2).")
            ),
            topperTips = listOf(
                "Write the poem appreciation in neat paragraphs rather than short fragments to secure full 5 marks."
            )
        ),

        // Chapter 2: An Epitome of Courage (Stephen Hawking)
        Chapter(
            id = "eng_ch_2",
            chapterNumber = 2,
            title = "An Epitome of Courage",
            marathiTitle = "धैर्याचे मूर्तिमंत रूप - डॉ. स्टीफन हॉकिंग",
            subjectType = SubjectType.ENGLISH,
            summary = "The inspiring biography of Dr. Stephen Hawking who, despite being diagnosed with Amyotrophic Lateral Sclerosis (ALS) at 21, revolutionized modern astrophysics and cosmology.",
            keyFormulas = listOf(
                "Character Traits: Undaunted optimism, razor-sharp intellect, dry wit, humility",
                "Greatest Achievement: 'A Brief History of Time' (best-seller for 237 weeks)",
                "Scientific Concept: Hawking Radiation (Black holes emit thermal radiation and slowly evaporate)",
                "Inspiring Quote: 'Look up at the stars and not down at your feet.'"
            ),
            importantLawsOrTheorems = listOf(
                "Hawking's Formula for Life: Focus on what your disability does not prevent you from doing well",
                "Synthesized Speech Computer: Allowed him to communicate through a cheek muscle sensor"
            ),
            fullNotesMarkdown = """
                # An Epitome of Courage - Dr. Stephen Hawking

                ### Life and Hardships:
                - Born on 8th January 1942 (300th anniversary of Galileo's death).
                - At 21, he was diagnosed with ALS (Lou Gehrig's disease), leaving his motor neurons paralyzed. Doctors gave him barely 2 years to live.
                - Refusing to succumb to despair, he continued his Ph.D. at Cambridge University.

                ### Monumental Achievements:
                - Formulated mathematical models proving that Black Holes emit energy known as **Hawking Radiation**.
                - Published *A Brief History of Time*, simplifying complex quantum mechanics and cosmology for common readers.
                - Honored with numerous awards, including the Albert Einstein Award and Presidential Medal of Freedom.
            """.trimIndent(),
            htmlContent = """
                <div style="font-family:sans-serif;line-height:1.6;color:#1e293b;padding:12px;">
                    <h2 style="color:#059669;border-bottom:2px solid #059669;padding-bottom:6px;">An Epitome of Courage</h2>
                    <p><strong>Protagonist:</strong> Dr. Stephen Hawking | <strong>Key Concept:</strong> Resilience & Black Holes</p>
                    <div style="background:#ecfdf5;border-left:4px solid #059669;padding:12px;border-radius:6px;">
                        <p>Hawking proved that physical confinement to a wheelchair cannot imprison the limitless human spirit.</p>
                    </div>
                </div>
            """.trimIndent(),
            mindMapRoot = MindMapNode(
                id = "m_eng2",
                title = "Dr. Stephen Hawking",
                description = "Epitome of Human Courage",
                children = listOf(
                    MindMapNode("m_e2_1", "The Disease", "ALS diagnosed at age 21"),
                    MindMapNode("m_e2_2", "Science", "Black holes & Hawking Radiation"),
                    MindMapNode("m_e2_3", "Legacy", "'A Brief History of Time' book"),
                    MindMapNode("m_e2_4", "Philosophy", "Unstoppable willpower & optimism")
                )
            ),
            questions = listOf(
                PracticeQuestion(
                    id = "q_eng2_1",
                    question = "What rare medical condition was Dr. Stephen Hawking diagnosed with?",
                    options = listOf("Amyotrophic Lateral Sclerosis (ALS)", "Parkinson's Disease", "Alzheimer's", "Muscular Dystrophy"),
                    correctOptionIndex = 0,
                    explanation = "Hawking was diagnosed with ALS (also called motor neuron disease) which affects nerve cells controlling voluntary muscles."
                )
            ),
            flashcards = listOf(
                Flashcard("fc_eng2_1", "Hawking Radiation", "What is Hawking Radiation?", "Thermal radiation predicted to be released by black holes outside their event horizon.")
            ),
            topperTips = listOf(
                "Memorize Hawking's key quotes for personal response questions to make your answers stand out."
            )
        ),

        // Chapter 3: English Grammar Masterclass
        Chapter(
            id = "eng_ch_3",
            chapterNumber = 3,
            title = "English Grammar & Language Study",
            marathiTitle = "इंग्रजी व्याकरण व भाषा अभ्यास (Tenses, Voice, Speech, Clauses)",
            subjectType = SubjectType.ENGLISH,
            summary = "Complete board-focused grammar rules: Active & Passive Voice, Direct & Indirect Speech, 12 Tenses, Figures of Speech, Degrees of Comparison, and Sentence Transformations.",
            keyFormulas = listOf(
                "Active to Passive: Subject + Verb + Object -> Object + appropriate 'be' form + Past Participle (V3) + by + Subject",
                "Direct to Indirect Speech: Present simple -> Past simple, Past simple -> Past perfect, 'said to' -> 'told'",
                "Degree of Comparison: Positive (as...as / so...as) -> Comparative (-er than / more...than) -> Superlative (the -est / the most)",
                "Question Tag: Positive sentence -> Negative tag; Negative sentence -> Positive tag",
                "Figures of Speech: Simile (like/as), Metaphor (direct comparison), Personification (human qualities to non-human)"
            ),
            importantLawsOrTheorems = listOf(
                "Do as Directed (Section 1: Language Study) carries 10 Marks in Board Exam",
                "Subject-Verb Agreement rules must always be verified"
            ),
            fullNotesMarkdown = """
                # Comprehensive English Grammar for Class 10th SSC

                ### 1. Active and Passive Voice:
                - **Simple Present:** He writes a letter. -> A letter is written by him.
                - **Simple Past:** She sang a song. -> A song was sung by her.
                - **Present Perfect:** They have built a bridge. -> A bridge has been built by them.
                - **Modal Auxiliaries:** You can solve this. -> This can be solved by you.

                ### 2. Direct and Indirect Speech:
                - **Pronoun Changes:** I -> he/she, we -> they, my -> his/her.
                - **Tense Shift:**
                  - 'am/is' -> 'was'
                  - 'have/has' -> 'had'
                  - 'will' -> 'would', 'can' -> 'could'
                - **Reporting Verbs:** Assertive: said that; Interrogative: asked / enquired if/whether; Imperative: requested / ordered to.

                ### 3. Clauses & Synthesis:
                - **Noun Clause:** Acts as subject or object ('I know *that he is honest*').
                - **Adjective Clause:** Qualifies a noun ('The boy *who scored first* is my friend').
                - **Adverb Clause:** Modifies a verb showing time, reason, condition ('We started *when the rain stopped*').
            """.trimIndent(),
            htmlContent = """
                <div style="font-family:sans-serif;line-height:1.6;color:#1e293b;padding:12px;">
                    <h2 style="color:#7c3aed;border-bottom:2px solid #7c3aed;padding-bottom:6px;">Grammar Cheat Sheet</h2>
                    <table style="width:100%;border-collapse:collapse;margin:12px 0;">
                        <tr style="background:#f3e8ff;">
                            <th style="border:1px solid #c084fc;padding:8px;">Grammar Item</th>
                            <th style="border:1px solid #c084fc;padding:8px;">Golden Formula</th>
                            <th style="border:1px solid #c084fc;padding:8px;">Example</th>
                        </tr>
                        <tr>
                            <td style="border:1px solid #e2e8f0;padding:8px;"><strong>Passive Voice</strong></td>
                            <td style="border:1px solid #e2e8f0;padding:8px;">Obj + Be + V3 + by + Sub</td>
                            <td style="border:1px solid #e2e8f0;padding:8px;">The bell was rung by him.</td>
                        </tr>
                        <tr>
                            <td style="border:1px solid #e2e8f0;padding:8px;"><strong>Indirect Speech</strong></td>
                            <td style="border:1px solid #e2e8f0;padding:8px;">Past shift + remove quotes</td>
                            <td style="border:1px solid #e2e8f0;padding:8px;">He said that he was happy.</td>
                        </tr>
                        <tr>
                            <td style="border:1px solid #e2e8f0;padding:8px;"><strong>Superlative Degree</strong></td>
                            <td style="border:1px solid #e2e8f0;padding:8px;">'The' + -est form</td>
                            <td style="border:1px solid #e2e8f0;padding:8px;">Mount Everest is the highest peak.</td>
                        </tr>
                    </table>
                </div>
            """.trimIndent(),
            mindMapRoot = MindMapNode(
                id = "m_eng3",
                title = "English Grammar",
                description = "Master Language Study & Grammar Rules",
                children = listOf(
                    MindMapNode("m_e3_1", "Voice", "Active & Passive conversion"),
                    MindMapNode("m_e3_2", "Narration", "Direct to Indirect rules"),
                    MindMapNode("m_e3_3", "Clauses", "Noun, Adjective, Adverb"),
                    MindMapNode("m_e3_4", "Transformations", "Degrees, Question tags, As soon as / No sooner")
                )
            ),
            questions = listOf(
                PracticeQuestion(
                    id = "q_eng3_1",
                    question = "Change to passive voice: 'The teacher guided the students.'",
                    options = listOf(
                        "The students were guided by the teacher.",
                        "The students are guided by the teacher.",
                        "The students had guided the teacher.",
                        "The teacher was guided by the students."
                    ),
                    correctOptionIndex = 0,
                    explanation = "Simple past passive takes: Object ('The students') + 'were' (plural) + V3 ('guided') + by + Subject ('the teacher')."
                ),
                PracticeQuestion(
                    id = "q_eng3_2",
                    question = "Add a question tag: 'She is working hard,'",
                    options = listOf("isn't she?", "is she?", "doesn't she?", "can't she?"),
                    correctOptionIndex = 0,
                    explanation = "For a positive statement with auxiliary verb 'is', the question tag is negative: 'isn't she?'"
                )
            ),
            flashcards = listOf(
                Flashcard("fc_eng3_1", "No sooner... than", "How to use 'No sooner... than'?", "Replace 'As soon as' with 'No sooner' + auxiliary verb (did/had/does) + subject + than...")
            ),
            topperTips = listOf(
                "When changing degrees of comparison, ensure the original meaning is strictly maintained."
            )
        ),

        // Chapter 4: Writing Skills & Communication
        Chapter(
            id = "eng_ch_4",
            chapterNumber = 4,
            title = "Writing Skills (Letter, Summary, Report, Speech)",
            marathiTitle = "उपयोजित इंग्रजी लेखन (पत्र, सारांश, अहवाल व भाषण)",
            subjectType = SubjectType.ENGLISH,
            summary = "Detailed guides and standard modern block formats for Formal Letters, Summary Writing, Report Writing for newspapers, Speech Delivery, and Expansion of Ideas.",
            keyFormulas = listOf(
                "Formal Letter Block Format: Sender's Address -> Date -> Receiver's Address -> Subject -> Salutation -> Body (3 paragraphs) -> Subscription -> Sender's Name",
                "Report Writing Format: Headline -> Byline (Staff Reporter) -> Dateline (Place, Date) -> Lead Paragraph -> Detail Body",
                "Speech Writing: Address to dignitaries and peers -> Stating importance of topic -> Facts and arguments -> Call to action -> Thank you",
                "Expansion of Ideas: Stating core proverb meaning -> Real life historical/social examples -> Moral conclusion"
            ),
            importantLawsOrTheorems = listOf(
                "Left-aligned block formatting is mandatory in Maharashtra State Board English examinations",
                "Avoid spelling and punctuation errors to retain maximum expression marks"
            ),
            fullNotesMarkdown = """
                # English Writing Skills - 25 Marks Strategy

                ### 1. Formal Letter Writing:
                - Everything must be aligned to the **left margin**.
                - **Sender's address:** 3 lines with pincode.
                - **Date:** 10th March 2025.
                - **Recipient's designation & address:** To, The Municipal Commissioner / The Headmaster.
                - **Subject:** Crisp, within 6 to 8 words.
                - **Body:**
                  - Para 1: Purpose of writing.
                  - Para 2: Detailed explanation of the issue or request.
                  - Para 3: Anticipated action and gratitude.
                - **Subscription:** Yours faithfully / Yours sincerely, [Name].

                ### 2. Report Writing (5 Marks):
                - **Headline:** Catchy and in capital/bold (e.g., ANNUAL SCIENCE EXHIBITION HELD AT MODEL SCHOOL).
                - **Byline:** By a Student Reporter / Staff Correspondent.
                - **Dateline:** Pune, March 12:
                - **Chronological description:** Who, what, when, where, and how.
            """.trimIndent(),
            htmlContent = """
                <div style="font-family:sans-serif;line-height:1.6;color:#1e293b;padding:12px;">
                    <h2 style="color:#d97706;border-bottom:2px solid #d97706;padding-bottom:6px;">Writing Skills Mastery</h2>
                    <div style="background:#fffbeb;border-left:4px solid #d97706;padding:12px;border-radius:6px;">
                        <p><strong>Formal Letter Rule:</strong> All components (addresses, dates, salutations, body, and sign-off) must align flush against the left margin without indentation.</p>
                    </div>
                </div>
            """.trimIndent(),
            mindMapRoot = MindMapNode(
                id = "m_eng4",
                title = "Writing Skills",
                description = "Master Board Composition",
                children = listOf(
                    MindMapNode("m_e4_1", "Letters", "Formal & Informal block layouts"),
                    MindMapNode("m_e4_2", "Summary", "1/3 length with suitable title"),
                    MindMapNode("m_e4_3", "Reports", "Headline, Dateline, Facts"),
                    MindMapNode("m_e4_4", "Expansion", "Proverbs, morals & insights")
                )
            ),
            questions = listOf(
                PracticeQuestion(
                    id = "q_eng4_1",
                    question = "Where is the date placed in modern block letter format?",
                    options = listOf("Left margin below sender's address", "Right top corner", "At the bottom after signature", "Inside the subject"),
                    correctOptionIndex = 0,
                    explanation = "Under the new block format, the date is placed flush with the left margin right below the sender's address."
                )
            ),
            flashcards = listOf(
                Flashcard("fc_eng4_1", "Byline", "What is a Byline in Report Writing?", "A line stating the name and designation of the person writing the report (e.g., 'By Staff Reporter').")
            ),
            topperTips = listOf(
                "Always give a creative title to your summary to secure 1 mark immediately."
            )
        )
    )
}
