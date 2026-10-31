# Step_semester_3
Semester 3 projects, assignments, and programming practice work.

## Date: 01-11-2026

**Today's Work:**
- Completed Session 10 (Week 10: Linked Lists & Data Structures Practice) Java programming questions.
- Solved class problems and assignment problems:
  - 5 Class Problems in `linked_list.class_problems`:
    - `BankAccountWithdrawalSystem.java`: Implemented bank account withdrawal system supporting Savings (minimum balance 1000) and Current (overdraft limit 5000) accounts with rule rejection.
    - `CampusVehiclePassSystem.java`: Designed campus vehicle pass system with tiered fee computation and electric vehicle charging bay allocation using a `Chargeable` interface.
    - `StudentClubRegistrationManagement.java`: Developed student club registration system preventing duplicates by overriding `equals()` and `hashCode()` strictly on student roll number.
    - `ClassMarksGridAnalysis.java`: Processed 2D grid of student marks to compute individual totals, formatted subject averages, and identified class topper.
    - `PayrollRegisterSystem.java`: Implemented polymorphic payroll system for FullTime, PartTime, and Intern staff, generating payslips, total payout, and top earner.
  - 5 Assignment Problems in `linked_list.assignment_problems`:
    - `PriorityTokenInsertion.java`: Implemented custom singly linked list with `addFirst` (O(1)), `addLast` (O(n)), and `insertAt` (O(n)) token insertion operations without `java.util.LinkedList`.
    - `CancelledOrdersCleanup.java`: Implemented in-place order code deletion via `removeAll(Node head, int code)` in O(n) time and O(1) space.
    - `ReverseTheQueue.java`: Reversed singly linked queue in place using three-pointer pointer reversal in O(n) time and O(1) space without allocating new nodes.
    - `TrainCoachesBothWays.java`: Built doubly linked list for train coaches with bidirectional traversal (`printForward`, `printBackward`) and O(1) node unlinking after O(n) search.
    - `RoundRobinGameTurns.java`: Implemented circular singly linked list with tail reference to model round-robin game turns wrapping seamlessly in O(1) add and O(k) turn simulation.
- Organized Java files into clean topic-based packages (`linked_list.class_problems` and `linked_list.assignment_problems`).
- Compiled and verified all solutions using `javac` with exact matching to all specification samples.
- Pushed solutions to feature/week_10.

**Next Session Plan:**
- Continue with the next Java programming session (Week 11).

**Issues Faced:**
- None. All 10 solutions compiled and tested cleanly with exact expected outputs.

## Date: 01-11-2026

**Today's Work:**
- Completed Session 9 (Week 9: Data Structures - Arrays, Hashing, Two Pointers, Sliding Window, Binary Search) Java programming questions.
- Solved class problems and assignment problems:
  - 5 Class Problems in `data_structures.class_problems`:
    - `LibraryCatalogLookup.java`: Implemented binary search on pre-sorted book records by ISBN in O(log n) time.
    - `WarehouseGridSummary.java`: Traversed 2D warehouse layout calculating total inventory and locating maximum item bin coordinates in O(m * n) time.
    - `PairWithTargetSum.java`: Detected target sum pairs using optimal HashSet complement lookup in O(n) time and O(n) space.
    - `PairWithTargetSumTwoPointers.java`: Evaluated algorithmic trade-offs comparing O(n) HashSet complement search against O(n log n) sorting + Two Pointers.
    - `ContainerWithMostWater.java`: Implemented container water maximization using the Two Pointers technique in O(n) time and O(1) space.
  - 5 Assignment Problems in `data_structures.assigment_problems`:
    - `ClassTopperFinder.java`: Analyzed 2D student marks matrix to find topper with tie-breaking for smallest row index in O(m * n) time.
    - `MergeTokenQueues.java`: Merged two sorted token lists preserving duplicates using Two Pointers in O(m + n) time without re-sorting.
    - `MostPopularCanteenOrder.java`: Counted canteen orders using HashMap frequency tracking and first-occurrence tie resolution in O(n) time.
    - `HotWeatherAlertWindows.java`: Counted qualifying consecutive k-hour weather alert blocks using Sliding Window in O(n) time.
    - `TicketPriceSlotFinder.java`: Found ticket price slot and insertion positions using Binary Search in O(log n) time.
