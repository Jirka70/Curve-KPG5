# Curves - Jiri Tresohlavy

# Task
- Add to an existing application some interesting curves (each curve for 0.5 pt.)
- Possibility to change parameters of curves (0.5 pt.)

# Launching
Project is made in the JavaFX framework. Just pull this project and launch Main class in your favorite Java IDE

# About application
- On the beginning, application displays only 5 buttons. When a button is clicked, certain curve with control points will be shown
- Application can create 5 different types of curves
- User can freely drag control points (black dots) wherever he wants to. Curve will adapt to the change, user made immediately

  
- **Cubic B-spline**  
  - curve is defined by 4 different points
  - curve is opened (end point of curve does not lie on the beginning point)
  - Formula: $` C(t) = \dfrac{1}{6} ((-b_0 + 3b_1 - 3b_2 + b_3) * t^3 + (3b_0 - 6b_1 + 3b_2) * t^2 + (-3b_0 + 3b_2) * t + (b_0 + 4b_1 + b_2)) `$
    - where $`t`$ stands for parameter in range of `[0, 1]`
    - where $`b_i`$ stands for i-th control point of the curve
      
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
    - where $`P_i`$ stands for i-th control point of the curve
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
    - where $`P_i`$ stands for i-th control point of the curve

<p align="center">
  <img width="437" alt="Bildschirmfoto 2024-03-27 um 5 20 32 PM" src="https://github.com/Jirka70/Curve-KPG5/assets/120426468/88190073-ac43-4492-aa56-90645e011df2">
  <br>
  Snapshot from application of <b>Quadratic Bezier</b>
</p>

- **Catmull Rom**
  - curve is defined by 4 control points
  - curve is also opened
  - curve is computed point by point with `evaluateCatmullRom()` in the `CatmullRom` class
  - Basically `4 x 4` basis matrix and tVector $`[t^3, t^2, t, 1]`$
  - each point is computed this way:
    - P = $` \Sigma_{i = 0}^{3} \ \Sigma_{j = 0}^{3} \ B_{ij} \ C_j \ t_i `$
    - where $`B`$ stands for the basis matrix
    - where $`C_j`$ stands for j-th control point
    - where $`t`$ stands for tVector
    - where $` t_i `$ stands for i-th variable in the tVector

<p align="center">
<img width="437" alt="Bildschirmfoto 2024-03-27 um 5 20 32 PM" src="https://github.com/Jirka70/Curve-KPG5/assets/120426468/c2781327-7e29-444d-ae8c-bad52274cd8f">
  <br>
  Snapshot from application of <b>Catmull Rom</b>
</p>

- **Coons Cubic**
  - curve is defined by 4 control points
  - curve is also opened
  - Formula: $`P(t) = \dfrac{1}{6} \Sigma_{i = 0}^{3} V_i C_i(t)`$
    - where $`C_0(t) = -t^3 + 3t^ - 3t + 1`$
    - where $`C_1(t) = 3t^3 - 6t^2 + 4`$
    - where $`C_2(t) = -3t^3 + 3t^2 + 3t + 1`$
    - where $`C_3(t) = t^3`$
    - where $`V_i`$ stands for i-th control point
    - where $`t`$ stands for parameter in range of `[0, 1]`
  - This curve is very similar to the Cubic B-Spline, but the formula is not the same 


<p align="center">
<img width="437" alt="Bildschirmfoto 2024-03-27 um 5 20 32 PM" src="https://github.com/Jirka70/Curve-KPG5/assets/120426468/8c36eef2-2e59-4df9-8476-af34822bbb14">
  <br>
  Snapshot from application of <b>Coons Cubic</b>
</p>

# References

http://home.zcu.cz/~bastl/GM1/GM1_lecture05.pdf
http://afrodita.zcu.cz/~kolinger/KPG/KPG10_ENG.pdf
https://en.wikipedia.org/wiki/B%C3%A9zier_curve
https://en.wikipedia.org/wiki/Spline_(mathematics)


