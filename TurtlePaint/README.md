# 🐢 Turtle Paint Application

This is a simple Java application that uses the Turtle graphics API to let users draw geometric shapes on a canvas. Users can interactively choose to draw circles, squares, and triangles, customize their appearance, and save their work.

---

## 🎯 Features

- Interactive CLI menu
- Draw shapes with border customization
    - ✅ Circle
    - ✅ Square
    - ✅ Triangle
    - ✅ Hexagon
- Choose color, border width, and position
- Save painting data to a `.csv` file for future use

---

## 🚀 Getting Started

### Prerequisites
- Java JDK 8 or higher
- `Turtle.java` and `World.java` must be available in your classpath

### Running the App
```bash
java  MainApp.java
java MainApp
```

### Example Run
```
Enter canvas width: 400
Enter canvas height: 400

Home Screen
1) Add Shape
2) Save Image
0) Exit
```

---

## 💾 Saving Paintings

When you choose `Save Image`, the app writes shape data to `painting.csv` like this:
```
500|500|white
square|65|65|15|blue|30|0
circle|65|-65|5|red|35|0
triangle|-80|10|10|green|55|0
```

---

## 🖼️  Console RUN

![Image] image should be here

---

## 📂 File Structure
```
├── MainApp.java
├── Shape.java (abstract)
├── Circle.java
├── Square.java
├── Hexagon.java
├── Triangle.java
├── Turtle.java
├── World.java
├── painting.csv
├── drawing.png
└── README.md
```

---

## 🛠️ Future Enhancements
✅ Load shapes from `painting.csv`
✅Add more shape types (e.g., Hexagon, Pentagon) --Hexagon done
- GUI version with shape preview

---

## 📜 License
This project is for educational purposes only.