- Organized Java files into topic-based packages (`data_structures.class_problems` and `data_structures.assigment_problems`).
- Compiled and tested all solutions against sample inputs and boundary cases.
- Pushed solutions to feature/week_9.

**Next Session Plan:**
- Continue with the next Java programming session (Week 10).

**Issues Faced:**
- None. All 10 solutions compiled and tested cleanly with exact expected outputs.

## Date: 01-11-2026

**Today's Work:**
- Completed Session 8 (Week 8: Object-Oriented Design & System Modeling) Java programming questions.
- Solved class problems and assignment problems:
  - 5 Class Problems in `object_oriented_design.class_problems`:
    - `VehicleRentalSystem.java`: Implemented vehicle rental system with availability tracking, polymorphic vehicle category pricing (Sedan, SUV, Truck), and vehicle return handling.
    - `EmployeeLeaveRequestWorkflow.java`: Modeled leave request workflow across employee categories (FullTime, PartTime, Contractor) with valid state transitions (Pending -> Approved/Rejected) and regression guards.
    - `OnlineExaminationSystem.java`: Designed online exam architecture with multiple question types (MCQ, True/False, Short Answer), self-evaluation scoring, and immutable submission answer locks.
    - `HotelBookingSystem.java`: Managed room reservation overlap checking, category pricing rules (StandardRoom, DeluxeRoom), and deadline-enforced cancellations.
    - `PaymentProcessingSystem.java`: Created shopping checkout module with payment method abstractions (CreditCard, PayPal), empty-order validation, and transaction-driven order status updates.
  - 5 Assignment Problems in `object_oriented_design.assigment_problems`:
    - `HostelLaundryQueue.java`: Modeled hostel washing machine booking system with wash type abstractions (Quick, Normal, Heavy), busy/free status protection, and cycle completion workflows.
    - `AssignmentSubmissionPortal.java`: Implemented college submission portal with category-specific late submission penalties (Coding 10%/day, Written 20%/day) and post-grading resubmission blocks.
    - `CampusPremiereTicketCounter.java`: Built movie ticket booking system with category-based seat pricing (Regular, Premium, Recliner), 6-seat limit, duplicate booking guards, and cancellation seat release.
    - `FitZoneMembershipDesk.java`: Designed gym membership subscription system with discount plan rules (Monthly, Quarterly, Annual), status lifecycle (Active, Frozen, Expired), and check-in access control.
    - `CampusNoticeBroadcaster.java`: Built notice broadcasting module with target department filtering, notice validation, and polymorphic notification delivery (Email, SMS, App).
- Organized Java files into topic-based packages (`object_oriented_design.class_problems` and `object_oriented_design.assigment_problems`).
- Compiled and tested all solutions against sample inputs and boundary cases.
- Pushed solutions to feature/week_8.

**Next Session Plan:**
- Continue with the next Java programming session (Week 9).

**Issues Faced:**
- None. All 10 solutions compiled and tested cleanly with exact expected outputs.

## Date: 01-11-2026

**Today's Work:**
- Completed Session 7 (Week 7: Abstract Classes, Interfaces & Polymorphism) Java programming questions.
- Solved class problems and assignment problems:
  - 5 Class Problems in `abstraction.class_problems`:
    - `Toy.java`: Abstract Toy class with abstract `makeSound()`, static counter assigning `toyId` (`TOY-1001`), and concrete subclasses `ToyCar` and `ToyRobot`.
    - `Printable.java`: Common `Printable` interface with `printLabel()`, implemented by unrelated classes `PackageBox` and `Invoice`, with polymorphic `printAll()`.
    - `Instrument.java`: Multilevel inheritance with abstract `Instrument`, concrete `StringInstrument`, and `Violin` using `super.play()` method call chaining.
    - `KitchenTool.java`: Abstract `KitchenTool` class with JavaBean validated `speedLevel` (1-5 range check), `Washable` interface, and `Blender` implementation.
    - `DeliveryNote.java`: Abstract `DeliveryNote` class with compile-time overloaded `confirmDelivery(String signature)`, concrete subclasses `ParcelNote` and `LetterNote`, and polymorphic `logAll()`.
  - 5 Assignment Problems in `abstraction.assigment_problems`:
    - `Ringable.java`: `Ringable` interface with `ring()`, implemented by independent device classes `AlarmClock` and `Doorbell`, with polymorphic `ringAll()`.
    - `ArtPiece.java`: Abstract `ArtPiece` class with shared static `pieceId` counter and abstract `describe()` implemented distinctly by `Painting` and `Sculpture`.
    - `GardenTool.java`: Multilevel class hierarchy (`GardenTool` -> `CuttingTool` -> `Pruner`) with abstract `use()` method and incremental `super.use()` message expansion.
    - `ClassroomDevice.java`: Abstract `ClassroomDevice` class combined with `Chargeable` interface featuring overloaded `charge()` methods in `Tablet`.
    - `Drone.java`: Abstract `Drone` class, selective `Trackable` interface implementation by `DeliveryDrone` and independent `GroundRobot`, with dynamic `instanceof` inspection in `getLocationIfTrackable()`.
