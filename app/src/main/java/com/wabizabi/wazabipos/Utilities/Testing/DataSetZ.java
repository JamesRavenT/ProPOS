package com.wabizabi.wazabipos.Utilities.Testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class DataSetZ implements DataSet {

    public static void insertInto(List<List<String>> transactionsTB) {


        List<String> t1 = new ArrayList<>(List.of("Beef Yakiudon", "Tako"));
        List<String> t2 = new ArrayList<>(List.of("Tako", "All California Sushi Platter"));
        List<String> t3 = new ArrayList<>(List.of("Tako", "Beef Yakiudon", "Tako", "Teriyakidon"));
        List<String> t4 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "Tako", "Chocolate Cake", "Teriyakidon"));
        List<String> t5 = new ArrayList<>(List.of("All California Sushi Platter", "Tako"));
        List<String> t6 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "4 Seasons", "All California Sushi Platter"));
        List<String> t7 = new ArrayList<>(List.of("Teriyakidon", "Salmon and Shrimp Tempura Roll"));
        List<String> t8 = new ArrayList<>(List.of("All California Sushi Platter", "Salmon and Shrimp Tempura Roll"));
        List<String> t9 = new ArrayList<>(List.of("Tako", "All California Sushi Platter", "Chocolate Cake", "Chocolate Cake", "Beef Yakiudon"));
        List<String> t10 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad", "Chocolate Cake", "Chocolate Cake", "Teriyakidon"));
        List<String> t11 = new ArrayList<>(List.of("Seaweed Salad", "Chocolate Cake", "Tako", "Tako", "Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Tako"));
        List<String> t12 = new ArrayList<>(List.of("All California Sushi Platter", "Tako"));
        List<String> t13 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Tako", "Seaweed Salad", "Teriyakidon", "Seaweed Salad", "Tako"));
        List<String> t14 = new ArrayList<>(List.of("All California Sushi Platter", "Beef Yakiudon"));
        List<String> t15 = new ArrayList<>(List.of("Beef Yakiudon", "All California Sushi Platter"));
        List<String> t16 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Tako", "All California Sushi Platter", "Teriyakidon", "Tako", "Tako"));
        List<String> t17 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "4 Seasons", "Seaweed Salad", "Tako", "Tako", "All California Sushi Platter"));
        List<String> t18 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t19 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Teriyakidon", "Teriyakidon"));
        List<String> t20 = new ArrayList<>(List.of("4 Seasons", "Teriyakidon"));
        List<String> t21 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "Teriyakidon", "All California Sushi Platter"));
        List<String> t22 = new ArrayList<>(List.of("All California Sushi Platter", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "Beef Yakiudon", "All California Sushi Platter"));
        List<String> t23 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Chocolate Cake", "4 Seasons", "Tako", "All California Sushi Platter", "Beef Yakiudon"));
        List<String> t24 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t25 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Seaweed Salad", "All California Sushi Platter", "Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t26 = new ArrayList<>(List.of("4 Seasons", "Teriyakidon", "Salmon and Shrimp Tempura Roll"));
        List<String> t27 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "Beef Yakiudon", "Chocolate Cake"));
        List<String> t28 = new ArrayList<>(List.of("Beef Yakiudon", "All California Sushi Platter"));
        List<String> t29 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Seaweed Salad"));
        List<String> t30 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "Beef Yakiudon", "Seaweed Salad", "Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Beef Yakiudon"));
        List<String> t31 = new ArrayList<>(List.of("Teriyakidon", "Teriyakidon", "Tako"));
        List<String> t32 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t33 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll"));
        List<String> t34 = new ArrayList<>(List.of("Chocolate Cake", "Seaweed Salad", "All California Sushi Platter", "Tako", "Tako"));
        List<String> t35 = new ArrayList<>(List.of("4 Seasons", "Chocolate Cake", "Tako", "Seaweed Salad", "All California Sushi Platter", "Tako", "Seaweed Salad"));
        List<String> t36 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t37 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t38 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll", "Tako", "Beef Yakiudon", "All California Sushi Platter"));
        List<String> t39 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t40 = new ArrayList<>(List.of("Teriyakidon"));
        List<String> t41 = new ArrayList<>(List.of("Tako"));
        List<String> t42 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad"));
        List<String> t43 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "All California Sushi Platter", "Chocolate Cake", "4 Seasons", "Tako", "All California Sushi Platter"));
        List<String> t44 = new ArrayList<>(List.of("Tako", "4 Seasons", "Seaweed Salad", "4 Seasons"));
        List<String> t45 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "Seaweed Salad", "Seaweed Salad", "Tako"));
        List<String> t46 = new ArrayList<>(List.of("Teriyakidon"));
        List<String> t47 = new ArrayList<>(List.of("Tako"));
        List<String> t48 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Tako", "Seaweed Salad"));
        List<String> t49 = new ArrayList<>(List.of("Teriyakidon", "Beef Yakiudon"));
        List<String> t50 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll"));
        List<String> t51 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter"));
        List<String> t52 = new ArrayList<>(List.of("All California Sushi Platter", "Seaweed Salad"));
        List<String> t53 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad", "4 Seasons", "Seaweed Salad"));
        List<String> t54 = new ArrayList<>(List.of("Teriyakidon", "Chocolate Cake", "Tako"));
        List<String> t55 = new ArrayList<>(List.of("Tako", "Teriyakidon"));
        List<String> t56 = new ArrayList<>(List.of("Teriyakidon", "Seaweed Salad", "Teriyakidon"));
        List<String> t57 = new ArrayList<>(List.of("All California Sushi Platter", "Salmon and Shrimp Tempura Roll", "Tako", "Beef Yakiudon"));
        List<String> t58 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll"));
        List<String> t59 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon", "4 Seasons", "Seaweed Salad", "Chocolate Cake", "Tako", "All California Sushi Platter"));
        List<String> t60 = new ArrayList<>(List.of("Tako", "All California Sushi Platter"));
        List<String> t61 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t62 = new ArrayList<>(List.of("Seaweed Salad", "Tako"));
        List<String> t63 = new ArrayList<>(List.of("Teriyakidon", "Tako", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Teriyakidon", "Tako"));
        List<String> t64 = new ArrayList<>(List.of("Tako", "4 Seasons", "Teriyakidon", "Seaweed Salad"));
        List<String> t65 = new ArrayList<>(List.of("All California Sushi Platter", "Tako", "Chocolate Cake", "Seaweed Salad", "4 Seasons"));
        List<String> t66 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t67 = new ArrayList<>(List.of("Teriyakidon", "Beef Yakiudon", "Seaweed Salad", "Seaweed Salad", "Beef Yakiudon", "All California Sushi Platter"));
        List<String> t68 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon and Shrimp Tempura Roll"));
        List<String> t69 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Tako", "Beef Yakiudon"));
        List<String> t70 = new ArrayList<>(List.of("Teriyakidon", "Seaweed Salad", "Chocolate Cake", "All California Sushi Platter"));
        List<String> t71 = new ArrayList<>(List.of("All California Sushi Platter", "Tako"));
        List<String> t72 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "Seaweed Salad", "Teriyakidon"));
        List<String> t73 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "Tako", "Tako", "Tako", "Tako", "4 Seasons"));
        List<String> t74 = new ArrayList<>(List.of("All California Sushi Platter", "All California Sushi Platter", "4 Seasons", "Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Seaweed Salad"));
        List<String> t75 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t76 = new ArrayList<>(List.of("Chocolate Cake", "4 Seasons"));
        List<String> t77 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Tako", "Salmon and Shrimp Tempura Roll", "4 Seasons"));
        List<String> t78 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "Seaweed Salad"));
        List<String> t79 = new ArrayList<>(List.of("All California Sushi Platter", "Chocolate Cake", "Tako", "All California Sushi Platter", "4 Seasons", "All California Sushi Platter", "All California Sushi Platter"));
        List<String> t80 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Teriyakidon", "Tako", "Seaweed Salad"));
        List<String> t81 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Seaweed Salad"));
        List<String> t82 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "Tako", "Beef Yakiudon"));
        List<String> t83 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad", "Seaweed Salad", "Teriyakidon", "All California Sushi Platter", "Salmon and Shrimp Tempura Roll"));
        List<String> t84 = new ArrayList<>(List.of("Teriyakidon"));
        List<String> t85 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Chocolate Cake"));
        List<String> t86 = new ArrayList<>(List.of("4 Seasons"));
        List<String> t87 = new ArrayList<>(List.of("Teriyakidon", "Tako", "Tako", "4 Seasons", "Beef Yakiudon"));
        List<String> t88 = new ArrayList<>(List.of("Chocolate Cake", "Seaweed Salad", "Teriyakidon"));
        List<String> t89 = new ArrayList<>(List.of("4 Seasons", "Teriyakidon", "Seaweed Salad", "Beef Yakiudon", "Chocolate Cake", "Tako", "Teriyakidon"));
        List<String> t90 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Teriyakidon", "Seaweed Salad"));
        List<String> t91 = new ArrayList<>(List.of("Tako", "All California Sushi Platter"));
        List<String> t92 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "4 Seasons", "Salmon and Shrimp Tempura Roll", "4 Seasons", "Tako", "Seaweed Salad"));
        List<String> t93 = new ArrayList<>(List.of("Seaweed Salad", "Tako"));
        List<String> t94 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "Seaweed Salad", "Seaweed Salad"));
        List<String> t95 = new ArrayList<>(List.of("All California Sushi Platter", "Tako", "Tako", "Teriyakidon", "Beef Yakiudon", "Tako", "All California Sushi Platter"));
        List<String> t96 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "Chocolate Cake", "Tako"));
        List<String> t97 = new ArrayList<>(List.of("Seaweed Salad", "Beef Yakiudon", "Tako", "Beef Yakiudon"));
        List<String> t98 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t99 = new ArrayList<>(List.of("All California Sushi Platter", "All California Sushi Platter", "Chocolate Cake", "Beef Yakiudon", "Tako"));
        List<String> t100 = new ArrayList<>(List.of("4 Seasons", "Teriyakidon"));
        List<String> t101 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t102 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "All California Sushi Platter", "Tako", "Beef Yakiudon"));
        List<String> t103 = new ArrayList<>(List.of("4 Seasons"));
        List<String> t104 = new ArrayList<>(List.of("Tako", "All California Sushi Platter", "Tako"));
        List<String> t105 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll"));
        List<String> t106 = new ArrayList<>(List.of("Beef Yakiudon", "All California Sushi Platter", "Tako"));
        List<String> t107 = new ArrayList<>(List.of("All California Sushi Platter", "Seaweed Salad", "Teriyakidon", "All California Sushi Platter", "Tako"));
        List<String> t108 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t109 = new ArrayList<>(List.of("Teriyakidon", "4 Seasons", "Tako", "Chocolate Cake", "Tako", "Tako", "Tako"));
        List<String> t110 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t111 = new ArrayList<>(List.of("Chocolate Cake", "4 Seasons"));
        List<String> t112 = new ArrayList<>(List.of("Tako", "Beef Yakiudon", "Tako", "All California Sushi Platter", "Teriyakidon", "4 Seasons"));
        List<String> t113 = new ArrayList<>(List.of("4 Seasons", "4 Seasons", "Seaweed Salad"));
        List<String> t114 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Teriyakidon", "Chocolate Cake", "Salmon and Shrimp Tempura Roll"));
        List<String> t115 = new ArrayList<>(List.of("Seaweed Salad", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "All California Sushi Platter"));
        List<String> t116 = new ArrayList<>(List.of("Seaweed Salad", "Beef Yakiudon", "Teriyakidon", "Salmon and Shrimp Tempura Roll", "4 Seasons", "Tako"));
        List<String> t117 = new ArrayList<>(List.of("Teriyakidon", "Teriyakidon"));
        List<String> t118 = new ArrayList<>(List.of("Chocolate Cake", "4 Seasons", "Chocolate Cake", "Tako", "Seaweed Salad"));
        List<String> t119 = new ArrayList<>(List.of("Seaweed Salad", "All California Sushi Platter", "All California Sushi Platter"));
        List<String> t120 = new ArrayList<>(List.of("Tako", "Teriyakidon", "4 Seasons", "Salmon and Shrimp Tempura Roll", "Tako", "Chocolate Cake"));
        List<String> t121 = new ArrayList<>(List.of("Chocolate Cake", "4 Seasons", "All California Sushi Platter"));
        List<String> t122 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t123 = new ArrayList<>(List.of("Tako"));
        List<String> t124 = new ArrayList<>(List.of("Tako"));
        List<String> t125 = new ArrayList<>(List.of("All California Sushi Platter", "Tako"));
        List<String> t126 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Seaweed Salad"));
        List<String> t127 = new ArrayList<>(List.of("Beef Yakiudon", "4 Seasons"));
        List<String> t128 = new ArrayList<>(List.of("Tako", "Chocolate Cake"));
        List<String> t129 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t130 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon", "4 Seasons", "Beef Yakiudon"));
        List<String> t131 = new ArrayList<>(List.of("Tako", "Beef Yakiudon", "Tako", "4 Seasons", "Tako"));
        List<String> t132 = new ArrayList<>(List.of("All California Sushi Platter", "Tako"));
        List<String> t133 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "4 Seasons"));
        List<String> t134 = new ArrayList<>(List.of("Chocolate Cake", "Seaweed Salad", "Teriyakidon", "Tako", "All California Sushi Platter", "Chocolate Cake"));
        List<String> t135 = new ArrayList<>(List.of("Teriyakidon", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Tako", "Tako", "Beef Yakiudon"));
        List<String> t136 = new ArrayList<>(List.of("Tako", "Beef Yakiudon"));
        List<String> t137 = new ArrayList<>(List.of("Beef Yakiudon", "Chocolate Cake", "Tako", "Tako", "Chocolate Cake", "4 Seasons"));
        List<String> t138 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad", "4 Seasons"));
        List<String> t139 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t140 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "All California Sushi Platter", "Tako"));
        List<String> t141 = new ArrayList<>(List.of("Beef Yakiudon", "Chocolate Cake", "Tako", "Tako", "4 Seasons", "Chocolate Cake"));
        List<String> t142 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t143 = new ArrayList<>(List.of("Beef Yakiudon", "4 Seasons", "Tako", "Tako"));
        List<String> t144 = new ArrayList<>(List.of("Seaweed Salad", "All California Sushi Platter", "Tako", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Beef Yakiudon"));
        List<String> t145 = new ArrayList<>(List.of("All California Sushi Platter", "Tako", "All California Sushi Platter"));
        List<String> t146 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t147 = new ArrayList<>(List.of("All California Sushi Platter", "Beef Yakiudon"));
        List<String> t148 = new ArrayList<>(List.of("Tako", "Seaweed Salad"));
        List<String> t149 = new ArrayList<>(List.of("All California Sushi Platter", "4 Seasons"));
        List<String> t150 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t151 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "4 Seasons", "Teriyakidon"));
        List<String> t152 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "Tako", "All California Sushi Platter", "Beef Yakiudon", "Tako", "Seaweed Salad"));
        List<String> t153 = new ArrayList<>(List.of("Teriyakidon", "Beef Yakiudon"));
        List<String> t154 = new ArrayList<>(List.of("Tako", "4 Seasons", "Chocolate Cake", "Beef Yakiudon", "Chocolate Cake", "Tako"));
        List<String> t155 = new ArrayList<>(List.of("Chocolate Cake", "Teriyakidon", "Chocolate Cake", "All California Sushi Platter"));
        List<String> t156 = new ArrayList<>(List.of("Tako"));
        List<String> t157 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "Tako", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "4 Seasons"));
        List<String> t158 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako", "Tako", "Tako", "4 Seasons", "Chocolate Cake", "All California Sushi Platter"));
        List<String> t159 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad", "Seaweed Salad", "4 Seasons", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon"));
        List<String> t160 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon", "4 Seasons", "Tako", "Seaweed Salad", "Tako", "Tako"));
        List<String> t161 = new ArrayList<>(List.of("Teriyakidon", "Tako", "4 Seasons", "4 Seasons"));
        List<String> t162 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "Tako"));
        List<String> t163 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "Seaweed Salad", "Seaweed Salad"));
        List<String> t164 = new ArrayList<>(List.of("All California Sushi Platter", "Teriyakidon", "Teriyakidon", "Seaweed Salad", "Teriyakidon"));
        List<String> t165 = new ArrayList<>(List.of("4 Seasons"));
        List<String> t166 = new ArrayList<>(List.of("Tako", "Chocolate Cake"));
        List<String> t167 = new ArrayList<>(List.of("Chocolate Cake", "Tako"));
        List<String> t168 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "All California Sushi Platter", "Tako"));
        List<String> t169 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t170 = new ArrayList<>(List.of("Teriyakidon", "4 Seasons", "Salmon and Shrimp Tempura Roll", "4 Seasons"));
        List<String> t171 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "Tako", "Seaweed Salad", "Chocolate Cake"));
        List<String> t172 = new ArrayList<>(List.of("4 Seasons", "Chocolate Cake", "Chocolate Cake", "Beef Yakiudon", "All California Sushi Platter"));
        List<String> t173 = new ArrayList<>(List.of("Seaweed Salad", "Chocolate Cake", "Beef Yakiudon", "Chocolate Cake"));
        List<String> t174 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t175 = new ArrayList<>(List.of("All California Sushi Platter", "Beef Yakiudon", "Seaweed Salad"));
        List<String> t176 = new ArrayList<>(List.of("Teriyakidon", "Tako", "4 Seasons", "Salmon and Shrimp Tempura Roll"));
        List<String> t177 = new ArrayList<>(List.of("Seaweed Salad", "Teriyakidon", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Salmon and Shrimp Tempura Roll"));
        List<String> t178 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t179 = new ArrayList<>(List.of("4 Seasons", "All California Sushi Platter", "Tako", "Chocolate Cake", "4 Seasons"));
        List<String> t180 = new ArrayList<>(List.of("Seaweed Salad", "All California Sushi Platter", "Tako"));
        List<String> t181 = new ArrayList<>(List.of("Beef Yakiudon"));
        List<String> t182 = new ArrayList<>(List.of("Seaweed Salad", "Chocolate Cake", "Tako", "Teriyakidon", "Teriyakidon", "Tako", "Seaweed Salad"));
        List<String> t183 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Tako", "Tako", "All California Sushi Platter", "Tako"));
        List<String> t184 = new ArrayList<>(List.of("Tako", "Tako", "4 Seasons"));
        List<String> t185 = new ArrayList<>(List.of("Teriyakidon", "Seaweed Salad", "Seaweed Salad"));
        List<String> t186 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "Tako", "Teriyakidon"));
        List<String> t187 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Seaweed Salad", "All California Sushi Platter", "All California Sushi Platter"));
        List<String> t188 = new ArrayList<>(List.of("All California Sushi Platter", "Tako", "All California Sushi Platter", "Teriyakidon", "4 Seasons", "Chocolate Cake", "Tako"));
        List<String> t189 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "4 Seasons", "Beef Yakiudon"));
        List<String> t190 = new ArrayList<>(List.of("Tako", "All California Sushi Platter"));
        List<String> t191 = new ArrayList<>(List.of("Tako", "Tako", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "All California Sushi Platter", "Chocolate Cake"));
        List<String> t192 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t193 = new ArrayList<>(List.of("Tako", "4 Seasons", "4 Seasons", "Beef Yakiudon"));
        List<String> t194 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako", "All California Sushi Platter", "4 Seasons", "Chocolate Cake", "Tako", "Beef Yakiudon"));
        List<String> t195 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Teriyakidon", "Tako", "Tako", "Seaweed Salad"));
        List<String> t196 = new ArrayList<>(List.of("Tako"));
        List<String> t197 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon and Shrimp Tempura Roll"));
        List<String> t198 = new ArrayList<>(List.of("All California Sushi Platter", "Salmon and Shrimp Tempura Roll", "Tako", "Tako", "Seaweed Salad"));
        List<String> t199 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t200 = new ArrayList<>(List.of("Tako", "Tako", "Tako"));
        List<String> t201 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t202 = new ArrayList<>(List.of("Tako", "Beef Yakiudon"));
        List<String> t203 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad", "Salmon and Shrimp Tempura Roll", "Teriyakidon"));
        List<String> t204 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t205 = new ArrayList<>(List.of("Tako", "Tako", "Seaweed Salad", "Tako", "Teriyakidon"));
        List<String> t206 = new ArrayList<>(List.of("Beef Yakiudon", "All California Sushi Platter"));
        List<String> t207 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t208 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "Tako", "Teriyakidon", "Tako", "4 Seasons", "Seaweed Salad"));
        List<String> t209 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t210 = new ArrayList<>(List.of("Tako", "Beef Yakiudon", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "Salmon and Shrimp Tempura Roll"));
        List<String> t211 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t212 = new ArrayList<>(List.of("Tako", "All California Sushi Platter", "Teriyakidon", "Teriyakidon", "Teriyakidon"));
        List<String> t213 = new ArrayList<>(List.of("Tako", "Teriyakidon", "4 Seasons"));
        List<String> t214 = new ArrayList<>(List.of("Tako", "Teriyakidon", "All California Sushi Platter"));
        List<String> t215 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "Chocolate Cake"));
        List<String> t216 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "Beef Yakiudon", "Teriyakidon"));
        List<String> t217 = new ArrayList<>(List.of("Teriyakidon", "Beef Yakiudon", "Beef Yakiudon"));
        List<String> t218 = new ArrayList<>(List.of("All California Sushi Platter", "Beef Yakiudon"));
        List<String> t219 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon", "Tako", "All California Sushi Platter", "Teriyakidon", "Salmon and Shrimp Tempura Roll"));
        List<String> t220 = new ArrayList<>(List.of("Teriyakidon", "All California Sushi Platter", "All California Sushi Platter", "4 Seasons", "Salmon and Shrimp Tempura Roll", "Teriyakidon"));
        List<String> t221 = new ArrayList<>(List.of("Teriyakidon", "Tako", "Chocolate Cake"));
        List<String> t222 = new ArrayList<>(List.of("All California Sushi Platter", "All California Sushi Platter", "Chocolate Cake"));
        List<String> t223 = new ArrayList<>(List.of("Tako"));
        List<String> t224 = new ArrayList<>(List.of("Tako", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t225 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "Tako", "Tako", "Chocolate Cake"));
        List<String> t226 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "Teriyakidon"));
        List<String> t227 = new ArrayList<>(List.of("Tako", "Beef Yakiudon"));
        List<String> t228 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Chocolate Cake"));
        List<String> t229 = new ArrayList<>(List.of("Chocolate Cake", "Beef Yakiudon", "Teriyakidon", "Seaweed Salad", "Seaweed Salad", "Tako", "Tako"));
        List<String> t230 = new ArrayList<>(List.of("All California Sushi Platter", "Teriyakidon", "All California Sushi Platter", "4 Seasons", "Teriyakidon", "Teriyakidon"));
        List<String> t231 = new ArrayList<>(List.of("Seaweed Salad", "Chocolate Cake", "All California Sushi Platter", "Chocolate Cake", "All California Sushi Platter", "4 Seasons", "Teriyakidon"));
        List<String> t232 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "Beef Yakiudon", "Chocolate Cake", "Beef Yakiudon"));
        List<String> t233 = new ArrayList<>(List.of("All California Sushi Platter", "Tako"));
        List<String> t234 = new ArrayList<>(List.of("4 Seasons", "Tako"));
        List<String> t235 = new ArrayList<>(List.of("Teriyakidon", "Chocolate Cake", "Tako", "Teriyakidon", "Beef Yakiudon", "Teriyakidon", "All California Sushi Platter"));
        List<String> t236 = new ArrayList<>(List.of("Seaweed Salad", "All California Sushi Platter", "Tako", "Salmon and Shrimp Tempura Roll", "Tako", "Salmon and Shrimp Tempura Roll", "Chocolate Cake"));
        List<String> t237 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Beef Yakiudon"));
        List<String> t238 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Teriyakidon", "Beef Yakiudon", "Tako", "All California Sushi Platter", "Tako"));
        List<String> t239 = new ArrayList<>(List.of("Beef Yakiudon", "All California Sushi Platter", "Tako", "Tako"));
        List<String> t240 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad"));
        List<String> t241 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll"));
        List<String> t242 = new ArrayList<>(List.of("Chocolate Cake", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Seaweed Salad", "4 Seasons", "Tako", "Chocolate Cake"));
        List<String> t243 = new ArrayList<>(List.of("4 Seasons", "Teriyakidon", "Teriyakidon", "Tako", "Tako", "Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t244 = new ArrayList<>(List.of("Seaweed Salad", "All California Sushi Platter", "Salmon and Shrimp Tempura Roll"));
        List<String> t245 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t246 = new ArrayList<>(List.of("All California Sushi Platter", "Seaweed Salad"));
        List<String> t247 = new ArrayList<>(List.of("Seaweed Salad", "Beef Yakiudon"));
        List<String> t248 = new ArrayList<>(List.of("Seaweed Salad", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Tako", "Chocolate Cake", "Teriyakidon"));
        List<String> t249 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t250 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t251 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "Tako", "Tako", "Beef Yakiudon", "Seaweed Salad", "4 Seasons"));
        List<String> t252 = new ArrayList<>(List.of("Tako", "Tako", "Seaweed Salad"));
        List<String> t253 = new ArrayList<>(List.of("Chocolate Cake", "Beef Yakiudon", "Chocolate Cake", "Tako", "All California Sushi Platter", "Tako", "Seaweed Salad"));
        List<String> t254 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t255 = new ArrayList<>(List.of("Tako", "All California Sushi Platter"));
        List<String> t256 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t257 = new ArrayList<>(List.of("All California Sushi Platter", "Tako", "Teriyakidon", "All California Sushi Platter"));
        List<String> t258 = new ArrayList<>(List.of("Seaweed Salad", "Salmon and Shrimp Tempura Roll"));
        List<String> t259 = new ArrayList<>(List.of("Tako", "Tako", "Salmon and Shrimp Tempura Roll", "Tako", "Seaweed Salad"));
        List<String> t260 = new ArrayList<>(List.of("Chocolate Cake", "Seaweed Salad"));
        List<String> t261 = new ArrayList<>(List.of("Teriyakidon", "Chocolate Cake", "Seaweed Salad", "All California Sushi Platter", "4 Seasons"));
        List<String> t262 = new ArrayList<>(List.of("All California Sushi Platter", "4 Seasons", "Salmon and Shrimp Tempura Roll"));
        List<String> t263 = new ArrayList<>(List.of("Teriyakidon", "Teriyakidon", "4 Seasons", "Chocolate Cake", "Chocolate Cake", "Tako", "4 Seasons"));
        List<String> t264 = new ArrayList<>(List.of("Tako", "Beef Yakiudon", "Beef Yakiudon", "Seaweed Salad", "Seaweed Salad", "Seaweed Salad"));
        List<String> t265 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t266 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "4 Seasons", "Teriyakidon"));
        List<String> t267 = new ArrayList<>(List.of("Beef Yakiudon", "All California Sushi Platter", "Seaweed Salad", "Seaweed Salad", "Seaweed Salad"));
        List<String> t268 = new ArrayList<>(List.of("Teriyakidon", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter"));
        List<String> t269 = new ArrayList<>(List.of("All California Sushi Platter", "Seaweed Salad", "Tako", "Tako"));
        List<String> t270 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad", "Teriyakidon", "All California Sushi Platter"));
        List<String> t271 = new ArrayList<>(List.of("Chocolate Cake", "Teriyakidon", "Beef Yakiudon", "All California Sushi Platter", "Tako"));
        List<String> t272 = new ArrayList<>(List.of("Tako"));
        List<String> t273 = new ArrayList<>(List.of("Tako", "Tako", "Chocolate Cake", "Chocolate Cake", "Salmon and Shrimp Tempura Roll"));
        List<String> t274 = new ArrayList<>(List.of("4 Seasons", "Tako", "Tako", "Tako", "4 Seasons", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll"));
        List<String> t275 = new ArrayList<>(List.of("Teriyakidon", "Teriyakidon", "Seaweed Salad", "Tako", "Seaweed Salad"));
        List<String> t276 = new ArrayList<>(List.of("Chocolate Cake", "Teriyakidon", "Beef Yakiudon", "Teriyakidon"));
        List<String> t277 = new ArrayList<>(List.of("Tako"));
        List<String> t278 = new ArrayList<>(List.of("Tako"));
        List<String> t279 = new ArrayList<>(List.of("Beef Yakiudon", "Chocolate Cake", "Chocolate Cake", "4 Seasons", "Chocolate Cake"));
        List<String> t280 = new ArrayList<>(List.of("Teriyakidon", "All California Sushi Platter"));
        List<String> t281 = new ArrayList<>(List.of("4 Seasons", "4 Seasons", "Seaweed Salad"));
        List<String> t282 = new ArrayList<>(List.of("Beef Yakiudon", "All California Sushi Platter", "4 Seasons", "4 Seasons", "Beef Yakiudon", "Tako", "Teriyakidon"));
        List<String> t283 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Chocolate Cake", "4 Seasons", "All California Sushi Platter", "Chocolate Cake", "Teriyakidon"));
        List<String> t284 = new ArrayList<>(List.of("4 Seasons", "Teriyakidon"));
        List<String> t285 = new ArrayList<>(List.of("4 Seasons"));
        List<String> t286 = new ArrayList<>(List.of("All California Sushi Platter", "4 Seasons", "Teriyakidon"));
        List<String> t287 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t288 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "All California Sushi Platter", "Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t289 = new ArrayList<>(List.of("Chocolate Cake", "All California Sushi Platter", "Tako", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Seaweed Salad", "Teriyakidon"));
        List<String> t290 = new ArrayList<>(List.of("Beef Yakiudon", "Chocolate Cake", "4 Seasons", "Beef Yakiudon"));
        List<String> t291 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Tako"));
        List<String> t292 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako", "Teriyakidon", "Salmon and Shrimp Tempura Roll"));
        List<String> t293 = new ArrayList<>(List.of("4 Seasons", "Beef Yakiudon"));
        List<String> t294 = new ArrayList<>(List.of("Tako", "Tako", "Chocolate Cake"));
        List<String> t295 = new ArrayList<>(List.of("Tako", "All California Sushi Platter"));
        List<String> t296 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "4 Seasons"));
        List<String> t297 = new ArrayList<>(List.of("All California Sushi Platter", "Beef Yakiudon"));
        List<String> t298 = new ArrayList<>(List.of("Tako"));
        List<String> t299 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t300 = new ArrayList<>(List.of("Teriyakidon", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter"));
        List<String> t301 = new ArrayList<>(List.of("All California Sushi Platter", "Seaweed Salad", "All California Sushi Platter", "Salmon and Shrimp Tempura Roll", "Tako", "4 Seasons", "Salmon and Shrimp Tempura Roll"));
        List<String> t302 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t303 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad", "Salmon and Shrimp Tempura Roll"));
        List<String> t304 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t305 = new ArrayList<>(List.of("Chocolate Cake", "Beef Yakiudon", "Chocolate Cake", "Tako", "Teriyakidon", "4 Seasons", "Teriyakidon"));
        List<String> t306 = new ArrayList<>(List.of("All California Sushi Platter", "Seaweed Salad"));
        List<String> t307 = new ArrayList<>(List.of("Teriyakidon", "Tako", "Tako", "Seaweed Salad"));
        List<String> t308 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "Tako", "4 Seasons"));
        List<String> t309 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Teriyakidon", "Seaweed Salad", "Tako"));
        List<String> t310 = new ArrayList<>(List.of("4 Seasons", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "4 Seasons", "Tako", "Teriyakidon"));
        List<String> t311 = new ArrayList<>(List.of("Beef Yakiudon", "All California Sushi Platter", "Teriyakidon"));
        List<String> t312 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Tako", "4 Seasons", "Tako"));
        List<String> t313 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad"));
        List<String> t314 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t315 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "Tako", "Tako", "Seaweed Salad", "All California Sushi Platter", "4 Seasons"));
        List<String> t316 = new ArrayList<>(List.of("Tako", "Seaweed Salad"));
        List<String> t317 = new ArrayList<>(List.of("Seaweed Salad", "Beef Yakiudon", "Tako", "Seaweed Salad", "All California Sushi Platter", "Chocolate Cake"));
        List<String> t318 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "4 Seasons", "All California Sushi Platter", "Chocolate Cake"));
        List<String> t319 = new ArrayList<>(List.of("Tako", "Tako", "Teriyakidon", "Teriyakidon", "Teriyakidon", "Tako"));
        List<String> t320 = new ArrayList<>(List.of("All California Sushi Platter", "Salmon and Shrimp Tempura Roll", "4 Seasons", "Salmon and Shrimp Tempura Roll"));
        List<String> t321 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t322 = new ArrayList<>(List.of("Seaweed Salad", "4 Seasons"));
        List<String> t323 = new ArrayList<>(List.of("Tako", "Beef Yakiudon"));
        List<String> t324 = new ArrayList<>(List.of("Beef Yakiudon", "Chocolate Cake", "Beef Yakiudon", "4 Seasons", "Beef Yakiudon", "4 Seasons", "Beef Yakiudon"));
        List<String> t325 = new ArrayList<>(List.of("Tako", "Teriyakidon", "Beef Yakiudon", "Tako", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter"));
        List<String> t326 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "4 Seasons", "Beef Yakiudon", "All California Sushi Platter", "4 Seasons"));
        List<String> t327 = new ArrayList<>(List.of("Seaweed Salad", "Beef Yakiudon", "All California Sushi Platter", "Seaweed Salad", "Tako", "4 Seasons"));
        List<String> t328 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon"));
        List<String> t329 = new ArrayList<>(List.of("Teriyakidon", "Seaweed Salad", "Seaweed Salad", "Beef Yakiudon", "All California Sushi Platter"));
        List<String> t330 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "Tako"));
        List<String> t331 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad"));
        List<String> t332 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "Teriyakidon", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Chocolate Cake", "Chocolate Cake"));
        List<String> t333 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "Teriyakidon", "Tako"));
        List<String> t334 = new ArrayList<>(List.of("Beef Yakiudon", "4 Seasons", "Salmon and Shrimp Tempura Roll", "Tako", "Teriyakidon"));
        List<String> t335 = new ArrayList<>(List.of("Beef Yakiudon", "Chocolate Cake", "All California Sushi Platter", "Teriyakidon"));
        List<String> t336 = new ArrayList<>(List.of("Seaweed Salad", "Salmon and Shrimp Tempura Roll"));
        List<String> t337 = new ArrayList<>(List.of("Tako"));
        List<String> t338 = new ArrayList<>(List.of("Tako"));
        List<String> t339 = new ArrayList<>(List.of("Tako", "4 Seasons", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "Seaweed Salad", "Salmon and Shrimp Tempura Roll"));
        List<String> t340 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad", "Beef Yakiudon", "Beef Yakiudon"));
        List<String> t341 = new ArrayList<>(List.of("All California Sushi Platter", "Beef Yakiudon", "All California Sushi Platter", "4 Seasons"));
        List<String> t342 = new ArrayList<>(List.of("Tako", "Beef Yakiudon"));
        List<String> t343 = new ArrayList<>(List.of("Teriyakidon", "Chocolate Cake", "4 Seasons", "Beef Yakiudon", "4 Seasons"));
        List<String> t344 = new ArrayList<>(List.of("Chocolate Cake", "Beef Yakiudon"));
        List<String> t345 = new ArrayList<>(List.of("Tako", "Tako", "Chocolate Cake", "All California Sushi Platter", "Beef Yakiudon", "Seaweed Salad", "Tako"));
        List<String> t346 = new ArrayList<>(List.of("Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "4 Seasons"));
        List<String> t347 = new ArrayList<>(List.of("Seaweed Salad", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "Tako", "Tako"));
        List<String> t348 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Teriyakidon", "Teriyakidon", "4 Seasons", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll"));
        List<String> t349 = new ArrayList<>(List.of("Tako", "All California Sushi Platter", "Tako", "Tako", "4 Seasons"));
        List<String> t350 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Chocolate Cake"));
        List<String> t351 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll"));
        List<String> t352 = new ArrayList<>(List.of("Beef Yakiudon", "Tako"));
        List<String> t353 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad", "All California Sushi Platter", "All California Sushi Platter", "All California Sushi Platter", "Seaweed Salad", "Teriyakidon"));
        List<String> t354 = new ArrayList<>(List.of("4 Seasons", "Beef Yakiudon", "Chocolate Cake"));
        List<String> t355 = new ArrayList<>(List.of("Chocolate Cake", "Seaweed Salad", "Chocolate Cake", "Salmon and Shrimp Tempura Roll"));
        List<String> t356 = new ArrayList<>(List.of("4 Seasons", "Chocolate Cake", "Seaweed Salad", "All California Sushi Platter", "Teriyakidon"));
        List<String> t357 = new ArrayList<>(List.of("Tako", "4 Seasons", "Teriyakidon"));
        List<String> t358 = new ArrayList<>(List.of("Beef Yakiudon", "All California Sushi Platter"));
        List<String> t359 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t360 = new ArrayList<>(List.of("Beef Yakiudon"));
        List<String> t361 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Teriyakidon", "4 Seasons", "Tako"));
        List<String> t362 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t363 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t364 = new ArrayList<>(List.of("Chocolate Cake", "All California Sushi Platter", "All California Sushi Platter", "All California Sushi Platter", "Tako", "Chocolate Cake", "Tako"));
        List<String> t365 = new ArrayList<>(List.of("Seaweed Salad", "4 Seasons", "Chocolate Cake", "4 Seasons", "Chocolate Cake", "Tako"));
        List<String> t366 = new ArrayList<>(List.of("All California Sushi Platter", "Chocolate Cake", "Beef Yakiudon", "Tako"));
        List<String> t367 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad"));
        List<String> t368 = new ArrayList<>(List.of("Beef Yakiudon", "All California Sushi Platter", "Tako", "Teriyakidon"));
        List<String> t369 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "Seaweed Salad", "Chocolate Cake", "All California Sushi Platter", "Teriyakidon"));
        List<String> t370 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t371 = new ArrayList<>(List.of("Tako", "All California Sushi Platter", "Chocolate Cake", "Seaweed Salad"));
        List<String> t372 = new ArrayList<>(List.of("Seaweed Salad", "Beef Yakiudon"));
        List<String> t373 = new ArrayList<>(List.of("Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "All California Sushi Platter"));
        List<String> t374 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "Salmon and Shrimp Tempura Roll", "Seaweed Salad", "All California Sushi Platter", "Seaweed Salad"));
        List<String> t375 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad", "4 Seasons", "Tako", "Beef Yakiudon", "All California Sushi Platter"));
        List<String> t376 = new ArrayList<>(List.of("Seaweed Salad", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "Beef Yakiudon", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "4 Seasons"));
        List<String> t377 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "Tako", "Teriyakidon", "Tako", "4 Seasons", "Tako"));
        List<String> t378 = new ArrayList<>(List.of("4 Seasons", "Salmon and Shrimp Tempura Roll", "4 Seasons", "Salmon and Shrimp Tempura Roll"));
        List<String> t379 = new ArrayList<>(List.of("Tako", "All California Sushi Platter", "Teriyakidon", "Tako", "Salmon and Shrimp Tempura Roll", "Tako", "Teriyakidon"));
        List<String> t380 = new ArrayList<>(List.of("Beef Yakiudon", "All California Sushi Platter"));
        List<String> t381 = new ArrayList<>(List.of("Teriyakidon", "Tako", "Teriyakidon", "Beef Yakiudon", "Tako"));
        List<String> t382 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Teriyakidon", "Teriyakidon", "Chocolate Cake"));
        List<String> t383 = new ArrayList<>(List.of("Beef Yakiudon", "All California Sushi Platter", "Teriyakidon"));
        List<String> t384 = new ArrayList<>(List.of("Chocolate Cake", "4 Seasons"));
        List<String> t385 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad", "Tako", "Seaweed Salad", "Beef Yakiudon"));
        List<String> t386 = new ArrayList<>(List.of("Tako", "4 Seasons", "Chocolate Cake", "Chocolate Cake", "All California Sushi Platter"));
        List<String> t387 = new ArrayList<>(List.of("Beef Yakiudon"));
        List<String> t388 = new ArrayList<>(List.of("Tako"));
        List<String> t389 = new ArrayList<>(List.of("Tako", "Beef Yakiudon", "Teriyakidon", "Seaweed Salad"));
        List<String> t390 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon", "Beef Yakiudon", "Seaweed Salad", "Tako", "All California Sushi Platter"));
        List<String> t391 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "Teriyakidon", "Salmon and Shrimp Tempura Roll", "4 Seasons", "Teriyakidon", "Teriyakidon"));
        List<String> t392 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t393 = new ArrayList<>(List.of("Beef Yakiudon"));
        List<String> t394 = new ArrayList<>(List.of("4 Seasons", "Teriyakidon", "4 Seasons", "Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t395 = new ArrayList<>(List.of("Beef Yakiudon"));
        List<String> t396 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t397 = new ArrayList<>(List.of("Tako"));
        List<String> t398 = new ArrayList<>(List.of("Tako", "Tako", "Chocolate Cake", "4 Seasons"));
        List<String> t399 = new ArrayList<>(List.of("4 Seasons", "Salmon and Shrimp Tempura Roll"));
        List<String> t400 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "All California Sushi Platter"));
        List<String> t401 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako", "Salmon and Shrimp Tempura Roll", "4 Seasons"));
        List<String> t402 = new ArrayList<>(List.of("Seaweed Salad", "Chocolate Cake", "All California Sushi Platter", "Seaweed Salad", "Chocolate Cake"));
        List<String> t403 = new ArrayList<>(List.of("Teriyakidon", "Tako", "Tako", "Teriyakidon"));
        List<String> t404 = new ArrayList<>(List.of("Teriyakidon", "Seaweed Salad", "4 Seasons"));
        List<String> t405 = new ArrayList<>(List.of("All California Sushi Platter", "All California Sushi Platter", "Teriyakidon"));
        List<String> t406 = new ArrayList<>(List.of("Chocolate Cake", "Teriyakidon", "All California Sushi Platter", "Salmon and Shrimp Tempura Roll", "4 Seasons"));
        List<String> t407 = new ArrayList<>(List.of("4 Seasons", "Salmon and Shrimp Tempura Roll", "Tako", "4 Seasons", "Teriyakidon", "All California Sushi Platter", "Chocolate Cake"));
        List<String> t408 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t409 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako", "Beef Yakiudon", "4 Seasons"));
        List<String> t410 = new ArrayList<>(List.of("Beef Yakiudon", "Teriyakidon", "Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Tako", "Seaweed Salad", "Tako"));
        List<String> t411 = new ArrayList<>(List.of("Chocolate Cake", "Seaweed Salad", "Teriyakidon", "All California Sushi Platter", "Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t412 = new ArrayList<>(List.of("4 Seasons"));
        List<String> t413 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako", "Beef Yakiudon"));
        List<String> t414 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "Tako"));
        List<String> t415 = new ArrayList<>(List.of("Tako", "Seaweed Salad"));
        List<String> t416 = new ArrayList<>(List.of("Beef Yakiudon", "Tako"));
        List<String> t417 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon and Shrimp Tempura Roll"));
        List<String> t418 = new ArrayList<>(List.of("Tako", "Beef Yakiudon"));
        List<String> t419 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t420 = new ArrayList<>(List.of("Tako"));
        List<String> t421 = new ArrayList<>(List.of("Chocolate Cake", "Beef Yakiudon", "All California Sushi Platter", "Tako", "Teriyakidon", "Beef Yakiudon"));
        List<String> t422 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "Tako", "Tako"));
        List<String> t423 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll"));
        List<String> t424 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "Teriyakidon", "Seaweed Salad", "Tako", "Seaweed Salad"));
        List<String> t425 = new ArrayList<>(List.of("Chocolate Cake", "Seaweed Salad"));
        List<String> t426 = new ArrayList<>(List.of("Tako", "4 Seasons", "Teriyakidon", "Teriyakidon", "Salmon and Shrimp Tempura Roll", "4 Seasons"));
        List<String> t427 = new ArrayList<>(List.of("Tako"));
        List<String> t428 = new ArrayList<>(List.of("All California Sushi Platter", "Tako", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon"));
        List<String> t429 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t430 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Teriyakidon", "4 Seasons"));
        List<String> t431 = new ArrayList<>(List.of("4 Seasons", "Beef Yakiudon", "All California Sushi Platter", "4 Seasons"));
        List<String> t432 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad", "Beef Yakiudon", "Beef Yakiudon"));
        List<String> t433 = new ArrayList<>(List.of("Seaweed Salad", "Teriyakidon", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Seaweed Salad", "Teriyakidon"));
        List<String> t434 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako", "Chocolate Cake", "Chocolate Cake", "Seaweed Salad"));
        List<String> t435 = new ArrayList<>(List.of("4 Seasons", "All California Sushi Platter"));
        List<String> t436 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Beef Yakiudon", "Teriyakidon", "All California Sushi Platter"));
        List<String> t437 = new ArrayList<>(List.of("Chocolate Cake", "All California Sushi Platter", "Teriyakidon", "Chocolate Cake"));
        List<String> t438 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "Tako", "All California Sushi Platter", "Seaweed Salad"));
        List<String> t439 = new ArrayList<>(List.of("Seaweed Salad", "Beef Yakiudon", "Tako"));
        List<String> t440 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Beef Yakiudon"));
        List<String> t441 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Seaweed Salad"));
        List<String> t442 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Tako", "Chocolate Cake", "All California Sushi Platter"));
        List<String> t443 = new ArrayList<>(List.of("Chocolate Cake", "4 Seasons", "Seaweed Salad", "Tako", "Beef Yakiudon", "Chocolate Cake", "Tako"));
        List<String> t444 = new ArrayList<>(List.of("Tako", "Tako", "Beef Yakiudon"));
        List<String> t445 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad", "Beef Yakiudon", "4 Seasons", "All California Sushi Platter", "Seaweed Salad", "Salmon and Shrimp Tempura Roll"));
        List<String> t446 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "Seaweed Salad", "Seaweed Salad", "4 Seasons", "Beef Yakiudon"));
        List<String> t447 = new ArrayList<>(List.of("Seaweed Salad", "Teriyakidon", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Chocolate Cake"));
        List<String> t448 = new ArrayList<>(List.of("All California Sushi Platter", "Teriyakidon", "Teriyakidon", "All California Sushi Platter", "4 Seasons", "Chocolate Cake", "Teriyakidon"));
        List<String> t449 = new ArrayList<>(List.of("Teriyakidon", "Tako", "Chocolate Cake", "All California Sushi Platter"));
        List<String> t450 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "Chocolate Cake", "Chocolate Cake", "All California Sushi Platter", "Beef Yakiudon"));
        List<String> t451 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako", "All California Sushi Platter"));
        List<String> t452 = new ArrayList<>(List.of("4 Seasons", "All California Sushi Platter", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "Tako", "Teriyakidon"));
        List<String> t453 = new ArrayList<>(List.of("Tako"));
        List<String> t454 = new ArrayList<>(List.of("Tako", "Tako", "Tako", "Tako", "Beef Yakiudon", "Tako"));
        List<String> t455 = new ArrayList<>(List.of("Tako", "Teriyakidon", "4 Seasons", "Tako", "4 Seasons", "Seaweed Salad", "Teriyakidon"));
        List<String> t456 = new ArrayList<>(List.of("Beef Yakiudon", "All California Sushi Platter"));
        List<String> t457 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t458 = new ArrayList<>(List.of("Tako", "Beef Yakiudon", "Chocolate Cake", "Teriyakidon", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll"));
        List<String> t459 = new ArrayList<>(List.of("Tako", "All California Sushi Platter", "Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t460 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "All California Sushi Platter"));
        List<String> t461 = new ArrayList<>(List.of("Beef Yakiudon", "Tako"));
        List<String> t462 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Beef Yakiudon", "Beef Yakiudon", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll"));
        List<String> t463 = new ArrayList<>(List.of("Teriyakidon", "Tako"));
        List<String> t464 = new ArrayList<>(List.of("4 Seasons", "All California Sushi Platter", "Salmon and Shrimp Tempura Roll"));
        List<String> t465 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Seaweed Salad"));
        List<String> t466 = new ArrayList<>(List.of("Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter"));
        List<String> t467 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "Chocolate Cake", "Tako"));
        List<String> t468 = new ArrayList<>(List.of("All California Sushi Platter", "Salmon and Shrimp Tempura Roll", "Tako", "Tako"));
        List<String> t469 = new ArrayList<>(List.of("Chocolate Cake", "4 Seasons", "4 Seasons", "Tako"));
        List<String> t470 = new ArrayList<>(List.of("Beef Yakiudon", "Chocolate Cake"));
        List<String> t471 = new ArrayList<>(List.of("4 Seasons", "Chocolate Cake", "Tako", "Tako", "Teriyakidon", "Seaweed Salad"));
        List<String> t472 = new ArrayList<>(List.of("Tako", "Tako", "All California Sushi Platter", "Seaweed Salad"));
        List<String> t473 = new ArrayList<>(List.of("4 Seasons", "Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t474 = new ArrayList<>(List.of("Tako", "Beef Yakiudon", "Seaweed Salad", "Seaweed Salad", "Seaweed Salad"));
        List<String> t475 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Tako"));
        List<String> t476 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "4 Seasons", "All California Sushi Platter", "All California Sushi Platter", "All California Sushi Platter"));
        List<String> t477 = new ArrayList<>(List.of("4 Seasons", "Tako", "Tako", "4 Seasons", "Tako"));
        List<String> t478 = new ArrayList<>(List.of("All California Sushi Platter", "Salmon and Shrimp Tempura Roll"));
        List<String> t479 = new ArrayList<>(List.of("Tako"));
        List<String> t480 = new ArrayList<>(List.of("Chocolate Cake", "Teriyakidon"));
        List<String> t481 = new ArrayList<>(List.of("Seaweed Salad", "4 Seasons", "Seaweed Salad", "Teriyakidon", "4 Seasons", "Chocolate Cake", "Tako"));
        List<String> t482 = new ArrayList<>(List.of("Chocolate Cake", "Salmon and Shrimp Tempura Roll", "4 Seasons", "Salmon and Shrimp Tempura Roll", "4 Seasons", "Chocolate Cake"));
        List<String> t483 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako", "Chocolate Cake"));
        List<String> t484 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "Salmon and Shrimp Tempura Roll"));
        List<String> t485 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "4 Seasons", "Seaweed Salad", "Chocolate Cake", "Beef Yakiudon"));
        List<String> t486 = new ArrayList<>(List.of("Teriyakidon"));
        List<String> t487 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad", "All California Sushi Platter", "All California Sushi Platter"));
        List<String> t488 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll"));
        List<String> t489 = new ArrayList<>(List.of("Teriyakidon", "Seaweed Salad", "Seaweed Salad", "Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Seaweed Salad"));
        List<String> t490 = new ArrayList<>(List.of("Chocolate Cake", "All California Sushi Platter", "Tako", "Beef Yakiudon"));
        List<String> t491 = new ArrayList<>(List.of("Beef Yakiudon", "4 Seasons", "Seaweed Salad"));
        List<String> t492 = new ArrayList<>(List.of("Chocolate Cake", "Teriyakidon", "Teriyakidon"));
        List<String> t493 = new ArrayList<>(List.of("Tako", "Beef Yakiudon"));
        List<String> t494 = new ArrayList<>(List.of("Tako"));
        List<String> t495 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "All California Sushi Platter"));
        List<String> t496 = new ArrayList<>(List.of("Teriyakidon", "Seaweed Salad", "Tako", "Chocolate Cake"));
        List<String> t497 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t498 = new ArrayList<>(List.of("All California Sushi Platter", "Seaweed Salad", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Tako", "Salmon and Shrimp Tempura Roll", "Chocolate Cake"));
        List<String> t499 = new ArrayList<>(List.of("All California Sushi Platter", "Beef Yakiudon", "All California Sushi Platter"));
        List<String> t500 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll"));
        List<String> t501 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t502 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "4 Seasons", "Chocolate Cake"));
        List<String> t503 = new ArrayList<>(List.of("Tako"));
        List<String> t504 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Beef Yakiudon", "Seaweed Salad", "Chocolate Cake", "Chocolate Cake", "Teriyakidon"));
        List<String> t505 = new ArrayList<>(List.of("Tako"));
        List<String> t506 = new ArrayList<>(List.of("Tako", "4 Seasons", "Chocolate Cake", "Tako"));
        List<String> t507 = new ArrayList<>(List.of("Tako"));
        List<String> t508 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Beef Yakiudon", "Teriyakidon", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "Tako"));
        List<String> t509 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Seaweed Salad"));
        List<String> t510 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll"));
        List<String> t511 = new ArrayList<>(List.of("Tako", "4 Seasons"));
        List<String> t512 = new ArrayList<>(List.of("Beef Yakiudon", "All California Sushi Platter", "Beef Yakiudon", "Chocolate Cake"));
        List<String> t513 = new ArrayList<>(List.of("Tako", "4 Seasons", "Tako", "4 Seasons"));
        List<String> t514 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "Beef Yakiudon", "Teriyakidon", "Beef Yakiudon", "Tako", "Teriyakidon"));
        List<String> t515 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "Teriyakidon"));
        List<String> t516 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t517 = new ArrayList<>(List.of("All California Sushi Platter", "Salmon and Shrimp Tempura Roll", "4 Seasons", "Chocolate Cake", "Seaweed Salad", "Tako"));
        List<String> t518 = new ArrayList<>(List.of("Tako", "Teriyakidon", "Seaweed Salad", "4 Seasons", "Tako"));
        List<String> t519 = new ArrayList<>(List.of("Tako"));
        List<String> t520 = new ArrayList<>(List.of("All California Sushi Platter", "Teriyakidon"));
        List<String> t521 = new ArrayList<>(List.of("Chocolate Cake", "4 Seasons", "Teriyakidon", "4 Seasons"));
        List<String> t522 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t523 = new ArrayList<>(List.of("All California Sushi Platter", "Tako", "Tako", "4 Seasons"));
        List<String> t524 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t525 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako", "Chocolate Cake", "Tako", "Seaweed Salad", "Seaweed Salad"));
        List<String> t526 = new ArrayList<>(List.of("Tako", "All California Sushi Platter"));
        List<String> t527 = new ArrayList<>(List.of("4 Seasons", "Salmon and Shrimp Tempura Roll"));
        List<String> t528 = new ArrayList<>(List.of("Tako", "4 Seasons", "Tako"));
        List<String> t529 = new ArrayList<>(List.of("Tako", "4 Seasons", "Chocolate Cake", "Teriyakidon", "Tako", "Teriyakidon", "Seaweed Salad"));
        List<String> t530 = new ArrayList<>(List.of("Chocolate Cake", "Seaweed Salad", "Seaweed Salad", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll"));
        List<String> t531 = new ArrayList<>(List.of("Tako", "Beef Yakiudon", "Tako"));
        List<String> t532 = new ArrayList<>(List.of("Tako", "Tako", "Chocolate Cake"));
        List<String> t533 = new ArrayList<>(List.of("All California Sushi Platter", "Teriyakidon"));
        List<String> t534 = new ArrayList<>(List.of("Tako", "Seaweed Salad"));
        List<String> t535 = new ArrayList<>(List.of("Seaweed Salad", "Tako"));
        List<String> t536 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad", "All California Sushi Platter", "Beef Yakiudon"));
        List<String> t537 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "4 Seasons", "Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t538 = new ArrayList<>(List.of("All California Sushi Platter", "Salmon and Shrimp Tempura Roll"));
        List<String> t539 = new ArrayList<>(List.of("Beef Yakiudon", "All California Sushi Platter", "Seaweed Salad", "4 Seasons"));
        List<String> t540 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Tako", "Tako", "Tako", "Beef Yakiudon"));
        List<String> t541 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t542 = new ArrayList<>(List.of("Seaweed Salad", "4 Seasons", "Teriyakidon", "All California Sushi Platter", "Tako", "Teriyakidon", "Chocolate Cake"));
        List<String> t543 = new ArrayList<>(List.of("Teriyakidon", "Salmon and Shrimp Tempura Roll", "Tako", "Seaweed Salad", "Teriyakidon", "4 Seasons", "Salmon and Shrimp Tempura Roll"));
        List<String> t544 = new ArrayList<>(List.of("Chocolate Cake", "4 Seasons", "Salmon and Shrimp Tempura Roll", "Tako", "Chocolate Cake"));
        List<String> t545 = new ArrayList<>(List.of("Chocolate Cake", "Teriyakidon", "Teriyakidon", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Beef Yakiudon"));
        List<String> t546 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "Teriyakidon"));
        List<String> t547 = new ArrayList<>(List.of("All California Sushi Platter", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t548 = new ArrayList<>(List.of("4 Seasons", "4 Seasons", "Seaweed Salad", "4 Seasons", "Beef Yakiudon"));
        List<String> t549 = new ArrayList<>(List.of("All California Sushi Platter", "Beef Yakiudon"));
        List<String> t550 = new ArrayList<>(List.of("Tako"));
        List<String> t551 = new ArrayList<>(List.of("Tako", "Seaweed Salad"));
        List<String> t552 = new ArrayList<>(List.of("Beef Yakiudon", "4 Seasons", "Seaweed Salad", "Seaweed Salad", "Tako", "Chocolate Cake", "Teriyakidon"));
        List<String> t553 = new ArrayList<>(List.of("Tako", "Beef Yakiudon"));
        List<String> t554 = new ArrayList<>(List.of("Teriyakidon", "4 Seasons", "Teriyakidon"));
        List<String> t555 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t556 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t557 = new ArrayList<>(List.of("Teriyakidon", "Seaweed Salad", "4 Seasons"));
        List<String> t558 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "4 Seasons", "Teriyakidon", "Seaweed Salad", "All California Sushi Platter", "4 Seasons"));
        List<String> t559 = new ArrayList<>(List.of("Tako", "Seaweed Salad"));
        List<String> t560 = new ArrayList<>(List.of("All California Sushi Platter", "All California Sushi Platter", "All California Sushi Platter", "Chocolate Cake", "Teriyakidon", "Seaweed Salad", "4 Seasons"));
        List<String> t561 = new ArrayList<>(List.of("Tako", "Beef Yakiudon", "Chocolate Cake", "All California Sushi Platter", "4 Seasons"));
        List<String> t562 = new ArrayList<>(List.of("Tako", "Tako", "Teriyakidon", "Tako", "Teriyakidon", "Tako", "Chocolate Cake"));
        List<String> t563 = new ArrayList<>(List.of("4 Seasons", "All California Sushi Platter", "All California Sushi Platter", "Beef Yakiudon", "Tako", "Beef Yakiudon"));
        List<String> t564 = new ArrayList<>(List.of("4 Seasons", "Tako", "Chocolate Cake", "Beef Yakiudon", "Beef Yakiudon", "Beef Yakiudon", "Seaweed Salad"));
        List<String> t565 = new ArrayList<>(List.of("4 Seasons", "Teriyakidon", "All California Sushi Platter", "Salmon and Shrimp Tempura Roll", "Tako", "Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t566 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t567 = new ArrayList<>(List.of("Chocolate Cake", "Beef Yakiudon", "Chocolate Cake", "All California Sushi Platter"));
        List<String> t568 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad", "Beef Yakiudon"));
        List<String> t569 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t570 = new ArrayList<>(List.of("Tako"));
        List<String> t571 = new ArrayList<>(List.of("Teriyakidon"));
        List<String> t572 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "4 Seasons", "Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Beef Yakiudon"));
        List<String> t573 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "Beef Yakiudon", "Seaweed Salad", "Chocolate Cake"));
        List<String> t574 = new ArrayList<>(List.of("All California Sushi Platter", "Tako", "Tako", "All California Sushi Platter"));
        List<String> t575 = new ArrayList<>(List.of("Teriyakidon", "All California Sushi Platter", "Chocolate Cake", "Beef Yakiudon", "Tako", "Beef Yakiudon"));
        List<String> t576 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t577 = new ArrayList<>(List.of("Beef Yakiudon", "4 Seasons", "Teriyakidon", "Seaweed Salad"));
        List<String> t578 = new ArrayList<>(List.of("Beef Yakiudon", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "Tako", "Teriyakidon"));
        List<String> t579 = new ArrayList<>(List.of("Tako"));
        List<String> t580 = new ArrayList<>(List.of("All California Sushi Platter", "Seaweed Salad", "Beef Yakiudon"));
        List<String> t581 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad", "All California Sushi Platter", "Chocolate Cake"));
        List<String> t582 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t583 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad"));
        List<String> t584 = new ArrayList<>(List.of("Beef Yakiudon", "Chocolate Cake"));
        List<String> t585 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "Tako"));
        List<String> t586 = new ArrayList<>(List.of("4 Seasons", "Tako", "Teriyakidon", "4 Seasons"));
        List<String> t587 = new ArrayList<>(List.of("Tako", "Tako", "Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll"));
        List<String> t588 = new ArrayList<>(List.of("Teriyakidon", "Beef Yakiudon", "All California Sushi Platter", "Beef Yakiudon", "Chocolate Cake", "Beef Yakiudon"));
        List<String> t589 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t590 = new ArrayList<>(List.of("Tako", "Seaweed Salad"));
        List<String> t591 = new ArrayList<>(List.of("Teriyakidon", "Teriyakidon"));
        List<String> t592 = new ArrayList<>(List.of("All California Sushi Platter", "Tako"));
        List<String> t593 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad", "Tako"));
        List<String> t594 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "Tako", "Tako"));
        List<String> t595 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "Teriyakidon", "All California Sushi Platter", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll"));
        List<String> t596 = new ArrayList<>(List.of("4 Seasons"));
        List<String> t597 = new ArrayList<>(List.of("All California Sushi Platter", "Seaweed Salad", "Tako", "Seaweed Salad", "4 Seasons", "Beef Yakiudon", "Beef Yakiudon"));
        List<String> t598 = new ArrayList<>(List.of("4 Seasons", "All California Sushi Platter", "All California Sushi Platter", "Chocolate Cake", "4 Seasons", "Tako", "Teriyakidon"));
        List<String> t599 = new ArrayList<>(List.of("Teriyakidon"));
        List<String> t600 = new ArrayList<>(List.of("Tako", "Seaweed Salad"));
        List<String> t601 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Teriyakidon", "All California Sushi Platter", "Chocolate Cake", "Beef Yakiudon"));
        List<String> t602 = new ArrayList<>(List.of("All California Sushi Platter", "Tako", "Beef Yakiudon"));
        List<String> t603 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Teriyakidon", "Seaweed Salad", "Beef Yakiudon"));
        List<String> t604 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad", "Tako", "Seaweed Salad", "Seaweed Salad", "Salmon and Shrimp Tempura Roll"));
        List<String> t605 = new ArrayList<>(List.of("Tako"));
        List<String> t606 = new ArrayList<>(List.of("All California Sushi Platter", "Beef Yakiudon"));
        List<String> t607 = new ArrayList<>(List.of("Tako", "All California Sushi Platter", "Tako", "Tako"));
        List<String> t608 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t609 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll"));
        List<String> t610 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "4 Seasons", "Seaweed Salad", "Seaweed Salad", "4 Seasons", "Teriyakidon"));
        List<String> t611 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon", "Seaweed Salad"));
        List<String> t612 = new ArrayList<>(List.of("Chocolate Cake", "All California Sushi Platter", "Seaweed Salad"));
        List<String> t613 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "4 Seasons"));
        List<String> t614 = new ArrayList<>(List.of("Teriyakidon", "Beef Yakiudon"));
        List<String> t615 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Teriyakidon", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon"));
        List<String> t616 = new ArrayList<>(List.of("Teriyakidon", "Seaweed Salad", "Salmon and Shrimp Tempura Roll", "Tako", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter"));
        List<String> t617 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t618 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "All California Sushi Platter", "Tako", "4 Seasons", "Teriyakidon"));
        List<String> t619 = new ArrayList<>(List.of("Seaweed Salad", "All California Sushi Platter"));
        List<String> t620 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Beef Yakiudon"));
        List<String> t621 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad"));
        List<String> t622 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako", "Tako", "Seaweed Salad", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "Tako"));
        List<String> t623 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Tako", "Tako", "Chocolate Cake", "4 Seasons"));
        List<String> t624 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "Teriyakidon", "Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t625 = new ArrayList<>(List.of("Beef Yakiudon", "All California Sushi Platter"));
        List<String> t626 = new ArrayList<>(List.of("Tako", "4 Seasons", "Chocolate Cake", "Tako", "Teriyakidon", "All California Sushi Platter"));
        List<String> t627 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "Beef Yakiudon"));
        List<String> t628 = new ArrayList<>(List.of("Tako", "Tako", "Teriyakidon", "4 Seasons", "Seaweed Salad"));
        List<String> t629 = new ArrayList<>(List.of("4 Seasons", "4 Seasons", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll"));
        List<String> t630 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "Tako", "Beef Yakiudon", "Teriyakidon"));
        List<String> t631 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad"));
        List<String> t632 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "4 Seasons"));
        List<String> t633 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t634 = new ArrayList<>(List.of("Chocolate Cake", "Teriyakidon", "Beef Yakiudon"));
        List<String> t635 = new ArrayList<>(List.of("Teriyakidon", "Seaweed Salad", "4 Seasons", "Chocolate Cake", "Salmon and Shrimp Tempura Roll"));
        List<String> t636 = new ArrayList<>(List.of("4 Seasons", "Tako", "Seaweed Salad"));
        List<String> t637 = new ArrayList<>(List.of("4 Seasons", "Tako", "4 Seasons", "Chocolate Cake", "4 Seasons", "Chocolate Cake", "4 Seasons"));
        List<String> t638 = new ArrayList<>(List.of("Tako"));
        List<String> t639 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t640 = new ArrayList<>(List.of("Tako", "All California Sushi Platter", "Seaweed Salad", "4 Seasons", "Beef Yakiudon", "Tako", "All California Sushi Platter"));
        List<String> t641 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "4 Seasons", "Teriyakidon", "Teriyakidon", "Tako"));
        List<String> t642 = new ArrayList<>(List.of("Beef Yakiudon"));
        List<String> t643 = new ArrayList<>(List.of("4 Seasons"));
        List<String> t644 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako", "Chocolate Cake", "Salmon and Shrimp Tempura Roll"));
        List<String> t645 = new ArrayList<>(List.of("Seaweed Salad", "All California Sushi Platter", "Seaweed Salad", "Seaweed Salad", "Seaweed Salad"));
        List<String> t646 = new ArrayList<>(List.of("All California Sushi Platter", "Seaweed Salad", "Seaweed Salad", "4 Seasons", "Beef Yakiudon", "Beef Yakiudon", "Seaweed Salad"));
        List<String> t647 = new ArrayList<>(List.of("Chocolate Cake", "Beef Yakiudon", "Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t648 = new ArrayList<>(List.of("Tako", "Seaweed Salad"));
        List<String> t649 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako", "Seaweed Salad", "Teriyakidon", "Beef Yakiudon", "Chocolate Cake", "Tako"));
        List<String> t650 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t651 = new ArrayList<>(List.of("Seaweed Salad", "Beef Yakiudon"));
        List<String> t652 = new ArrayList<>(List.of("Teriyakidon", "Tako", "Tako", "Seaweed Salad", "Teriyakidon", "All California Sushi Platter", "Salmon and Shrimp Tempura Roll"));
        List<String> t653 = new ArrayList<>(List.of("Beef Yakiudon", "Chocolate Cake", "Tako", "All California Sushi Platter", "Tako"));
        List<String> t654 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Tako", "Seaweed Salad", "4 Seasons"));
        List<String> t655 = new ArrayList<>(List.of("4 Seasons", "Teriyakidon"));
        List<String> t656 = new ArrayList<>(List.of("Chocolate Cake", "4 Seasons", "All California Sushi Platter", "All California Sushi Platter"));
        List<String> t657 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "Chocolate Cake"));
        List<String> t658 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Tako", "All California Sushi Platter", "4 Seasons"));
        List<String> t659 = new ArrayList<>(List.of("Chocolate Cake", "Teriyakidon", "Tako", "Teriyakidon", "Chocolate Cake", "Beef Yakiudon", "Beef Yakiudon"));
        List<String> t660 = new ArrayList<>(List.of("Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Chocolate Cake"));
        List<String> t661 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll"));
        List<String> t662 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako", "Tako", "Tako", "All California Sushi Platter"));
        List<String> t663 = new ArrayList<>(List.of("Seaweed Salad", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "Seaweed Salad", "Tako", "Teriyakidon"));
        List<String> t664 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad", "Tako", "4 Seasons", "4 Seasons"));
        List<String> t665 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Seaweed Salad", "Teriyakidon", "Teriyakidon", "Teriyakidon", "Tako"));
        List<String> t666 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t667 = new ArrayList<>(List.of("Teriyakidon", "Chocolate Cake", "Teriyakidon", "All California Sushi Platter", "4 Seasons"));
        List<String> t668 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Chocolate Cake", "Tako", "Chocolate Cake"));
        List<String> t669 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad", "Tako", "Beef Yakiudon", "Chocolate Cake"));
        List<String> t670 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "Beef Yakiudon", "Tako", "Tako", "Tako", "Beef Yakiudon"));
        List<String> t671 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll"));
        List<String> t672 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad", "All California Sushi Platter", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll", "Seaweed Salad"));
        List<String> t673 = new ArrayList<>(List.of("Teriyakidon", "Tako"));
        List<String> t674 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t675 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t676 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "Beef Yakiudon", "Tako"));
        List<String> t677 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t678 = new ArrayList<>(List.of("All California Sushi Platter", "All California Sushi Platter"));
        List<String> t679 = new ArrayList<>(List.of("Tako", "Tako", "Tako", "4 Seasons", "Chocolate Cake", "Tako", "All California Sushi Platter"));
        List<String> t680 = new ArrayList<>(List.of("Tako"));
        List<String> t681 = new ArrayList<>(List.of("4 Seasons"));
        List<String> t682 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Chocolate Cake", "4 Seasons", "Beef Yakiudon", "Teriyakidon", "Salmon and Shrimp Tempura Roll"));
        List<String> t683 = new ArrayList<>(List.of("All California Sushi Platter", "Tako"));
        List<String> t684 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Chocolate Cake", "Chocolate Cake", "Chocolate Cake"));
        List<String> t685 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "4 Seasons", "All California Sushi Platter", "Chocolate Cake"));
        List<String> t686 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Beef Yakiudon"));
        List<String> t687 = new ArrayList<>(List.of("Beef Yakiudon", "Chocolate Cake"));
        List<String> t688 = new ArrayList<>(List.of("Beef Yakiudon", "4 Seasons", "Salmon and Shrimp Tempura Roll", "Tako", "Chocolate Cake", "Tako", "Chocolate Cake"));
        List<String> t689 = new ArrayList<>(List.of("Chocolate Cake", "All California Sushi Platter", "All California Sushi Platter"));
        List<String> t690 = new ArrayList<>(List.of("Seaweed Salad", "Teriyakidon"));
        List<String> t691 = new ArrayList<>(List.of("All California Sushi Platter", "Tako", "All California Sushi Platter"));
        List<String> t692 = new ArrayList<>(List.of("Tako", "Tako", "Tako", "Tako"));
        List<String> t693 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Tako", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter"));
        List<String> t694 = new ArrayList<>(List.of("Beef Yakiudon", "Tako"));
        List<String> t695 = new ArrayList<>(List.of("All California Sushi Platter", "Tako", "Seaweed Salad", "Tako", "Beef Yakiudon", "Beef Yakiudon", "Chocolate Cake"));
        List<String> t696 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t697 = new ArrayList<>(List.of("Teriyakidon", "Seaweed Salad", "4 Seasons", "All California Sushi Platter", "All California Sushi Platter", "Tako", "Tako"));
        List<String> t698 = new ArrayList<>(List.of("Seaweed Salad", "All California Sushi Platter", "Seaweed Salad", "Chocolate Cake"));
        List<String> t699 = new ArrayList<>(List.of("Tako"));
        List<String> t700 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t701 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "Seaweed Salad"));
        List<String> t702 = new ArrayList<>(List.of("Tako", "Tako", "4 Seasons"));
        List<String> t703 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Chocolate Cake", "4 Seasons", "Tako", "All California Sushi Platter", "Chocolate Cake", "Teriyakidon"));
        List<String> t704 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "Seaweed Salad", "Seaweed Salad", "Beef Yakiudon", "Seaweed Salad", "Tako"));
        List<String> t705 = new ArrayList<>(List.of("Tako"));
        List<String> t706 = new ArrayList<>(List.of("Tako", "Seaweed Salad"));
        List<String> t707 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako", "Teriyakidon", "4 Seasons"));
        List<String> t708 = new ArrayList<>(List.of("4 Seasons", "All California Sushi Platter", "Salmon and Shrimp Tempura Roll"));
        List<String> t709 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "Tako", "All California Sushi Platter", "Tako"));
        List<String> t710 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t711 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad", "Teriyakidon", "Teriyakidon"));
        List<String> t712 = new ArrayList<>(List.of("All California Sushi Platter", "All California Sushi Platter", "Beef Yakiudon", "All California Sushi Platter", "Teriyakidon"));
        List<String> t713 = new ArrayList<>(List.of("Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Chocolate Cake", "Chocolate Cake"));
        List<String> t714 = new ArrayList<>(List.of("Teriyakidon"));
        List<String> t715 = new ArrayList<>(List.of("Beef Yakiudon", "Tako"));
        List<String> t716 = new ArrayList<>(List.of("Beef Yakiudon", "Tako"));
        List<String> t717 = new ArrayList<>(List.of("Tako"));
        List<String> t718 = new ArrayList<>(List.of("Chocolate Cake", "4 Seasons", "4 Seasons", "4 Seasons", "Beef Yakiudon", "Beef Yakiudon"));
        List<String> t719 = new ArrayList<>(List.of("Seaweed Salad", "Tako"));
        List<String> t720 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "4 Seasons", "All California Sushi Platter", "Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t721 = new ArrayList<>(List.of("4 Seasons", "4 Seasons", "Tako", "Chocolate Cake", "Seaweed Salad"));
        List<String> t722 = new ArrayList<>(List.of("All California Sushi Platter", "Salmon and Shrimp Tempura Roll"));
        List<String> t723 = new ArrayList<>(List.of("Teriyakidon", "Tako", "Seaweed Salad", "Teriyakidon"));
        List<String> t724 = new ArrayList<>(List.of("Tako", "Beef Yakiudon", "Seaweed Salad", "Salmon and Shrimp Tempura Roll"));
        List<String> t725 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad", "4 Seasons", "4 Seasons"));
        List<String> t726 = new ArrayList<>(List.of("All California Sushi Platter", "4 Seasons", "Teriyakidon", "Chocolate Cake"));
        List<String> t727 = new ArrayList<>(List.of("Seaweed Salad", "All California Sushi Platter", "Tako", "All California Sushi Platter", "All California Sushi Platter"));
        List<String> t728 = new ArrayList<>(List.of("All California Sushi Platter", "Beef Yakiudon", "Tako", "Salmon and Shrimp Tempura Roll", "4 Seasons", "Beef Yakiudon"));
        List<String> t729 = new ArrayList<>(List.of("Teriyakidon", "4 Seasons", "Salmon and Shrimp Tempura Roll", "Tako", "Tako"));
        List<String> t730 = new ArrayList<>(List.of("Tako", "4 Seasons", "Chocolate Cake"));
        List<String> t731 = new ArrayList<>(List.of("4 Seasons", "Teriyakidon", "All California Sushi Platter", "Chocolate Cake", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll"));
        List<String> t732 = new ArrayList<>(List.of("Teriyakidon", "Chocolate Cake", "Tako"));
        List<String> t733 = new ArrayList<>(List.of("Tako"));
        List<String> t734 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t735 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Seaweed Salad"));
        List<String> t736 = new ArrayList<>(List.of("Tako"));
        List<String> t737 = new ArrayList<>(List.of("Tako", "Beef Yakiudon", "Chocolate Cake", "Tako", "Teriyakidon", "Tako"));
        List<String> t738 = new ArrayList<>(List.of("Tako"));
        List<String> t739 = new ArrayList<>(List.of("All California Sushi Platter", "Beef Yakiudon"));
        List<String> t740 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t741 = new ArrayList<>(List.of("All California Sushi Platter", "All California Sushi Platter", "Teriyakidon", "Tako"));
        List<String> t742 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad"));
        List<String> t743 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad", "Seaweed Salad"));
        List<String> t744 = new ArrayList<>(List.of("Tako", "4 Seasons", "Chocolate Cake", "Seaweed Salad", "4 Seasons", "Chocolate Cake", "Seaweed Salad"));
        List<String> t745 = new ArrayList<>(List.of("Tako", "All California Sushi Platter"));
        List<String> t746 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t747 = new ArrayList<>(List.of("Teriyakidon", "4 Seasons", "All California Sushi Platter", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Tako"));
        List<String> t748 = new ArrayList<>(List.of("Teriyakidon", "Salmon and Shrimp Tempura Roll", "Teriyakidon"));
        List<String> t749 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "4 Seasons", "Chocolate Cake", "Tako"));
        List<String> t750 = new ArrayList<>(List.of("Tako", "All California Sushi Platter"));
        List<String> t751 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Teriyakidon"));
        List<String> t752 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad"));
        List<String> t753 = new ArrayList<>(List.of("Seaweed Salad", "All California Sushi Platter"));
        List<String> t754 = new ArrayList<>(List.of("Teriyakidon", "Chocolate Cake", "All California Sushi Platter", "Seaweed Salad"));
        List<String> t755 = new ArrayList<>(List.of("Tako", "Teriyakidon", "Seaweed Salad", "Tako", "Beef Yakiudon"));
        List<String> t756 = new ArrayList<>(List.of("Tako"));
        List<String> t757 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "Seaweed Salad", "Beef Yakiudon", "Seaweed Salad", "Beef Yakiudon"));
        List<String> t758 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Seaweed Salad"));
        List<String> t759 = new ArrayList<>(List.of("Beef Yakiudon", "Chocolate Cake", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "All California Sushi Platter"));
        List<String> t760 = new ArrayList<>(List.of("Tako", "Teriyakidon", "Salmon and Shrimp Tempura Roll", "Teriyakidon"));
        List<String> t761 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t762 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad", "Tako", "4 Seasons", "Tako", "Tako"));
        List<String> t763 = new ArrayList<>(List.of("4 Seasons", "Salmon and Shrimp Tempura Roll", "4 Seasons", "Beef Yakiudon"));
        List<String> t764 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon", "Tako"));
        List<String> t765 = new ArrayList<>(List.of("Tako", "4 Seasons", "Chocolate Cake", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "4 Seasons"));
        List<String> t766 = new ArrayList<>(List.of("Beef Yakiudon", "4 Seasons", "4 Seasons", "Salmon and Shrimp Tempura Roll", "4 Seasons", "Tako"));
        List<String> t767 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad", "Tako", "Tako", "Tako", "All California Sushi Platter", "All California Sushi Platter"));
        List<String> t768 = new ArrayList<>(List.of("4 Seasons", "Tako", "Chocolate Cake", "Tako", "Seaweed Salad", "All California Sushi Platter", "4 Seasons"));
        List<String> t769 = new ArrayList<>(List.of("Tako", "Tako", "All California Sushi Platter", "All California Sushi Platter"));
        List<String> t770 = new ArrayList<>(List.of("4 Seasons", "Beef Yakiudon", "Teriyakidon"));
        List<String> t771 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "Beef Yakiudon"));
        List<String> t772 = new ArrayList<>(List.of("Teriyakidon"));
        List<String> t773 = new ArrayList<>(List.of("Tako", "4 Seasons"));
        List<String> t774 = new ArrayList<>(List.of("Seaweed Salad", "Beef Yakiudon", "4 Seasons", "Tako", "Tako"));
        List<String> t775 = new ArrayList<>(List.of("All California Sushi Platter", "Tako", "Salmon and Shrimp Tempura Roll", "Tako", "All California Sushi Platter"));
        List<String> t776 = new ArrayList<>(List.of("All California Sushi Platter", "Tako"));
        List<String> t777 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "4 Seasons", "Salmon and Shrimp Tempura Roll"));
        List<String> t778 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Tako"));
        List<String> t779 = new ArrayList<>(List.of("Tako", "Beef Yakiudon", "Tako", "Seaweed Salad", "4 Seasons", "4 Seasons"));
        List<String> t780 = new ArrayList<>(List.of("Tako"));
        List<String> t781 = new ArrayList<>(List.of("4 Seasons", "Beef Yakiudon", "Seaweed Salad"));
        List<String> t782 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t783 = new ArrayList<>(List.of("Tako", "Teriyakidon", "Tako", "4 Seasons"));
        List<String> t784 = new ArrayList<>(List.of("Tako", "4 Seasons", "Seaweed Salad", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Seaweed Salad"));
        List<String> t785 = new ArrayList<>(List.of("Chocolate Cake", "Seaweed Salad", "All California Sushi Platter", "Seaweed Salad", "Tako"));
        List<String> t786 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t787 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll"));
        List<String> t788 = new ArrayList<>(List.of("Tako", "All California Sushi Platter"));
        List<String> t789 = new ArrayList<>(List.of("4 Seasons", "4 Seasons", "Tako", "Seaweed Salad", "Teriyakidon"));
        List<String> t790 = new ArrayList<>(List.of("Seaweed Salad", "All California Sushi Platter"));
        List<String> t791 = new ArrayList<>(List.of("Teriyakidon", "4 Seasons", "Beef Yakiudon", "Teriyakidon", "Tako"));
        List<String> t792 = new ArrayList<>(List.of("Tako", "Chocolate Cake"));
        List<String> t793 = new ArrayList<>(List.of("4 Seasons", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Salmon and Shrimp Tempura Roll"));
        List<String> t794 = new ArrayList<>(List.of("All California Sushi Platter", "Tako", "4 Seasons", "Beef Yakiudon", "Chocolate Cake", "Teriyakidon", "Tako"));
        List<String> t795 = new ArrayList<>(List.of("Tako", "All California Sushi Platter", "Salmon and Shrimp Tempura Roll", "Seaweed Salad", "All California Sushi Platter"));
        List<String> t796 = new ArrayList<>(List.of("All California Sushi Platter", "All California Sushi Platter"));
        List<String> t797 = new ArrayList<>(List.of("Seaweed Salad", "Salmon and Shrimp Tempura Roll"));
        List<String> t798 = new ArrayList<>(List.of("Tako", "Tako", "4 Seasons", "Seaweed Salad", "Seaweed Salad"));
        List<String> t799 = new ArrayList<>(List.of("Beef Yakiudon", "Teriyakidon", "Teriyakidon", "Teriyakidon", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon"));
        List<String> t800 = new ArrayList<>(List.of("All California Sushi Platter", "Tako", "4 Seasons", "Beef Yakiudon", "Tako", "Salmon and Shrimp Tempura Roll", "Chocolate Cake"));
        List<String> t801 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon and Shrimp Tempura Roll"));
        List<String> t802 = new ArrayList<>(List.of("4 Seasons", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "All California Sushi Platter", "Seaweed Salad", "Teriyakidon"));
        List<String> t803 = new ArrayList<>(List.of("All California Sushi Platter", "Salmon and Shrimp Tempura Roll"));
        List<String> t804 = new ArrayList<>(List.of("All California Sushi Platter", "Beef Yakiudon", "Seaweed Salad", "Tako", "All California Sushi Platter", "Chocolate Cake", "4 Seasons"));
        List<String> t805 = new ArrayList<>(List.of("Chocolate Cake", "Seaweed Salad", "Chocolate Cake"));
        List<String> t806 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "Tako"));
        List<String> t807 = new ArrayList<>(List.of("Tako", "Beef Yakiudon", "Chocolate Cake", "Teriyakidon"));
        List<String> t808 = new ArrayList<>(List.of("All California Sushi Platter", "All California Sushi Platter"));
        List<String> t809 = new ArrayList<>(List.of("All California Sushi Platter", "Chocolate Cake", "Tako", "Tako", "Seaweed Salad", "Tako", "Seaweed Salad"));
        List<String> t810 = new ArrayList<>(List.of("All California Sushi Platter", "Chocolate Cake", "All California Sushi Platter", "4 Seasons", "Seaweed Salad", "Tako", "Teriyakidon"));
        List<String> t811 = new ArrayList<>(List.of("4 Seasons", "Tako", "4 Seasons", "Tako", "Seaweed Salad", "Tako", "Tako"));
        List<String> t812 = new ArrayList<>(List.of("Tako", "Seaweed Salad"));
        List<String> t813 = new ArrayList<>(List.of("4 Seasons", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "4 Seasons", "Tako", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll"));
        List<String> t814 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "Tako", "4 Seasons", "All California Sushi Platter"));
        List<String> t815 = new ArrayList<>(List.of("All California Sushi Platter", "All California Sushi Platter"));
        List<String> t816 = new ArrayList<>(List.of("Teriyakidon", "All California Sushi Platter", "Tako", "Teriyakidon", "Seaweed Salad", "Teriyakidon"));
        List<String> t817 = new ArrayList<>(List.of("Chocolate Cake", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Tako", "Chocolate Cake", "All California Sushi Platter"));
        List<String> t818 = new ArrayList<>(List.of("Tako", "All California Sushi Platter"));
        List<String> t819 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon"));
        List<String> t820 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "4 Seasons", "Teriyakidon", "Teriyakidon", "Salmon and Shrimp Tempura Roll", "Chocolate Cake"));
        List<String> t821 = new ArrayList<>(List.of("Seaweed Salad", "Teriyakidon", "Tako", "Tako", "Teriyakidon"));
        List<String> t822 = new ArrayList<>(List.of("Beef Yakiudon", "Teriyakidon", "Beef Yakiudon", "Beef Yakiudon", "Tako", "All California Sushi Platter"));
        List<String> t823 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Tako", "Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Chocolate Cake"));
        List<String> t824 = new ArrayList<>(List.of("All California Sushi Platter", "Beef Yakiudon"));
        List<String> t825 = new ArrayList<>(List.of("Tako", "Tako", "Tako", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Chocolate Cake"));
        List<String> t826 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t827 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t828 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "Tako"));
        List<String> t829 = new ArrayList<>(List.of("4 Seasons", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "All California Sushi Platter"));
        List<String> t830 = new ArrayList<>(List.of("Seaweed Salad", "Chocolate Cake", "Teriyakidon", "All California Sushi Platter"));
        List<String> t831 = new ArrayList<>(List.of("Seaweed Salad", "Tako"));
        List<String> t832 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon"));
        List<String> t833 = new ArrayList<>(List.of("Beef Yakiudon", "4 Seasons", "Salmon and Shrimp Tempura Roll"));
        List<String> t834 = new ArrayList<>(List.of("Beef Yakiudon", "4 Seasons", "Tako", "Beef Yakiudon"));
        List<String> t835 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "4 Seasons"));
        List<String> t836 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "Chocolate Cake", "Tako", "All California Sushi Platter", "Beef Yakiudon", "Tako"));
        List<String> t837 = new ArrayList<>(List.of("All California Sushi Platter", "Tako", "4 Seasons"));
        List<String> t838 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "Tako", "Seaweed Salad"));
        List<String> t839 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll"));
        List<String> t840 = new ArrayList<>(List.of("Teriyakidon", "4 Seasons", "Seaweed Salad", "Tako", "Seaweed Salad", "Beef Yakiudon"));
        List<String> t841 = new ArrayList<>(List.of("Seaweed Salad", "Seaweed Salad"));
        List<String> t842 = new ArrayList<>(List.of("Tako", "4 Seasons", "Chocolate Cake", "Teriyakidon", "4 Seasons", "Beef Yakiudon"));
        List<String> t843 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t844 = new ArrayList<>(List.of("Teriyakidon", "Teriyakidon", "Tako", "4 Seasons"));
        List<String> t845 = new ArrayList<>(List.of("Tako", "Beef Yakiudon"));
        List<String> t846 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t847 = new ArrayList<>(List.of("Tako", "Seaweed Salad", "Teriyakidon", "Tako", "All California Sushi Platter", "Tako"));
        List<String> t848 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Seaweed Salad", "Tako", "All California Sushi Platter"));
        List<String> t849 = new ArrayList<>(List.of("Teriyakidon", "Chocolate Cake", "Tako", "Seaweed Salad", "Salmon and Shrimp Tempura Roll"));
        List<String> t850 = new ArrayList<>(List.of("Teriyakidon", "Chocolate Cake", "Chocolate Cake", "4 Seasons", "Salmon and Shrimp Tempura Roll"));
        List<String> t851 = new ArrayList<>(List.of("Tako", "All California Sushi Platter", "Chocolate Cake", "Chocolate Cake", "Teriyakidon", "Beef Yakiudon", "All California Sushi Platter"));
        List<String> t852 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako", "4 Seasons"));
        List<String> t853 = new ArrayList<>(List.of("Tako", "4 Seasons", "Salmon and Shrimp Tempura Roll", "Tako", "4 Seasons"));
        List<String> t854 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "4 Seasons"));
        List<String> t855 = new ArrayList<>(List.of("Beef Yakiudon"));
        List<String> t856 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "All California Sushi Platter"));
        List<String> t857 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t858 = new ArrayList<>(List.of("Teriyakidon", "Salmon and Shrimp Tempura Roll", "Tako", "4 Seasons", "Beef Yakiudon", "Chocolate Cake", "Salmon and Shrimp Tempura Roll"));
        List<String> t859 = new ArrayList<>(List.of("Tako", "Tako", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Teriyakidon", "Tako"));
        List<String> t860 = new ArrayList<>(List.of("Beef Yakiudon", "Teriyakidon", "Beef Yakiudon", "Seaweed Salad"));
        List<String> t861 = new ArrayList<>(List.of("Tako", "4 Seasons", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "All California Sushi Platter", "Tako"));
        List<String> t862 = new ArrayList<>(List.of("Chocolate Cake", "4 Seasons", "Teriyakidon", "Seaweed Salad", "Beef Yakiudon", "Chocolate Cake", "Seaweed Salad"));
        List<String> t863 = new ArrayList<>(List.of("All California Sushi Platter", "Chocolate Cake", "4 Seasons", "4 Seasons", "Chocolate Cake", "Tako", "All California Sushi Platter"));
        List<String> t864 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll", "Chocolate Cake"));
        List<String> t865 = new ArrayList<>(List.of("Beef Yakiudon", "Tako"));
        List<String> t866 = new ArrayList<>(List.of("Seaweed Salad", "All California Sushi Platter", "Beef Yakiudon"));
        List<String> t867 = new ArrayList<>(List.of("Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Tako", "Teriyakidon"));
        List<String> t868 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "4 Seasons"));
        List<String> t869 = new ArrayList<>(List.of("Teriyakidon", "All California Sushi Platter", "Tako", "Chocolate Cake", "All California Sushi Platter", "Tako"));
        List<String> t870 = new ArrayList<>(List.of("Tako"));
        List<String> t871 = new ArrayList<>(List.of("Tako", "Tako", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Tako"));
        List<String> t872 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad", "4 Seasons", "4 Seasons", "Tako", "Tako"));
        List<String> t873 = new ArrayList<>(List.of("4 Seasons", "Tako", "Tako"));
        List<String> t874 = new ArrayList<>(List.of("Chocolate Cake", "Beef Yakiudon", "Teriyakidon", "Salmon and Shrimp Tempura Roll"));
        List<String> t875 = new ArrayList<>(List.of("All California Sushi Platter", "Salmon and Shrimp Tempura Roll", "4 Seasons", "4 Seasons", "Chocolate Cake", "Beef Yakiudon", "Tako"));
        List<String> t876 = new ArrayList<>(List.of("Tako", "All California Sushi Platter", "4 Seasons"));
        List<String> t877 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "Tako"));
        List<String> t878 = new ArrayList<>(List.of("4 Seasons", "Tako", "Salmon and Shrimp Tempura Roll", "Teriyakidon"));
        List<String> t879 = new ArrayList<>(List.of("Tako", "4 Seasons", "Tako", "Tako", "Tako", "Beef Yakiudon", "Chocolate Cake"));
        List<String> t880 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "All California Sushi Platter"));
        List<String> t881 = new ArrayList<>(List.of("Teriyakidon", "Beef Yakiudon", "All California Sushi Platter"));
        List<String> t882 = new ArrayList<>(List.of("Beef Yakiudon", "Teriyakidon", "Tako", "All California Sushi Platter", "Salmon and Shrimp Tempura Roll"));
        List<String> t883 = new ArrayList<>(List.of("Tako", "Teriyakidon", "4 Seasons", "Tako", "All California Sushi Platter", "All California Sushi Platter", "Salmon and Shrimp Tempura Roll"));
        List<String> t884 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Beef Yakiudon", "4 Seasons", "Seaweed Salad", "Chocolate Cake", "Teriyakidon"));
        List<String> t885 = new ArrayList<>(List.of("All California Sushi Platter", "Chocolate Cake", "4 Seasons", "Salmon and Shrimp Tempura Roll", "Tako", "Chocolate Cake"));
        List<String> t886 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t887 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t888 = new ArrayList<>(List.of("All California Sushi Platter", "Tako"));
        List<String> t889 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t890 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "Teriyakidon", "Seaweed Salad"));
        List<String> t891 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Beef Yakiudon", "Chocolate Cake"));
        List<String> t892 = new ArrayList<>(List.of("4 Seasons", "Teriyakidon", "Chocolate Cake"));
        List<String> t893 = new ArrayList<>(List.of("Tako", "Seaweed Salad"));
        List<String> t894 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Teriyakidon", "Beef Yakiudon", "Beef Yakiudon"));
        List<String> t895 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t896 = new ArrayList<>(List.of("4 Seasons"));
        List<String> t897 = new ArrayList<>(List.of("4 Seasons", "All California Sushi Platter", "Chocolate Cake", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Teriyakidon"));
        List<String> t898 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll", "Tako", "Tako", "Seaweed Salad", "Tako"));
        List<String> t899 = new ArrayList<>(List.of("Beef Yakiudon"));
        List<String> t900 = new ArrayList<>(List.of("Tako", "Beef Yakiudon", "Tako", "Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Teriyakidon", "4 Seasons"));
        List<String> t901 = new ArrayList<>(List.of("Chocolate Cake", "Teriyakidon", "Tako", "All California Sushi Platter", "4 Seasons", "Chocolate Cake", "All California Sushi Platter"));
        List<String> t902 = new ArrayList<>(List.of("Seaweed Salad", "Chocolate Cake", "Chocolate Cake", "4 Seasons", "Seaweed Salad", "Tako"));
        List<String> t903 = new ArrayList<>(List.of("Tako", "Seaweed Salad"));
        List<String> t904 = new ArrayList<>(List.of("All California Sushi Platter", "Tako"));
        List<String> t905 = new ArrayList<>(List.of("Seaweed Salad", "4 Seasons", "Teriyakidon", "Teriyakidon", "Tako"));
        List<String> t906 = new ArrayList<>(List.of("All California Sushi Platter", "Beef Yakiudon"));
        List<String> t907 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll", "Seaweed Salad"));
        List<String> t908 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "All California Sushi Platter", "All California Sushi Platter", "Chocolate Cake", "Tako", "Tako"));
        List<String> t909 = new ArrayList<>(List.of("Teriyakidon", "Seaweed Salad"));
        List<String> t910 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "Tako"));
        List<String> t911 = new ArrayList<>(List.of("Seaweed Salad", "Teriyakidon"));
        List<String> t912 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Beef Yakiudon", "4 Seasons", "All California Sushi Platter", "Tako"));
        List<String> t913 = new ArrayList<>(List.of("Seaweed Salad", "4 Seasons", "Beef Yakiudon"));
        List<String> t914 = new ArrayList<>(List.of("Beef Yakiudon", "Tako"));
        List<String> t915 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t916 = new ArrayList<>(List.of("All California Sushi Platter", "Seaweed Salad"));
        List<String> t917 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t918 = new ArrayList<>(List.of("Beef Yakiudon", "Teriyakidon", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Teriyakidon"));
        List<String> t919 = new ArrayList<>(List.of("4 Seasons", "Salmon and Shrimp Tempura Roll", "Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t920 = new ArrayList<>(List.of("Seaweed Salad", "Tako"));
        List<String> t921 = new ArrayList<>(List.of("Tako", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "Salmon and Shrimp Tempura Roll", "Teriyakidon", "Tako"));
        List<String> t922 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "All California Sushi Platter"));
        List<String> t923 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t924 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll"));
        List<String> t925 = new ArrayList<>(List.of("Beef Yakiudon", "Tako", "All California Sushi Platter", "Tako", "Teriyakidon", "Chocolate Cake"));
        List<String> t926 = new ArrayList<>(List.of("Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Seaweed Salad", "Tako", "Chocolate Cake", "Teriyakidon"));
        List<String> t927 = new ArrayList<>(List.of("Seaweed Salad", "Beef Yakiudon", "Tako", "Beef Yakiudon", "Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t928 = new ArrayList<>(List.of("All California Sushi Platter", "Tako", "Teriyakidon"));
        List<String> t929 = new ArrayList<>(List.of("4 Seasons", "Salmon and Shrimp Tempura Roll"));
        List<String> t930 = new ArrayList<>(List.of("Seaweed Salad", "Beef Yakiudon", "Teriyakidon", "4 Seasons", "4 Seasons", "Tako", "Chocolate Cake"));
        List<String> t931 = new ArrayList<>(List.of("Beef Yakiudon", "Seaweed Salad", "Tako", "Tako", "Chocolate Cake", "Tako"));
        List<String> t932 = new ArrayList<>(List.of("Teriyakidon", "All California Sushi Platter"));
        List<String> t933 = new ArrayList<>(List.of("All California Sushi Platter", "Teriyakidon", "Teriyakidon", "4 Seasons"));
        List<String> t934 = new ArrayList<>(List.of("Chocolate Cake", "Beef Yakiudon", "All California Sushi Platter", "Beef Yakiudon", "Tako", "All California Sushi Platter"));
        List<String> t935 = new ArrayList<>(List.of("Chocolate Cake", "Beef Yakiudon", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t936 = new ArrayList<>(List.of("All California Sushi Platter", "4 Seasons", "Seaweed Salad"));
        List<String> t937 = new ArrayList<>(List.of("All California Sushi Platter", "4 Seasons", "Beef Yakiudon", "Seaweed Salad", "Tako", "Tako", "Tako"));
        List<String> t938 = new ArrayList<>(List.of("Tako", "Seaweed Salad"));
        List<String> t939 = new ArrayList<>(List.of("Tako", "All California Sushi Platter", "4 Seasons"));
        List<String> t940 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Chocolate Cake", "4 Seasons", "Seaweed Salad"));
        List<String> t941 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Salmon and Shrimp Tempura Roll"));
        List<String> t942 = new ArrayList<>(List.of("Seaweed Salad", "Salmon and Shrimp Tempura Roll"));
        List<String> t943 = new ArrayList<>(List.of("Teriyakidon"));
        List<String> t944 = new ArrayList<>(List.of("Tako", "Beef Yakiudon"));
        List<String> t945 = new ArrayList<>(List.of("All California Sushi Platter", "Seaweed Salad"));
        List<String> t946 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t947 = new ArrayList<>(List.of("4 Seasons", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Teriyakidon"));
        List<String> t948 = new ArrayList<>(List.of("Teriyakidon", "Teriyakidon", "Teriyakidon", "Salmon and Shrimp Tempura Roll"));
        List<String> t949 = new ArrayList<>(List.of("Tako", "4 Seasons", "Seaweed Salad", "Chocolate Cake", "Tako", "All California Sushi Platter", "Tako"));
        List<String> t950 = new ArrayList<>(List.of("All California Sushi Platter", "4 Seasons", "All California Sushi Platter", "Tako", "All California Sushi Platter", "All California Sushi Platter"));
        List<String> t951 = new ArrayList<>(List.of("Tako", "All California Sushi Platter", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Chocolate Cake"));
        List<String> t952 = new ArrayList<>(List.of("Seaweed Salad", "Teriyakidon"));
        List<String> t953 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Chocolate Cake"));
        List<String> t954 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "4 Seasons", "Seaweed Salad", "All California Sushi Platter", "Teriyakidon", "Tako", "4 Seasons"));
        List<String> t955 = new ArrayList<>(List.of("Tako", "4 Seasons", "4 Seasons", "All California Sushi Platter", "Seaweed Salad"));
        List<String> t956 = new ArrayList<>(List.of("All California Sushi Platter", "Teriyakidon", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Seaweed Salad"));
        List<String> t957 = new ArrayList<>(List.of("4 Seasons", "All California Sushi Platter", "Tako", "Salmon and Shrimp Tempura Roll", "4 Seasons", "Tako", "Seaweed Salad"));
        List<String> t958 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t959 = new ArrayList<>(List.of("Tako", "4 Seasons", "Seaweed Salad"));
        List<String> t960 = new ArrayList<>(List.of("4 Seasons", "Teriyakidon", "Beef Yakiudon"));
        List<String> t961 = new ArrayList<>(List.of("Tako", "Teriyakidon"));
        List<String> t962 = new ArrayList<>(List.of("All California Sushi Platter"));
        List<String> t963 = new ArrayList<>(List.of("Tako", "Tako", "Seaweed Salad", "Seaweed Salad", "Tako", "Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t964 = new ArrayList<>(List.of("4 Seasons", "Seaweed Salad", "Beef Yakiudon", "Teriyakidon", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Seaweed Salad"));
        List<String> t965 = new ArrayList<>(List.of("Teriyakidon", "Tako", "Chocolate Cake", "Tako", "Seaweed Salad", "Tako"));
        List<String> t966 = new ArrayList<>(List.of("Seaweed Salad", "Teriyakidon", "Beef Yakiudon", "Seaweed Salad", "4 Seasons", "Salmon and Shrimp Tempura Roll", "Seaweed Salad"));
        List<String> t967 = new ArrayList<>(List.of("4 Seasons", "Beef Yakiudon", "4 Seasons"));
        List<String> t968 = new ArrayList<>(List.of("Teriyakidon", "Teriyakidon", "Beef Yakiudon"));
        List<String> t969 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll"));
        List<String> t970 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "Seaweed Salad", "Teriyakidon", "Teriyakidon", "Teriyakidon"));
        List<String> t971 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t972 = new ArrayList<>(List.of("Chocolate Cake", "4 Seasons"));
        List<String> t973 = new ArrayList<>(List.of("4 Seasons", "4 Seasons", "Teriyakidon", "Tako", "Salmon and Shrimp Tempura Roll"));
        List<String> t974 = new ArrayList<>(List.of("Beef Yakiudon", "Beef Yakiudon"));
        List<String> t975 = new ArrayList<>(List.of("All California Sushi Platter", "Teriyakidon"));
        List<String> t976 = new ArrayList<>(List.of("4 Seasons", "Salmon and Shrimp Tempura Roll"));
        List<String> t977 = new ArrayList<>(List.of("All California Sushi Platter", "Salmon and Shrimp Tempura Roll", "Beef Yakiudon", "Beef Yakiudon", "Seaweed Salad", "Salmon and Shrimp Tempura Roll"));
        List<String> t978 = new ArrayList<>(List.of("All California Sushi Platter", "Tako"));
        List<String> t979 = new ArrayList<>(List.of("All California Sushi Platter", "Seaweed Salad"));
        List<String> t980 = new ArrayList<>(List.of("Teriyakidon", "All California Sushi Platter", "Teriyakidon", "All California Sushi Platter", "4 Seasons"));
        List<String> t981 = new ArrayList<>(List.of("Seaweed Salad", "Tako", "Seaweed Salad"));
        List<String> t982 = new ArrayList<>(List.of("4 Seasons", "Chocolate Cake", "Chocolate Cake"));
        List<String> t983 = new ArrayList<>(List.of("Seaweed Salad", "4 Seasons", "Tako", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t984 = new ArrayList<>(List.of("Beef Yakiudon", "Tako"));
        List<String> t985 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll"));
        List<String> t986 = new ArrayList<>(List.of("Teriyakidon", "Tako", "Tako", "Teriyakidon", "All California Sushi Platter", "Teriyakidon"));
        List<String> t987 = new ArrayList<>(List.of("Teriyakidon", "Teriyakidon", "4 Seasons", "Chocolate Cake", "Teriyakidon", "All California Sushi Platter", "4 Seasons"));
        List<String> t988 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t989 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Tako"));
        List<String> t990 = new ArrayList<>(List.of("All California Sushi Platter", "All California Sushi Platter", "4 Seasons", "Salmon and Shrimp Tempura Roll", "All California Sushi Platter", "Tako", "Tako"));
        List<String> t991 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t992 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Seaweed Salad", "4 Seasons", "Teriyakidon", "All California Sushi Platter"));
        List<String> t993 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t994 = new ArrayList<>(List.of("Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Tako"));
        List<String> t995 = new ArrayList<>(List.of("Teriyakidon"));
        List<String> t996 = new ArrayList<>(List.of("Seaweed Salad", "Salmon and Shrimp Tempura Roll", "Tako", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll", "Chocolate Cake", "Chocolate Cake"));
        List<String> t997 = new ArrayList<>(List.of("Seaweed Salad"));
        List<String> t998 = new ArrayList<>(List.of("Teriyakidon", "All California Sushi Platter", "Chocolate Cake", "Salmon and Shrimp Tempura Roll", "Tako"));
        List<String> t999 = new ArrayList<>(List.of("Beef Yakiudon"));
        List<String> t1000 = new ArrayList<>(List.of("Tako", "Beef Yakiudon", "Salmon and Shrimp Tempura Roll"));

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
                t491, t492, t493, t494, t495, t496, t497, t498, t499, t500,
                t501, t502, t503, t504, t505, t506, t507, t508, t509, t510,
                t511, t512, t513, t514, t515, t516, t517, t518, t519, t520,
                t521, t522, t523, t524, t525, t526, t527, t528, t529, t530,
                t531, t532, t533, t534, t535, t536, t537, t538, t539, t540,
                t541, t542, t543, t544, t545, t546, t547, t548, t549, t550,
                t551, t552, t553, t554, t555, t556, t557, t558, t559, t560,
                t561, t562, t563, t564, t565, t566, t567, t568, t569, t570,
                t571, t572, t573, t574, t575, t576, t577, t578, t579, t580,
                t581, t582, t583, t584, t585, t586, t587, t588, t589, t590,
                t591, t592, t593, t594, t595, t596, t597, t598, t599, t600,
                t601, t602, t603, t604, t605, t606, t607, t608, t609, t610,
                t611, t612, t613, t614, t615, t616, t617, t618, t619, t620,
                t621, t622, t623, t624, t625, t626, t627, t628, t629, t630,
                t631, t632, t633, t634, t635, t636, t637, t638, t639, t640,
                t641, t642, t643, t644, t645, t646, t647, t648, t649, t650,
                t651, t652, t653, t654, t655, t656, t657, t658, t659, t660,
                t661, t662, t663, t664, t665, t666, t667, t668, t669, t670,
                t671, t672, t673, t674, t675, t676, t677, t678, t679, t680,
                t681, t682, t683, t684, t685, t686, t687, t688, t689, t690,
                t691, t692, t693, t694, t695, t696, t697, t698, t699, t700,
                t701, t702, t703, t704, t705, t706, t707, t708, t709, t710,
                t711, t712, t713, t714, t715, t716, t717, t718, t719, t720,
                t721, t722, t723, t724, t725, t726, t727, t728, t729, t730,
                t731, t732, t733, t734, t735, t736, t737, t738, t739, t740,
                t741, t742, t743, t744, t745, t746, t747, t748, t749, t750,
                t751, t752, t753, t754, t755, t756, t757, t758, t759, t760,
                t761, t762, t763, t764, t765, t766, t767, t768, t769, t770,
                t771, t772, t773, t774, t775, t776, t777, t778, t779, t780,
                t781, t782, t783, t784, t785, t786, t787, t788, t789, t790,
                t791, t792, t793, t794, t795, t796, t797, t798, t799, t800,
                t801, t802, t803, t804, t805, t806, t807, t808, t809, t810,
                t811, t812, t813, t814, t815, t816, t817, t818, t819, t820,
                t821, t822, t823, t824, t825, t826, t827, t828, t829, t830,
                t831, t832, t833, t834, t835, t836, t837, t838, t839, t840,
                t841, t842, t843, t844, t845, t846, t847, t848, t849, t850,
                t851, t852, t853, t854, t855, t856, t857, t858, t859, t860,
                t861, t862, t863, t864, t865, t866, t867, t868, t869, t870,
                t871, t872, t873, t874, t875, t876, t877, t878, t879, t880,
                t881, t882, t883, t884, t885, t886, t887, t888, t889, t890,
                t891, t892, t893, t894, t895, t896, t897, t898, t899, t900,
                t901, t902, t903, t904, t905, t906, t907, t908, t909, t910,
                t911, t912, t913, t914, t915, t916, t917, t918, t919, t920,
                t921, t922, t923, t924, t925, t926, t927, t928, t929, t930,
                t931, t932, t933, t934, t935, t936, t937, t938, t939, t940,
                t941, t942, t943, t944, t945, t946, t947, t948, t949, t950,
                t951, t952, t953, t954, t955, t956, t957, t958, t959, t960,
                t961, t962, t963, t964, t965, t966, t967, t968, t969, t970,
                t971, t972, t973, t974, t975, t976, t977, t978, t979, t980,
                t981, t982, t983, t984, t985, t986, t987, t988, t989, t990,
                t991, t992, t993, t994, t995, t996, t997, t998, t999, t1000
                );
        for (List<String> transaction : transactionsTB) {
            Set<String> filteredTransactions = new LinkedHashSet<>(transaction);
            transaction.clear();
            transaction.addAll(filteredTransactions);
        }
    }
}
