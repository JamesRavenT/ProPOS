package com.wabizabi.wazabipos.Utilities.Testing;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class DataSetA implements DataSet {
    public static void insertInto(List<List<String>> transactionsTB){


        List<String> t1 = new ArrayList<>(List.of("Tuna", "Royal", "Royal", "Tendon", "Tendon", "Tuna", "California Maki"));
        List<String> t2 = new ArrayList<>(List.of("Tuna", "Tonkotsu Ramen"));
        List<String> t3 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t4 = new ArrayList<>(List.of("California Maki", "California Maki"));
        List<String> t5 = new ArrayList<>(List.of("Tendon", "WZ Sushi Platter", "Tendon", "Royal", "Chocolate Cake", "Tuna", "Tendon"));
        List<String> t6 = new ArrayList<>(List.of("Royal", "Tonkotsu Ramen", "WZ Sushi Platter", "Salad Wrap", "Tendon"));
        List<String> t7 = new ArrayList<>(List.of("Royal", "WZ Sushi Platter", "WZ Sushi Platter", "Royal", "California Maki", "Chocolate Cake"));
        List<String> t8 = new ArrayList<>(List.of("Tuna", "California Maki", "Chocolate Cake", "Royal", "Salad Wrap", "Tuna"));
        List<String> t9 = new ArrayList<>(List.of("WZ Sushi Platter", "Tendon", "Royal", "Royal", "WZ Sushi Platter", "Tendon"));
        List<String> t10 = new ArrayList<>(List.of("Tuna"));
        List<String> t11 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tuna", "Salad Wrap", "California Maki", "WZ Sushi Platter", "Chocolate Cake", "Tendon"));
        List<String> t12 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t13 = new ArrayList<>(List.of("Tuna", "Chocolate Cake", "Royal", "WZ Sushi Platter"));
        List<String> t14 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t15 = new ArrayList<>(List.of("Royal", "Royal"));
        List<String> t16 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t17 = new ArrayList<>(List.of("Salad Wrap", "WZ Sushi Platter"));
        List<String> t18 = new ArrayList<>(List.of("Chocolate Cake", "Royal", "Tuna", "California Maki", "Tuna", "Royal", "Tuna"));
        List<String> t19 = new ArrayList<>(List.of("Tonkotsu Ramen", "Royal", "Tonkotsu Ramen", "California Maki", "Tuna"));
        List<String> t20 = new ArrayList<>(List.of("Tuna", "Tendon", "Salad Wrap", "Royal"));
        List<String> t21 = new ArrayList<>(List.of("Chocolate Cake", "Tonkotsu Ramen", "Salad Wrap", "Tonkotsu Ramen", "WZ Sushi Platter", "Tuna"));
        List<String> t22 = new ArrayList<>(List.of("Tonkotsu Ramen"));
        List<String> t23 = new ArrayList<>(List.of("Tonkotsu Ramen", "WZ Sushi Platter"));
        List<String> t24 = new ArrayList<>(List.of("Chocolate Cake", "WZ Sushi Platter", "Tuna", "Tendon", "Chocolate Cake"));
        List<String> t25 = new ArrayList<>(List.of("Chocolate Cake", "Tendon", "Tuna", "WZ Sushi Platter", "California Maki", "Chocolate Cake"));
        List<String> t26 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna", "Tuna", "Salad Wrap", "Royal"));
        List<String> t27 = new ArrayList<>(List.of("Tuna", "Tuna", "California Maki"));
        List<String> t28 = new ArrayList<>(List.of("Salad Wrap", "Tuna", "Salad Wrap", "Tonkotsu Ramen"));
        List<String> t29 = new ArrayList<>(List.of("Tonkotsu Ramen", "California Maki"));
        List<String> t30 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna", "Salad Wrap"));
        List<String> t31 = new ArrayList<>(List.of("Tendon", "Tendon", "Salad Wrap", "Tonkotsu Ramen", "Royal"));
        List<String> t32 = new ArrayList<>(List.of("Tonkotsu Ramen", "California Maki"));
        List<String> t33 = new ArrayList<>(List.of("California Maki"));
        List<String> t34 = new ArrayList<>(List.of("Chocolate Cake", "Tuna", "Tonkotsu Ramen", "Tonkotsu Ramen"));
        List<String> t35 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Tuna", "Tendon", "Salad Wrap", "Tonkotsu Ramen"));
        List<String> t36 = new ArrayList<>(List.of("Tonkotsu Ramen", "Salad Wrap"));
        List<String> t37 = new ArrayList<>(List.of("Salad Wrap", "Tuna"));
        List<String> t38 = new ArrayList<>(List.of("California Maki"));
        List<String> t39 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tuna", "California Maki", "Tonkotsu Ramen", "Salad Wrap", "Tuna", "Chocolate Cake"));
        List<String> t40 = new ArrayList<>(List.of("WZ Sushi Platter", "Chocolate Cake", "Tuna", "California Maki", "Chocolate Cake", "Salad Wrap", "Tuna"));
        List<String> t41 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter"));
        List<String> t42 = new ArrayList<>(List.of("Tendon"));
        List<String> t43 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t44 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tuna"));
        List<String> t45 = new ArrayList<>(List.of("Tuna", "Salad Wrap"));
        List<String> t46 = new ArrayList<>(List.of("Salad Wrap", "Tuna"));
        List<String> t47 = new ArrayList<>(List.of("Salad Wrap", "Tuna", "Tendon", "WZ Sushi Platter", "Salad Wrap", "Salad Wrap"));
        List<String> t48 = new ArrayList<>(List.of("Tonkotsu Ramen", "WZ Sushi Platter", "Tuna", "Tonkotsu Ramen", "Tonkotsu Ramen", "Tuna"));
        List<String> t49 = new ArrayList<>(List.of("Tonkotsu Ramen", "Chocolate Cake"));
        List<String> t50 = new ArrayList<>(List.of("Chocolate Cake", "California Maki", "California Maki", "Chocolate Cake", "WZ Sushi Platter", "Royal"));
        List<String> t51 = new ArrayList<>(List.of("Tuna", "Tuna", "WZ Sushi Platter"));
        List<String> t52 = new ArrayList<>(List.of("California Maki", "Tuna", "Tuna", "Tendon", "Tendon", "WZ Sushi Platter"));
        List<String> t53 = new ArrayList<>(List.of("California Maki", "Tuna"));
        List<String> t54 = new ArrayList<>(List.of("Tuna", "Tendon"));
        List<String> t55 = new ArrayList<>(List.of("Royal", "Tonkotsu Ramen", "Salad Wrap", "Royal", "Chocolate Cake", "California Maki", "Tendon"));
        List<String> t56 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t57 = new ArrayList<>(List.of("Tendon", "Tendon", "Chocolate Cake", "Chocolate Cake"));
        List<String> t58 = new ArrayList<>(List.of("Tendon", "Tonkotsu Ramen", "Royal", "Salad Wrap", "WZ Sushi Platter", "California Maki", "Salad Wrap"));
        List<String> t59 = new ArrayList<>(List.of("California Maki", "California Maki"));
        List<String> t60 = new ArrayList<>(List.of("Salad Wrap", "Salad Wrap", "Tuna"));
        List<String> t61 = new ArrayList<>(List.of("Tendon", "Tonkotsu Ramen", "Tonkotsu Ramen", "Tendon", "Tendon", "Tonkotsu Ramen", "WZ Sushi Platter"));
        List<String> t62 = new ArrayList<>(List.of("Tuna", "Tuna"));
        List<String> t63 = new ArrayList<>(List.of("Tonkotsu Ramen"));
        List<String> t64 = new ArrayList<>(List.of("Tonkotsu Ramen", "California Maki"));
        List<String> t65 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "WZ Sushi Platter"));
        List<String> t66 = new ArrayList<>(List.of("Chocolate Cake", "WZ Sushi Platter", "Tendon", "Chocolate Cake"));
        List<String> t67 = new ArrayList<>(List.of("Tuna", "Royal", "Salad Wrap", "Tendon"));
        List<String> t68 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t69 = new ArrayList<>(List.of("Salad Wrap", "Tuna", "Tendon", "Tuna", "Chocolate Cake"));
        List<String> t70 = new ArrayList<>(List.of("Salad Wrap", "California Maki", "California Maki", "California Maki", "Royal"));
        List<String> t71 = new ArrayList<>(List.of("Tuna", "California Maki", "Tuna", "WZ Sushi Platter", "Tendon"));
        List<String> t72 = new ArrayList<>(List.of("Salad Wrap", "California Maki"));
        List<String> t73 = new ArrayList<>(List.of("Tendon", "California Maki"));
        List<String> t74 = new ArrayList<>(List.of("Salad Wrap", "Tendon", "Chocolate Cake", "Salad Wrap", "California Maki", "Salad Wrap", "Royal"));
        List<String> t75 = new ArrayList<>(List.of("Tonkotsu Ramen"));
        List<String> t76 = new ArrayList<>(List.of("Tuna"));
        List<String> t77 = new ArrayList<>(List.of("California Maki", "WZ Sushi Platter", "Tonkotsu Ramen", "WZ Sushi Platter", "Tuna", "Chocolate Cake"));
        List<String> t78 = new ArrayList<>(List.of("Tonkotsu Ramen", "California Maki", "Tendon", "Tuna", "Tonkotsu Ramen", "Tendon", "Tonkotsu Ramen"));
        List<String> t79 = new ArrayList<>(List.of("Chocolate Cake", "Tuna", "Tonkotsu Ramen", "Tonkotsu Ramen", "Tuna"));
        List<String> t80 = new ArrayList<>(List.of("California Maki", "Tuna", "Tuna", "Tonkotsu Ramen"));
        List<String> t81 = new ArrayList<>(List.of("Salad Wrap", "Chocolate Cake", "Royal", "Tonkotsu Ramen"));
        List<String> t82 = new ArrayList<>(List.of("Tuna", "California Maki", "Chocolate Cake", "Tendon", "Tuna", "Tendon"));
        List<String> t83 = new ArrayList<>(List.of("Royal", "California Maki", "Tendon", "Chocolate Cake"));
        List<String> t84 = new ArrayList<>(List.of("Tendon", "Tuna"));
        List<String> t85 = new ArrayList<>(List.of("WZ Sushi Platter", "Salad Wrap", "Salad Wrap", "Royal", "Tuna", "California Maki", "Tendon"));
        List<String> t86 = new ArrayList<>(List.of("Royal", "Tuna", "Tonkotsu Ramen", "California Maki", "Tendon", "Tendon"));
        List<String> t87 = new ArrayList<>(List.of("Tuna", "Royal"));
        List<String> t88 = new ArrayList<>(List.of("Royal", "Tuna", "Tuna", "Royal", "Tonkotsu Ramen"));
        List<String> t89 = new ArrayList<>(List.of("Salad Wrap", "WZ Sushi Platter"));
        List<String> t90 = new ArrayList<>(List.of("Salad Wrap", "WZ Sushi Platter"));
        List<String> t91 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tendon", "Salad Wrap", "Salad Wrap"));
        List<String> t92 = new ArrayList<>(List.of("Chocolate Cake", "California Maki", "Chocolate Cake", "California Maki", "WZ Sushi Platter", "Royal"));
        List<String> t93 = new ArrayList<>(List.of("Tuna", "Tuna"));
        List<String> t94 = new ArrayList<>(List.of("Salad Wrap", "California Maki", "Chocolate Cake", "Chocolate Cake", "WZ Sushi Platter"));
        List<String> t95 = new ArrayList<>(List.of("Tonkotsu Ramen", "Salad Wrap"));
        List<String> t96 = new ArrayList<>(List.of("Salad Wrap", "Tuna", "Tuna", "Chocolate Cake", "Tonkotsu Ramen", "Salad Wrap"));
        List<String> t97 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter", "Tendon", "Tuna"));
        List<String> t98 = new ArrayList<>(List.of("Chocolate Cake", "Salad Wrap", "Tuna", "Chocolate Cake", "California Maki", "California Maki", "Chocolate Cake"));
        List<String> t99 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tuna", "Royal", "Chocolate Cake", "Salad Wrap"));
        List<String> t100 = new ArrayList<>(List.of("Tonkotsu Ramen", "California Maki", "California Maki", "Tuna", "Tonkotsu Ramen", "Tendon", "Tendon"));
        List<String> t101 = new ArrayList<>(List.of("Chocolate Cake", "California Maki", "Tendon", "Tuna", "Tendon"));
        List<String> t102 = new ArrayList<>(List.of("Tuna", "Tonkotsu Ramen", "Salad Wrap", "Salad Wrap", "Tendon", "Royal", "Tonkotsu Ramen"));
        List<String> t103 = new ArrayList<>(List.of("California Maki"));
        List<String> t104 = new ArrayList<>(List.of("Tendon", "Salad Wrap"));
        List<String> t105 = new ArrayList<>(List.of("Tuna", "California Maki", "Tuna", "Tuna", "Royal", "WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t106 = new ArrayList<>(List.of("Chocolate Cake", "Tuna"));
        List<String> t107 = new ArrayList<>(List.of("Tuna"));
        List<String> t108 = new ArrayList<>(List.of("Tendon"));
        List<String> t109 = new ArrayList<>(List.of("Chocolate Cake", "California Maki", "WZ Sushi Platter", "Chocolate Cake", "Tuna"));
        List<String> t110 = new ArrayList<>(List.of("Salad Wrap", "WZ Sushi Platter", "Salad Wrap", "Tendon", "Salad Wrap", "California Maki", "Tuna"));
        List<String> t111 = new ArrayList<>(List.of("Chocolate Cake", "Salad Wrap", "California Maki", "Tuna", "Tuna", "Royal"));
        List<String> t112 = new ArrayList<>(List.of("Tonkotsu Ramen", "WZ Sushi Platter", "California Maki"));
        List<String> t113 = new ArrayList<>(List.of("Tonkotsu Ramen", "WZ Sushi Platter", "Tuna", "California Maki", "Tendon", "California Maki", "Tuna"));
        List<String> t114 = new ArrayList<>(List.of("Salad Wrap", "Tuna", "Royal"));
        List<String> t115 = new ArrayList<>(List.of("Chocolate Cake", "Tuna", "Tonkotsu Ramen", "Tuna"));
        List<String> t116 = new ArrayList<>(List.of("Royal", "Salad Wrap"));
        List<String> t117 = new ArrayList<>(List.of("Tonkotsu Ramen", "California Maki"));
        List<String> t118 = new ArrayList<>(List.of("Royal", "California Maki", "Salad Wrap", "Tuna"));
        List<String> t119 = new ArrayList<>(List.of("Tuna", "Tonkotsu Ramen", "California Maki", "California Maki"));
        List<String> t120 = new ArrayList<>(List.of("Tuna", "Royal", "Chocolate Cake", "Tendon", "Salad Wrap"));
        List<String> t121 = new ArrayList<>(List.of("California Maki", "Tonkotsu Ramen", "Tuna", "Royal"));
        List<String> t122 = new ArrayList<>(List.of("Salad Wrap", "Chocolate Cake", "Chocolate Cake", "WZ Sushi Platter", "Royal"));
        List<String> t123 = new ArrayList<>(List.of("Tuna", "Salad Wrap", "Tendon", "Tendon"));
        List<String> t124 = new ArrayList<>(List.of("Tuna", "Tendon", "Tuna"));
        List<String> t125 = new ArrayList<>(List.of("California Maki", "WZ Sushi Platter"));
        List<String> t126 = new ArrayList<>(List.of("Tuna", "California Maki"));
        List<String> t127 = new ArrayList<>(List.of("California Maki"));
        List<String> t128 = new ArrayList<>(List.of("California Maki", "Tendon"));
        List<String> t129 = new ArrayList<>(List.of("Tuna", "Tuna", "Tonkotsu Ramen"));
        List<String> t130 = new ArrayList<>(List.of("California Maki", "Tuna", "Tuna"));
        List<String> t131 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t132 = new ArrayList<>(List.of("Salad Wrap", "WZ Sushi Platter"));
        List<String> t133 = new ArrayList<>(List.of("Tuna", "Tendon", "Tuna", "California Maki", "Royal"));
        List<String> t134 = new ArrayList<>(List.of("California Maki", "Tuna", "Tendon", "Tuna", "Tendon"));
        List<String> t135 = new ArrayList<>(List.of("Salad Wrap"));
        List<String> t136 = new ArrayList<>(List.of("Royal", "Tonkotsu Ramen", "Salad Wrap", "California Maki", "Royal", "California Maki", "Tendon"));
        List<String> t137 = new ArrayList<>(List.of("Tuna", "California Maki", "California Maki", "Tuna"));
        List<String> t138 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t139 = new ArrayList<>(List.of("Tuna"));
        List<String> t140 = new ArrayList<>(List.of("Royal", "Royal", "Tuna", "WZ Sushi Platter", "Tuna"));
        List<String> t141 = new ArrayList<>(List.of("Tuna", "Salad Wrap", "Salad Wrap", "Tendon"));
        List<String> t142 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna"));
        List<String> t143 = new ArrayList<>(List.of("California Maki", "Salad Wrap", "Tuna"));
        List<String> t144 = new ArrayList<>(List.of("Royal", "California Maki"));
        List<String> t145 = new ArrayList<>(List.of("WZ Sushi Platter", "Salad Wrap"));
        List<String> t146 = new ArrayList<>(List.of("WZ Sushi Platter", "Tonkotsu Ramen"));
        List<String> t147 = new ArrayList<>(List.of("Tendon", "Tendon", "Royal", "Tuna", "California Maki"));
        List<String> t148 = new ArrayList<>(List.of("Tuna", "California Maki"));
        List<String> t149 = new ArrayList<>(List.of("WZ Sushi Platter", "California Maki", "Tendon", "Salad Wrap", "WZ Sushi Platter", "Tendon", "Royal"));
        List<String> t150 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tuna"));
        List<String> t151 = new ArrayList<>(List.of("Tonkotsu Ramen", "Chocolate Cake", "Tuna", "California Maki"));
        List<String> t152 = new ArrayList<>(List.of("California Maki"));
        List<String> t153 = new ArrayList<>(List.of("WZ Sushi Platter", "California Maki", "California Maki", "Salad Wrap", "California Maki", "Tuna", "Tendon"));
        List<String> t154 = new ArrayList<>(List.of("Tuna", "Tendon", "Tonkotsu Ramen", "Tendon", "WZ Sushi Platter", "Tendon"));
        List<String> t155 = new ArrayList<>(List.of("Tuna", "Tendon"));
        List<String> t156 = new ArrayList<>(List.of("Tuna", "Tuna", "California Maki", "Royal", "WZ Sushi Platter", "Tuna"));
        List<String> t157 = new ArrayList<>(List.of("California Maki", "WZ Sushi Platter", "Tuna", "Salad Wrap", "Royal"));
        List<String> t158 = new ArrayList<>(List.of("WZ Sushi Platter", "Salad Wrap", "Salad Wrap"));
        List<String> t159 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tendon", "Tuna", "Salad Wrap"));
        List<String> t160 = new ArrayList<>(List.of("Salad Wrap", "Salad Wrap", "WZ Sushi Platter", "Tendon", "Royal", "California Maki", "Tuna"));
        List<String> t161 = new ArrayList<>(List.of("Salad Wrap", "Salad Wrap", "Salad Wrap", "Royal", "Tuna", "WZ Sushi Platter", "Tuna"));
        List<String> t162 = new ArrayList<>(List.of("Salad Wrap", "WZ Sushi Platter"));
        List<String> t163 = new ArrayList<>(List.of("Royal", "Tuna", "Tuna", "Royal"));
        List<String> t164 = new ArrayList<>(List.of("Salad Wrap", "WZ Sushi Platter"));
        List<String> t165 = new ArrayList<>(List.of("Chocolate Cake", "Salad Wrap", "Tendon", "Tonkotsu Ramen"));
        List<String> t166 = new ArrayList<>(List.of("Tendon", "Tuna", "Tuna", "Tuna"));
        List<String> t167 = new ArrayList<>(List.of("California Maki", "California Maki", "Tuna"));
        List<String> t168 = new ArrayList<>(List.of("Tuna", "Royal", "Chocolate Cake", "Tonkotsu Ramen", "Chocolate Cake"));
        List<String> t169 = new ArrayList<>(List.of("Salad Wrap", "California Maki", "Royal", "Salad Wrap", "Salad Wrap", "Salad Wrap"));
        List<String> t170 = new ArrayList<>(List.of("Tendon"));
        List<String> t171 = new ArrayList<>(List.of("Chocolate Cake", "Royal", "WZ Sushi Platter", "Chocolate Cake"));
        List<String> t172 = new ArrayList<>(List.of("Tuna", "Royal", "Tuna", "Chocolate Cake", "Tendon", "Tuna"));
        List<String> t173 = new ArrayList<>(List.of("California Maki"));
        List<String> t174 = new ArrayList<>(List.of("Tendon", "Salad Wrap"));
        List<String> t175 = new ArrayList<>(List.of("Salad Wrap", "California Maki"));
        List<String> t176 = new ArrayList<>(List.of("California Maki", "Tendon", "Tendon"));
        List<String> t177 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tuna"));
        List<String> t178 = new ArrayList<>(List.of("California Maki", "Tendon", "Tuna"));
        List<String> t179 = new ArrayList<>(List.of("Tuna", "Tonkotsu Ramen", "Tuna"));
        List<String> t180 = new ArrayList<>(List.of("Tendon", "Salad Wrap", "Royal", "Tuna", "Tonkotsu Ramen", "Chocolate Cake", "WZ Sushi Platter"));
        List<String> t181 = new ArrayList<>(List.of("Tuna", "Tuna", "Chocolate Cake", "Tonkotsu Ramen", "Tuna"));
        List<String> t182 = new ArrayList<>(List.of("California Maki", "Tonkotsu Ramen", "Tuna", "California Maki", "Tonkotsu Ramen", "Tendon", "Tonkotsu Ramen"));
        List<String> t183 = new ArrayList<>(List.of("Tuna", "Tonkotsu Ramen", "California Maki", "Tendon", "Tuna"));
        List<String> t184 = new ArrayList<>(List.of("Tendon", "WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t185 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t186 = new ArrayList<>(List.of("Royal", "WZ Sushi Platter"));
        List<String> t187 = new ArrayList<>(List.of("California Maki", "Royal", "California Maki", "Chocolate Cake", "Tuna", "Salad Wrap", "Tonkotsu Ramen"));
        List<String> t188 = new ArrayList<>(List.of("Royal", "Salad Wrap", "Tuna"));
        List<String> t189 = new ArrayList<>(List.of("Tuna", "Royal", "Royal", "Salad Wrap"));
        List<String> t190 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter"));
        List<String> t191 = new ArrayList<>(List.of("Tendon", "Tendon", "California Maki", "Chocolate Cake", "Salad Wrap"));
        List<String> t192 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Royal", "Chocolate Cake"));
        List<String> t193 = new ArrayList<>(List.of("WZ Sushi Platter", "Tonkotsu Ramen"));
        List<String> t194 = new ArrayList<>(List.of("California Maki"));
        List<String> t195 = new ArrayList<>(List.of("Tuna", "Tuna", "California Maki", "Royal", "WZ Sushi Platter"));
        List<String> t196 = new ArrayList<>(List.of("Chocolate Cake", "Tendon", "Tonkotsu Ramen"));
        List<String> t197 = new ArrayList<>(List.of("Royal", "Royal", "Tuna"));
        List<String> t198 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Salad Wrap", "WZ Sushi Platter", "Tonkotsu Ramen", "Tuna"));
        List<String> t199 = new ArrayList<>(List.of("Royal", "Tendon"));
        List<String> t200 = new ArrayList<>(List.of("Tuna", "Salad Wrap", "WZ Sushi Platter"));
        List<String> t201 = new ArrayList<>(List.of("Tuna", "Royal", "Chocolate Cake", "Salad Wrap", "Tuna", "Tonkotsu Ramen"));
        List<String> t202 = new ArrayList<>(List.of("Royal"));
        List<String> t203 = new ArrayList<>(List.of("California Maki", "Tuna"));
        List<String> t204 = new ArrayList<>(List.of("California Maki", "Tendon", "Salad Wrap", "Salad Wrap", "California Maki", "Tuna"));
        List<String> t205 = new ArrayList<>(List.of("Tonkotsu Ramen"));
        List<String> t206 = new ArrayList<>(List.of("Tuna", "Salad Wrap", "WZ Sushi Platter", "Chocolate Cake", "WZ Sushi Platter", "Tuna"));
        List<String> t207 = new ArrayList<>(List.of("Tonkotsu Ramen", "Salad Wrap"));
        List<String> t208 = new ArrayList<>(List.of("Royal", "WZ Sushi Platter", "Salad Wrap"));
        List<String> t209 = new ArrayList<>(List.of("Royal", "Royal", "Royal"));
        List<String> t210 = new ArrayList<>(List.of("Tonkotsu Ramen", "California Maki", "Tonkotsu Ramen"));
        List<String> t211 = new ArrayList<>(List.of("Royal", "WZ Sushi Platter", "Tuna", "Tendon", "Tonkotsu Ramen"));
        List<String> t212 = new ArrayList<>(List.of("Tonkotsu Ramen", "Salad Wrap", "Salad Wrap"));
        List<String> t213 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tuna"));
        List<String> t214 = new ArrayList<>(List.of("Salad Wrap", "Chocolate Cake", "WZ Sushi Platter", "California Maki", "WZ Sushi Platter", "Royal"));
        List<String> t215 = new ArrayList<>(List.of("Salad Wrap", "Tuna"));
        List<String> t216 = new ArrayList<>(List.of("California Maki", "Salad Wrap"));
        List<String> t217 = new ArrayList<>(List.of("Salad Wrap", "Salad Wrap", "Tuna", "Tonkotsu Ramen", "Chocolate Cake", "California Maki", "Chocolate Cake"));
        List<String> t218 = new ArrayList<>(List.of("Chocolate Cake", "Tendon", "Chocolate Cake"));
        List<String> t219 = new ArrayList<>(List.of("Royal", "WZ Sushi Platter", "Chocolate Cake", "WZ Sushi Platter", "Chocolate Cake", "California Maki"));
        List<String> t220 = new ArrayList<>(List.of("Salad Wrap", "Royal", "Salad Wrap", "California Maki", "WZ Sushi Platter", "Tonkotsu Ramen", "Chocolate Cake"));
        List<String> t221 = new ArrayList<>(List.of("Tuna"));
        List<String> t222 = new ArrayList<>(List.of("Royal", "Chocolate Cake"));
        List<String> t223 = new ArrayList<>(List.of("Tuna"));
        List<String> t224 = new ArrayList<>(List.of("Tuna"));
        List<String> t225 = new ArrayList<>(List.of("Chocolate Cake", "California Maki", "WZ Sushi Platter", "Tonkotsu Ramen", "WZ Sushi Platter", "WZ Sushi Platter", "Tuna"));
        List<String> t226 = new ArrayList<>(List.of("WZ Sushi Platter", "Tonkotsu Ramen", "California Maki", "Salad Wrap", "Royal", "Royal", "Tuna"));
        List<String> t227 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t228 = new ArrayList<>(List.of("Tuna", "Salad Wrap"));
        List<String> t229 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tuna"));
        List<String> t230 = new ArrayList<>(List.of("WZ Sushi Platter", "Tonkotsu Ramen", "Royal", "WZ Sushi Platter"));
        List<String> t231 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna", "California Maki", "WZ Sushi Platter", "Chocolate Cake", "California Maki"));
        List<String> t232 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t233 = new ArrayList<>(List.of("Tendon", "Tonkotsu Ramen"));
        List<String> t234 = new ArrayList<>(List.of("Salad Wrap", "WZ Sushi Platter"));
        List<String> t235 = new ArrayList<>(List.of("Tuna", "Tonkotsu Ramen", "Tonkotsu Ramen", "Tuna"));
        List<String> t236 = new ArrayList<>(List.of("Tonkotsu Ramen"));
        List<String> t237 = new ArrayList<>(List.of("California Maki", "Salad Wrap", "WZ Sushi Platter"));
        List<String> t238 = new ArrayList<>(List.of("California Maki", "WZ Sushi Platter"));
        List<String> t239 = new ArrayList<>(List.of("California Maki"));
        List<String> t240 = new ArrayList<>(List.of("Tuna", "California Maki", "Tuna"));
        List<String> t241 = new ArrayList<>(List.of("Salad Wrap"));
        List<String> t242 = new ArrayList<>(List.of("Chocolate Cake", "California Maki", "Chocolate Cake", "Tonkotsu Ramen", "Tuna", "Tendon"));
        List<String> t243 = new ArrayList<>(List.of("WZ Sushi Platter", "Tendon", "Tuna", "California Maki", "Royal", "Royal"));
        List<String> t244 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna"));
        List<String> t245 = new ArrayList<>(List.of("Tendon", "Tonkotsu Ramen", "Tuna", "Chocolate Cake", "Tendon"));
        List<String> t246 = new ArrayList<>(List.of("California Maki", "California Maki"));
        List<String> t247 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t248 = new ArrayList<>(List.of("Tendon", "Salad Wrap", "California Maki", "Royal", "WZ Sushi Platter", "Salad Wrap"));
        List<String> t249 = new ArrayList<>(List.of("Tuna", "Salad Wrap"));
        List<String> t250 = new ArrayList<>(List.of("Tendon", "California Maki", "Tuna", "Tendon", "Royal", "Royal"));
        List<String> t251 = new ArrayList<>(List.of("Royal", "Chocolate Cake", "Tonkotsu Ramen", "Tuna"));
        List<String> t252 = new ArrayList<>(List.of("California Maki", "Tuna", "Chocolate Cake"));
        List<String> t253 = new ArrayList<>(List.of("Salad Wrap", "Tonkotsu Ramen", "WZ Sushi Platter", "Royal", "Tonkotsu Ramen", "Royal"));
        List<String> t254 = new ArrayList<>(List.of("Tendon"));
        List<String> t255 = new ArrayList<>(List.of("Tendon"));
        List<String> t256 = new ArrayList<>(List.of("WZ Sushi Platter", "Royal", "California Maki", "Tuna", "California Maki", "Tendon"));
        List<String> t257 = new ArrayList<>(List.of("Tuna", "California Maki", "WZ Sushi Platter", "California Maki", "Salad Wrap", "Tuna", "Royal"));
        List<String> t258 = new ArrayList<>(List.of("California Maki", "Tonkotsu Ramen"));
        List<String> t259 = new ArrayList<>(List.of("WZ Sushi Platter", "California Maki"));
        List<String> t260 = new ArrayList<>(List.of("Chocolate Cake", "Tonkotsu Ramen", "Tuna", "Chocolate Cake", "Salad Wrap"));
        List<String> t261 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t262 = new ArrayList<>(List.of("Salad Wrap", "Salad Wrap", "Royal"));
        List<String> t263 = new ArrayList<>(List.of("California Maki", "WZ Sushi Platter", "Royal"));
        List<String> t264 = new ArrayList<>(List.of("Tuna", "Tuna", "Royal"));
        List<String> t265 = new ArrayList<>(List.of("Royal", "Royal", "Salad Wrap", "Tuna", "WZ Sushi Platter", "Tonkotsu Ramen", "WZ Sushi Platter"));
        List<String> t266 = new ArrayList<>(List.of("Tuna"));
        List<String> t267 = new ArrayList<>(List.of("Salad Wrap", "Tuna", "Tendon", "Tonkotsu Ramen"));
        List<String> t268 = new ArrayList<>(List.of("Tonkotsu Ramen", "Salad Wrap", "WZ Sushi Platter", "Tuna", "Tonkotsu Ramen"));
        List<String> t269 = new ArrayList<>(List.of("California Maki", "California Maki", "Salad Wrap"));
        List<String> t270 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter", "Tonkotsu Ramen", "Tonkotsu Ramen", "Tendon"));
        List<String> t271 = new ArrayList<>(List.of("Tuna"));
        List<String> t272 = new ArrayList<>(List.of("Tonkotsu Ramen", "Salad Wrap", "Salad Wrap", "Tuna"));
        List<String> t273 = new ArrayList<>(List.of("Tendon", "Tendon", "California Maki", "California Maki"));
        List<String> t274 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tuna"));
        List<String> t275 = new ArrayList<>(List.of("California Maki", "Tendon", "Salad Wrap", "Tonkotsu Ramen", "Royal"));
        List<String> t276 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter", "California Maki", "California Maki", "Salad Wrap", "WZ Sushi Platter", "Tuna"));
        List<String> t277 = new ArrayList<>(List.of("California Maki"));
        List<String> t278 = new ArrayList<>(List.of("Tonkotsu Ramen", "WZ Sushi Platter"));
        List<String> t279 = new ArrayList<>(List.of("Tuna", "Tuna", "WZ Sushi Platter", "Salad Wrap", "Chocolate Cake", "Tendon"));
        List<String> t280 = new ArrayList<>(List.of("Salad Wrap", "California Maki", "Royal"));
        List<String> t281 = new ArrayList<>(List.of("Salad Wrap"));
        List<String> t282 = new ArrayList<>(List.of("Chocolate Cake", "Salad Wrap", "Tuna", "California Maki", "WZ Sushi Platter", "California Maki", "Tuna"));
        List<String> t283 = new ArrayList<>(List.of("Tuna", "Royal", "Tuna"));
        List<String> t284 = new ArrayList<>(List.of("WZ Sushi Platter", "Tendon", "Chocolate Cake", "Royal", "California Maki", "Salad Wrap"));
        List<String> t285 = new ArrayList<>(List.of("California Maki", "Tuna", "Tonkotsu Ramen", "WZ Sushi Platter", "Salad Wrap"));
        List<String> t286 = new ArrayList<>(List.of("WZ Sushi Platter", "Chocolate Cake", "Royal", "California Maki", "Royal", "Salad Wrap"));
        List<String> t287 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tonkotsu Ramen", "Chocolate Cake", "Chocolate Cake", "Royal"));
        List<String> t288 = new ArrayList<>(List.of("Salad Wrap", "Salad Wrap"));
        List<String> t289 = new ArrayList<>(List.of("California Maki", "Salad Wrap", "California Maki", "Royal", "Royal", "Royal"));
        List<String> t290 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna", "Tuna", "California Maki", "Salad Wrap", "California Maki", "Salad Wrap"));
        List<String> t291 = new ArrayList<>(List.of("Salad Wrap", "Tuna"));
        List<String> t292 = new ArrayList<>(List.of("Tonkotsu Ramen"));
        List<String> t293 = new ArrayList<>(List.of("Royal", "WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t294 = new ArrayList<>(List.of("California Maki"));
        List<String> t295 = new ArrayList<>(List.of("Tendon", "Tuna", "Tendon", "Tendon", "Royal"));
        List<String> t296 = new ArrayList<>(List.of("California Maki", "California Maki", "Tendon"));
        List<String> t297 = new ArrayList<>(List.of("California Maki", "Tonkotsu Ramen"));
        List<String> t298 = new ArrayList<>(List.of("Tuna", "Royal", "Salad Wrap"));
        List<String> t299 = new ArrayList<>(List.of("Tuna", "Tuna", "Tonkotsu Ramen", "Tuna", "Tendon", "WZ Sushi Platter", "Salad Wrap"));
        List<String> t300 = new ArrayList<>(List.of("California Maki", "Tonkotsu Ramen", "Tonkotsu Ramen", "Tonkotsu Ramen"));
        List<String> t301 = new ArrayList<>(List.of("Royal", "Tuna", "Salad Wrap", "Salad Wrap"));
        List<String> t302 = new ArrayList<>(List.of("Tendon"));
        List<String> t303 = new ArrayList<>(List.of("Tendon", "Royal"));
        List<String> t304 = new ArrayList<>(List.of("Tuna", "Salad Wrap"));
        List<String> t305 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter", "Royal"));
        List<String> t306 = new ArrayList<>(List.of("Tonkotsu Ramen"));
        List<String> t307 = new ArrayList<>(List.of("Salad Wrap"));
        List<String> t308 = new ArrayList<>(List.of("Tuna"));
        List<String> t309 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tuna", "Salad Wrap", "Tendon", "Tendon"));
        List<String> t310 = new ArrayList<>(List.of("Tuna", "Chocolate Cake", "Tuna", "Tonkotsu Ramen", "Tonkotsu Ramen", "Tendon"));
        List<String> t311 = new ArrayList<>(List.of("Tendon", "Tuna", "California Maki", "Chocolate Cake", "Tuna"));
        List<String> t312 = new ArrayList<>(List.of("Tuna", "Chocolate Cake", "Royal", "WZ Sushi Platter"));
        List<String> t313 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tuna", "Royal"));
        List<String> t314 = new ArrayList<>(List.of("Tendon", "Tendon", "California Maki"));
        List<String> t315 = new ArrayList<>(List.of("Tuna", "Tuna", "WZ Sushi Platter", "California Maki"));
        List<String> t316 = new ArrayList<>(List.of("Tendon", "Royal", "Royal", "California Maki", "Tuna", "Tuna"));
        List<String> t317 = new ArrayList<>(List.of("Salad Wrap", "Tendon", "Chocolate Cake"));
        List<String> t318 = new ArrayList<>(List.of("Salad Wrap", "Chocolate Cake", "Tendon", "Royal"));
        List<String> t319 = new ArrayList<>(List.of("Tuna", "Salad Wrap", "Salad Wrap"));
        List<String> t320 = new ArrayList<>(List.of("Tendon", "Tuna", "WZ Sushi Platter", "Tuna", "Royal"));
        List<String> t321 = new ArrayList<>(List.of("Tuna", "Tendon", "Tuna"));
        List<String> t322 = new ArrayList<>(List.of("Tuna", "Tuna", "California Maki", "California Maki", "Chocolate Cake", "WZ Sushi Platter", "Tuna"));
        List<String> t323 = new ArrayList<>(List.of("Royal", "Tuna", "Chocolate Cake", "WZ Sushi Platter", "California Maki"));
        List<String> t324 = new ArrayList<>(List.of("Tuna", "Salad Wrap"));
        List<String> t325 = new ArrayList<>(List.of("Tonkotsu Ramen", "Salad Wrap", "Royal", "Tuna", "California Maki"));
        List<String> t326 = new ArrayList<>(List.of("Tuna", "Tuna"));
        List<String> t327 = new ArrayList<>(List.of("Tendon", "Tonkotsu Ramen"));
        List<String> t328 = new ArrayList<>(List.of("Salad Wrap", "Tuna", "Tonkotsu Ramen"));
        List<String> t329 = new ArrayList<>(List.of("Tuna", "Tendon", "Tuna", "Tuna", "California Maki", "WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t330 = new ArrayList<>(List.of("California Maki", "Tuna", "Salad Wrap", "Tuna"));
        List<String> t331 = new ArrayList<>(List.of("Chocolate Cake", "Tonkotsu Ramen", "Tonkotsu Ramen", "Tonkotsu Ramen", "Royal", "WZ Sushi Platter", "Tuna"));
        List<String> t332 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tuna", "Royal", "Tuna"));
        List<String> t333 = new ArrayList<>(List.of("Tonkotsu Ramen", "California Maki"));
        List<String> t334 = new ArrayList<>(List.of("Tendon", "WZ Sushi Platter", "Chocolate Cake"));
        List<String> t335 = new ArrayList<>(List.of("Tendon", "Salad Wrap", "WZ Sushi Platter", "WZ Sushi Platter", "Salad Wrap"));
        List<String> t336 = new ArrayList<>(List.of("Royal"));
        List<String> t337 = new ArrayList<>(List.of("WZ Sushi Platter", "California Maki"));
        List<String> t338 = new ArrayList<>(List.of("Salad Wrap", "Tuna", "Tuna", "California Maki", "Tendon", "Salad Wrap", "California Maki"));
        List<String> t339 = new ArrayList<>(List.of("California Maki", "Tuna", "Tuna", "California Maki"));
        List<String> t340 = new ArrayList<>(List.of("California Maki", "Tuna", "WZ Sushi Platter", "Tuna"));
        List<String> t341 = new ArrayList<>(List.of("Tuna", "Tuna"));
        List<String> t342 = new ArrayList<>(List.of("Tendon", "Royal"));
        List<String> t343 = new ArrayList<>(List.of("Salad Wrap"));
        List<String> t344 = new ArrayList<>(List.of("Salad Wrap", "Salad Wrap", "Tuna", "Tuna"));
        List<String> t345 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter", "Tendon", "Chocolate Cake", "Chocolate Cake", "Salad Wrap", "California Maki"));
        List<String> t346 = new ArrayList<>(List.of("Tuna", "Royal"));
        List<String> t347 = new ArrayList<>(List.of("California Maki", "Tuna"));
        List<String> t348 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t349 = new ArrayList<>(List.of("California Maki", "WZ Sushi Platter"));
        List<String> t350 = new ArrayList<>(List.of("Royal", "WZ Sushi Platter", "WZ Sushi Platter", "Salad Wrap", "Tuna"));
        List<String> t351 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Tonkotsu Ramen", "Tendon", "Tuna", "Tonkotsu Ramen"));
        List<String> t352 = new ArrayList<>(List.of("California Maki", "Tendon", "Tendon", "WZ Sushi Platter", "Chocolate Cake"));
        List<String> t353 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter", "Royal", "Tuna", "Chocolate Cake", "Chocolate Cake", "Tendon"));
        List<String> t354 = new ArrayList<>(List.of("California Maki", "WZ Sushi Platter", "Tuna", "Tuna", "Chocolate Cake", "WZ Sushi Platter", "Tonkotsu Ramen"));
        List<String> t355 = new ArrayList<>(List.of("Tendon", "WZ Sushi Platter", "Tuna", "Tuna", "Chocolate Cake"));
        List<String> t356 = new ArrayList<>(List.of("California Maki", "Tonkotsu Ramen", "Tuna", "Chocolate Cake"));
        List<String> t357 = new ArrayList<>(List.of("Chocolate Cake", "Tuna", "WZ Sushi Platter", "Tendon", "Tendon", "Royal", "Tuna"));
        List<String> t358 = new ArrayList<>(List.of("Tuna", "Tendon", "Tuna"));
        List<String> t359 = new ArrayList<>(List.of("California Maki", "California Maki", "Tuna", "Chocolate Cake"));
        List<String> t360 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t361 = new ArrayList<>(List.of("California Maki"));
        List<String> t362 = new ArrayList<>(List.of("Tendon", "Tuna", "Salad Wrap", "Salad Wrap"));
        List<String> t363 = new ArrayList<>(List.of("Chocolate Cake", "WZ Sushi Platter", "Tonkotsu Ramen", "California Maki", "Royal", "WZ Sushi Platter", "California Maki"));
        List<String> t364 = new ArrayList<>(List.of("Salad Wrap", "Chocolate Cake", "Salad Wrap", "Tonkotsu Ramen", "Tonkotsu Ramen"));
        List<String> t365 = new ArrayList<>(List.of("California Maki", "Chocolate Cake", "Tonkotsu Ramen", "Tonkotsu Ramen", "California Maki", "Chocolate Cake"));
        List<String> t366 = new ArrayList<>(List.of("Tonkotsu Ramen", "Royal"));
        List<String> t367 = new ArrayList<>(List.of("WZ Sushi Platter", "Tuna", "Tonkotsu Ramen"));
        List<String> t368 = new ArrayList<>(List.of("Chocolate Cake", "Tuna", "California Maki", "California Maki", "Chocolate Cake", "WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t369 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter", "Tuna", "WZ Sushi Platter"));
        List<String> t370 = new ArrayList<>(List.of("Salad Wrap"));
        List<String> t371 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Salad Wrap", "Tendon", "Tuna", "Tendon"));
        List<String> t372 = new ArrayList<>(List.of("Tuna", "Salad Wrap", "Tuna", "California Maki", "WZ Sushi Platter", "Tendon", "Royal"));
        List<String> t373 = new ArrayList<>(List.of("Salad Wrap", "Royal"));
        List<String> t374 = new ArrayList<>(List.of("Salad Wrap", "California Maki", "Royal", "Salad Wrap", "California Maki"));
        List<String> t375 = new ArrayList<>(List.of("Tendon"));
        List<String> t376 = new ArrayList<>(List.of("Tuna", "Tuna", "Chocolate Cake", "Tuna", "Chocolate Cake"));
        List<String> t377 = new ArrayList<>(List.of("California Maki", "WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t378 = new ArrayList<>(List.of("Royal", "Royal"));
        List<String> t379 = new ArrayList<>(List.of("Salad Wrap", "WZ Sushi Platter", "Tuna", "Salad Wrap", "Chocolate Cake", "Salad Wrap"));
        List<String> t380 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t381 = new ArrayList<>(List.of("Tuna", "Salad Wrap", "Salad Wrap"));
        List<String> t382 = new ArrayList<>(List.of("WZ Sushi Platter", "California Maki", "Tuna"));
        List<String> t383 = new ArrayList<>(List.of("Tuna", "Royal", "Chocolate Cake", "Royal", "Chocolate Cake", "Tuna"));
        List<String> t384 = new ArrayList<>(List.of("Tuna", "Tonkotsu Ramen", "Salad Wrap", "California Maki", "Tuna", "Salad Wrap", "Tuna"));
        List<String> t385 = new ArrayList<>(List.of("Tonkotsu Ramen", "WZ Sushi Platter"));
        List<String> t386 = new ArrayList<>(List.of("Tuna", "Tuna", "Tendon", "WZ Sushi Platter", "Salad Wrap"));
        List<String> t387 = new ArrayList<>(List.of("Tuna", "Tuna"));
        List<String> t388 = new ArrayList<>(List.of("Tuna", "California Maki"));
        List<String> t389 = new ArrayList<>(List.of("Tuna", "Royal", "Salad Wrap", "California Maki", "Chocolate Cake", "California Maki"));
        List<String> t390 = new ArrayList<>(List.of("Salad Wrap", "Tuna"));
        List<String> t391 = new ArrayList<>(List.of("Salad Wrap", "Tuna", "WZ Sushi Platter", "Tuna", "Salad Wrap", "Chocolate Cake"));
        List<String> t392 = new ArrayList<>(List.of("WZ Sushi Platter", "California Maki"));
        List<String> t393 = new ArrayList<>(List.of("Tuna", "Tonkotsu Ramen", "California Maki", "Tuna", "Tuna", "Tonkotsu Ramen"));
        List<String> t394 = new ArrayList<>(List.of("Royal", "Tuna", "Tuna", "Chocolate Cake", "Tuna"));
        List<String> t395 = new ArrayList<>(List.of("Royal", "Tendon", "Salad Wrap", "Chocolate Cake", "Royal", "Tonkotsu Ramen"));
        List<String> t396 = new ArrayList<>(List.of("Salad Wrap", "Tonkotsu Ramen", "Tonkotsu Ramen", "WZ Sushi Platter", "Salad Wrap", "California Maki"));
        List<String> t397 = new ArrayList<>(List.of("WZ Sushi Platter", "Tendon", "Tuna", "Royal", "WZ Sushi Platter"));
        List<String> t398 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tendon", "California Maki", "California Maki", "Salad Wrap", "California Maki"));
        List<String> t399 = new ArrayList<>(List.of("California Maki", "Royal", "Royal", "California Maki"));
        List<String> t400 = new ArrayList<>(List.of("Salad Wrap"));
        List<String> t401 = new ArrayList<>(List.of("California Maki", "Tuna"));
        List<String> t402 = new ArrayList<>(List.of("Salad Wrap", "Tuna", "California Maki", "California Maki", "Tuna", "Tonkotsu Ramen"));
        List<String> t403 = new ArrayList<>(List.of("Chocolate Cake", "Salad Wrap"));
        List<String> t404 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Chocolate Cake", "WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t405 = new ArrayList<>(List.of("Chocolate Cake", "Tuna", "Royal", "California Maki"));
        List<String> t406 = new ArrayList<>(List.of("Salad Wrap", "Tendon", "Tuna", "WZ Sushi Platter", "Salad Wrap", "Salad Wrap"));
        List<String> t407 = new ArrayList<>(List.of("California Maki", "Tendon", "Chocolate Cake", "Royal", "Royal", "Salad Wrap", "Chocolate Cake"));
        List<String> t408 = new ArrayList<>(List.of("Tuna"));
        List<String> t409 = new ArrayList<>(List.of("Tuna", "Tonkotsu Ramen", "Tendon", "Tuna", "WZ Sushi Platter", "Tonkotsu Ramen", "Salad Wrap"));
        List<String> t410 = new ArrayList<>(List.of("Tonkotsu Ramen"));
        List<String> t411 = new ArrayList<>(List.of("Chocolate Cake", "Royal", "Tonkotsu Ramen", "Tuna", "Tuna"));
        List<String> t412 = new ArrayList<>(List.of("Tonkotsu Ramen"));
        List<String> t413 = new ArrayList<>(List.of("Tuna", "Salad Wrap"));
        List<String> t414 = new ArrayList<>(List.of("WZ Sushi Platter", "Chocolate Cake", "California Maki", "California Maki", "WZ Sushi Platter", "Tuna"));
        List<String> t415 = new ArrayList<>(List.of("Salad Wrap", "California Maki", "California Maki"));
        List<String> t416 = new ArrayList<>(List.of("Tendon", "Tuna", "Chocolate Cake"));
        List<String> t417 = new ArrayList<>(List.of("California Maki", "Royal", "California Maki", "Chocolate Cake", "Tuna", "California Maki", "WZ Sushi Platter"));
        List<String> t418 = new ArrayList<>(List.of("California Maki", "Royal", "WZ Sushi Platter", "Chocolate Cake", "Royal"));
        List<String> t419 = new ArrayList<>(List.of("WZ Sushi Platter", "Tendon", "Tuna"));
        List<String> t420 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter"));
        List<String> t421 = new ArrayList<>(List.of("WZ Sushi Platter", "Tonkotsu Ramen", "Tuna", "Tuna", "Royal"));
        List<String> t422 = new ArrayList<>(List.of("California Maki"));
        List<String> t423 = new ArrayList<>(List.of("Royal", "Tuna", "Salad Wrap", "WZ Sushi Platter"));
        List<String> t424 = new ArrayList<>(List.of("WZ Sushi Platter", "Salad Wrap", "Royal"));
        List<String> t425 = new ArrayList<>(List.of("Tonkotsu Ramen", "WZ Sushi Platter", "Tuna", "Salad Wrap", "Tendon", "Chocolate Cake"));
        List<String> t426 = new ArrayList<>(List.of("Royal", "Tendon"));
        List<String> t427 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tuna"));
        List<String> t428 = new ArrayList<>(List.of("Chocolate Cake", "Tonkotsu Ramen"));
        List<String> t429 = new ArrayList<>(List.of("Royal", "Royal", "Royal", "Tuna", "Royal"));
        List<String> t430 = new ArrayList<>(List.of("Salad Wrap", "Tuna"));
        List<String> t431 = new ArrayList<>(List.of("Royal", "Royal", "Salad Wrap", "Tuna", "Tendon"));
        List<String> t432 = new ArrayList<>(List.of("Tuna"));
        List<String> t433 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tuna", "WZ Sushi Platter"));
        List<String> t434 = new ArrayList<>(List.of("Tuna", "Royal", "Chocolate Cake", "Tuna", "Salad Wrap"));
        List<String> t435 = new ArrayList<>(List.of("Tuna", "Royal", "Chocolate Cake", "Salad Wrap", "Tendon", "Salad Wrap"));
        List<String> t436 = new ArrayList<>(List.of("Chocolate Cake", "Salad Wrap", "Tonkotsu Ramen", "Tendon", "Salad Wrap", "Royal", "Tendon"));
        List<String> t437 = new ArrayList<>(List.of("Salad Wrap", "Tendon", "Royal", "Salad Wrap", "California Maki"));
        List<String> t438 = new ArrayList<>(List.of("California Maki", "California Maki", "WZ Sushi Platter"));
        List<String> t439 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tuna", "WZ Sushi Platter", "California Maki"));
        List<String> t440 = new ArrayList<>(List.of("Chocolate Cake", "Royal", "Chocolate Cake", "California Maki", "Tuna", "California Maki", "California Maki"));
        List<String> t441 = new ArrayList<>(List.of("Tuna", "Salad Wrap"));
        List<String> t442 = new ArrayList<>(List.of("Tuna", "Royal"));
        List<String> t443 = new ArrayList<>(List.of("Salad Wrap", "WZ Sushi Platter"));
        List<String> t444 = new ArrayList<>(List.of("Tuna", "Tendon", "WZ Sushi Platter", "Tuna", "Tuna"));
        List<String> t445 = new ArrayList<>(List.of("Tonkotsu Ramen", "Tonkotsu Ramen", "Tuna", "California Maki"));
        List<String> t446 = new ArrayList<>(List.of("Salad Wrap"));
        List<String> t447 = new ArrayList<>(List.of("Tuna", "Tuna", "Tuna", "Tuna"));
        List<String> t448 = new ArrayList<>(List.of("Tuna", "Tuna", "Royal", "Tendon"));
        List<String> t449 = new ArrayList<>(List.of("Royal", "Chocolate Cake", "Tendon", "Tendon"));
        List<String> t450 = new ArrayList<>(List.of("WZ Sushi Platter", "Chocolate Cake", "Royal", "Tonkotsu Ramen"));
        List<String> t451 = new ArrayList<>(List.of("Royal", "Tendon", "Tuna"));
        List<String> t452 = new ArrayList<>(List.of("Tendon", "Tuna", "Tonkotsu Ramen", "Chocolate Cake", "WZ Sushi Platter", "Chocolate Cake"));
        List<String> t453 = new ArrayList<>(List.of("California Maki", "Tonkotsu Ramen", "Royal", "Tuna", "California Maki"));
        List<String> t454 = new ArrayList<>(List.of("Royal"));
        List<String> t455 = new ArrayList<>(List.of("Tuna", "Salad Wrap"));
        List<String> t456 = new ArrayList<>(List.of("Tendon", "California Maki", "Tendon", "WZ Sushi Platter", "Tendon"));
        List<String> t457 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t458 = new ArrayList<>(List.of("Tonkotsu Ramen", "WZ Sushi Platter", "Chocolate Cake"));
        List<String> t459 = new ArrayList<>(List.of("Tuna", "Tuna"));
        List<String> t460 = new ArrayList<>(List.of("Royal", "Tuna", "Chocolate Cake", "California Maki", "Tonkotsu Ramen", "Chocolate Cake"));
        List<String> t461 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t462 = new ArrayList<>(List.of("Salad Wrap", "WZ Sushi Platter", "Tuna"));
        List<String> t463 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Tonkotsu Ramen", "Tendon", "Tuna"));
        List<String> t464 = new ArrayList<>(List.of("WZ Sushi Platter", "Tonkotsu Ramen"));
        List<String> t465 = new ArrayList<>(List.of("Tendon", "Tuna", "Royal", "Royal", "California Maki"));
        List<String> t466 = new ArrayList<>(List.of("Salad Wrap", "Salad Wrap", "Tonkotsu Ramen", "Tuna", "California Maki", "Tuna"));
        List<String> t467 = new ArrayList<>(List.of("Tuna", "Chocolate Cake", "Royal", "WZ Sushi Platter", "Tuna", "Royal", "Chocolate Cake"));
        List<String> t468 = new ArrayList<>(List.of("Tuna", "Royal", "WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t469 = new ArrayList<>(List.of("Tuna", "Chocolate Cake", "Tendon", "Tonkotsu Ramen", "Tendon"));
        List<String> t470 = new ArrayList<>(List.of("Tendon", "California Maki", "Tendon", "Royal", "Tendon", "Tuna", "Tuna"));
        List<String> t471 = new ArrayList<>(List.of("WZ Sushi Platter", "California Maki", "California Maki", "Tendon"));
        List<String> t472 = new ArrayList<>(List.of("Royal", "Tendon", "Tonkotsu Ramen", "Chocolate Cake"));
        List<String> t473 = new ArrayList<>(List.of("Tonkotsu Ramen", "Salad Wrap"));
        List<String> t474 = new ArrayList<>(List.of("Tuna", "Tendon", "WZ Sushi Platter", "Royal"));
        List<String> t475 = new ArrayList<>(List.of("Chocolate Cake", "California Maki", "Tuna", "Salad Wrap", "Chocolate Cake", "Tuna"));
        List<String> t476 = new ArrayList<>(List.of("Royal", "Tonkotsu Ramen", "Tuna", "WZ Sushi Platter", "Salad Wrap"));
        List<String> t477 = new ArrayList<>(List.of("WZ Sushi Platter", "Chocolate Cake", "Royal", "Tendon", "Royal", "Tuna", "Tonkotsu Ramen"));
        List<String> t478 = new ArrayList<>(List.of("Tendon", "Tuna"));
        List<String> t479 = new ArrayList<>(List.of("Tendon", "Tonkotsu Ramen", "Chocolate Cake", "Tuna", "Salad Wrap"));
        List<String> t480 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter"));
        List<String> t481 = new ArrayList<>(List.of("Royal", "Royal", "Tonkotsu Ramen", "Tuna", "Tuna"));
        List<String> t482 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t483 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t484 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Tonkotsu Ramen"));
        List<String> t485 = new ArrayList<>(List.of("Tonkotsu Ramen", "Royal", "Tuna", "Tuna", "Tonkotsu Ramen"));
        List<String> t486 = new ArrayList<>(List.of("Tuna"));
        List<String> t487 = new ArrayList<>(List.of("Tuna", "WZ Sushi Platter", "Chocolate Cake", "Salad Wrap", "Tuna", "Tonkotsu Ramen", "Tuna"));
        List<String> t488 = new ArrayList<>(List.of("Salad Wrap", "California Maki", "Salad Wrap"));
        List<String> t489 = new ArrayList<>(List.of("Chocolate Cake", "Salad Wrap", "Tuna", "Tuna", "Chocolate Cake", "WZ Sushi Platter", "Tuna"));
        List<String> t490 = new ArrayList<>(List.of("Salad Wrap", "Chocolate Cake", "WZ Sushi Platter", "Royal", "Tendon", "Tonkotsu Ramen", "Tendon"));
        List<String> t491 = new ArrayList<>(List.of("Royal", "Royal", "Tuna", "Tendon", "California Maki"));
        List<String> t492 = new ArrayList<>(List.of("WZ Sushi Platter", "Tendon", "Royal", "Tuna", "California Maki", "Tonkotsu Ramen"));
        List<String> t493 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Tuna", "Tuna"));
        List<String> t494 = new ArrayList<>(List.of("Salad Wrap", "Salad Wrap"));
        List<String> t495 = new ArrayList<>(List.of("Tuna", "Tuna", "Chocolate Cake", "WZ Sushi Platter", "Tuna"));
        List<String> t496 = new ArrayList<>(List.of("Tuna"));
        List<String> t497 = new ArrayList<>(List.of("California Maki", "Tonkotsu Ramen", "California Maki", "Salad Wrap"));
        List<String> t498 = new ArrayList<>(List.of("Royal", "California Maki"));
        List<String> t499 = new ArrayList<>(List.of("Tuna", "Tuna"));
        List<String> t500 = new ArrayList<>(List.of("California Maki", "Tuna"));

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
