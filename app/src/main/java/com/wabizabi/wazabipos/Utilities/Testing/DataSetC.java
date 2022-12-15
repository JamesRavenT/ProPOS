package com.wabizabi.wazabipos.Utilities.Testing;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class DataSetC implements DataSet {
    public static void insertInto(List<List<String>> transactionsTB){

        List<String> t1 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Sprite", "Chocolate Cake", "Tuna Sashimi", "Katsudon"));
        List<String> t2 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chef's Special Sushi Platter", "Tuna Sashimi", "Kani Salad", "Sprite", "Sprite"));
        List<String> t3 = new ArrayList<>(List.of("Kani Salad", "Sprite", "Tuna Salmon Dynamite Roll", "Katsudon", "Tuna Sashimi", "Tuna Sashimi"));
        List<String> t4 = new ArrayList<>(List.of("Sprite", "Tuna Salmon Dynamite Roll", "Tuna Sashimi", "Tuna Sashimi"));
        List<String> t5 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Tuna Sashimi"));
        List<String> t6 = new ArrayList<>(List.of("California Deluxe", "Tuna Sashimi", "Tuna Sashimi", "Chocolate Cake", "Tuna Sashimi", "Tuna Sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t7 = new ArrayList<>(List.of("Tuna Sashimi", "Kani Salad", "Tuna Sashimi", "Tuna Sashimi", "Kani Salad", "California Deluxe"));
        List<String> t8 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi"));
        List<String> t9 = new ArrayList<>(List.of("Katsudon", "Chef's Special Sushi Platter"));
        List<String> t10 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Salmon Dynamite Roll", "California Deluxe"));
        List<String> t11 = new ArrayList<>(List.of("Sprite"));
        List<String> t12 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Chef's Special Sushi Platter", "Tuna Salmon Dynamite Roll", "Katsudon", "Tuna Sashimi"));
        List<String> t13 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi"));
        List<String> t14 = new ArrayList<>(List.of("Katsudon", "Chocolate Cake", "Katsudon", "Kani Salad", "Tuna Sashimi", "Sprite"));
        List<String> t15 = new ArrayList<>(List.of("Kani Salad", "Sprite", "California Deluxe"));
        List<String> t16 = new ArrayList<>(List.of("Sprite", "Katsudon", "Sprite", "Kani Salad", "Kani Salad"));
        List<String> t17 = new ArrayList<>(List.of("Kani Salad"));
        List<String> t18 = new ArrayList<>(List.of("Katsudon", "Chocolate Cake"));
        List<String> t19 = new ArrayList<>(List.of("California Deluxe", "Sprite", "Kani Salad", "Kani Salad", "California Deluxe", "Chocolate Cake", "California Deluxe"));
        List<String> t20 = new ArrayList<>(List.of("Sprite"));
        List<String> t21 = new ArrayList<>(List.of("Katsudon", "Chef's Special Sushi Platter", "California Deluxe", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll", "Kani Salad", "Tuna Sashimi"));
        List<String> t22 = new ArrayList<>(List.of("Kani Salad", "Kani Salad"));
        List<String> t23 = new ArrayList<>(List.of("Kani Salad", "Katsudon", "Katsudon", "Katsudon", "Katsudon", "Chef's Special Sushi Platter"));
        List<String> t24 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Tuna Salmon Dynamite Roll"));
        List<String> t25 = new ArrayList<>(List.of("California Deluxe", "Tuna Sashimi", "Tuna Sashimi", "Tuna Salmon Dynamite Roll", "California Deluxe", "Tuna Sashimi"));
        List<String> t26 = new ArrayList<>(List.of("Kani Salad", "Tuna Sashimi", "Katsudon", "Tuna Sashimi", "Chef's Special Sushi Platter", "Tuna Sashimi"));
        List<String> t27 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Sashimi", "Chef's Special Sushi Platter", "California Deluxe", "California Deluxe"));
        List<String> t28 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Tuna Salmon Dynamite Roll"));
        List<String> t29 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Sprite", "California Deluxe"));
        List<String> t30 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Chocolate Cake", "Kani Salad", "Chef's Special Sushi Platter", "Kani Salad", "Tuna Sashimi", "California Deluxe"));
        List<String> t31 = new ArrayList<>(List.of("California Deluxe", "California Deluxe", "Kani Salad", "Tuna Sashimi", "Chocolate Cake", "Tuna Sashimi", "Katsudon"));
        List<String> t32 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Chocolate Cake"));
        List<String> t33 = new ArrayList<>(List.of("Katsudon", "Sprite", "Chef's Special Sushi Platter", "Chocolate Cake"));
        List<String> t34 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Kani Salad", "Tuna Sashimi", "Tuna Sashimi", "Chocolate Cake"));
        List<String> t35 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Tuna Sashimi", "California Deluxe", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll"));
        List<String> t36 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chocolate Cake", "Sprite", "Tuna Sashimi"));
        List<String> t37 = new ArrayList<>(List.of("Tuna Sashimi"));
        List<String> t38 = new ArrayList<>(List.of("Kani Salad", "Chocolate Cake", "Tuna Sashimi", "Chef's Special Sushi Platter", "Chef's Special Sushi Platter"));
        List<String> t39 = new ArrayList<>(List.of("Sprite", "California Deluxe", "Chef's Special Sushi Platter", "Kani Salad", "Tuna Salmon Dynamite Roll"));
        List<String> t40 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chef's Special Sushi Platter", "Tuna Salmon Dynamite Roll", "Chocolate Cake", "Kani Salad", "Chocolate Cake", "Tuna Sashimi"));
        List<String> t41 = new ArrayList<>(List.of("Katsudon", "Tuna Salmon Dynamite Roll", "Tuna Sashimi", "Tuna Sashimi", "Sprite", "Tuna Sashimi"));
        List<String> t42 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi"));
        List<String> t43 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Salmon Dynamite Roll", "Tuna Sashimi", "Chef's Special Sushi Platter", "Katsudon", "Kani Salad"));
        List<String> t44 = new ArrayList<>(List.of("Tuna Sashimi", "Kani Salad"));
        List<String> t45 = new ArrayList<>(List.of("Sprite"));
        List<String> t46 = new ArrayList<>(List.of("Katsudon"));
        List<String> t47 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Chocolate Cake", "Tuna Sashimi", "Chef's Special Sushi Platter"));
        List<String> t48 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Katsudon", "Chocolate Cake", "Kani Salad", "Sprite", "Tuna Salmon Dynamite Roll", "Tuna Sashimi"));
        List<String> t49 = new ArrayList<>(List.of("California Deluxe", "Kani Salad", "Tuna Sashimi"));
        List<String> t50 = new ArrayList<>(List.of("Tuna Sashimi", "Katsudon", "Sprite", "California Deluxe", "Chef's Special Sushi Platter", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll"));
        List<String> t51 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll", "Katsudon", "Chocolate Cake", "Kani Salad", "Chef's Special Sushi Platter"));
        List<String> t52 = new ArrayList<>(List.of("Chef's Special Sushi Platter"));
        List<String> t53 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake"));
        List<String> t54 = new ArrayList<>(List.of("Tuna Sashimi", "California Deluxe", "Katsudon", "Katsudon", "Chef's Special Sushi Platter", "Chocolate Cake", "Tuna Salmon Dynamite Roll"));
        List<String> t55 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t56 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Kani Salad"));
        List<String> t57 = new ArrayList<>(List.of("Katsudon", "Sprite", "California Deluxe", "Sprite", "Tuna Sashimi", "Chocolate Cake"));
        List<String> t58 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Chef's Special Sushi Platter", "Kani Salad", "Tuna Sashimi", "Chocolate Cake", "Kani Salad", "Sprite"));
        List<String> t59 = new ArrayList<>(List.of("Tuna Sashimi", "Chef's Special Sushi Platter", "Tuna Sashimi"));
        List<String> t60 = new ArrayList<>(List.of("Katsudon", "Chocolate Cake", "Tuna Sashimi", "Chef's Special Sushi Platter"));
        List<String> t61 = new ArrayList<>(List.of("California Deluxe", "Tuna Sashimi", "Tuna Sashimi", "Tuna Salmon Dynamite Roll", "Tuna Sashimi", "California Deluxe"));
        List<String> t62 = new ArrayList<>(List.of("Katsudon", "California Deluxe", "Tuna Salmon Dynamite Roll", "Katsudon", "California Deluxe", "Tuna Sashimi"));
        List<String> t63 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Kani Salad"));
        List<String> t64 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Sashimi"));
        List<String> t65 = new ArrayList<>(List.of("Sprite"));
        List<String> t66 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t67 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "California Deluxe", "California Deluxe", "Katsudon", "Kani Salad", "Sprite"));
        List<String> t68 = new ArrayList<>(List.of("Sprite", "Tuna Salmon Dynamite Roll", "Chocolate Cake"));
        List<String> t69 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Chocolate Cake"));
        List<String> t70 = new ArrayList<>(List.of("Katsudon", "Chocolate Cake", "California Deluxe"));
        List<String> t71 = new ArrayList<>(List.of("Katsudon", "Katsudon"));
        List<String> t72 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll"));
        List<String> t73 = new ArrayList<>(List.of("Tuna Sashimi", "Katsudon", "Tuna Salmon Dynamite Roll", "Tuna Sashimi"));
        List<String> t74 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Chef's Special Sushi Platter", "Sprite", "Katsudon"));
        List<String> t75 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Tuna Sashimi"));
        List<String> t76 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll"));
        List<String> t77 = new ArrayList<>(List.of("Kani Salad", "Kani Salad", "Tuna Sashimi", "Katsudon", "Katsudon", "Chef's Special Sushi Platter"));
        List<String> t78 = new ArrayList<>(List.of("Kani Salad", "California Deluxe"));
        List<String> t79 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Tuna Sashimi"));
        List<String> t80 = new ArrayList<>(List.of("Tuna Sashimi", "Katsudon", "Tuna Sashimi", "Chef's Special Sushi Platter", "Kani Salad", "California Deluxe", "California Deluxe"));
        List<String> t81 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Kani Salad", "Tuna Sashimi", "Katsudon", "Chef's Special Sushi Platter"));
        List<String> t82 = new ArrayList<>(List.of("Tuna Sashimi", "Katsudon", "Chocolate Cake", "Tuna Sashimi", "Tuna Sashimi"));
        List<String> t83 = new ArrayList<>(List.of("Sprite", "Tuna Sashimi", "Sprite", "Tuna Salmon Dynamite Roll", "Sprite"));
        List<String> t84 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "California Deluxe", "Chef's Special Sushi Platter", "Tuna Sashimi", "Tuna Sashimi", "Chocolate Cake", "Chocolate Cake"));
        List<String> t85 = new ArrayList<>(List.of("Katsudon", "Katsudon"));
        List<String> t86 = new ArrayList<>(List.of("California Deluxe", "Kani Salad"));
        List<String> t87 = new ArrayList<>(List.of("Katsudon"));
        List<String> t88 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Tuna Sashimi", "Chocolate Cake", "Sprite", "Chef's Special Sushi Platter", "California Deluxe", "Kani Salad"));
        List<String> t89 = new ArrayList<>(List.of("Katsudon", "Sprite", "Tuna Salmon Dynamite Roll", "Kani Salad"));
        List<String> t90 = new ArrayList<>(List.of("Sprite", "Tuna Sashimi", "Tuna Salmon Dynamite Roll", "Katsudon"));
        List<String> t91 = new ArrayList<>(List.of("Kani Salad", "Chocolate Cake", "Kani Salad"));
        List<String> t92 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chef's Special Sushi Platter"));
        List<String> t93 = new ArrayList<>(List.of("California Deluxe", "Sprite", "California Deluxe"));
        List<String> t94 = new ArrayList<>(List.of("Katsudon", "Chef's Special Sushi Platter", "Kani Salad", "California Deluxe", "Tuna Sashimi", "California Deluxe", "Kani Salad"));
        List<String> t95 = new ArrayList<>(List.of("Katsudon", "Tuna Sashimi"));
        List<String> t96 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi"));
        List<String> t97 = new ArrayList<>(List.of("Katsudon"));
        List<String> t98 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Salmon Dynamite Roll", "Tuna Sashimi"));
        List<String> t99 = new ArrayList<>(List.of("California Deluxe", "California Deluxe", "Sprite", "Tuna Salmon Dynamite Roll"));
        List<String> t100 = new ArrayList<>(List.of("Tuna Sashimi", "California Deluxe"));
        List<String> t101 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Sashimi", "California Deluxe", "Chocolate Cake", "Sprite"));
        List<String> t102 = new ArrayList<>(List.of("Katsudon", "Tuna Salmon Dynamite Roll", "Kani Salad"));
        List<String> t103 = new ArrayList<>(List.of("California Deluxe", "Katsudon"));
        List<String> t104 = new ArrayList<>(List.of("Tuna Sashimi", "Chocolate Cake", "Kani Salad", "Sprite", "Tuna Sashimi", "Kani Salad"));
        List<String> t105 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Sashimi"));
        List<String> t106 = new ArrayList<>(List.of("Katsudon", "Kani Salad", "Tuna Sashimi"));
        List<String> t107 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t108 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll", "Sprite", "California Deluxe"));
        List<String> t109 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Sprite", "Katsudon", "Chef's Special Sushi Platter", "Katsudon", "California Deluxe", "Kani Salad"));
        List<String> t110 = new ArrayList<>(List.of("Tuna Sashimi", "Chef's Special Sushi Platter"));
        List<String> t111 = new ArrayList<>(List.of("California Deluxe", "Tuna Salmon Dynamite Roll", "Kani Salad", "Kani Salad", "Tuna Sashimi", "Tuna Sashimi"));
        List<String> t112 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Tuna Sashimi"));
        List<String> t113 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Tuna Sashimi"));
        List<String> t114 = new ArrayList<>(List.of("Tuna Sashimi", "Katsudon", "Tuna Sashimi", "Tuna Salmon Dynamite Roll", "Chef's Special Sushi Platter"));
        List<String> t115 = new ArrayList<>(List.of("California Deluxe"));
        List<String> t116 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Kani Salad", "Katsudon"));
        List<String> t117 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "California Deluxe", "Sprite", "Tuna Sashimi", "Sprite"));
        List<String> t118 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Sashimi", "Tuna Sashimi", "Katsudon", "Chocolate Cake", "Sprite"));
        List<String> t119 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chef's Special Sushi Platter", "California Deluxe", "Tuna Sashimi", "Kani Salad", "Tuna Sashimi"));
        List<String> t120 = new ArrayList<>(List.of("Tuna Sashimi", "Katsudon"));
        List<String> t121 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Salmon Dynamite Roll", "Katsudon", "Kani Salad", "California Deluxe", "Katsudon"));
        List<String> t122 = new ArrayList<>(List.of("Tuna Sashimi", "Chef's Special Sushi Platter", "Tuna Sashimi", "California Deluxe"));
        List<String> t123 = new ArrayList<>(List.of("Kani Salad", "Tuna Sashimi", "Tuna Salmon Dynamite Roll", "California Deluxe", "Sprite", "Sprite"));
        List<String> t124 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Sashimi", "Sprite"));
        List<String> t125 = new ArrayList<>(List.of("Chocolate Cake", "Sprite"));
        List<String> t126 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t127 = new ArrayList<>(List.of("Katsudon", "Chocolate Cake", "Katsudon"));
        List<String> t128 = new ArrayList<>(List.of("Kani Salad", "Chef's Special Sushi Platter", "California Deluxe", "Tuna Salmon Dynamite Roll", "Katsudon", "Sprite", "Tuna Sashimi"));
        List<String> t129 = new ArrayList<>(List.of("California Deluxe", "California Deluxe"));
        List<String> t130 = new ArrayList<>(List.of("Kani Salad", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll", "Chocolate Cake", "Chef's Special Sushi Platter", "Chocolate Cake", "Tuna Salmon Dynamite Roll"));
        List<String> t131 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chef's Special Sushi Platter", "Chef's Special Sushi Platter"));
        List<String> t132 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Chocolate Cake", "Chocolate Cake", "California Deluxe", "Tuna Salmon Dynamite Roll"));
        List<String> t133 = new ArrayList<>(List.of("Chocolate Cake", "Katsudon", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll"));
        List<String> t134 = new ArrayList<>(List.of("Kani Salad", "Sprite", "Chocolate Cake"));
        List<String> t135 = new ArrayList<>(List.of("Chocolate Cake", "Katsudon", "Sprite"));
        List<String> t136 = new ArrayList<>(List.of("California Deluxe"));
        List<String> t137 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Chocolate Cake", "Sprite", "Kani Salad", "Chef's Special Sushi Platter"));
        List<String> t138 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Chef's Special Sushi Platter", "Katsudon", "Katsudon", "Sprite"));
        List<String> t139 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Chocolate Cake", "Chef's Special Sushi Platter", "California Deluxe", "Sprite", "Sprite"));
        List<String> t140 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Katsudon"));
        List<String> t141 = new ArrayList<>(List.of("Sprite", "Tuna Salmon Dynamite Roll", "Tuna Sashimi", "Tuna Sashimi"));
        List<String> t142 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Tuna Sashimi", "Tuna Sashimi"));
        List<String> t143 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll"));
        List<String> t144 = new ArrayList<>(List.of("California Deluxe"));
        List<String> t145 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake"));
        List<String> t146 = new ArrayList<>(List.of("California Deluxe", "Chocolate Cake", "Tuna Salmon Dynamite Roll", "Tuna Sashimi"));
        List<String> t147 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Katsudon"));
        List<String> t148 = new ArrayList<>(List.of("California Deluxe"));
        List<String> t149 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Kani Salad", "Sprite", "Tuna Sashimi", "Chocolate Cake", "Tuna Sashimi"));
        List<String> t150 = new ArrayList<>(List.of("Chocolate Cake", "Sprite", "Katsudon"));
        List<String> t151 = new ArrayList<>(List.of("California Deluxe", "Chef's Special Sushi Platter"));
        List<String> t152 = new ArrayList<>(List.of("Katsudon", "Tuna Sashimi"));
        List<String> t153 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chocolate Cake", "Sprite", "Chef's Special Sushi Platter", "California Deluxe", "California Deluxe", "Sprite"));
        List<String> t154 = new ArrayList<>(List.of("Kani Salad", "Tuna Sashimi", "Katsudon", "California Deluxe", "Chocolate Cake"));
        List<String> t155 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Sprite"));
        List<String> t156 = new ArrayList<>(List.of("Chocolate Cake", "California Deluxe"));
        List<String> t157 = new ArrayList<>(List.of("Tuna Sashimi", "Katsudon"));
        List<String> t158 = new ArrayList<>(List.of("Tuna Sashimi"));
        List<String> t159 = new ArrayList<>(List.of("California Deluxe", "Tuna Sashimi", "Tuna Sashimi", "Chocolate Cake"));
        List<String> t160 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chef's Special Sushi Platter", "Tuna Sashimi", "Chocolate Cake", "Chef's Special Sushi Platter", "Tuna Sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t161 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Chocolate Cake", "Chef's Special Sushi Platter", "Sprite"));
        List<String> t162 = new ArrayList<>(List.of("Katsudon", "Tuna Sashimi"));
        List<String> t163 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t164 = new ArrayList<>(List.of("Kani Salad", "Tuna Salmon Dynamite Roll"));
        List<String> t165 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Sashimi"));
        List<String> t166 = new ArrayList<>(List.of("Kani Salad", "California Deluxe", "Katsudon", "Katsudon", "Chef's Special Sushi Platter", "Katsudon"));
        List<String> t167 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chocolate Cake"));
        List<String> t168 = new ArrayList<>(List.of("Sprite", "California Deluxe", "California Deluxe", "Tuna Sashimi", "Tuna Sashimi", "Katsudon", "Sprite"));
        List<String> t169 = new ArrayList<>(List.of("Kani Salad", "Chef's Special Sushi Platter", "Tuna Sashimi", "Sprite"));
        List<String> t170 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Sashimi"));
        List<String> t171 = new ArrayList<>(List.of("Tuna Sashimi"));
        List<String> t172 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Katsudon", "Tuna Sashimi", "Kani Salad"));
        List<String> t173 = new ArrayList<>(List.of("Kani Salad", "Tuna Sashimi", "Chef's Special Sushi Platter", "Kani Salad", "Tuna Sashimi", "Chocolate Cake"));
        List<String> t174 = new ArrayList<>(List.of("Sprite", "Katsudon", "California Deluxe"));
        List<String> t175 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Kani Salad", "Tuna Salmon Dynamite Roll", "Kani Salad"));
        List<String> t176 = new ArrayList<>(List.of("Kani Salad", "Tuna Sashimi", "Chocolate Cake", "Katsudon", "Kani Salad"));
        List<String> t177 = new ArrayList<>(List.of("Tuna Sashimi", "Katsudon", "Kani Salad"));
        List<String> t178 = new ArrayList<>(List.of("Katsudon", "Tuna Sashimi", "Sprite", "Katsudon", "Kani Salad", "Tuna Sashimi"));
        List<String> t179 = new ArrayList<>(List.of("Sprite", "Tuna Sashimi"));
        List<String> t180 = new ArrayList<>(List.of("Kani Salad", "Sprite", "Tuna Sashimi"));
        List<String> t181 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Sprite", "Kani Salad"));
        List<String> t182 = new ArrayList<>(List.of("California Deluxe", "Tuna Salmon Dynamite Roll", "Tuna Sashimi", "California Deluxe", "Kani Salad", "Tuna Salmon Dynamite Roll", "Chocolate Cake"));
        List<String> t183 = new ArrayList<>(List.of("Kani Salad", "Tuna Sashimi", "Kani Salad"));
        List<String> t184 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chef's Special Sushi Platter"));
        List<String> t185 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Chef's Special Sushi Platter", "California Deluxe", "Tuna Salmon Dynamite Roll"));
        List<String> t186 = new ArrayList<>(List.of("Katsudon", "Chocolate Cake", "Katsudon", "Sprite", "Katsudon", "Kani Salad", "Sprite"));
        List<String> t187 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi"));
        List<String> t188 = new ArrayList<>(List.of("Tuna Sashimi"));
        List<String> t189 = new ArrayList<>(List.of("Tuna Sashimi"));
        List<String> t190 = new ArrayList<>(List.of("Katsudon", "California Deluxe", "California Deluxe", "Katsudon", "Chef's Special Sushi Platter"));
        List<String> t191 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Sashimi", "Kani Salad", "Tuna Sashimi", "Tuna Sashimi", "California Deluxe"));
        List<String> t192 = new ArrayList<>(List.of("Sprite"));
        List<String> t193 = new ArrayList<>(List.of("Kani Salad", "Chocolate Cake", "Kani Salad", "Sprite", "Kani Salad"));
        List<String> t194 = new ArrayList<>(List.of("Sprite", "Tuna Sashimi", "Tuna Sashimi", "Tuna Sashimi"));
        List<String> t195 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi"));
        List<String> t196 = new ArrayList<>(List.of("Tuna Sashimi", "Kani Salad", "Katsudon", "Chocolate Cake", "Chocolate Cake", "Tuna Sashimi"));
        List<String> t197 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Chocolate Cake", "California Deluxe"));
        List<String> t198 = new ArrayList<>(List.of("Tuna Sashimi", "California Deluxe", "California Deluxe"));
        List<String> t199 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Sashimi"));
        List<String> t200 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Kani Salad", "Chef's Special Sushi Platter", "Chef's Special Sushi Platter"));
        List<String> t201 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Kani Salad", "California Deluxe", "Kani Salad", "Sprite", "Tuna Salmon Dynamite Roll", "Chocolate Cake"));
        List<String> t202 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Salmon Dynamite Roll", "Kani Salad"));
        List<String> t203 = new ArrayList<>(List.of("California Deluxe", "California Deluxe", "Sprite"));
        List<String> t204 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Salmon Dynamite Roll", "Tuna Sashimi", "Katsudon", "Katsudon", "Chef's Special Sushi Platter"));
        List<String> t205 = new ArrayList<>(List.of("Chef's Special Sushi Platter"));
        List<String> t206 = new ArrayList<>(List.of("Kani Salad", "California Deluxe", "California Deluxe"));
        List<String> t207 = new ArrayList<>(List.of("Kani Salad", "Tuna Salmon Dynamite Roll", "California Deluxe", "Tuna Salmon Dynamite Roll", "California Deluxe"));
        List<String> t208 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Sprite", "Chocolate Cake", "Chocolate Cake"));
        List<String> t209 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Tuna Sashimi"));
        List<String> t210 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t211 = new ArrayList<>(List.of("Chocolate Cake", "California Deluxe", "Sprite", "California Deluxe", "Kani Salad", "Kani Salad"));
        List<String> t212 = new ArrayList<>(List.of("California Deluxe", "Katsudon", "Tuna Salmon Dynamite Roll", "Chef's Special Sushi Platter"));
        List<String> t213 = new ArrayList<>(List.of("Sprite"));
        List<String> t214 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Kani Salad"));
        List<String> t215 = new ArrayList<>(List.of("Tuna Sashimi", "Katsudon", "Tuna Sashimi", "Kani Salad", "Tuna Sashimi", "California Deluxe", "Tuna Sashimi"));
        List<String> t216 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Sprite", "California Deluxe", "Chef's Special Sushi Platter", "Tuna Sashimi", "Chef's Special Sushi Platter"));
        List<String> t217 = new ArrayList<>(List.of("Katsudon", "Chef's Special Sushi Platter"));
        List<String> t218 = new ArrayList<>(List.of("Katsudon", "Katsudon", "Tuna Sashimi", "California Deluxe"));
        List<String> t219 = new ArrayList<>(List.of("Sprite", "Sprite"));
        List<String> t220 = new ArrayList<>(List.of("Kani Salad", "Chocolate Cake"));
        List<String> t221 = new ArrayList<>(List.of("Sprite", "Tuna Sashimi", "Tuna Sashimi", "California Deluxe", "Tuna Salmon Dynamite Roll", "Tuna Sashimi"));
        List<String> t222 = new ArrayList<>(List.of("Katsudon", "Kani Salad", "Tuna Sashimi", "Tuna Sashimi", "California Deluxe", "Kani Salad", "Chef's Special Sushi Platter"));
        List<String> t223 = new ArrayList<>(List.of("Kani Salad"));
        List<String> t224 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Katsudon", "California Deluxe", "Katsudon", "Sprite", "Tuna Sashimi", "Kani Salad"));
        List<String> t225 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Salmon Dynamite Roll", "Kani Salad", "Kani Salad", "Chocolate Cake", "California Deluxe", "Tuna Sashimi"));
        List<String> t226 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll"));
        List<String> t227 = new ArrayList<>(List.of("Katsudon", "Katsudon", "Chocolate Cake"));
        List<String> t228 = new ArrayList<>(List.of("Sprite"));
        List<String> t229 = new ArrayList<>(List.of("Tuna Sashimi", "Chef's Special Sushi Platter", "Sprite", "Chocolate Cake", "California Deluxe", "Katsudon"));
        List<String> t230 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Tuna Sashimi", "Sprite", "Tuna Sashimi", "Kani Salad", "Tuna Sashimi"));
        List<String> t231 = new ArrayList<>(List.of("Kani Salad", "Katsudon", "California Deluxe", "Chef's Special Sushi Platter", "Kani Salad"));
        List<String> t232 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Chef's Special Sushi Platter"));
        List<String> t233 = new ArrayList<>(List.of("Sprite", "Chocolate Cake", "California Deluxe"));
        List<String> t234 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Salmon Dynamite Roll", "Chocolate Cake", "Chocolate Cake", "Tuna Salmon Dynamite Roll"));
        List<String> t235 = new ArrayList<>(List.of("Tuna Sashimi", "Sprite", "Katsudon"));
        List<String> t236 = new ArrayList<>(List.of("California Deluxe", "Katsudon", "Katsudon", "Chef's Special Sushi Platter", "Tuna Sashimi", "Chocolate Cake", "Tuna Salmon Dynamite Roll"));
        List<String> t237 = new ArrayList<>(List.of("Kani Salad", "Chef's Special Sushi Platter", "Chef's Special Sushi Platter", "Kani Salad", "Sprite", "Kani Salad", "California Deluxe"));
        List<String> t238 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Katsudon"));
        List<String> t239 = new ArrayList<>(List.of("California Deluxe", "Tuna Sashimi", "Kani Salad", "Tuna Sashimi", "Kani Salad", "Chef's Special Sushi Platter", "Tuna Sashimi"));
        List<String> t240 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Chocolate Cake", "Tuna Sashimi"));
        List<String> t241 = new ArrayList<>(List.of("Sprite", "Sprite", "California Deluxe", "Sprite", "Sprite"));
        List<String> t242 = new ArrayList<>(List.of("Sprite", "Tuna Sashimi", "Chef's Special Sushi Platter", "Chef's Special Sushi Platter", "Katsudon"));
        List<String> t243 = new ArrayList<>(List.of("Katsudon", "Tuna Salmon Dynamite Roll"));
        List<String> t244 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Chef's Special Sushi Platter", "Tuna Sashimi", "Chef's Special Sushi Platter", "California Deluxe", "Sprite"));
        List<String> t245 = new ArrayList<>(List.of("Katsudon", "Chocolate Cake", "Kani Salad", "Tuna Salmon Dynamite Roll", "Tuna Sashimi"));
        List<String> t246 = new ArrayList<>(List.of("Katsudon", "Tuna Sashimi", "Tuna Salmon Dynamite Roll", "Chocolate Cake"));
        List<String> t247 = new ArrayList<>(List.of("Kani Salad", "Tuna Sashimi"));
        List<String> t248 = new ArrayList<>(List.of("Tuna Sashimi"));
        List<String> t249 = new ArrayList<>(List.of("Tuna Sashimi", "Chocolate Cake", "Chef's Special Sushi Platter", "Sprite", "Kani Salad"));
        List<String> t250 = new ArrayList<>(List.of("Tuna Sashimi", "Katsudon"));
        List<String> t251 = new ArrayList<>(List.of("Sprite", "Chef's Special Sushi Platter", "Katsudon", "Kani Salad"));
        List<String> t252 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Katsudon", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll", "Tuna Sashimi"));
        List<String> t253 = new ArrayList<>(List.of("Katsudon", "Chef's Special Sushi Platter", "Sprite", "California Deluxe", "Chef's Special Sushi Platter", "Katsudon", "Tuna Sashimi"));
        List<String> t254 = new ArrayList<>(List.of("California Deluxe", "Sprite", "Chocolate Cake", "Sprite"));
        List<String> t255 = new ArrayList<>(List.of("Kani Salad", "Tuna Sashimi"));
        List<String> t256 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Sprite", "California Deluxe", "Tuna Sashimi"));
        List<String> t257 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Tuna Sashimi", "Kani Salad", "Tuna Sashimi", "Chocolate Cake"));
        List<String> t258 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Chocolate Cake", "Katsudon"));
        List<String> t259 = new ArrayList<>(List.of("Tuna Sashimi"));
        List<String> t260 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi"));
        List<String> t261 = new ArrayList<>(List.of("Kani Salad", "Chef's Special Sushi Platter"));
        List<String> t262 = new ArrayList<>(List.of("Tuna Sashimi", "Kani Salad", "Tuna Salmon Dynamite Roll", "Sprite"));
        List<String> t263 = new ArrayList<>(List.of("Tuna Sashimi", "Kani Salad"));
        List<String> t264 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Salmon Dynamite Roll", "Tuna Sashimi", "Kani Salad"));
        List<String> t265 = new ArrayList<>(List.of("Kani Salad", "Katsudon", "Katsudon"));
        List<String> t266 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "California Deluxe", "Kani Salad", "Tuna Salmon Dynamite Roll", "Sprite", "Tuna Salmon Dynamite Roll", "Chocolate Cake"));
        List<String> t267 = new ArrayList<>(List.of("Sprite", "Katsudon", "Kani Salad", "Sprite", "Chef's Special Sushi Platter", "Tuna Salmon Dynamite Roll", "Tuna Sashimi"));
        List<String> t268 = new ArrayList<>(List.of("Chocolate Cake", "Katsudon", "Kani Salad", "Tuna Sashimi", "Sprite"));
        List<String> t269 = new ArrayList<>(List.of("Kani Salad", "Chef's Special Sushi Platter", "Chef's Special Sushi Platter", "Chef's Special Sushi Platter", "California Deluxe"));
        List<String> t270 = new ArrayList<>(List.of("Kani Salad", "Tuna Salmon Dynamite Roll"));
        List<String> t271 = new ArrayList<>(List.of("Chocolate Cake", "Katsudon", "Tuna Sashimi", "Sprite", "Tuna Salmon Dynamite Roll", "Tuna Sashimi"));
        List<String> t272 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Sprite", "Chocolate Cake", "California Deluxe", "California Deluxe", "Kani Salad"));
        List<String> t273 = new ArrayList<>(List.of("Katsudon", "California Deluxe", "Tuna Salmon Dynamite Roll"));
        List<String> t274 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll"));
        List<String> t275 = new ArrayList<>(List.of("Katsudon", "Kani Salad", "California Deluxe", "Tuna Sashimi", "Katsudon", "Tuna Salmon Dynamite Roll"));
        List<String> t276 = new ArrayList<>(List.of("California Deluxe", "Kani Salad", "Katsudon", "Sprite"));
        List<String> t277 = new ArrayList<>(List.of("Sprite", "Tuna Sashimi", "Chef's Special Sushi Platter"));
        List<String> t278 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi"));
        List<String> t279 = new ArrayList<>(List.of("Kani Salad", "Sprite", "Sprite"));
        List<String> t280 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Sashimi", "Kani Salad"));
        List<String> t281 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t282 = new ArrayList<>(List.of("Kani Salad", "Kani Salad"));
        List<String> t283 = new ArrayList<>(List.of("Sprite", "Chocolate Cake", "Kani Salad", "Chocolate Cake", "Chocolate Cake", "Tuna Sashimi", "Chef's Special Sushi Platter"));
        List<String> t284 = new ArrayList<>(List.of("California Deluxe", "Tuna Sashimi", "Tuna Salmon Dynamite Roll", "Chocolate Cake", "California Deluxe", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll"));
        List<String> t285 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chocolate Cake", "Tuna Sashimi", "Tuna Sashimi", "Sprite"));
        List<String> t286 = new ArrayList<>(List.of("Kani Salad", "Tuna Sashimi", "California Deluxe", "Chocolate Cake", "Chocolate Cake", "Tuna Sashimi"));
        List<String> t287 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Tuna Sashimi", "Chocolate Cake", "Chocolate Cake", "Tuna Salmon Dynamite Roll"));
        List<String> t288 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi"));
        List<String> t289 = new ArrayList<>(List.of("Sprite", "Tuna Sashimi", "Tuna Sashimi"));
        List<String> t290 = new ArrayList<>(List.of("Kani Salad", "California Deluxe", "Tuna Sashimi", "Tuna Sashimi", "Chef's Special Sushi Platter", "Chef's Special Sushi Platter", "Tuna Sashimi"));
        List<String> t291 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Katsudon", "Tuna Salmon Dynamite Roll", "California Deluxe", "Katsudon", "Tuna Sashimi"));
        List<String> t292 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chocolate Cake", "Tuna Salmon Dynamite Roll", "Kani Salad", "Tuna Sashimi", "Chef's Special Sushi Platter"));
        List<String> t293 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi"));
        List<String> t294 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi"));
        List<String> t295 = new ArrayList<>(List.of("Sprite", "Chocolate Cake"));
        List<String> t296 = new ArrayList<>(List.of("California Deluxe", "Sprite", "Chocolate Cake"));
        List<String> t297 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "California Deluxe", "Katsudon"));
        List<String> t298 = new ArrayList<>(List.of("Kani Salad", "Katsudon"));
        List<String> t299 = new ArrayList<>(List.of("Katsudon", "Katsudon", "Tuna Sashimi"));
        List<String> t300 = new ArrayList<>(List.of("California Deluxe", "Katsudon", "Tuna Sashimi", "Kani Salad", "Tuna Salmon Dynamite Roll"));
        List<String> t301 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chef's Special Sushi Platter"));
        List<String> t302 = new ArrayList<>(List.of("Kani Salad", "Katsudon"));
        List<String> t303 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Sprite", "Sprite", "Tuna Sashimi", "Kani Salad", "Tuna Salmon Dynamite Roll"));
        List<String> t304 = new ArrayList<>(List.of("Tuna Sashimi", "Sprite", "Tuna Salmon Dynamite Roll", "Tuna Sashimi"));
        List<String> t305 = new ArrayList<>(List.of("Kani Salad", "Sprite"));
        List<String> t306 = new ArrayList<>(List.of("Sprite", "Chef's Special Sushi Platter", "Tuna Salmon Dynamite Roll", "Chef's Special Sushi Platter", "Tuna Sashimi"));
        List<String> t307 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll"));
        List<String> t308 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Katsudon", "Tuna Sashimi", "Katsudon"));
        List<String> t309 = new ArrayList<>(List.of("Kani Salad", "Kani Salad", "Kani Salad", "Tuna Salmon Dynamite Roll"));
        List<String> t310 = new ArrayList<>(List.of("Katsudon", "Tuna Sashimi", "Katsudon"));
        List<String> t311 = new ArrayList<>(List.of("California Deluxe", "Tuna Sashimi", "Katsudon", "California Deluxe", "Tuna Salmon Dynamite Roll"));
        List<String> t312 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Tuna Salmon Dynamite Roll", "Tuna Sashimi", "Tuna Sashimi", "Katsudon"));
        List<String> t313 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chef's Special Sushi Platter", "Tuna Sashimi", "California Deluxe", "Kani Salad", "Kani Salad", "Tuna Sashimi"));
        List<String> t314 = new ArrayList<>(List.of("Tuna Sashimi", "Sprite", "California Deluxe"));
        List<String> t315 = new ArrayList<>(List.of("Chocolate Cake", "Kani Salad", "Chocolate Cake", "Tuna Salmon Dynamite Roll", "Chef's Special Sushi Platter"));
        List<String> t316 = new ArrayList<>(List.of("Katsudon", "Chef's Special Sushi Platter"));
        List<String> t317 = new ArrayList<>(List.of("California Deluxe", "Katsudon", "Tuna Sashimi", "Chef's Special Sushi Platter", "Tuna Sashimi"));
        List<String> t318 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Sashimi", "Tuna Sashimi", "California Deluxe", "Kani Salad", "Tuna Sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t319 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chocolate Cake", "Katsudon"));
        List<String> t320 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Kani Salad", "Katsudon", "California Deluxe", "Chocolate Cake"));
        List<String> t321 = new ArrayList<>(List.of("Kani Salad", "Tuna Sashimi", "Kani Salad", "Chef's Special Sushi Platter", "California Deluxe", "Chef's Special Sushi Platter", "Chef's Special Sushi Platter"));
        List<String> t322 = new ArrayList<>(List.of("Kani Salad", "Tuna Sashimi"));
        List<String> t323 = new ArrayList<>(List.of("Katsudon"));
        List<String> t324 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Kani Salad", "Chef's Special Sushi Platter", "Chocolate Cake"));
        List<String> t325 = new ArrayList<>(List.of("Chocolate Cake", "Katsudon", "Katsudon", "California Deluxe"));
        List<String> t326 = new ArrayList<>(List.of("Kani Salad", "Kani Salad"));
        List<String> t327 = new ArrayList<>(List.of("Tuna Sashimi", "Katsudon", "Tuna Sashimi", "Chef's Special Sushi Platter"));
        List<String> t328 = new ArrayList<>(List.of("Tuna Sashimi", "California Deluxe"));
        List<String> t329 = new ArrayList<>(List.of("Tuna Sashimi"));
        List<String> t330 = new ArrayList<>(List.of("Katsudon", "Tuna Salmon Dynamite Roll"));
        List<String> t331 = new ArrayList<>(List.of("Kani Salad", "Chef's Special Sushi Platter", "Chef's Special Sushi Platter", "Katsudon", "Sprite"));
        List<String> t332 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Sashimi", "Tuna Sashimi", "Chef's Special Sushi Platter"));
        List<String> t333 = new ArrayList<>(List.of("Katsudon", "California Deluxe", "Kani Salad", "Sprite", "Katsudon", "Tuna Sashimi"));
        List<String> t334 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Salmon Dynamite Roll", "Tuna Sashimi", "Tuna Sashimi", "Chef's Special Sushi Platter"));
        List<String> t335 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Katsudon", "Kani Salad", "Chocolate Cake"));
        List<String> t336 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Tuna Sashimi", "Kani Salad", "Chef's Special Sushi Platter"));
        List<String> t337 = new ArrayList<>(List.of("Tuna Sashimi", "Chef's Special Sushi Platter", "Kani Salad", "Katsudon"));
        List<String> t338 = new ArrayList<>(List.of("Tuna Sashimi", "Kani Salad", "Chocolate Cake", "Katsudon"));
        List<String> t339 = new ArrayList<>(List.of("California Deluxe"));
        List<String> t340 = new ArrayList<>(List.of("Chef's Special Sushi Platter"));
        List<String> t341 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t342 = new ArrayList<>(List.of("Sprite", "Chocolate Cake"));
        List<String> t343 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Tuna Sashimi", "Tuna Sashimi", "Sprite"));
        List<String> t344 = new ArrayList<>(List.of("Kani Salad", "Kani Salad", "Katsudon", "Chocolate Cake", "Tuna Sashimi", "Tuna Sashimi"));
        List<String> t345 = new ArrayList<>(List.of("Katsudon", "Tuna Sashimi"));
        List<String> t346 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Salmon Dynamite Roll", "Tuna Sashimi", "Kani Salad", "Tuna Sashimi", "Katsudon", "Tuna Sashimi"));
        List<String> t347 = new ArrayList<>(List.of("Chocolate Cake", "Kani Salad", "California Deluxe", "Chef's Special Sushi Platter", "California Deluxe", "Kani Salad"));
        List<String> t348 = new ArrayList<>(List.of("Chef's Special Sushi Platter"));
        List<String> t349 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Salmon Dynamite Roll"));
        List<String> t350 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Katsudon", "Sprite", "Tuna Salmon Dynamite Roll"));
        List<String> t351 = new ArrayList<>(List.of("California Deluxe", "Tuna Sashimi", "Kani Salad"));
        List<String> t352 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll"));
        List<String> t353 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Sashimi", "Tuna Sashimi", "Katsudon"));
        List<String> t354 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll"));
        List<String> t355 = new ArrayList<>(List.of("Katsudon", "California Deluxe", "Sprite", "Sprite"));
        List<String> t356 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Chef's Special Sushi Platter", "Tuna Sashimi"));
        List<String> t357 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t358 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll"));
        List<String> t359 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Sashimi", "Kani Salad", "California Deluxe", "Chef's Special Sushi Platter"));
        List<String> t360 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Sprite", "Tuna Salmon Dynamite Roll"));
        List<String> t361 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Katsudon"));
        List<String> t362 = new ArrayList<>(List.of("Kani Salad", "Tuna Sashimi", "California Deluxe", "California Deluxe", "Tuna Sashimi", "Chocolate Cake"));
        List<String> t363 = new ArrayList<>(List.of("Kani Salad"));
        List<String> t364 = new ArrayList<>(List.of("Kani Salad", "Tuna Salmon Dynamite Roll", "Kani Salad", "Tuna Sashimi"));
        List<String> t365 = new ArrayList<>(List.of("Tuna Sashimi", "California Deluxe", "Kani Salad"));
        List<String> t366 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll"));
        List<String> t367 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi"));
        List<String> t368 = new ArrayList<>(List.of("Kani Salad", "Katsudon"));
        List<String> t369 = new ArrayList<>(List.of("Sprite", "Sprite", "Tuna Sashimi", "Sprite"));
        List<String> t370 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "California Deluxe", "Tuna Salmon Dynamite Roll", "Kani Salad", "Tuna Salmon Dynamite Roll", "Tuna Sashimi"));
        List<String> t371 = new ArrayList<>(List.of("Kani Salad", "Tuna Sashimi"));
        List<String> t372 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Katsudon", "Sprite", "Tuna Sashimi"));
        List<String> t373 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Sashimi", "Chef's Special Sushi Platter", "Kani Salad"));
        List<String> t374 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Tuna Salmon Dynamite Roll"));
        List<String> t375 = new ArrayList<>(List.of("Katsudon", "Sprite"));
        List<String> t376 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Chocolate Cake"));
        List<String> t377 = new ArrayList<>(List.of("Tuna Sashimi", "Chocolate Cake", "California Deluxe", "Chef's Special Sushi Platter", "Kani Salad"));
        List<String> t378 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Katsudon"));
        List<String> t379 = new ArrayList<>(List.of("Kani Salad", "Kani Salad", "Tuna Sashimi", "Tuna Sashimi", "Tuna Sashimi", "Chocolate Cake", "Chocolate Cake"));
        List<String> t380 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Kani Salad", "Tuna Sashimi", "Chef's Special Sushi Platter", "Katsudon", "Sprite", "Tuna Sashimi"));
        List<String> t381 = new ArrayList<>(List.of("Katsudon", "Kani Salad", "Chocolate Cake", "Tuna Salmon Dynamite Roll", "Katsudon"));
        List<String> t382 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Sashimi", "Sprite", "Tuna Salmon Dynamite Roll", "Tuna Sashimi", "California Deluxe", "Tuna Sashimi"));
        List<String> t383 = new ArrayList<>(List.of("Katsudon", "Tuna Salmon Dynamite Roll"));
        List<String> t384 = new ArrayList<>(List.of("Tuna Sashimi", "California Deluxe"));
        List<String> t385 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Sashimi", "Tuna Sashimi"));
        List<String> t386 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Kani Salad", "Chef's Special Sushi Platter", "Tuna Sashimi"));
        List<String> t387 = new ArrayList<>(List.of("Chocolate Cake", "Sprite", "California Deluxe", "Sprite", "Chef's Special Sushi Platter", "Chef's Special Sushi Platter"));
        List<String> t388 = new ArrayList<>(List.of("California Deluxe", "Chocolate Cake", "Kani Salad", "Katsudon"));
        List<String> t389 = new ArrayList<>(List.of("Sprite", "Tuna Salmon Dynamite Roll", "Chocolate Cake", "Chef's Special Sushi Platter"));
        List<String> t390 = new ArrayList<>(List.of("Kani Salad", "Tuna Sashimi", "Katsudon", "California Deluxe", "California Deluxe", "Tuna Sashimi"));
        List<String> t391 = new ArrayList<>(List.of("Sprite", "Chocolate Cake", "Kani Salad", "California Deluxe", "Chef's Special Sushi Platter", "Tuna Salmon Dynamite Roll", "California Deluxe"));
        List<String> t392 = new ArrayList<>(List.of("Chocolate Cake", "Katsudon", "Tuna Sashimi", "Tuna Salmon Dynamite Roll", "Kani Salad"));
        List<String> t393 = new ArrayList<>(List.of("Kani Salad"));
        List<String> t394 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Sashimi"));
        List<String> t395 = new ArrayList<>(List.of("Katsudon", "Kani Salad"));
        List<String> t396 = new ArrayList<>(List.of("Katsudon", "Tuna Sashimi"));
        List<String> t397 = new ArrayList<>(List.of("Tuna Sashimi", "Chocolate Cake", "Chef's Special Sushi Platter", "California Deluxe", "Sprite", "Chocolate Cake"));
        List<String> t398 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "California Deluxe"));
        List<String> t399 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Kani Salad"));
        List<String> t400 = new ArrayList<>(List.of("Sprite", "Kani Salad", "California Deluxe", "Tuna Salmon Dynamite Roll"));
        List<String> t401 = new ArrayList<>(List.of("Sprite", "Katsudon"));
        List<String> t402 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Sprite", "Tuna Salmon Dynamite Roll"));
        List<String> t403 = new ArrayList<>(List.of("Tuna Sashimi"));
        List<String> t404 = new ArrayList<>(List.of("California Deluxe", "Tuna Sashimi"));
        List<String> t405 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Sprite", "Tuna Salmon Dynamite Roll", "Kani Salad", "Tuna Sashimi"));
        List<String> t406 = new ArrayList<>(List.of("Tuna Sashimi", "Katsudon", "Tuna Salmon Dynamite Roll", "Chocolate Cake"));
        List<String> t407 = new ArrayList<>(List.of("Kani Salad", "Sprite", "Sprite", "California Deluxe"));
        List<String> t408 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Sprite", "Tuna Salmon Dynamite Roll", "Tuna Sashimi", "Tuna Sashimi", "Katsudon"));
        List<String> t409 = new ArrayList<>(List.of("Sprite", "Chocolate Cake"));
        List<String> t410 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t411 = new ArrayList<>(List.of("Sprite", "Tuna Sashimi", "Chocolate Cake", "Tuna Sashimi", "California Deluxe"));
        List<String> t412 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Sashimi", "Tuna Sashimi", "California Deluxe", "Tuna Sashimi", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll"));
        List<String> t413 = new ArrayList<>(List.of("Katsudon"));
        List<String> t414 = new ArrayList<>(List.of("Katsudon", "Kani Salad", "Tuna Sashimi", "Chef's Special Sushi Platter", "California Deluxe"));
        List<String> t415 = new ArrayList<>(List.of("Tuna Sashimi", "Kani Salad", "Chocolate Cake", "Sprite", "Katsudon"));
        List<String> t416 = new ArrayList<>(List.of("Tuna Sashimi", "Chef's Special Sushi Platter"));
        List<String> t417 = new ArrayList<>(List.of("California Deluxe"));
        List<String> t418 = new ArrayList<>(List.of("Sprite", "Chef's Special Sushi Platter", "Katsudon", "Tuna Salmon Dynamite Roll", "Chef's Special Sushi Platter", "Katsudon"));
        List<String> t419 = new ArrayList<>(List.of("Sprite", "Tuna Sashimi", "Katsudon", "California Deluxe", "Sprite", "Chocolate Cake"));
        List<String> t420 = new ArrayList<>(List.of("Sprite", "Chocolate Cake", "Chocolate Cake", "Katsudon"));
        List<String> t421 = new ArrayList<>(List.of("California Deluxe"));
        List<String> t422 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "California Deluxe", "Sprite", "Tuna Sashimi", "Tuna Sashimi"));
        List<String> t423 = new ArrayList<>(List.of("Sprite", "Tuna Sashimi", "Sprite", "Sprite", "Chef's Special Sushi Platter", "Tuna Salmon Dynamite Roll"));
        List<String> t424 = new ArrayList<>(List.of("Katsudon", "Chocolate Cake", "Tuna Salmon Dynamite Roll"));
        List<String> t425 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Sprite", "Chef's Special Sushi Platter", "Tuna Salmon Dynamite Roll", "Kani Salad"));
        List<String> t426 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Chocolate Cake", "Chocolate Cake", "Tuna Salmon Dynamite Roll"));
        List<String> t427 = new ArrayList<>(List.of("Chocolate Cake", "Kani Salad", "Kani Salad", "Chocolate Cake", "Chocolate Cake", "California Deluxe"));
        List<String> t428 = new ArrayList<>(List.of("California Deluxe", "Chocolate Cake", "Katsudon", "California Deluxe", "Sprite"));
        List<String> t429 = new ArrayList<>(List.of("Tuna Sashimi", "California Deluxe", "Katsudon", "Chef's Special Sushi Platter"));
        List<String> t430 = new ArrayList<>(List.of("Katsudon", "Tuna Sashimi", "Chef's Special Sushi Platter", "California Deluxe", "Sprite", "California Deluxe", "Tuna Sashimi"));
        List<String> t431 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Sashimi", "Sprite", "California Deluxe", "Tuna Sashimi", "Tuna Sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t432 = new ArrayList<>(List.of("Tuna Sashimi", "Kani Salad", "California Deluxe", "Tuna Sashimi", "Chocolate Cake", "Tuna Sashimi"));
        List<String> t433 = new ArrayList<>(List.of("Chocolate Cake", "Chef's Special Sushi Platter", "Chocolate Cake", "Sprite", "Tuna Sashimi", "California Deluxe"));
        List<String> t434 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Kani Salad", "Tuna Sashimi", "Tuna Sashimi"));
        List<String> t435 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t436 = new ArrayList<>(List.of("Sprite", "Sprite"));
        List<String> t437 = new ArrayList<>(List.of("Sprite", "Sprite", "Tuna Sashimi", "Tuna Salmon Dynamite Roll", "Katsudon", "Tuna Sashimi", "Katsudon"));
        List<String> t438 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Katsudon", "Chef's Special Sushi Platter", "Katsudon"));
        List<String> t439 = new ArrayList<>(List.of("Katsudon", "Tuna Sashimi", "Tuna Salmon Dynamite Roll", "Kani Salad", "Tuna Salmon Dynamite Roll", "Sprite", "Tuna Sashimi"));
        List<String> t440 = new ArrayList<>(List.of("Katsudon", "Sprite", "Katsudon", "Tuna Sashimi", "Chocolate Cake", "Tuna Sashimi", "California Deluxe"));
        List<String> t441 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Tuna Sashimi", "Sprite", "Tuna Sashimi"));
        List<String> t442 = new ArrayList<>(List.of("Sprite", "Tuna Sashimi"));
        List<String> t443 = new ArrayList<>(List.of("Kani Salad", "Tuna Sashimi"));
        List<String> t444 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Kani Salad", "Sprite", "Tuna Sashimi", "California Deluxe"));
        List<String> t445 = new ArrayList<>(List.of("Tuna Sashimi", "California Deluxe"));
        List<String> t446 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi"));
        List<String> t447 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "California Deluxe", "Kani Salad"));
        List<String> t448 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Kani Salad", "Kani Salad", "Chocolate Cake"));
        List<String> t449 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Tuna Sashimi", "Tuna Sashimi", "Tuna Sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t450 = new ArrayList<>(List.of("Sprite", "Sprite", "Tuna Sashimi", "Tuna Sashimi"));
        List<String> t451 = new ArrayList<>(List.of("Sprite", "California Deluxe"));
        List<String> t452 = new ArrayList<>(List.of("Katsudon", "Katsudon"));
        List<String> t453 = new ArrayList<>(List.of("Katsudon", "Katsudon", "Tuna Sashimi", "Kani Salad", "Katsudon", "Tuna Sashimi", "Chocolate Cake"));
        List<String> t454 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Tuna Sashimi", "Sprite"));
        List<String> t455 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Tuna Sashimi"));
        List<String> t456 = new ArrayList<>(List.of("Kani Salad", "Tuna Sashimi", "Tuna Sashimi", "Kani Salad", "California Deluxe"));
        List<String> t457 = new ArrayList<>(List.of("Kani Salad", "Tuna Sashimi"));
        List<String> t458 = new ArrayList<>(List.of("Tuna Sashimi", "Kani Salad", "Sprite", "Chef's Special Sushi Platter", "Kani Salad", "California Deluxe", "Tuna Sashimi"));
        List<String> t459 = new ArrayList<>(List.of("Tuna Sashimi", "California Deluxe", "Katsudon", "Katsudon"));
        List<String> t460 = new ArrayList<>(List.of("Katsudon", "Tuna Sashimi", "Tuna Salmon Dynamite Roll", "Chocolate Cake", "Tuna Sashimi", "Katsudon"));
        List<String> t461 = new ArrayList<>(List.of("Sprite"));
        List<String> t462 = new ArrayList<>(List.of("Katsudon", "Tuna Sashimi", "California Deluxe", "Sprite", "Chocolate Cake"));
        List<String> t463 = new ArrayList<>(List.of("Kani Salad", "Chocolate Cake", "Sprite", "Tuna Salmon Dynamite Roll", "Sprite"));
        List<String> t464 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll"));
        List<String> t465 = new ArrayList<>(List.of("Kani Salad", "Tuna Salmon Dynamite Roll", "Katsudon", "Chocolate Cake", "California Deluxe"));
        List<String> t466 = new ArrayList<>(List.of("Sprite", "California Deluxe"));
        List<String> t467 = new ArrayList<>(List.of("Katsudon"));
        List<String> t468 = new ArrayList<>(List.of("Tuna Sashimi", "California Deluxe", "Chocolate Cake", "Tuna Salmon Dynamite Roll"));
        List<String> t469 = new ArrayList<>(List.of("Katsudon"));
        List<String> t470 = new ArrayList<>(List.of("Tuna Sashimi", "Chef's Special Sushi Platter", "California Deluxe", "Tuna Sashimi"));
        List<String> t471 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "California Deluxe", "Tuna Sashimi"));
        List<String> t472 = new ArrayList<>(List.of("Sprite", "Chef's Special Sushi Platter", "California Deluxe", "California Deluxe", "Tuna Sashimi", "Chef's Special Sushi Platter", "Tuna Sashimi"));
        List<String> t473 = new ArrayList<>(List.of("Tuna Sashimi", "Katsudon"));
        List<String> t474 = new ArrayList<>(List.of("Kani Salad"));
        List<String> t475 = new ArrayList<>(List.of("Tuna Sashimi"));
        List<String> t476 = new ArrayList<>(List.of("Kani Salad", "Katsudon", "Tuna Sashimi", "Tuna Sashimi", "Kani Salad", "Tuna Salmon Dynamite Roll", "California Deluxe"));
        List<String> t477 = new ArrayList<>(List.of("Tuna Sashimi", "Kani Salad", "Kani Salad", "Katsudon", "Katsudon", "Sprite"));
        List<String> t478 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Sashimi"));
        List<String> t479 = new ArrayList<>(List.of("Kani Salad", "Sprite"));
        List<String> t480 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Sprite", "Kani Salad"));
        List<String> t481 = new ArrayList<>(List.of("California Deluxe", "Chocolate Cake", "Chef's Special Sushi Platter"));
        List<String> t482 = new ArrayList<>(List.of("Tuna Sashimi"));
        List<String> t483 = new ArrayList<>(List.of("Chef's Special Sushi Platter", "Chef's Special Sushi Platter"));
        List<String> t484 = new ArrayList<>(List.of("Chocolate Cake", "Katsudon", "Sprite", "Tuna Sashimi", "Sprite"));
        List<String> t485 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Sashimi", "California Deluxe"));
        List<String> t486 = new ArrayList<>(List.of("Sprite", "California Deluxe", "Chocolate Cake", "Chocolate Cake", "California Deluxe", "Tuna Sashimi"));
        List<String> t487 = new ArrayList<>(List.of("Tuna Sashimi"));
        List<String> t488 = new ArrayList<>(List.of("Sprite", "Sprite", "Tuna Salmon Dynamite Roll", "Sprite", "Tuna Salmon Dynamite Roll", "Tuna Sashimi"));
        List<String> t489 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Sashimi", "Katsudon"));
        List<String> t490 = new ArrayList<>(List.of("Tuna Sashimi", "Katsudon", "Tuna Salmon Dynamite Roll", "Chocolate Cake", "Kani Salad", "Sprite", "Katsudon"));
        List<String> t491 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Kani Salad"));
        List<String> t492 = new ArrayList<>(List.of("Chocolate Cake", "Chef's Special Sushi Platter", "Katsudon", "Tuna Salmon Dynamite Roll", "Sprite", "Kani Salad"));
        List<String> t493 = new ArrayList<>(List.of("Katsudon", "Katsudon"));
        List<String> t494 = new ArrayList<>(List.of("Tuna Sashimi", "Katsudon"));
        List<String> t495 = new ArrayList<>(List.of("California Deluxe", "California Deluxe", "Chef's Special Sushi Platter", "Tuna Salmon Dynamite Roll", "Katsudon"));
        List<String> t496 = new ArrayList<>(List.of("Tuna Sashimi"));
        List<String> t497 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll"));
        List<String> t498 = new ArrayList<>(List.of("Tuna Sashimi", "Tuna Sashimi", "Chef's Special Sushi Platter", "Tuna Salmon Dynamite Roll", "Chef's Special Sushi Platter", "Tuna Sashimi"));
        List<String> t499 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Sashimi", "Tuna Sashimi", "California Deluxe", "Tuna Salmon Dynamite Roll", "Katsudon", "Katsudon"));
        List<String> t500 = new ArrayList<>(List.of("Tuna Sashimi", "Katsudon"));

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
