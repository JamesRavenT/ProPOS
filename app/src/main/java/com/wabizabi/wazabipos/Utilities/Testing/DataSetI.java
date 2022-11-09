package com.wabizabi.wazabipos.Utilities.Testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class DataSetI implements DataSet {

    public static void insertInto(List<List<String>> transactionsTB) {


        List<String> t1 = new ArrayList<>(List.of("Tuna", "California Deluxe", "Sea weeds Salad", "Tuna", "Chocolate Cake", "Tuna", "Gyudon"));
        List<String> t2 = new ArrayList<>(List.of("Sea weeds Salad", "Chocolate Cake", "Tuna", "Tuna"));
        List<String> t3 = new ArrayList<>(List.of("Tuna", "Tuna", "Tuna"));
        List<String> t4 = new ArrayList<>(List.of("Tantanmen", "Tuna", "Gyudon", "Tuna", "California Deluxe"));
        List<String> t5 = new ArrayList<>(List.of("WZ Sushi Platter", "Sea weeds Salad", "Chocolate Cake", "Sea weeds Salad"));
        List<String> t6 = new ArrayList<>(List.of("Chocolate Cake", "Tuna", "Royal", "Sea weeds Salad", "Tuna"));
        List<String> t7 = new ArrayList<>(List.of("Sea weeds Salad"));
        List<String> t8 = new ArrayList<>(List.of("Chocolate Cake", "Tuna", "Tuna", "Tantanmen", "Tuna", "Tuna", "Tantanmen"));
        List<String> t9 = new ArrayList<>(List.of("Tantanmen", "Sea weeds Salad", "Gyudon", "Tantanmen", "Royal", "Tantanmen"));
        List<String> t10 = new ArrayList<>(List.of("Royal", "Chocolate Cake", "Sea weeds Salad", "Tuna", "Tantanmen"));
        List<String> t11 = new ArrayList<>(List.of("Tuna", "Tuna", "Tantanmen", "Tuna", "Sea weeds Salad", "Tuna", "Tantanmen"));
        List<String> t12 = new ArrayList<>(List.of("Sea weeds Salad", "Tuna", "Tuna"));
        List<String> t13 = new ArrayList<>(List.of("Chocolate Cake", "Tantanmen", "Sea weeds Salad", "Chocolate Cake", "Gyudon", "Gyudon", "Gyudon"));
        List<String> t14 = new ArrayList<>(List.of("Sea weeds Salad"));
        List<String> t15 = new ArrayList<>(List.of("Tuna"));
        List<String> t16 = new ArrayList<>(List.of("California Deluxe", "Tuna"));
        List<String> t17 = new ArrayList<>(List.of("Tantanmen", "Sea weeds Salad"));
        List<String> t18 = new ArrayList<>(List.of("Tuna", "California Deluxe", "Royal", "California Deluxe", "Tuna", "Royal", "California Deluxe"));
        List<String> t19 = new ArrayList<>(List.of("WZ Sushi Platter", "Gyudon", "California Deluxe"));
        List<String> t20 = new ArrayList<>(List.of("Gyudon", "Tuna", "Sea weeds Salad", "Gyudon", "California Deluxe", "Royal"));
        List<String> t21 = new ArrayList<>(List.of("Chocolate Cake", "Royal"));
        List<String> t22 = new ArrayList<>(List.of("Sea weeds Salad", "Tuna", "Royal", "Tantanmen", "Gyudon", "Gyudon", "Tuna"));
        List<String> t23 = new ArrayList<>(List.of("WZ Sushi Platter", "Sea weeds Salad", "Tantanmen", "Tantanmen", "Sea weeds Salad", "California Deluxe", "Tuna"));
        List<String> t24 = new ArrayList<>(List.of("California Deluxe", "California Deluxe"));
        List<String> t25 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter", "Chocolate Cake", "Tantanmen", "Tuna"));
        List<String> t26 = new ArrayList<>(List.of("Tuna", "Tuna"));
        List<String> t27 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna"));
        List<String> t28 = new ArrayList<>(List.of("Tuna", "Chocolate Cake", "Tuna"));
        List<String> t29 = new ArrayList<>(List.of("Gyudon", "Royal", "Sea weeds Salad", "Gyudon", "Tantanmen"));
        List<String> t30 = new ArrayList<>(List.of("California Deluxe", "Tuna", "California Deluxe"));
        List<String> t31 = new ArrayList<>(List.of("WZ Sushi Platter", "California Deluxe"));
        List<String> t32 = new ArrayList<>(List.of("Tuna", "Royal", "Royal", "Gyudon", "Tuna"));
        List<String> t33 = new ArrayList<>(List.of("Royal", "Royal"));
        List<String> t34 = new ArrayList<>(List.of("Tantanmen", "WZ Sushi Platter", "Tuna", "Tuna", "California Deluxe"));
        List<String> t35 = new ArrayList<>(List.of("Sea weeds Salad", "Tantanmen"));
        List<String> t36 = new ArrayList<>(List.of("Tuna", "Tuna"));
        List<String> t37 = new ArrayList<>(List.of("Tantanmen", "Tantanmen", "Chocolate Cake", "California Deluxe"));
        List<String> t38 = new ArrayList<>(List.of("WZ Sushi Platter", "Gyudon", "Tuna", "Tuna", "Sea weeds Salad", "WZ Sushi Platter", "Chocolate Cake"));
        List<String> t39 = new ArrayList<>(List.of("Sea weeds Salad", "Gyudon"));
        List<String> t40 = new ArrayList<>(List.of("Tantanmen"));
        List<String> t41 = new ArrayList<>(List.of("WZ Sushi Platter", "California Deluxe", "California Deluxe", "Sea weeds Salad"));
        List<String> t42 = new ArrayList<>(List.of("Tuna", "Tuna", "California Deluxe", "Tuna"));
        List<String> t43 = new ArrayList<>(List.of("Tuna", "Tuna", "Tuna", "Royal"));
        List<String> t44 = new ArrayList<>(List.of("Tuna", "Sea weeds Salad"));
        List<String> t45 = new ArrayList<>(List.of("Royal", "Tantanmen", "Royal"));
        List<String> t46 = new ArrayList<>(List.of("Tantanmen", "Royal", "Chocolate Cake", "Tuna", "Chocolate Cake", "Gyudon", "Sea weeds Salad"));
        List<String> t47 = new ArrayList<>(List.of("Chocolate Cake", "Tuna"));
        List<String> t48 = new ArrayList<>(List.of("Tuna"));
        List<String> t49 = new ArrayList<>(List.of("Tuna", "Tuna"));
        List<String> t50 = new ArrayList<>(List.of("Tantanmen", "WZ Sushi Platter", "Sea weeds Salad", "Tuna"));
        List<String> t51 = new ArrayList<>(List.of("Tantanmen", "Chocolate Cake", "WZ Sushi Platter", "Sea weeds Salad", "Chocolate Cake"));
        List<String> t52 = new ArrayList<>(List.of("Tuna"));
        List<String> t53 = new ArrayList<>(List.of("Royal", "Tantanmen", "Sea weeds Salad"));
        List<String> t54 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna", "Chocolate Cake", "California Deluxe", "Tuna", "Tuna", "Sea weeds Salad"));
        List<String> t55 = new ArrayList<>(List.of("Sea weeds Salad", "Gyudon", "WZ Sushi Platter", "Tuna", "California Deluxe", "Tuna"));
        List<String> t56 = new ArrayList<>(List.of("Tuna"));
        List<String> t57 = new ArrayList<>(List.of("Gyudon"));
        List<String> t58 = new ArrayList<>(List.of("Tantanmen", "Tuna"));
        List<String> t59 = new ArrayList<>(List.of("WZ Sushi Platter", "Sea weeds Salad", "Royal", "WZ Sushi Platter", "WZ Sushi Platter", "Sea weeds Salad", "Sea weeds Salad"));
        List<String> t60 = new ArrayList<>(List.of("Tantanmen", "WZ Sushi Platter", "WZ Sushi Platter", "Tuna", "Tuna"));
        List<String> t61 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen"));
        List<String> t62 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter", "Chocolate Cake"));
        List<String> t63 = new ArrayList<>(List.of("California Deluxe", "Gyudon"));
        List<String> t64 = new ArrayList<>(List.of("Chocolate Cake", "WZ Sushi Platter"));
        List<String> t65 = new ArrayList<>(List.of("Sea weeds Salad", "WZ Sushi Platter"));
        List<String> t66 = new ArrayList<>(List.of("Tantanmen", "Chocolate Cake"));
        List<String> t67 = new ArrayList<>(List.of("WZ Sushi Platter", "California Deluxe"));
        List<String> t68 = new ArrayList<>(List.of("Tantanmen", "Sea weeds Salad", "Tuna"));
        List<String> t69 = new ArrayList<>(List.of("Sea weeds Salad", "Tantanmen", "Tuna", "Tuna", "Tuna", "Tuna"));
        List<String> t70 = new ArrayList<>(List.of("California Deluxe", "Gyudon"));
        List<String> t71 = new ArrayList<>(List.of("Chocolate Cake", "Gyudon", "Gyudon", "Gyudon", "Sea weeds Salad", "Royal", "Tuna"));
        List<String> t72 = new ArrayList<>(List.of("Gyudon", "Tuna", "Tantanmen", "Gyudon"));
        List<String> t73 = new ArrayList<>(List.of("Tuna", "Tuna"));
        List<String> t74 = new ArrayList<>(List.of("Royal", "Royal", "Gyudon", "California Deluxe", "California Deluxe", "Tuna", "Royal"));
        List<String> t75 = new ArrayList<>(List.of("Tantanmen", "Royal", "Gyudon", "Tuna", "Gyudon"));
        List<String> t76 = new ArrayList<>(List.of("California Deluxe", "Gyudon", "Tantanmen"));
        List<String> t77 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t78 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t79 = new ArrayList<>(List.of("Tantanmen", "Tantanmen"));
        List<String> t80 = new ArrayList<>(List.of("Gyudon", "Royal", "Tuna", "WZ Sushi Platter", "Gyudon"));
        List<String> t81 = new ArrayList<>(List.of("Tuna", "Tuna", "WZ Sushi Platter", "Gyudon"));
        List<String> t82 = new ArrayList<>(List.of("Royal", "Tantanmen", "Tuna", "Sea weeds Salad", "Royal", "WZ Sushi Platter"));
        List<String> t83 = new ArrayList<>(List.of("WZ Sushi Platter", "Chocolate Cake", "California Deluxe", "Royal", "WZ Sushi Platter", "Tantanmen"));
        List<String> t84 = new ArrayList<>(List.of("California Deluxe", "Gyudon", "Royal", "Chocolate Cake"));
        List<String> t85 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t86 = new ArrayList<>(List.of("California Deluxe", "Tantanmen"));
        List<String> t87 = new ArrayList<>(List.of("Tuna"));
        List<String> t88 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna", "Gyudon", "WZ Sushi Platter", "California Deluxe", "Gyudon"));
        List<String> t89 = new ArrayList<>(List.of("Sea weeds Salad", "Sea weeds Salad", "California Deluxe"));
        List<String> t90 = new ArrayList<>(List.of("Tuna", "Tuna", "Tuna", "Royal", "Tuna"));
        List<String> t91 = new ArrayList<>(List.of("California Deluxe", "Tuna", "California Deluxe", "WZ Sushi Platter", "Sea weeds Salad", "Sea weeds Salad", "Tuna"));
        List<String> t92 = new ArrayList<>(List.of("Sea weeds Salad", "WZ Sushi Platter", "Tantanmen", "Royal"));
        List<String> t93 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen"));
        List<String> t94 = new ArrayList<>(List.of("Sea weeds Salad", "Sea weeds Salad", "Tantanmen", "Chocolate Cake"));
        List<String> t95 = new ArrayList<>(List.of("Royal"));
        List<String> t96 = new ArrayList<>(List.of("Royal", "California Deluxe", "Sea weeds Salad"));
        List<String> t97 = new ArrayList<>(List.of("WZ Sushi Platter", "Royal", "Tuna", "WZ Sushi Platter", "California Deluxe", "Tuna"));
        List<String> t98 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna"));
        List<String> t99 = new ArrayList<>(List.of("Tuna", "Gyudon", "Tuna", "Chocolate Cake", "Tuna", "Sea weeds Salad", "Tuna"));
        List<String> t100 = new ArrayList<>(List.of("Gyudon", "California Deluxe", "Royal", "Tantanmen"));
        List<String> t101 = new ArrayList<>(List.of("Tuna", "Tantanmen"));
        List<String> t102 = new ArrayList<>(List.of("Tantanmen", "Chocolate Cake", "Royal", "Tuna", "Gyudon", "Royal", "Royal"));
        List<String> t103 = new ArrayList<>(List.of("Royal"));
        List<String> t104 = new ArrayList<>(List.of("Tuna", "Royal"));
        List<String> t105 = new ArrayList<>(List.of("California Deluxe", "Tuna", "Chocolate Cake", "Sea weeds Salad", "Sea weeds Salad", "Chocolate Cake"));
        List<String> t106 = new ArrayList<>(List.of("Tantanmen", "California Deluxe", "Chocolate Cake", "California Deluxe", "Chocolate Cake"));
        List<String> t107 = new ArrayList<>(List.of("Tuna", "Chocolate Cake", "California Deluxe", "Chocolate Cake", "WZ Sushi Platter", "Tuna"));
        List<String> t108 = new ArrayList<>(List.of("California Deluxe", "WZ Sushi Platter", "Tuna"));
        List<String> t109 = new ArrayList<>(List.of("Tuna", "California Deluxe"));
        List<String> t110 = new ArrayList<>(List.of("Tantanmen", "Gyudon", "California Deluxe", "California Deluxe", "Chocolate Cake", "Chocolate Cake"));
        List<String> t111 = new ArrayList<>(List.of("Sea weeds Salad", "California Deluxe", "Tantanmen"));
        List<String> t112 = new ArrayList<>(List.of("Sea weeds Salad", "Gyudon", "WZ Sushi Platter", "WZ Sushi Platter", "Gyudon", "California Deluxe"));
        List<String> t113 = new ArrayList<>(List.of("Tuna", "Tuna", "California Deluxe", "California Deluxe", "Chocolate Cake", "WZ Sushi Platter"));
        List<String> t114 = new ArrayList<>(List.of("Sea weeds Salad", "Tantanmen"));
        List<String> t115 = new ArrayList<>(List.of("Royal"));
        List<String> t116 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna", "Tantanmen", "WZ Sushi Platter", "Sea weeds Salad", "WZ Sushi Platter"));
        List<String> t117 = new ArrayList<>(List.of("Tantanmen", "Sea weeds Salad", "Tuna", "Tuna", "Tantanmen", "Sea weeds Salad"));
        List<String> t118 = new ArrayList<>(List.of("Royal", "California Deluxe", "Tuna", "Sea weeds Salad", "Sea weeds Salad", "Gyudon"));
        List<String> t119 = new ArrayList<>(List.of("Gyudon", "WZ Sushi Platter", "Royal", "Tuna", "Tuna", "Royal", "Tuna"));
        List<String> t120 = new ArrayList<>(List.of("Tuna", "Tuna", "California Deluxe", "California Deluxe", "Chocolate Cake", "Tantanmen"));
        List<String> t121 = new ArrayList<>(List.of("Chocolate Cake", "Gyudon", "Gyudon", "Tantanmen"));
        List<String> t122 = new ArrayList<>(List.of("Sea weeds Salad", "Tuna", "Gyudon"));
        List<String> t123 = new ArrayList<>(List.of("Sea weeds Salad", "Tantanmen"));
        List<String> t124 = new ArrayList<>(List.of("Tuna"));
        List<String> t125 = new ArrayList<>(List.of("California Deluxe", "California Deluxe", "Tantanmen", "Royal", "Tuna", "Sea weeds Salad", "Tuna"));
        List<String> t126 = new ArrayList<>(List.of("Chocolate Cake", "Gyudon", "California Deluxe", "Gyudon", "California Deluxe", "Tuna", "Chocolate Cake"));
        List<String> t127 = new ArrayList<>(List.of("Tuna", "Tuna", "Royal", "Royal", "Tuna", "WZ Sushi Platter"));
        List<String> t128 = new ArrayList<>(List.of("Sea weeds Salad", "Sea weeds Salad"));
        List<String> t129 = new ArrayList<>(List.of("Sea weeds Salad", "Chocolate Cake", "Chocolate Cake", "Sea weeds Salad", "Tuna", "Tantanmen"));
        List<String> t130 = new ArrayList<>(List.of("California Deluxe"));
        List<String> t131 = new ArrayList<>(List.of("Gyudon", "Sea weeds Salad", "WZ Sushi Platter", "Tuna"));
        List<String> t132 = new ArrayList<>(List.of("Gyudon", "California Deluxe", "Royal", "California Deluxe", "WZ Sushi Platter", "Gyudon", "Chocolate Cake"));
        List<String> t133 = new ArrayList<>(List.of("Tantanmen", "California Deluxe", "California Deluxe", "Royal", "Tantanmen", "Sea weeds Salad"));
        List<String> t134 = new ArrayList<>(List.of("Royal", "Gyudon"));
        List<String> t135 = new ArrayList<>(List.of("Gyudon"));
        List<String> t136 = new ArrayList<>(List.of("Gyudon", "WZ Sushi Platter", "Tuna", "Sea weeds Salad", "Royal"));
        List<String> t137 = new ArrayList<>(List.of("Royal", "Chocolate Cake", "Royal", "Chocolate Cake", "WZ Sushi Platter"));
        List<String> t138 = new ArrayList<>(List.of("Royal", "Tuna", "Royal", "Chocolate Cake"));
        List<String> t139 = new ArrayList<>(List.of("Gyudon", "Royal", "Royal", "California Deluxe", "Chocolate Cake", "WZ Sushi Platter", "Tantanmen"));
        List<String> t140 = new ArrayList<>(List.of("Chocolate Cake", "WZ Sushi Platter", "California Deluxe", "Tuna", "Royal", "Chocolate Cake", "Tuna"));
        List<String> t141 = new ArrayList<>(List.of("Tuna", "Royal", "Sea weeds Salad"));
        List<String> t142 = new ArrayList<>(List.of("Tantanmen", "Tuna", "Tuna"));
        List<String> t143 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Tantanmen", "Royal"));
        List<String> t144 = new ArrayList<>(List.of("Sea weeds Salad", "Tuna"));
        List<String> t145 = new ArrayList<>(List.of("Gyudon", "Royal", "California Deluxe", "Royal", "Gyudon", "Chocolate Cake", "Royal"));
        List<String> t146 = new ArrayList<>(List.of("Tantanmen", "Tuna"));
        List<String> t147 = new ArrayList<>(List.of("Gyudon", "Tantanmen", "Tuna", "Tuna", "Gyudon", "Royal"));
        List<String> t148 = new ArrayList<>(List.of("California Deluxe", "California Deluxe", "Tantanmen", "Chocolate Cake", "Royal"));
        List<String> t149 = new ArrayList<>(List.of("Tuna", "Sea weeds Salad"));
        List<String> t150 = new ArrayList<>(List.of("California Deluxe", "Royal", "Royal", "Tuna", "Chocolate Cake", "Chocolate Cake"));
        List<String> t151 = new ArrayList<>(List.of("California Deluxe"));
        List<String> t152 = new ArrayList<>(List.of("Sea weeds Salad"));
        List<String> t153 = new ArrayList<>(List.of("Royal"));
        List<String> t154 = new ArrayList<>(List.of("Tuna", "Chocolate Cake", "WZ Sushi Platter", "Chocolate Cake"));
        List<String> t155 = new ArrayList<>(List.of("Sea weeds Salad", "WZ Sushi Platter", "Tuna", "Tantanmen"));
        List<String> t156 = new ArrayList<>(List.of("Gyudon", "Tuna", "WZ Sushi Platter", "Gyudon", "Tantanmen", "California Deluxe", "Gyudon"));
        List<String> t157 = new ArrayList<>(List.of("Gyudon"));
        List<String> t158 = new ArrayList<>(List.of("Tuna", "Tuna"));
        List<String> t159 = new ArrayList<>(List.of("Tuna", "Tantanmen", "Gyudon", "Tantanmen", "Tantanmen"));
        List<String> t160 = new ArrayList<>(List.of("Royal", "WZ Sushi Platter", "Tantanmen", "California Deluxe"));
        List<String> t161 = new ArrayList<>(List.of("Gyudon", "Tuna", "Tuna", "Tuna", "Tantanmen", "Royal"));
        List<String> t162 = new ArrayList<>(List.of("Tuna", "Tantanmen"));
        List<String> t163 = new ArrayList<>(List.of("Chocolate Cake", "Tantanmen"));
        List<String> t164 = new ArrayList<>(List.of("Tuna", "Tuna", "WZ Sushi Platter", "Tantanmen", "Gyudon", "California Deluxe", "WZ Sushi Platter"));
        List<String> t165 = new ArrayList<>(List.of("Chocolate Cake", "WZ Sushi Platter", "California Deluxe"));
        List<String> t166 = new ArrayList<>(List.of("Royal", "Sea weeds Salad", "Tantanmen", "Tantanmen", "Tuna", "Chocolate Cake", "Sea weeds Salad"));
        List<String> t167 = new ArrayList<>(List.of("Sea weeds Salad", "Sea weeds Salad", "Tantanmen", "California Deluxe", "Sea weeds Salad"));
        List<String> t168 = new ArrayList<>(List.of("California Deluxe", "Gyudon", "WZ Sushi Platter", "Gyudon"));
        List<String> t169 = new ArrayList<>(List.of("Sea weeds Salad", "Tuna", "Tuna"));
        List<String> t170 = new ArrayList<>(List.of("California Deluxe", "Sea weeds Salad"));
        List<String> t171 = new ArrayList<>(List.of("Tuna", "California Deluxe", "California Deluxe", "Sea weeds Salad"));
        List<String> t172 = new ArrayList<>(List.of("Tuna", "California Deluxe"));
        List<String> t173 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter"));
        List<String> t174 = new ArrayList<>(List.of("Gyudon", "Tuna", "Gyudon"));
        List<String> t175 = new ArrayList<>(List.of("California Deluxe"));
        List<String> t176 = new ArrayList<>(List.of("WZ Sushi Platter", "Sea weeds Salad", "Gyudon", "Royal", "WZ Sushi Platter"));
        List<String> t177 = new ArrayList<>(List.of("Sea weeds Salad"));
        List<String> t178 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna", "California Deluxe", "Chocolate Cake"));
        List<String> t179 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna", "Sea weeds Salad", "Tuna", "Tuna", "Tantanmen"));
        List<String> t180 = new ArrayList<>(List.of("Sea weeds Salad"));
        List<String> t181 = new ArrayList<>(List.of("California Deluxe", "California Deluxe", "Royal", "Royal", "Tantanmen", "Tantanmen"));
        List<String> t182 = new ArrayList<>(List.of("Tuna", "Tuna", "Tuna", "WZ Sushi Platter"));
        List<String> t183 = new ArrayList<>(List.of("Tuna", "Tuna", "Royal", "WZ Sushi Platter"));
        List<String> t184 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter", "WZ Sushi Platter", "Tuna", "Gyudon"));
        List<String> t185 = new ArrayList<>(List.of("Tuna", "Tuna", "Sea weeds Salad", "Tantanmen", "WZ Sushi Platter", "Tantanmen"));
        List<String> t186 = new ArrayList<>(List.of("Tuna"));
        List<String> t187 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna", "Chocolate Cake"));
        List<String> t188 = new ArrayList<>(List.of("Tuna", "Sea weeds Salad"));
        List<String> t189 = new ArrayList<>(List.of("Tantanmen", "Royal", "WZ Sushi Platter"));
        List<String> t190 = new ArrayList<>(List.of("Tuna", "Tantanmen", "Tantanmen", "Gyudon"));
        List<String> t191 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter", "WZ Sushi Platter", "WZ Sushi Platter", "Tuna", "Tantanmen", "Gyudon"));
        List<String> t192 = new ArrayList<>(List.of("Tantanmen"));
        List<String> t193 = new ArrayList<>(List.of("Royal"));
        List<String> t194 = new ArrayList<>(List.of("Sea weeds Salad"));
        List<String> t195 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t196 = new ArrayList<>(List.of("Tantanmen", "Gyudon"));
        List<String> t197 = new ArrayList<>(List.of("WZ Sushi Platter", "Gyudon", "Tuna", "Royal", "Royal"));
        List<String> t198 = new ArrayList<>(List.of("Royal", "Chocolate Cake", "California Deluxe", "California Deluxe", "WZ Sushi Platter", "Sea weeds Salad"));
        List<String> t199 = new ArrayList<>(List.of("Tuna", "Tuna", "California Deluxe"));
        List<String> t200 = new ArrayList<>(List.of("Gyudon", "Tuna", "Tantanmen", "California Deluxe", "Tantanmen"));
        List<String> t201 = new ArrayList<>(List.of("Tuna", "Sea weeds Salad", "Royal", "Chocolate Cake", "Royal"));
        List<String> t202 = new ArrayList<>(List.of("Royal", "Sea weeds Salad", "Gyudon", "Tuna"));
        List<String> t203 = new ArrayList<>(List.of("Gyudon", "Tuna"));
        List<String> t204 = new ArrayList<>(List.of("Tuna", "Gyudon", "WZ Sushi Platter", "WZ Sushi Platter", "Tuna", "Tuna"));
        List<String> t205 = new ArrayList<>(List.of("Tantanmen", "Sea weeds Salad", "Royal", "Tuna"));
        List<String> t206 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter", "Sea weeds Salad", "Tantanmen", "Chocolate Cake"));
        List<String> t207 = new ArrayList<>(List.of("Sea weeds Salad", "Tantanmen"));
        List<String> t208 = new ArrayList<>(List.of("Tuna"));
        List<String> t209 = new ArrayList<>(List.of("California Deluxe", "WZ Sushi Platter"));
        List<String> t210 = new ArrayList<>(List.of("Chocolate Cake", "California Deluxe", "Royal"));
        List<String> t211 = new ArrayList<>(List.of("WZ Sushi Platter", "Sea weeds Salad", "Sea weeds Salad", "Gyudon"));
        List<String> t212 = new ArrayList<>(List.of("Chocolate Cake", "Gyudon"));
        List<String> t213 = new ArrayList<>(List.of("Chocolate Cake", "Royal", "WZ Sushi Platter", "California Deluxe", "Sea weeds Salad"));
        List<String> t214 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna", "Tuna", "Gyudon", "Chocolate Cake", "WZ Sushi Platter", "California Deluxe"));
        List<String> t215 = new ArrayList<>(List.of("Tantanmen", "Chocolate Cake", "Gyudon", "Gyudon", "California Deluxe"));
        List<String> t216 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t217 = new ArrayList<>(List.of("Tuna", "Gyudon", "Chocolate Cake", "Chocolate Cake", "Tuna", "WZ Sushi Platter"));
        List<String> t218 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna", "WZ Sushi Platter", "California Deluxe"));
        List<String> t219 = new ArrayList<>(List.of("California Deluxe"));
        List<String> t220 = new ArrayList<>(List.of("Tantanmen", "Royal", "Royal", "Tuna", "Tantanmen", "Tuna"));
        List<String> t221 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t222 = new ArrayList<>(List.of("Sea weeds Salad", "Tuna", "Tantanmen", "Sea weeds Salad", "Royal", "California Deluxe"));
        List<String> t223 = new ArrayList<>(List.of("Tuna", "California Deluxe", "WZ Sushi Platter", "Tuna", "WZ Sushi Platter"));
        List<String> t224 = new ArrayList<>(List.of("WZ Sushi Platter", "Sea weeds Salad"));
        List<String> t225 = new ArrayList<>(List.of("Tantanmen", "Tuna"));
        List<String> t226 = new ArrayList<>(List.of("Royal", "Chocolate Cake", "Tuna"));
        List<String> t227 = new ArrayList<>(List.of("Royal"));
        List<String> t228 = new ArrayList<>(List.of("Chocolate Cake", "Tuna", "California Deluxe", "Gyudon"));
        List<String> t229 = new ArrayList<>(List.of("California Deluxe", "California Deluxe", "Tuna", "Tuna", "WZ Sushi Platter"));
        List<String> t230 = new ArrayList<>(List.of("Gyudon", "Gyudon", "Gyudon", "California Deluxe"));
        List<String> t231 = new ArrayList<>(List.of("Tuna", "Tuna", "Tuna"));
        List<String> t232 = new ArrayList<>(List.of("Tuna", "Tuna", "Chocolate Cake", "Royal"));
        List<String> t233 = new ArrayList<>(List.of("Gyudon", "California Deluxe", "Tuna", "Tuna", "Gyudon", "Chocolate Cake"));
        List<String> t234 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen", "Sea weeds Salad", "WZ Sushi Platter", "Sea weeds Salad", "Sea weeds Salad"));
        List<String> t235 = new ArrayList<>(List.of("Royal"));
        List<String> t236 = new ArrayList<>(List.of("Tuna", "Sea weeds Salad", "Royal", "Tuna", "California Deluxe"));
        List<String> t237 = new ArrayList<>(List.of("California Deluxe", "WZ Sushi Platter"));
        List<String> t238 = new ArrayList<>(List.of("Gyudon", "Chocolate Cake", "Sea weeds Salad"));
        List<String> t239 = new ArrayList<>(List.of("Gyudon"));
        List<String> t240 = new ArrayList<>(List.of("Chocolate Cake", "Tuna", "WZ Sushi Platter", "Tuna"));
        List<String> t241 = new ArrayList<>(List.of("California Deluxe", "Royal", "Sea weeds Salad"));
        List<String> t242 = new ArrayList<>(List.of("Sea weeds Salad", "Royal", "Gyudon"));
        List<String> t243 = new ArrayList<>(List.of("Tantanmen", "Tuna", "Tuna", "Tuna", "California Deluxe"));
        List<String> t244 = new ArrayList<>(List.of("Tuna", "Tantanmen", "WZ Sushi Platter", "Tuna", "Chocolate Cake"));
        List<String> t245 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter", "Tuna"));
        List<String> t246 = new ArrayList<>(List.of("California Deluxe", "Tuna"));
        List<String> t247 = new ArrayList<>(List.of("Tantanmen", "Tuna"));
        List<String> t248 = new ArrayList<>(List.of("WZ Sushi Platter", "California Deluxe", "Tuna", "WZ Sushi Platter"));
        List<String> t249 = new ArrayList<>(List.of("California Deluxe", "Sea weeds Salad", "Tuna"));
        List<String> t250 = new ArrayList<>(List.of("Tantanmen", "Royal", "Tuna", "Tantanmen"));
        List<String> t251 = new ArrayList<>(List.of("Tuna", "Tantanmen", "Royal", "Royal", "Royal", "Chocolate Cake", "WZ Sushi Platter"));
        List<String> t252 = new ArrayList<>(List.of("Royal", "Chocolate Cake", "Gyudon", "Royal", "Gyudon"));
        List<String> t253 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter", "California Deluxe", "Tuna", "Sea weeds Salad"));
        List<String> t254 = new ArrayList<>(List.of("Royal", "Royal", "Royal", "California Deluxe", "Royal"));
        List<String> t255 = new ArrayList<>(List.of("Chocolate Cake", "California Deluxe", "Tuna"));
        List<String> t256 = new ArrayList<>(List.of("Royal"));
        List<String> t257 = new ArrayList<>(List.of("Gyudon"));
        List<String> t258 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna", "Sea weeds Salad", "Tantanmen", "Tuna", "Tuna", "Tuna"));
        List<String> t259 = new ArrayList<>(List.of("Tantanmen", "Sea weeds Salad", "Royal", "Tantanmen", "Sea weeds Salad", "Sea weeds Salad"));
        List<String> t260 = new ArrayList<>(List.of("Royal", "Tuna", "Tuna"));
        List<String> t261 = new ArrayList<>(List.of("California Deluxe", "Sea weeds Salad", "California Deluxe", "Tantanmen", "Chocolate Cake", "WZ Sushi Platter", "Sea weeds Salad"));
        List<String> t262 = new ArrayList<>(List.of("Tantanmen", "California Deluxe", "Gyudon", "Sea weeds Salad", "Tuna", "California Deluxe", "WZ Sushi Platter"));
        List<String> t263 = new ArrayList<>(List.of("Tuna", "Royal", "Gyudon", "WZ Sushi Platter", "Gyudon", "Sea weeds Salad", "Tuna"));
        List<String> t264 = new ArrayList<>(List.of("Gyudon", "WZ Sushi Platter", "Tantanmen", "Tantanmen", "Chocolate Cake", "Sea weeds Salad", "Tantanmen"));
        List<String> t265 = new ArrayList<>(List.of("Tuna", "Tuna", "Tantanmen", "Tuna", "Royal", "Tantanmen"));
        List<String> t266 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen", "California Deluxe", "Royal"));
        List<String> t267 = new ArrayList<>(List.of("Tuna", "Sea weeds Salad", "California Deluxe", "Tuna", "Tuna", "WZ Sushi Platter", "Royal"));
        List<String> t268 = new ArrayList<>(List.of("Sea weeds Salad", "Sea weeds Salad"));
        List<String> t269 = new ArrayList<>(List.of("Royal", "Tuna", "Chocolate Cake", "California Deluxe"));
        List<String> t270 = new ArrayList<>(List.of("Tantanmen", "Gyudon"));
        List<String> t271 = new ArrayList<>(List.of("WZ Sushi Platter", "California Deluxe", "Tuna", "Tuna", "Gyudon", "Tantanmen", "Tuna"));
        List<String> t272 = new ArrayList<>(List.of("Tuna", "Tuna", "Tuna", "WZ Sushi Platter"));
        List<String> t273 = new ArrayList<>(List.of("Tantanmen", "Tantanmen", "Gyudon", "WZ Sushi Platter", "Tantanmen"));
        List<String> t274 = new ArrayList<>(List.of("Tuna", "Chocolate Cake"));
        List<String> t275 = new ArrayList<>(List.of("Gyudon", "Sea weeds Salad", "WZ Sushi Platter", "Tantanmen"));
        List<String> t276 = new ArrayList<>(List.of("Gyudon"));
        List<String> t277 = new ArrayList<>(List.of("Chocolate Cake", "Tuna", "Gyudon"));
        List<String> t278 = new ArrayList<>(List.of("Gyudon", "Tuna", "California Deluxe", "Tuna", "California Deluxe", "Royal"));
        List<String> t279 = new ArrayList<>(List.of("Tuna", "Royal", "Tuna"));
        List<String> t280 = new ArrayList<>(List.of("Royal", "Tantanmen", "WZ Sushi Platter", "Tuna"));
        List<String> t281 = new ArrayList<>(List.of("Royal", "California Deluxe"));
        List<String> t282 = new ArrayList<>(List.of("Chocolate Cake", "Royal", "WZ Sushi Platter", "Tantanmen", "Tuna"));
        List<String> t283 = new ArrayList<>(List.of("Sea weeds Salad", "WZ Sushi Platter"));
        List<String> t284 = new ArrayList<>(List.of("California Deluxe", "Tantanmen", "Tuna", "Tantanmen"));
        List<String> t285 = new ArrayList<>(List.of("Tuna", "Tantanmen", "Tuna", "Tantanmen", "Sea weeds Salad", "California Deluxe", "Chocolate Cake"));
        List<String> t286 = new ArrayList<>(List.of("Tuna", "Chocolate Cake", "Tantanmen"));
        List<String> t287 = new ArrayList<>(List.of("Tuna"));
        List<String> t288 = new ArrayList<>(List.of("Gyudon", "Sea weeds Salad", "Tuna", "Gyudon", "Sea weeds Salad", "Chocolate Cake", "Chocolate Cake"));
        List<String> t289 = new ArrayList<>(List.of("Sea weeds Salad"));
        List<String> t290 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t291 = new ArrayList<>(List.of("Tantanmen", "Gyudon"));
        List<String> t292 = new ArrayList<>(List.of("Royal"));
        List<String> t293 = new ArrayList<>(List.of("Tuna", "Chocolate Cake", "California Deluxe"));
        List<String> t294 = new ArrayList<>(List.of("California Deluxe", "Tantanmen", "Tantanmen", "Royal", "Sea weeds Salad"));
        List<String> t295 = new ArrayList<>(List.of("California Deluxe", "Royal", "WZ Sushi Platter", "Gyudon"));
        List<String> t296 = new ArrayList<>(List.of("Tantanmen", "California Deluxe"));
        List<String> t297 = new ArrayList<>(List.of("Gyudon"));
        List<String> t298 = new ArrayList<>(List.of("Gyudon", "Tuna", "Tuna"));
        List<String> t299 = new ArrayList<>(List.of("Tantanmen", "California Deluxe", "Sea weeds Salad", "Tantanmen", "California Deluxe"));
        List<String> t300 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen"));
        List<String> t301 = new ArrayList<>(List.of("Tuna", "Gyudon", "Royal", "WZ Sushi Platter", "Sea weeds Salad", "Gyudon", "WZ Sushi Platter"));
        List<String> t302 = new ArrayList<>(List.of("Royal", "Gyudon", "Chocolate Cake"));
        List<String> t303 = new ArrayList<>(List.of("Sea weeds Salad", "California Deluxe", "Chocolate Cake"));
        List<String> t304 = new ArrayList<>(List.of("Tantanmen", "Tuna", "Gyudon", "Chocolate Cake"));
        List<String> t305 = new ArrayList<>(List.of("WZ Sushi Platter", "California Deluxe", "Tantanmen"));
        List<String> t306 = new ArrayList<>(List.of("Gyudon", "Royal", "Sea weeds Salad", "Tuna"));
        List<String> t307 = new ArrayList<>(List.of("Tuna", "Gyudon", "WZ Sushi Platter", "Royal", "California Deluxe"));
        List<String> t308 = new ArrayList<>(List.of("Tantanmen", "Tuna"));
        List<String> t309 = new ArrayList<>(List.of("California Deluxe", "Sea weeds Salad"));
        List<String> t310 = new ArrayList<>(List.of("Sea weeds Salad", "Tuna"));
        List<String> t311 = new ArrayList<>(List.of("Chocolate Cake", "Sea weeds Salad"));
        List<String> t312 = new ArrayList<>(List.of("Tuna", "California Deluxe"));
        List<String> t313 = new ArrayList<>(List.of("WZ Sushi Platter", "Gyudon", "Sea weeds Salad", "Tuna", "Tuna", "Sea weeds Salad"));
        List<String> t314 = new ArrayList<>(List.of("Chocolate Cake", "Gyudon", "Tuna", "California Deluxe", "Tuna", "WZ Sushi Platter", "Tantanmen"));
        List<String> t315 = new ArrayList<>(List.of("Chocolate Cake", "Gyudon", "California Deluxe", "California Deluxe", "Royal", "Tantanmen", "Sea weeds Salad"));
        List<String> t316 = new ArrayList<>(List.of("Tantanmen", "Tuna", "Sea weeds Salad", "Tuna"));
        List<String> t317 = new ArrayList<>(List.of("Tantanmen"));
        List<String> t318 = new ArrayList<>(List.of("Tuna", "California Deluxe"));
        List<String> t319 = new ArrayList<>(List.of("Gyudon", "California Deluxe", "Tantanmen", "Tantanmen", "Gyudon"));
        List<String> t320 = new ArrayList<>(List.of("Tantanmen", "Sea weeds Salad", "Royal", "California Deluxe", "Tuna", "Tantanmen"));
        List<String> t321 = new ArrayList<>(List.of("Tuna", "California Deluxe", "Tuna"));
        List<String> t322 = new ArrayList<>(List.of("Tuna"));
        List<String> t323 = new ArrayList<>(List.of("Tuna", "Gyudon", "Tuna", "Royal", "Tantanmen", "California Deluxe"));
        List<String> t324 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen", "Chocolate Cake", "Gyudon", "Royal", "California Deluxe", "Gyudon"));
        List<String> t325 = new ArrayList<>(List.of("California Deluxe", "Chocolate Cake", "Sea weeds Salad", "Sea weeds Salad", "Royal", "Sea weeds Salad", "Royal"));
        List<String> t326 = new ArrayList<>(List.of("Gyudon"));
        List<String> t327 = new ArrayList<>(List.of("Gyudon", "Tuna", "Royal", "WZ Sushi Platter", "WZ Sushi Platter", "WZ Sushi Platter", "Sea weeds Salad"));
        List<String> t328 = new ArrayList<>(List.of("Tuna", "Tuna"));
        List<String> t329 = new ArrayList<>(List.of("Tuna", "Royal", "Royal", "Tuna", "Royal", "Chocolate Cake", "Tuna"));
        List<String> t330 = new ArrayList<>(List.of("California Deluxe", "Tuna"));
        List<String> t331 = new ArrayList<>(List.of("Chocolate Cake", "Tuna", "Tuna"));
        List<String> t332 = new ArrayList<>(List.of("Chocolate Cake", "Royal", "Tuna", "California Deluxe", "Chocolate Cake"));
        List<String> t333 = new ArrayList<>(List.of("California Deluxe", "WZ Sushi Platter", "Tuna", "Tantanmen"));
        List<String> t334 = new ArrayList<>(List.of("Royal", "California Deluxe", "WZ Sushi Platter", "Chocolate Cake", "Chocolate Cake", "Gyudon"));
        List<String> t335 = new ArrayList<>(List.of("Chocolate Cake", "Sea weeds Salad", "Royal", "WZ Sushi Platter", "Royal"));
        List<String> t336 = new ArrayList<>(List.of("Tuna", "Sea weeds Salad", "Tantanmen", "Tuna", "Chocolate Cake", "Royal"));
        List<String> t337 = new ArrayList<>(List.of("California Deluxe", "Tantanmen"));
        List<String> t338 = new ArrayList<>(List.of("WZ Sushi Platter", "California Deluxe"));
        List<String> t339 = new ArrayList<>(List.of("Royal", "Sea weeds Salad", "WZ Sushi Platter"));
        List<String> t340 = new ArrayList<>(List.of("Sea weeds Salad", "Tuna", "Royal", "Tuna", "Royal"));
        List<String> t341 = new ArrayList<>(List.of("Tuna", "Tantanmen", "Chocolate Cake", "Tuna", "WZ Sushi Platter", "Tuna"));
        List<String> t342 = new ArrayList<>(List.of("California Deluxe", "Tantanmen", "WZ Sushi Platter", "Tantanmen"));
        List<String> t343 = new ArrayList<>(List.of("Royal", "Tantanmen", "Royal", "California Deluxe", "Tuna"));
        List<String> t344 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna"));
        List<String> t345 = new ArrayList<>(List.of("WZ Sushi Platter", "Gyudon", "Gyudon"));
        List<String> t346 = new ArrayList<>(List.of("Royal", "Tuna", "Gyudon", "California Deluxe", "California Deluxe", "Chocolate Cake"));
        List<String> t347 = new ArrayList<>(List.of("Sea weeds Salad", "WZ Sushi Platter"));
        List<String> t348 = new ArrayList<>(List.of("Gyudon", "Royal"));
        List<String> t349 = new ArrayList<>(List.of("Tuna", "Sea weeds Salad"));
        List<String> t350 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter", "California Deluxe", "Tuna", "Royal", "Sea weeds Salad"));
        List<String> t351 = new ArrayList<>(List.of("Sea weeds Salad", "California Deluxe"));
        List<String> t352 = new ArrayList<>(List.of("Royal", "Chocolate Cake", "Royal", "Sea weeds Salad"));
        List<String> t353 = new ArrayList<>(List.of("Chocolate Cake", "Tantanmen", "Royal", "WZ Sushi Platter", "Chocolate Cake"));
        List<String> t354 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t355 = new ArrayList<>(List.of("WZ Sushi Platter", "Royal", "WZ Sushi Platter", "Royal", "Tuna"));
        List<String> t356 = new ArrayList<>(List.of("Sea weeds Salad", "Chocolate Cake", "Tuna", "Chocolate Cake", "Chocolate Cake", "Chocolate Cake", "Gyudon"));
        List<String> t357 = new ArrayList<>(List.of("Tuna", "Royal", "Sea weeds Salad", "Tantanmen"));
        List<String> t358 = new ArrayList<>(List.of("California Deluxe", "California Deluxe", "Tantanmen", "Sea weeds Salad"));
        List<String> t359 = new ArrayList<>(List.of("Tantanmen", "Tuna"));
        List<String> t360 = new ArrayList<>(List.of("California Deluxe", "Chocolate Cake", "California Deluxe"));
        List<String> t361 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna", "WZ Sushi Platter", "Tantanmen", "Tantanmen"));
        List<String> t362 = new ArrayList<>(List.of("Tuna", "Tantanmen"));
        List<String> t363 = new ArrayList<>(List.of("Gyudon", "WZ Sushi Platter"));
        List<String> t364 = new ArrayList<>(List.of("WZ Sushi Platter", "California Deluxe", "WZ Sushi Platter", "Tuna", "Gyudon"));
        List<String> t365 = new ArrayList<>(List.of("Sea weeds Salad", "Chocolate Cake", "Gyudon", "Tuna", "WZ Sushi Platter", "Royal"));
        List<String> t366 = new ArrayList<>(List.of("WZ Sushi Platter", "Royal", "WZ Sushi Platter", "Tuna", "Tuna", "Tuna", "WZ Sushi Platter"));
        List<String> t367 = new ArrayList<>(List.of("Sea weeds Salad", "Tuna", "WZ Sushi Platter", "Royal"));
        List<String> t368 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t369 = new ArrayList<>(List.of("Royal", "Royal", "California Deluxe"));
        List<String> t370 = new ArrayList<>(List.of("Tantanmen", "WZ Sushi Platter", "Tantanmen"));
        List<String> t371 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen", "Tuna", "Gyudon", "Sea weeds Salad", "Royal"));
        List<String> t372 = new ArrayList<>(List.of("Tantanmen", "Tuna"));
        List<String> t373 = new ArrayList<>(List.of("Tuna", "Tuna", "Gyudon", "Chocolate Cake", "California Deluxe", "Tuna"));
        List<String> t374 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t375 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen", "Chocolate Cake", "Tantanmen", "Chocolate Cake", "WZ Sushi Platter", "Sea weeds Salad"));
        List<String> t376 = new ArrayList<>(List.of("Tantanmen", "Tuna", "Tantanmen", "Gyudon", "Tuna", "California Deluxe", "Sea weeds Salad"));
        List<String> t377 = new ArrayList<>(List.of("Tuna", "California Deluxe"));
        List<String> t378 = new ArrayList<>(List.of("Gyudon"));
        List<String> t379 = new ArrayList<>(List.of("Tuna"));
        List<String> t380 = new ArrayList<>(List.of("Gyudon"));
        List<String> t381 = new ArrayList<>(List.of("Tantanmen", "Chocolate Cake", "Tuna", "Gyudon"));
        List<String> t382 = new ArrayList<>(List.of("California Deluxe", "California Deluxe", "Sea weeds Salad", "Sea weeds Salad"));
        List<String> t383 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna", "WZ Sushi Platter"));
        List<String> t384 = new ArrayList<>(List.of("Tantanmen", "WZ Sushi Platter"));
        List<String> t385 = new ArrayList<>(List.of("Tantanmen"));
        List<String> t386 = new ArrayList<>(List.of("Royal"));
        List<String> t387 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter"));
        List<String> t388 = new ArrayList<>(List.of("Tuna", "Royal"));
        List<String> t389 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter"));
        List<String> t390 = new ArrayList<>(List.of("Gyudon", "California Deluxe", "Tuna", "Royal", "Sea weeds Salad", "WZ Sushi Platter"));
        List<String> t391 = new ArrayList<>(List.of("WZ Sushi Platter", "Sea weeds Salad", "Royal", "Royal"));
        List<String> t392 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Royal"));
        List<String> t393 = new ArrayList<>(List.of("Chocolate Cake", "Tuna", "California Deluxe"));
        List<String> t394 = new ArrayList<>(List.of("WZ Sushi Platter", "Chocolate Cake", "Tantanmen", "Sea weeds Salad", "California Deluxe", "California Deluxe"));
        List<String> t395 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen"));
        List<String> t396 = new ArrayList<>(List.of("Royal", "California Deluxe", "Tuna", "Tuna", "Tantanmen", "Tantanmen"));
        List<String> t397 = new ArrayList<>(List.of("Sea weeds Salad"));
        List<String> t398 = new ArrayList<>(List.of("Gyudon", "California Deluxe", "Chocolate Cake", "WZ Sushi Platter"));
        List<String> t399 = new ArrayList<>(List.of("California Deluxe"));
        List<String> t400 = new ArrayList<>(List.of("Tuna", "Tuna"));
        List<String> t401 = new ArrayList<>(List.of("Gyudon", "WZ Sushi Platter"));
        List<String> t402 = new ArrayList<>(List.of("WZ Sushi Platter", "California Deluxe"));
        List<String> t403 = new ArrayList<>(List.of("Royal", "Gyudon", "Sea weeds Salad"));
        List<String> t404 = new ArrayList<>(List.of("Gyudon", "Tuna", "Sea weeds Salad", "WZ Sushi Platter", "Sea weeds Salad"));
        List<String> t405 = new ArrayList<>(List.of("Tuna", "Tuna", "Tuna", "Tantanmen", "Sea weeds Salad"));
        List<String> t406 = new ArrayList<>(List.of("WZ Sushi Platter", "California Deluxe", "Sea weeds Salad", "Gyudon", "WZ Sushi Platter"));
        List<String> t407 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t408 = new ArrayList<>(List.of("Tuna", "Royal", "Tantanmen", "Tantanmen", "California Deluxe", "Gyudon", "Tantanmen"));
        List<String> t409 = new ArrayList<>(List.of("Tuna"));
        List<String> t410 = new ArrayList<>(List.of("Tuna", "Tantanmen", "Gyudon", "Royal"));
        List<String> t411 = new ArrayList<>(List.of("Sea weeds Salad", "WZ Sushi Platter"));
        List<String> t412 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "California Deluxe", "Gyudon", "Chocolate Cake", "Gyudon"));
        List<String> t413 = new ArrayList<>(List.of("Tantanmen", "Chocolate Cake", "Gyudon", "Tuna", "Gyudon", "WZ Sushi Platter"));
        List<String> t414 = new ArrayList<>(List.of("California Deluxe", "Tuna"));
        List<String> t415 = new ArrayList<>(List.of("Gyudon", "Tantanmen", "California Deluxe", "Tuna", "Tuna"));
        List<String> t416 = new ArrayList<>(List.of("California Deluxe", "Royal", "Gyudon"));
        List<String> t417 = new ArrayList<>(List.of("Tuna", "Royal", "Tuna"));
        List<String> t418 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t419 = new ArrayList<>(List.of("Tuna", "Chocolate Cake", "Tuna", "Tantanmen"));
        List<String> t420 = new ArrayList<>(List.of("Tuna", "Gyudon"));
        List<String> t421 = new ArrayList<>(List.of("WZ Sushi Platter", "California Deluxe"));
        List<String> t422 = new ArrayList<>(List.of("Tuna"));
        List<String> t423 = new ArrayList<>(List.of("Royal", "Chocolate Cake", "California Deluxe"));
        List<String> t424 = new ArrayList<>(List.of("Tantanmen", "California Deluxe"));
        List<String> t425 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t426 = new ArrayList<>(List.of("California Deluxe", "Tuna"));
        List<String> t427 = new ArrayList<>(List.of("Gyudon"));
        List<String> t428 = new ArrayList<>(List.of("Tantanmen", "WZ Sushi Platter", "Chocolate Cake", "Sea weeds Salad", "Chocolate Cake", "Chocolate Cake", "Tantanmen"));
        List<String> t429 = new ArrayList<>(List.of("Tuna", "Tuna", "Tuna"));
        List<String> t430 = new ArrayList<>(List.of("California Deluxe", "Sea weeds Salad", "Tuna", "Sea weeds Salad", "Tuna", "Tantanmen", "Chocolate Cake"));
        List<String> t431 = new ArrayList<>(List.of("Tuna", "Tantanmen", "Chocolate Cake", "Tuna", "Tantanmen"));
        List<String> t432 = new ArrayList<>(List.of("Tuna"));
        List<String> t433 = new ArrayList<>(List.of("Chocolate Cake", "Royal", "Chocolate Cake", "Sea weeds Salad"));
        List<String> t434 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna", "California Deluxe", "Gyudon", "Chocolate Cake"));
        List<String> t435 = new ArrayList<>(List.of("California Deluxe", "Gyudon", "Tantanmen", "Gyudon", "WZ Sushi Platter", "Tuna"));
        List<String> t436 = new ArrayList<>(List.of("Royal", "Chocolate Cake", "Tuna", "Tantanmen", "Tuna", "Sea weeds Salad"));
        List<String> t437 = new ArrayList<>(List.of("Tuna", "Royal", "WZ Sushi Platter", "Tuna"));
        List<String> t438 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t439 = new ArrayList<>(List.of("California Deluxe", "Chocolate Cake", "Tuna"));
        List<String> t440 = new ArrayList<>(List.of("Royal"));
        List<String> t441 = new ArrayList<>(List.of("Gyudon", "Chocolate Cake", "Sea weeds Salad", "Tuna", "Tantanmen"));
        List<String> t442 = new ArrayList<>(List.of("Gyudon", "Tantanmen", "Chocolate Cake", "Chocolate Cake"));
        List<String> t443 = new ArrayList<>(List.of("Tuna", "Sea weeds Salad", "Tantanmen"));
        List<String> t444 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t445 = new ArrayList<>(List.of("California Deluxe", "Tuna", "California Deluxe", "Tuna", "Tantanmen"));
        List<String> t446 = new ArrayList<>(List.of("California Deluxe", "Tantanmen", "California Deluxe", "Chocolate Cake"));
        List<String> t447 = new ArrayList<>(List.of("Tuna", "Tantanmen"));
        List<String> t448 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t449 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter"));
        List<String> t450 = new ArrayList<>(List.of("California Deluxe", "Tuna", "Gyudon", "Chocolate Cake"));
        List<String> t451 = new ArrayList<>(List.of("California Deluxe", "California Deluxe", "WZ Sushi Platter"));
        List<String> t452 = new ArrayList<>(List.of("Tuna", "Sea weeds Salad", "Tuna", "Tantanmen", "California Deluxe", "Gyudon"));
        List<String> t453 = new ArrayList<>(List.of("Gyudon", "Tuna", "WZ Sushi Platter", "Gyudon", "Tantanmen", "California Deluxe"));
        List<String> t454 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen", "California Deluxe"));
        List<String> t455 = new ArrayList<>(List.of("Royal", "Sea weeds Salad", "Gyudon", "Royal", "Royal", "WZ Sushi Platter", "Tuna"));
        List<String> t456 = new ArrayList<>(List.of("Tuna"));
        List<String> t457 = new ArrayList<>(List.of("Sea weeds Salad", "WZ Sushi Platter", "Tuna", "Sea weeds Salad", "Tuna", "Chocolate Cake"));
        List<String> t458 = new ArrayList<>(List.of("California Deluxe"));
        List<String> t459 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter", "Chocolate Cake"));
        List<String> t460 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter", "WZ Sushi Platter", "Tantanmen", "Chocolate Cake", "California Deluxe"));
        List<String> t461 = new ArrayList<>(List.of("Sea weeds Salad", "California Deluxe"));
        List<String> t462 = new ArrayList<>(List.of("Sea weeds Salad", "California Deluxe", "Tuna"));
        List<String> t463 = new ArrayList<>(List.of("Sea weeds Salad", "Gyudon"));
        List<String> t464 = new ArrayList<>(List.of("Sea weeds Salad", "Royal"));
        List<String> t465 = new ArrayList<>(List.of("California Deluxe", "WZ Sushi Platter", "Chocolate Cake", "Gyudon", "Chocolate Cake", "Chocolate Cake", "Gyudon"));
        List<String> t466 = new ArrayList<>(List.of("Tuna", "Tuna"));
        List<String> t467 = new ArrayList<>(List.of("Gyudon", "Gyudon", "Tuna"));
        List<String> t468 = new ArrayList<>(List.of("Chocolate Cake", "Tuna", "Tuna", "Tantanmen", "Chocolate Cake", "WZ Sushi Platter"));
        List<String> t469 = new ArrayList<>(List.of("Sea weeds Salad", "Chocolate Cake", "Sea weeds Salad", "Gyudon", "Sea weeds Salad"));
        List<String> t470 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter"));
        List<String> t471 = new ArrayList<>(List.of("Tantanmen", "California Deluxe"));
        List<String> t472 = new ArrayList<>(List.of("Tuna", "Tuna", "Tantanmen", "Gyudon", "California Deluxe"));
        List<String> t473 = new ArrayList<>(List.of("Tuna", "Gyudon", "Tantanmen", "Gyudon", "Tantanmen", "Tantanmen", "Tuna"));
        List<String> t474 = new ArrayList<>(List.of("Tuna", "Sea weeds Salad", "Gyudon", "Tuna", "California Deluxe", "Tuna", "WZ Sushi Platter"));
        List<String> t475 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen"));
        List<String> t476 = new ArrayList<>(List.of("Tantanmen", "Chocolate Cake", "Sea weeds Salad"));
        List<String> t477 = new ArrayList<>(List.of("Tuna", "Chocolate Cake", "Tuna", "WZ Sushi Platter"));
        List<String> t478 = new ArrayList<>(List.of("Tuna", "Tantanmen", "Tuna", "WZ Sushi Platter", "WZ Sushi Platter", "Tantanmen", "WZ Sushi Platter"));
        List<String> t479 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen", "California Deluxe", "Gyudon"));
        List<String> t480 = new ArrayList<>(List.of("Tuna", "Royal", "WZ Sushi Platter", "Sea weeds Salad", "California Deluxe", "Tantanmen"));
        List<String> t481 = new ArrayList<>(List.of("Sea weeds Salad", "Sea weeds Salad"));
        List<String> t482 = new ArrayList<>(List.of("Sea weeds Salad", "Tuna"));
        List<String> t483 = new ArrayList<>(List.of("Gyudon", "Tuna", "Tuna", "Sea weeds Salad", "Chocolate Cake", "Tuna", "Sea weeds Salad"));
        List<String> t484 = new ArrayList<>(List.of("Tuna"));
        List<String> t485 = new ArrayList<>(List.of("Gyudon", "WZ Sushi Platter"));
        List<String> t486 = new ArrayList<>(List.of("Chocolate Cake", "California Deluxe", "Tantanmen", "Chocolate Cake", "Sea weeds Salad"));
        List<String> t487 = new ArrayList<>(List.of("Tantanmen", "WZ Sushi Platter", "California Deluxe", "Gyudon"));
        List<String> t488 = new ArrayList<>(List.of("Gyudon"));
        List<String> t489 = new ArrayList<>(List.of("California Deluxe", "California Deluxe"));
        List<String> t490 = new ArrayList<>(List.of("Gyudon", "WZ Sushi Platter", "Chocolate Cake"));
        List<String> t491 = new ArrayList<>(List.of("Royal"));
        List<String> t492 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter", "WZ Sushi Platter", "Tuna", "Royal", "Tuna"));
        List<String> t493 = new ArrayList<>(List.of("Royal", "Tuna", "Royal"));
        List<String> t494 = new ArrayList<>(List.of("WZ Sushi Platter", "California Deluxe"));
        List<String> t495 = new ArrayList<>(List.of("California Deluxe", "Tuna"));
        List<String> t496 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t497 = new ArrayList<>(List.of("Royal", "Royal", "Tuna", "Tantanmen", "Tantanmen", "Sea weeds Salad", "WZ Sushi Platter"));
        List<String> t498 = new ArrayList<>(List.of("Tantanmen", "Tantanmen", "Sea weeds Salad", "Sea weeds Salad", "Tuna"));
        List<String> t499 = new ArrayList<>(List.of("WZ Sushi Platter", "Gyudon", "WZ Sushi Platter", "California Deluxe", "California Deluxe", "Tantanmen"));
        List<String> t500 = new ArrayList<>(List.of("Tuna", "Gyudon"));

        Collections.addAll(transactionsTB,
                t1, t2, t3, t4, t5, t6, t7, t8, t9, t10,
                t11, t12, t13, t14, t15, t16, t17, t18, t19, t20,
                t21, t22, t23, t24, t25, t26, t27, t28, t29, t30,
                t31, t32, t33, t34, t35, t36, t37, t38, t39, t40,
                t41, t42, t43, t44, t45, t46, t47, t48, t49, t50,
                t51, t52, t53, t54, t55, t56, t57, t58, t59, t60,
                t61, t62, t63, t64, t65, t66, t67, t68, t69, t70,
                t71, t72, t73, t74, t75, t76, t77, t78, t79, t80,
                t81, t82, t83, t84, t85, t86, t87, t88, t89, t90,
                t91, t92, t93, t94, t95, t96, t97, t98, t99, t100,
                t101, t102, t103, t104, t105, t106, t107, t108, t109, t110,
                t111, t112, t113, t114, t115, t116, t117, t118, t119, t120,
                t121, t122, t123, t124, t125, t126, t127, t128, t129, t130,
                t131, t132, t133, t134, t135, t136, t137, t138, t139, t140,
                t141, t142, t143, t144, t145, t146, t147, t148, t149, t150,
                t151, t152, t153, t154, t155, t156, t157, t158, t159, t160,
                t161, t162, t163, t164, t165, t166, t167, t168, t169, t170,
                t171, t172, t173, t174, t175, t176, t177, t178, t179, t180,
                t181, t182, t183, t184, t185, t186, t187, t188, t189, t190,
                t191, t192, t193, t194, t195, t196, t197, t198, t199, t200,
                t201, t202, t203, t204, t205, t206, t207, t208, t209, t210,
                t211, t212, t213, t214, t215, t216, t217, t218, t219, t220,
                t221, t222, t223, t224, t225, t226, t227, t228, t229, t230,
                t231, t232, t233, t234, t235, t236, t237, t238, t239, t240,
                t241, t242, t243, t244, t245, t246, t247, t248, t249, t250,
                t251, t252, t253, t254, t255, t256, t257, t258, t259, t260,
                t261, t262, t263, t264, t265, t266, t267, t268, t269, t270,
                t271, t272, t273, t274, t275, t276, t277, t278, t279, t280,
                t281, t282, t283, t284, t285, t286, t287, t288, t289, t290,
                t291, t292, t293, t294, t295, t296, t297, t298, t299, t300,
                t301, t302, t303, t304, t305, t306, t307, t308, t309, t310,
                t311, t312, t313, t314, t315, t316, t317, t318, t319, t320,
                t321, t322, t323, t324, t325, t326, t327, t328, t329, t330,
                t331, t332, t333, t334, t335, t336, t337, t338, t339, t340,
                t341, t342, t343, t344, t345, t346, t347, t348, t349, t350,
                t351, t352, t353, t354, t355, t356, t357, t358, t359, t360,
                t361, t362, t363, t364, t365, t366, t367, t368, t369, t370,
                t371, t372, t373, t374, t375, t376, t377, t378, t379, t380,
                t381, t382, t383, t384, t385, t386, t387, t388, t389, t390,
                t391, t392, t393, t394, t395, t396, t397, t398, t399, t400,
                t401, t402, t403, t404, t405, t406, t407, t408, t409, t410,
                t411, t412, t413, t414, t415, t416, t417, t418, t419, t420,
                t421, t422, t423, t424, t425, t426, t427, t428, t429, t430,
                t431, t432, t433, t434, t435, t436, t437, t438, t439, t440,
                t441, t442, t443, t444, t445, t446, t447, t448, t449, t450,
                t451, t452, t453, t454, t455, t456, t457, t458, t459, t460,
                t461, t462, t463, t464, t465, t466, t467, t468, t469, t470,
                t471, t472, t473, t474, t475, t476, t477, t478, t479, t480,
                t481, t482, t483, t484, t485, t486, t487, t488, t489, t490,
                t491, t492, t493, t494, t495, t496, t497, t498, t499, t500
                );
        for (List<String> transaction : transactionsTB) {
            Set<String> filteredTransactions = new LinkedHashSet<>(transaction);
            transaction.clear();
            transaction.addAll(filteredTransactions);
        }
    }
}