- Organized Java files into topic-based packages (`abstraction.class_problems` and `abstraction.assigment_problems`).
- Compiled and tested all solutions against sample inputs and boundary cases.
- Pushed solutions to feature/week_7.

**Next Session Plan:**
- Continue with the next Java programming session (Week 8).

**Issues Faced:**
- None. All 10 solutions compiled and tested cleanly with exact expected outputs.

## Date: 01-11-2026

**Today's Work:**
- Completed Session 6 (Week 6: Inheritance, Polymorphism & Membership Hierarchy) Java programming questions.
- Solved class problems and assignment problems:
  - 5 Class Problems in `inheritance.class_problems`:
    - `LibraryMember.java`: Implemented base LibraryMember class with validated memberId constructor, borrow counters, fine recording, and `enrollBatch()` trial processor.
    - `HonorsStudentMember.java`: Multilevel inheritance subclass adding bonus borrow limits, `classifyGeneration()` instanceof checks, and polymorphic `getTotalBooksBorrowed()`.
    - `StudentMember.java`: Direct subclass extending LibraryMember, overriding `chargeFine()` to halve late fines via `super.chargeFine()`, and defensive fine history copying.
    - `WeeklyCirculationReport.java`: Assembled formatted circulation announcements with StringBuilder and instanceof-guarded safe downcasts reaching student course details.
    - `FacultyMember.java`: Hierarchical subclass of LibraryMember, shared static memberNumber counter, character-based renewal code validator, and null-safe `processNightlyAudit()` aggregation.
  - 5 Assignment Problems in `inheritance.assigment_problems`:
    - `GymMember.java`: Implemented base GymMember class with length and whitespace validation, attendance tracking, fee payments, and `signUpBatch()` trial registration.
    - `EliteMember.java`: Multilevel inheritance subclass extending PremiumMember with reserved locker, `classifyGeneration()` hierarchy classifier, and polymorphic `getTotalSessionsAttended()`.
    - `PremiumMember.java`: Single inheritance subclass extending GymMember, overriding `chargeLateFee()` with 50% discount delegation to `super.chargeLateFee()`, and defensive history return.
    - `AttendanceAnnouncer.java`: Generated batch attendance text with StringBuilder and instanceof-guarded safe downcasts reaching trainer assignments.
    - `GroupClassMember.java`: Hierarchical subclass extending GymMember, shared static counter, character-based referral code validator, and null-safe `processWeeklyCheckIn()` aggregation.
- Organized Java files into topic-based packages (`inheritance.class_problems` and `inheritance.assigment_problems`).
- Compiled and tested all solutions against sample inputs and boundary cases.
- Pushed solutions to feature/week_6.

**Next Session Plan:**
- Continue with the next Java programming session (Week 7).

**Issues Faced:**
- None. All 10 solutions compiled and tested cleanly with exact expected outputs.

## Date: 01-11-2026

