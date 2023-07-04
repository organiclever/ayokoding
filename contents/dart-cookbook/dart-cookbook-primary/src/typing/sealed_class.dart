sealed class TShirtSize {}

class Small extends TShirtSize {}

class Medium extends TShirtSize {}

class ExtraLarge extends TShirtSize {
  final int size;

  ExtraLarge(this.size);
}

void printSizeInfo(TShirtSize theSize) {
  // When not exhaustive, the compiler will refuse to compile
  switch (theSize) {
    case Small _:
      print("Small");
    case Medium _:
      print("Medium");
    case ExtraLarge val:
      print("E" + "x" * val.size + "tra Large");
  }
}

sealed class Role {
  void printInfo() {
    // When not exhaustive, the compiler will refuse to compile
    switch (this) {
      case Teacher teacher:
        print(
            "Name: ${teacher.name}, License: ${teacher.teachingLicense}, Major: ${teacher.teachingMajor}");
        break;
      case Student student:
        print(
            "Student: ${student.name}, ID: ${student.studentId}, School: ${student.school}");
        break;
    }
  }
}

class Teacher extends Role {
  final String name;
  final String teachingLicense;
  final String teachingMajor;

  Teacher(this.name, this.teachingLicense, this.teachingMajor);
}

class Student extends Role {
  final String name;
  final String studentId;
  final String school;

  Student(this.name, this.studentId, this.school);
}

void main() {
  printSizeInfo(Small()); // Output: Small
  printSizeInfo(Medium()); // Output: Medium
  printSizeInfo(ExtraLarge(1)); // Output: Extra Large
  printSizeInfo(ExtraLarge(3)); // Output: Exxxtra Large

  Teacher("John Doe", "123456", "Math")
      .printInfo(); // Output: Name: John Doe, License: 123456, Major: Math
  Student("Jane Doe", "123456", "University of Life")
      .printInfo(); // Output: Student: Jane Doe, ID: 123456, School: University of Life
}
