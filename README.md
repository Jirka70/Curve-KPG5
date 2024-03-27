# Curves - Jiri Tresohlavy

# Task
- Add to an existing application some interesting curves (each curve for 0.5 pt.)
- Possibility to change parameters of curves (0.5 pt.)

# Launching
Project is made in the JavaFX framework. Just pull this project and launch Main class in your favorite Java IDE

# About application
- Application can create 5 different types of curves
- **Cubic B-spline**  
  - curve is defined by 4 different points
  - curve is opened, this basically means, the curve does not make closed polygon
  - Formula: $` C(t) = \dfrac{1}{6} ((-b_0 + 3b_1 - 3b_2 + b_3) * t^3 + (3b_0 - 6b_1 + 3b_2) * t^2 + (-3b_0 + 3b_2) * t + (b_0 + 4b_1 + b_2)) `$
    - where $`t`$ stands for parameter in range of `[0, 1]`
    - where $`b_i`$ stands for ith control point of the curve
<p align="center">
  <img width="660" alt="Bildschirmfoto 2024-03-27 um 5 10 16 PM" src="https://github.com/Jirka70/Curve-KPG5/assets/120426468/4d7e30b7-0a6c-4cde-a5b8-20c700dbf681">
  <br>
  Snapshot from application of <b>Cubic B-Spline</b>
p>