**Today's Work:**
- Completed Session 5 (Week 5: Access Modifiers, Encapsulation & Object Modeling) Java programming questions.
- Solved class problems and assignment problems:
  - 5 Class Problems in `encapsulation.class_problems`:
    - `MovieTicketVisibilityChecker.java`: Validated Java visibility rules for SAME_CLASS, SAME_PACKAGE, and DIFFERENT_PACKAGE across access levels with batch summarization.
    - `SubclassTicketAccess.java`: Modeled cross-package inheritance rules distinguishing SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE (allowed) and SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE (denied) for protected access.
    - `CineScreen.java`: Enforced constructor-time boundary validation rejecting non-positive total seats, with silent rejection on out-of-bounds bookSeat and cancelBooking transitions.
    - `MovieBookingProfile.java`: Implemented a standard JavaBean with public no-arg constructor, `this()` constructor chaining, and a write-only OTP property without a getter.
    - `BookingReceipt.java`: Achieved true immutability via defensive copying of seat numbers in and out, with-style mutation (`withUpdatedSeat`), and null-safe nightly settlement batch aggregation using `instanceof`.
  - 5 Assignment Problems in `encapsulation.assigment_problems`:
    - `MembershipFieldReachChecker.java`: Classified field visibility for LibraryMember fields and produced modifier-grouped summary breakdown across access attempts.
    - `ReferenceDeskSubclassReach.java`: Handled 5 access contexts with an early-exit scanner identifying the very first denied access attempt.
    - `BookInventory.java`: Encapsulated private total and available copy counts with boundary-checked, silent-rejection checkout and checkin operations.
    - `LibraryMember.java`: Implemented JavaBean conventions with a write-once `membershipId` property and a write-only, one-way transformed `securityAnswer` property.
    - `LoanReceipt.java`: Constructed immutable loan receipts with defensive array copying, with-style bookId corrections, static initialization block in `CirculationLedger`, and null-safe batch circulation processing using `instanceof`.
- Organized Java files into topic-based packages (`encapsulation.class_problems` and `encapsulation.assigment_problems`).
- Compiled and tested all solutions against sample inputs and boundary cases.
- Pushed solutions to feature/week_5.

**Next Session Plan:**
- Continue with the next Java programming session (Week 6).

**Issues Faced:**
- None. All 10 solutions compiled and tested cleanly with exact expected outputs.

## Date: 01-11-2026

**Today's Work:**
- Completed Session 4 (Week 4: Constructors and Java Keywords) Java programming questions.
- Solved class problems and assignment problems:
  - 5 Class Problems in `constructors_and_keywords.class_problems`:
    - `LibraryBook.java`: Implemented `this()` constructor chaining ensuring default PENDING status for unconfirmed ISBNs.
    - `Employee.java`: Resolved parameter/field naming collisions in constructors and `raiseSalary()` using the `this` keyword.
    - `LateFeeAccount.java`: Locked fee calculation and summary printing using `final` methods while skipping on-time accounts.
    - `SrmStudent.java`: One-time setup of college and academic year metadata using a `static` initialization block.
    - `FeeAccount.java`: Dispatched hostel vs day-scholar payment processing in a batch loop using `instanceof` with account counters.
  - 5 Assignment Problems in `constructors_and_keywords.assigment_problems`:
    - `Participant.java`: Overloaded constructors with `this(...)` chaining to assign default "Unassigned" team names for solo hackathon entries.
    - `Item.java`: Resolved naming clashes with `this` keyword in constructor and batch `restock()` method.
    - `ParkingTicket.java`: Enforced non-overridable fee formula using `final` methods with skip logic for on-time vehicles.
    - `MembershipCard.java`: One-time library name and validity loading using a `static` block across batch student card creation.
    - `Payment.java`: Replayed closing-time payments using `instanceof` type checking for 2% card processing fees and tracked total collected.
- Organized Java files into topic-based packages.
- Compiled and tested the solutions.
- Pushed solutions to feature/week_4.

**Next Session Plan:**
- Continue with the next Java programming session (Week 5).

**Issues Faced:**
- None. All 10 solutions compiled and tested cleanly with expected sample outputs.

## Date: 01-11-2026

