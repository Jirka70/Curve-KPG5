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
  - curve is opened (end point of curve does not lie on the beginning point)
  - Formula: $` C(t) = \dfrac{1}{6} ((-b_0 + 3b_1 - 3b_2 + b_3) * t^3 + (3b_0 - 6b_1 + 3b_2) * t^2 + (-3b_0 + 3b_2) * t + (b_0 + 4b_1 + b_2)) `$
    - where $`t`$ stands for parameter in range of `[0, 1]`
    - where $`b_i`$ stands for ith control point of the curve
      
<p align="center">
  <img width="660" alt="Bildschirmfoto 2024-03-27 um 5 10 16 PM" src="https://github.com/Jirka70/Curve-KPG5/assets/120426468/4d7e30b7-0a6c-4cde-a5b8-20c700dbf681">
  <br>
  Snapshot from application of <b>Cubic B-Spline</b>
</p>

- **Cubic Bezier**
  - one of the most used curves
  - curve is also defined by 4 different points
  - formula is pretty easy to understand
  - Formula: $`B(t) = (1 - t)^3 P_0 + 3(1 - t)^2 t P_1 + 3 (t - 1) t^2 P_2 + t^3 P_3`$
    - where $`t`$ stands for parameter in range of `[0, 1]`
    - where $`P_i`$ stands for ith control point of the curve
  - curve is also opened
 
<p align="center">
  <img width="713" alt="Bildschirmfoto 2024-03-27 um 5 16 12 PM" src="https://github.com/Jirka70/Curve-KPG5/assets/120426468/767d5859-c1fe-44a5-b722-564b38b736a8">
  <br>
  Snapshot from application of <b>Cubic Bezier</b>
</p>

- **Quadratic Bezier**
  - similar to the Cubic Bezier curve
  - curve is defined only by 3 control points
  - curve is also opened
  - Formula: $` (1 - t)^2 P_0 + 2(t - 1) t P_1 + t^2 P_2`$
    - where $`t`$ stands for parameter in range of `[0, 1]`
    - where $`P_i`$ stands for ith control point of the curve

<p align="center">
  <img width="437" alt="Bildschirmfoto 2024-03-27 um 5 20 32 PM" src="https://github.com/Jirka70/Curve-KPG5/assets/120426468/88190073-ac43-4492-aa56-90645e011df2">
  <br>
  Snapshot from application of <b>Quadratic Bezier</b>
</p>

- **Catmull Rom**
  - curve is defined by 4 control points
  - curve is also opened
  - curve is computed point by point with `evaluateCatmullRom()` in the `CatmullRom` class
  - Basically `4 x 4` basis matrix is introduced there
  - each point is computed 