**Today's Work:**
- Completed Session 3 (Week 3) Java programming questions.
- Solved class problems and assignment problems:
  - 5 Class Problems in `object_oriented_programming.class_problems`:
    - `PlacementRecord.java`: Student placement record tracking with custom constructor and formatted printing.
    - `MessWallet.java`: Encapsulated hostel mess wallet with controlled topUp, overdraft-preventing deduct, and read-only balance.
    - `Course.java`: Overloaded course constructor chaining via `this(...)` with total credit calculation.
    - `IdCard.java`: Reference copying verification demonstrating identity (`==`) vs independent objects.
    - `Student.java`: Class design correctly separating instance fields from static fields and class-level methods.
  - 5 Assignment Problems in `object_oriented_programming.assigment_problems`:
    - `BookInventory.java`: Object array of book inventory records replacing parallel arrays with formatted entry display.
    - `PayrollAccount.java`: Encapsulated payroll account managing basic salary, positive bonus crediting, and percentage tax deduction.
    - `EmployeeProfile.java`: Overloaded constructor chaining via `this(...)` initializing permanent and intern profiles.
    - `HallTicket.java`: Shared reference mutation demonstrating that multiple references point to the same memory object.
    - `CompanyEmployee.java`: Static company name and static employee counter incremented uniformly across object instantiations.
- Organized Java files into topic-based packages.
- Compiled and tested the solutions.
- Pushed solutions to feature/week_3.

**Next Session Plan:**
- Continue with the next Java programming session (Week 4).

**Issues Faced:**
- None. All 10 solutions compiled and tested cleanly with expected sample outputs.

## Date: 01-11-2026

**Today's Work:**
- Completed Session 2 Java programming questions.
- Solved class problems and assignment problems:
  - 5 Class Problems in `string.class_problems`:
    - `VowelConsonantCounter.java`: Count vowels and consonants in a string ignoring spaces.
    - `CSVStudentRecordParser.java`: Parse and validate 3-field CSV student records.
    - `FileExtensionValidator.java`: Validate file extensions (pdf, docx, zip) using substring and lastIndexOf.
    - `MaskedPhoneNumberFormatter.java`: Validate 10-digit phone number and format as XXXXXX-last4 using StringBuilder.
    - `BankTransactionReferenceValidator.java`: Normalize reference and validate 3-letter bank code + 11 digits body.
  - 5 Assignment Problems in `string.assigment_problems`:
    - `AtmPinLengthValidator.java`: Validate exact 4-digit ATM PIN length.
    - `WordReversalEncoder.java`: Reverse each word individually while preserving word order.
    - `ProductInventoryCsvParser.java`: Parse CSV inventory records and format output.
    - `LibraryIsbnValidator.java`: Normalize ISBN code and validate 3-letter publisher + 10-digit body.
    - `StopWordWordFrequencyReport.java`: Filter stop words, normalize text, count frequencies, and sort in descending order.
- Organized Java files into topic-based packages.
- Compiled and tested the solutions.
- Pushed solutions to feature/week_2.

**Next Session Plan:**
- Continue with the next Java programming session.

**Issues Faced:**
- None.

## Date: 31-10-2026

**Today's Work:**
- Completed Session 1 Java programming questions.
- Solved class problems and assignment problems:
  - 5 Class Problems in `week1.class_problems`:
    - `RockPaperScissors.java`: Rock-Paper-Scissors simulator against computer with round summary and win percentage.
    - `PalindromeChecker.java`: Palindrome detection using iterative, recursive, and array-reversal approaches.
    - `BmiCalculator.java`: Body Mass Index calculation and wellness categorization in tabular format.
    - `FirstNonRepeatingCharacter.java`: Frequency counting to find the first unique character with early exit.
    - `ReverseCustomerName.java`: String reversal preserving original customer name argument.
  - 5 Assignment Problems in `week1.assigment_problems`:
    - `ExamHallSeatDuplicationChecker.java`: Array scan checking for duplicate seat assignments without Collections.
    - `TypingSpeedAccuracyChecker.java`: Character-by-character accuracy percentage calculation and first mismatch reporting.
    - `TrafficSignalStreakAnalyzer.java`: Longest continuous streak analysis for traffic signal readings.
    - `WarehouseInventoryBalancer.java`: Section inventory total balance check and maximum quantity item detection.
    - `MovieReviewWordLengthProfiler.java`: Review text parsing and categorization into short, medium, and long word lengths.
- Organized Java files into topic-based packages.
- Compiled and tested the solutions.
- Pushed solutions to feature/week_1.

**Next Session Plan:**
- Continue with the next Java programming session.

**Issues Faced:**
- None.
