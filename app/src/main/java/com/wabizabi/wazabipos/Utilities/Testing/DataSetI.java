package com.wabizabi.wazabipos.Utilities.Testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class DataSetI implements DataSet {

    public static void insertInto(List<List<String>> transactionsTB) {

        List<String> t1 = new ArrayList<>(List.of("Kani Salad", "Tuna Salmon Dynamite Roll", "Salmon sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t2 = new ArrayList<>(List.of("Deluxe Sushi Platter"));
        List<String> t3 = new ArrayList<>(List.of("Teriyakidon", "Teriyakidon", "Sprite", "Kani Salad", "Salmon sashimi", "Kani Salad", "Tuna Salmon Dynamite Roll"));
        List<String> t4 = new ArrayList<>(List.of("Kani Salad", "Chocolate Cake", "Teriyakidon"));
        List<String> t5 = new ArrayList<>(List.of("Sprite", "Tuna Salmon Dynamite Roll", "Salmon sashimi", "Tuna Salmon Dynamite Roll", "Beef Yaki Udon"));
        List<String> t6 = new ArrayList<>(List.of("Salmon sashimi", "Chocolate Cake", "Salmon sashimi", "Chocolate Cake"));
        List<String> t7 = new ArrayList<>(List.of("Teriyakidon", "Salmon sashimi", "Chocolate Cake", "Tuna Salmon Dynamite Roll", "Beef Yaki Udon"));
        List<String> t8 = new ArrayList<>(List.of("Sprite", "Sprite", "Sprite", "Salmon sashimi", "Kani Salad", "Tuna Salmon Dynamite Roll"));
        List<String> t9 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Salmon sashimi", "Teriyakidon", "Kani Salad", "Chocolate Cake", "Salmon sashimi"));
        List<String> t10 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Salmon sashimi"));
        List<String> t11 = new ArrayList<>(List.of("Sprite", "Sprite", "Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter", "Sprite"));
        List<String> t12 = new ArrayList<>(List.of("Kani Salad", "Salmon sashimi"));
        List<String> t13 = new ArrayList<>(List.of("Salmon sashimi", "Kani Salad"));
        List<String> t14 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chocolate Cake", "Teriyakidon"));
        List<String> t15 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Salmon sashimi", "Chocolate Cake", "Chocolate Cake"));
        List<String> t16 = new ArrayList<>(List.of("Kani Salad"));
        List<String> t17 = new ArrayList<>(List.of("Kani Salad", "Kani Salad", "Tuna Salmon Dynamite Roll", "Beef Yaki Udon", "Sprite"));
        List<String> t18 = new ArrayList<>(List.of("Salmon sashimi", "Kani Salad"));
        List<String> t19 = new ArrayList<>(List.of("Salmon sashimi", "Sprite", "Beef Yaki Udon", "Tuna Salmon Dynamite Roll"));
        List<String> t20 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Salmon sashimi", "Tuna Salmon Dynamite Roll", "Teriyakidon"));
        List<String> t21 = new ArrayList<>(List.of("Sprite", "Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter"));
        List<String> t22 = new ArrayList<>(List.of("Salmon sashimi", "Deluxe Sushi Platter", "Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter", "Kani Salad"));
        List<String> t23 = new ArrayList<>(List.of("Kani Salad", "Beef Yaki Udon", "Chocolate Cake", "Salmon sashimi"));
        List<String> t24 = new ArrayList<>(List.of("Kani Salad", "Tuna Salmon Dynamite Roll", "Kani Salad", "Deluxe Sushi Platter", "Teriyakidon", "Salmon sashimi"));
        List<String> t25 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Kani Salad", "Sprite", "Deluxe Sushi Platter", "Beef Yaki Udon"));
        List<String> t26 = new ArrayList<>(List.of("Teriyakidon", "Sprite", "Salmon sashimi", "Chocolate Cake"));
        List<String> t27 = new ArrayList<>(List.of("Sprite", "Chocolate Cake"));
        List<String> t28 = new ArrayList<>(List.of("Chocolate Cake", "Teriyakidon"));
        List<String> t29 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Teriyakidon", "Deluxe Sushi Platter", "Sprite", "Deluxe Sushi Platter"));
        List<String> t30 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Chocolate Cake"));
        List<String> t31 = new ArrayList<>(List.of("Beef Yaki Udon", "Tuna Salmon Dynamite Roll", "Salmon sashimi"));
        List<String> t32 = new ArrayList<>(List.of("Salmon sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t33 = new ArrayList<>(List.of("Salmon sashimi", "Chocolate Cake", "Tuna Salmon Dynamite Roll", "Salmon sashimi", "Kani Salad", "Teriyakidon", "Deluxe Sushi Platter"));
        List<String> t34 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t35 = new ArrayList<>(List.of("Salmon sashimi", "Kani Salad"));
        List<String> t36 = new ArrayList<>(List.of("Salmon sashimi", "Tuna Salmon Dynamite Roll", "Chocolate Cake"));
        List<String> t37 = new ArrayList<>(List.of("Sprite", "Salmon sashimi", "Chocolate Cake", "Teriyakidon"));
        List<String> t38 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll"));
        List<String> t39 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t40 = new ArrayList<>(List.of("Salmon sashimi", "Kani Salad"));
        List<String> t41 = new ArrayList<>(List.of("Teriyakidon", "Deluxe Sushi Platter", "Kani Salad", "Kani Salad", "Sprite"));
        List<String> t42 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Tuna Salmon Dynamite Roll"));
        List<String> t43 = new ArrayList<>(List.of("Kani Salad", "Salmon sashimi"));
        List<String> t44 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Salmon sashimi", "Salmon sashimi", "Chocolate Cake", "Deluxe Sushi Platter", "Salmon sashimi"));
        List<String> t45 = new ArrayList<>(List.of("Kani Salad", "Tuna Salmon Dynamite Roll", "Beef Yaki Udon", "Teriyakidon", "Beef Yaki Udon", "Teriyakidon", "Chocolate Cake"));
        List<String> t46 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Deluxe Sushi Platter", "Salmon sashimi", "Chocolate Cake", "Deluxe Sushi Platter", "Salmon sashimi"));
        List<String> t47 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Beef Yaki Udon", "Tuna Salmon Dynamite Roll", "Salmon sashimi", "Sprite", "Salmon sashimi"));
        List<String> t48 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Chocolate Cake", "Sprite"));
        List<String> t49 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t50 = new ArrayList<>(List.of("Salmon sashimi", "Deluxe Sushi Platter", "Chocolate Cake", "Beef Yaki Udon", "Sprite", "Tuna Salmon Dynamite Roll"));
        List<String> t51 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll"));
        List<String> t52 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Salmon sashimi", "Teriyakidon"));
        List<String> t53 = new ArrayList<>(List.of("Sprite", "Teriyakidon"));
        List<String> t54 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll", "Salmon sashimi"));
        List<String> t55 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t56 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Sprite"));
        List<String> t57 = new ArrayList<>(List.of("Beef Yaki Udon", "Beef Yaki Udon", "Chocolate Cake", "Tuna Salmon Dynamite Roll", "Kani Salad"));
        List<String> t58 = new ArrayList<>(List.of("Kani Salad", "Tuna Salmon Dynamite Roll"));
        List<String> t59 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Kani Salad", "Deluxe Sushi Platter"));
        List<String> t60 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Salmon sashimi", "Kani Salad", "Teriyakidon", "Teriyakidon", "Beef Yaki Udon", "Kani Salad"));
        List<String> t61 = new ArrayList<>(List.of("Chocolate Cake", "Kani Salad", "Sprite", "Sprite", "Kani Salad"));
        List<String> t62 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Deluxe Sushi Platter"));
        List<String> t63 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Chocolate Cake", "Chocolate Cake", "Salmon sashimi", "Beef Yaki Udon", "Sprite", "Salmon sashimi"));
        List<String> t64 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Kani Salad"));
        List<String> t65 = new ArrayList<>(List.of("Beef Yaki Udon", "Teriyakidon", "Teriyakidon", "Deluxe Sushi Platter"));
        List<String> t66 = new ArrayList<>(List.of("Chocolate Cake", "Deluxe Sushi Platter", "Salmon sashimi", "Deluxe Sushi Platter", "Teriyakidon", "Salmon sashimi"));
        List<String> t67 = new ArrayList<>(List.of("Teriyakidon", "Salmon sashimi", "Sprite", "Deluxe Sushi Platter"));
        List<String> t68 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Beef Yaki Udon"));
        List<String> t69 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Sprite", "Teriyakidon"));
        List<String> t70 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll"));
        List<String> t71 = new ArrayList<>(List.of("Kani Salad", "Salmon sashimi", "Chocolate Cake", "Salmon sashimi", "Deluxe Sushi Platter"));
        List<String> t72 = new ArrayList<>(List.of("Salmon sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t73 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Salmon sashimi", "Deluxe Sushi Platter"));
        List<String> t74 = new ArrayList<>(List.of("Teriyakidon"));
        List<String> t75 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll"));
        List<String> t76 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t77 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Deluxe Sushi Platter", "Salmon sashimi", "Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter"));
        List<String> t78 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t79 = new ArrayList<>(List.of("Sprite", "Sprite"));
        List<String> t80 = new ArrayList<>(List.of("Salmon sashimi", "Teriyakidon", "Kani Salad"));
        List<String> t81 = new ArrayList<>(List.of("Beef Yaki Udon", "Teriyakidon", "Tuna Salmon Dynamite Roll"));
        List<String> t82 = new ArrayList<>(List.of("Teriyakidon", "Sprite"));
        List<String> t83 = new ArrayList<>(List.of("Teriyakidon", "Salmon sashimi", "Beef Yaki Udon", "Teriyakidon", "Sprite", "Chocolate Cake"));
        List<String> t84 = new ArrayList<>(List.of("Teriyakidon", "Salmon sashimi", "Beef Yaki Udon", "Chocolate Cake", "Kani Salad", "Kani Salad"));
        List<String> t85 = new ArrayList<>(List.of("Deluxe Sushi Platter"));
        List<String> t86 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Salmon sashimi", "Kani Salad"));
        List<String> t87 = new ArrayList<>(List.of("Salmon sashimi", "Tuna Salmon Dynamite Roll", "Sprite"));
        List<String> t88 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t89 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Teriyakidon", "Teriyakidon", "Salmon sashimi", "Salmon sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t90 = new ArrayList<>(List.of("Salmon sashimi", "Kani Salad", "Sprite", "Chocolate Cake", "Beef Yaki Udon", "Sprite", "Kani Salad"));
        List<String> t91 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t92 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Kani Salad", "Teriyakidon"));
        List<String> t93 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Salmon sashimi"));
        List<String> t94 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter"));
        List<String> t95 = new ArrayList<>(List.of("Salmon sashimi", "Teriyakidon", "Teriyakidon", "Salmon sashimi", "Kani Salad", "Chocolate Cake"));
        List<String> t96 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Salmon sashimi"));
        List<String> t97 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter"));
        List<String> t98 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t99 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Beef Yaki Udon", "Chocolate Cake", "Deluxe Sushi Platter", "Teriyakidon", "Tuna Salmon Dynamite Roll", "Teriyakidon"));
        List<String> t100 = new ArrayList<>(List.of("Sprite", "Teriyakidon", "Beef Yaki Udon", "Deluxe Sushi Platter", "Chocolate Cake"));
        List<String> t101 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Salmon sashimi", "Salmon sashimi"));
        List<String> t102 = new ArrayList<>(List.of("Kani Salad", "Kani Salad", "Chocolate Cake"));
        List<String> t103 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Beef Yaki Udon", "Teriyakidon", "Teriyakidon", "Sprite", "Tuna Salmon Dynamite Roll"));
        List<String> t104 = new ArrayList<>(List.of("Beef Yaki Udon", "Beef Yaki Udon", "Deluxe Sushi Platter", "Sprite", "Salmon sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t105 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Deluxe Sushi Platter", "Sprite", "Teriyakidon", "Teriyakidon"));
        List<String> t106 = new ArrayList<>(List.of("Sprite", "Beef Yaki Udon"));
        List<String> t107 = new ArrayList<>(List.of("Salmon sashimi", "Teriyakidon", "Chocolate Cake", "Kani Salad"));
        List<String> t108 = new ArrayList<>(List.of("Kani Salad", "Sprite", "Chocolate Cake", "Teriyakidon", "Beef Yaki Udon", "Teriyakidon"));
        List<String> t109 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Beef Yaki Udon", "Teriyakidon", "Chocolate Cake", "Beef Yaki Udon", "Sprite", "Sprite"));
        List<String> t110 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Kani Salad", "Sprite", "Beef Yaki Udon", "Salmon sashimi", "Salmon sashimi"));
        List<String> t111 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t112 = new ArrayList<>(List.of("Sprite"));
        List<String> t113 = new ArrayList<>(List.of("Kani Salad", "Salmon sashimi", "Beef Yaki Udon"));
        List<String> t114 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll"));
        List<String> t115 = new ArrayList<>(List.of("Sprite", "Chocolate Cake", "Teriyakidon", "Chocolate Cake", "Sprite", "Salmon sashimi"));
        List<String> t116 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Salmon sashimi", "Sprite", "Deluxe Sushi Platter", "Chocolate Cake", "Tuna Salmon Dynamite Roll", "Chocolate Cake"));
        List<String> t117 = new ArrayList<>(List.of("Teriyakidon", "Deluxe Sushi Platter", "Deluxe Sushi Platter", "Salmon sashimi", "Salmon sashimi", "Salmon sashimi"));
        List<String> t118 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Salmon sashimi", "Teriyakidon"));
        List<String> t119 = new ArrayList<>(List.of("Kani Salad", "Kani Salad", "Beef Yaki Udon", "Deluxe Sushi Platter", "Chocolate Cake"));
        List<String> t120 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter"));
        List<String> t121 = new ArrayList<>(List.of("Chocolate Cake", "Deluxe Sushi Platter", "Salmon sashimi", "Teriyakidon", "Deluxe Sushi Platter", "Kani Salad", "Chocolate Cake"));
        List<String> t122 = new ArrayList<>(List.of("Sprite", "Chocolate Cake"));
        List<String> t123 = new ArrayList<>(List.of("Teriyakidon", "Kani Salad", "Salmon sashimi", "Salmon sashimi"));
        List<String> t124 = new ArrayList<>(List.of("Salmon sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t125 = new ArrayList<>(List.of("Salmon sashimi", "Deluxe Sushi Platter"));
        List<String> t126 = new ArrayList<>(List.of("Salmon sashimi", "Beef Yaki Udon", "Sprite", "Chocolate Cake"));
        List<String> t127 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Chocolate Cake"));
        List<String> t128 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t129 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t130 = new ArrayList<>(List.of("Sprite", "Tuna Salmon Dynamite Roll", "Salmon sashimi", "Kani Salad", "Salmon sashimi"));
        List<String> t131 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Kani Salad", "Deluxe Sushi Platter", "Salmon sashimi"));
        List<String> t132 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Beef Yaki Udon"));
        List<String> t133 = new ArrayList<>(List.of("Beef Yaki Udon", "Salmon sashimi"));
        List<String> t134 = new ArrayList<>(List.of("Sprite", "Chocolate Cake", "Teriyakidon", "Salmon sashimi", "Deluxe Sushi Platter"));
        List<String> t135 = new ArrayList<>(List.of("Kani Salad", "Sprite", "Deluxe Sushi Platter", "Beef Yaki Udon", "Beef Yaki Udon"));
        List<String> t136 = new ArrayList<>(List.of("Teriyakidon", "Teriyakidon", "Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter"));
        List<String> t137 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Deluxe Sushi Platter", "Salmon sashimi", "Salmon sashimi", "Chocolate Cake", "Tuna Salmon Dynamite Roll"));
        List<String> t138 = new ArrayList<>(List.of("Teriyakidon", "Tuna Salmon Dynamite Roll"));
        List<String> t139 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Chocolate Cake"));
        List<String> t140 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Sprite"));
        List<String> t141 = new ArrayList<>(List.of("Salmon sashimi", "Deluxe Sushi Platter", "Beef Yaki Udon", "Sprite", "Kani Salad", "Beef Yaki Udon", "Kani Salad"));
        List<String> t142 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Chocolate Cake", "Teriyakidon", "Salmon sashimi", "Salmon sashimi"));
        List<String> t143 = new ArrayList<>(List.of("Teriyakidon", "Beef Yaki Udon", "Chocolate Cake", "Salmon sashimi"));
        List<String> t144 = new ArrayList<>(List.of("Sprite", "Salmon sashimi", "Salmon sashimi", "Tuna Salmon Dynamite Roll", "Sprite"));
        List<String> t145 = new ArrayList<>(List.of("Beef Yaki Udon", "Sprite", "Deluxe Sushi Platter", "Sprite", "Teriyakidon"));
        List<String> t146 = new ArrayList<>(List.of("Beef Yaki Udon", "Salmon sashimi", "Teriyakidon"));
        List<String> t147 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter"));
        List<String> t148 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Teriyakidon", "Kani Salad", "Beef Yaki Udon"));
        List<String> t149 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter", "Sprite", "Sprite"));
        List<String> t150 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Deluxe Sushi Platter", "Chocolate Cake", "Kani Salad"));
        List<String> t151 = new ArrayList<>(List.of("Kani Salad", "Beef Yaki Udon", "Salmon sashimi", "Sprite", "Beef Yaki Udon"));
        List<String> t152 = new ArrayList<>(List.of("Teriyakidon", "Salmon sashimi", "Teriyakidon", "Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter", "Tuna Salmon Dynamite Roll", "Salmon sashimi"));
        List<String> t153 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Teriyakidon", "Sprite", "Deluxe Sushi Platter", "Deluxe Sushi Platter", "Deluxe Sushi Platter"));
        List<String> t154 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Deluxe Sushi Platter", "Deluxe Sushi Platter", "Deluxe Sushi Platter"));
        List<String> t155 = new ArrayList<>(List.of("Salmon sashimi", "Kani Salad", "Sprite", "Sprite", "Chocolate Cake"));
        List<String> t156 = new ArrayList<>(List.of("Beef Yaki Udon"));
        List<String> t157 = new ArrayList<>(List.of("Kani Salad", "Deluxe Sushi Platter", "Deluxe Sushi Platter"));
        List<String> t158 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Teriyakidon", "Chocolate Cake", "Sprite", "Salmon sashimi", "Chocolate Cake"));
        List<String> t159 = new ArrayList<>(List.of("Teriyakidon", "Chocolate Cake", "Chocolate Cake", "Kani Salad", "Salmon sashimi", "Tuna Salmon Dynamite Roll", "Kani Salad"));
        List<String> t160 = new ArrayList<>(List.of("Salmon sashimi", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll"));
        List<String> t161 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Salmon sashimi"));
        List<String> t162 = new ArrayList<>(List.of("Sprite"));
        List<String> t163 = new ArrayList<>(List.of("Beef Yaki Udon", "Chocolate Cake", "Teriyakidon", "Beef Yaki Udon"));
        List<String> t164 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll"));
        List<String> t165 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chocolate Cake", "Salmon sashimi", "Kani Salad", "Salmon sashimi", "Beef Yaki Udon", "Salmon sashimi"));
        List<String> t166 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Salmon sashimi"));
        List<String> t167 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Deluxe Sushi Platter"));
        List<String> t168 = new ArrayList<>(List.of("Kani Salad", "Tuna Salmon Dynamite Roll"));
        List<String> t169 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t170 = new ArrayList<>(List.of("Salmon sashimi", "Beef Yaki Udon"));
        List<String> t171 = new ArrayList<>(List.of("Sprite", "Teriyakidon", "Beef Yaki Udon"));
        List<String> t172 = new ArrayList<>(List.of("Salmon sashimi", "Teriyakidon", "Salmon sashimi", "Salmon sashimi"));
        List<String> t173 = new ArrayList<>(List.of("Kani Salad", "Salmon sashimi"));
        List<String> t174 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Sprite", "Kani Salad", "Sprite", "Salmon sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t175 = new ArrayList<>(List.of("Salmon sashimi", "Beef Yaki Udon", "Deluxe Sushi Platter", "Tuna Salmon Dynamite Roll"));
        List<String> t176 = new ArrayList<>(List.of("Sprite", "Teriyakidon", "Kani Salad", "Chocolate Cake"));
        List<String> t177 = new ArrayList<>(List.of("Beef Yaki Udon", "Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter", "Sprite", "Deluxe Sushi Platter", "Sprite"));
        List<String> t178 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Salmon Dynamite Roll", "Chocolate Cake"));
        List<String> t179 = new ArrayList<>(List.of("Teriyakidon", "Deluxe Sushi Platter", "Chocolate Cake", "Beef Yaki Udon", "Teriyakidon"));
        List<String> t180 = new ArrayList<>(List.of("Salmon sashimi", "Kani Salad", "Beef Yaki Udon", "Deluxe Sushi Platter", "Salmon sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t181 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll"));
        List<String> t182 = new ArrayList<>(List.of("Beef Yaki Udon"));
        List<String> t183 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Chocolate Cake", "Deluxe Sushi Platter", "Salmon sashimi", "Deluxe Sushi Platter", "Salmon sashimi", "Beef Yaki Udon"));
        List<String> t184 = new ArrayList<>(List.of("Beef Yaki Udon", "Beef Yaki Udon", "Kani Salad", "Salmon sashimi"));
        List<String> t185 = new ArrayList<>(List.of("Sprite", "Chocolate Cake", "Chocolate Cake", "Kani Salad"));
        List<String> t186 = new ArrayList<>(List.of("Chocolate Cake", "Teriyakidon", "Deluxe Sushi Platter", "Sprite", "Sprite", "Salmon sashimi"));
        List<String> t187 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Salmon sashimi", "Beef Yaki Udon", "Teriyakidon", "Salmon sashimi", "Deluxe Sushi Platter"));
        List<String> t188 = new ArrayList<>(List.of("Sprite", "Salmon sashimi", "Deluxe Sushi Platter"));
        List<String> t189 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Kani Salad", "Salmon sashimi", "Teriyakidon"));
        List<String> t190 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Beef Yaki Udon"));
        List<String> t191 = new ArrayList<>(List.of("Kani Salad"));
        List<String> t192 = new ArrayList<>(List.of("Beef Yaki Udon", "Chocolate Cake", "Deluxe Sushi Platter", "Kani Salad", "Chocolate Cake", "Salmon sashimi"));
        List<String> t193 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Sprite", "Kani Salad", "Sprite", "Teriyakidon", "Tuna Salmon Dynamite Roll", "Salmon sashimi"));
        List<String> t194 = new ArrayList<>(List.of("Salmon sashimi", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll", "Beef Yaki Udon", "Salmon sashimi"));
        List<String> t195 = new ArrayList<>(List.of("Chocolate Cake", "Sprite", "Salmon sashimi", "Beef Yaki Udon", "Kani Salad", "Teriyakidon"));
        List<String> t196 = new ArrayList<>(List.of("Salmon sashimi", "Beef Yaki Udon", "Beef Yaki Udon", "Deluxe Sushi Platter", "Beef Yaki Udon", "Chocolate Cake", "Kani Salad"));
        List<String> t197 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t198 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Kani Salad", "Beef Yaki Udon"));
        List<String> t199 = new ArrayList<>(List.of("Beef Yaki Udon", "Chocolate Cake", "Sprite", "Chocolate Cake"));
        List<String> t200 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chocolate Cake", "Sprite", "Salmon sashimi", "Deluxe Sushi Platter", "Beef Yaki Udon"));
        List<String> t201 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Salmon sashimi", "Salmon sashimi", "Chocolate Cake", "Kani Salad"));
        List<String> t202 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Deluxe Sushi Platter"));
        List<String> t203 = new ArrayList<>(List.of("Beef Yaki Udon", "Kani Salad", "Tuna Salmon Dynamite Roll"));
        List<String> t204 = new ArrayList<>(List.of("Salmon sashimi", "Deluxe Sushi Platter", "Sprite", "Salmon sashimi", "Teriyakidon"));
        List<String> t205 = new ArrayList<>(List.of("Chocolate Cake", "Teriyakidon", "Salmon sashimi", "Deluxe Sushi Platter", "Salmon sashimi", "Teriyakidon"));
        List<String> t206 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Beef Yaki Udon"));
        List<String> t207 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t208 = new ArrayList<>(List.of("Kani Salad", "Sprite", "Salmon sashimi", "Salmon sashimi"));
        List<String> t209 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Teriyakidon", "Chocolate Cake", "Salmon sashimi", "Teriyakidon"));
        List<String> t210 = new ArrayList<>(List.of("Beef Yaki Udon", "Salmon sashimi"));
        List<String> t211 = new ArrayList<>(List.of("Salmon sashimi", "Deluxe Sushi Platter"));
        List<String> t212 = new ArrayList<>(List.of("Sprite", "Beef Yaki Udon", "Chocolate Cake"));
        List<String> t213 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t214 = new ArrayList<>(List.of("Sprite"));
        List<String> t215 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll"));
        List<String> t216 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Salmon sashimi", "Teriyakidon"));
        List<String> t217 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Kani Salad", "Sprite", "Tuna Salmon Dynamite Roll", "Sprite"));
        List<String> t218 = new ArrayList<>(List.of("Salmon sashimi", "Teriyakidon", "Sprite", "Salmon sashimi", "Deluxe Sushi Platter"));
        List<String> t219 = new ArrayList<>(List.of("Sprite", "Salmon sashimi", "Kani Salad"));
        List<String> t220 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Sprite", "Salmon sashimi", "Salmon sashimi", "Tuna Salmon Dynamite Roll", "Sprite", "Chocolate Cake"));
        List<String> t221 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Teriyakidon", "Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter", "Salmon sashimi", "Salmon sashimi", "Sprite"));
        List<String> t222 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t223 = new ArrayList<>(List.of("Chocolate Cake", "Sprite"));
        List<String> t224 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Chocolate Cake", "Salmon sashimi", "Teriyakidon", "Teriyakidon", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll"));
        List<String> t225 = new ArrayList<>(List.of("Beef Yaki Udon", "Deluxe Sushi Platter", "Kani Salad", "Deluxe Sushi Platter"));
        List<String> t226 = new ArrayList<>(List.of("Beef Yaki Udon", "Salmon sashimi"));
        List<String> t227 = new ArrayList<>(List.of("Kani Salad"));
        List<String> t228 = new ArrayList<>(List.of("Teriyakidon", "Beef Yaki Udon", "Chocolate Cake", "Salmon sashimi", "Deluxe Sushi Platter", "Salmon sashimi", "Sprite"));
        List<String> t229 = new ArrayList<>(List.of("Salmon sashimi", "Kani Salad", "Salmon sashimi", "Beef Yaki Udon", "Sprite", "Teriyakidon", "Salmon sashimi"));
        List<String> t230 = new ArrayList<>(List.of("Sprite", "Teriyakidon", "Salmon sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t231 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Deluxe Sushi Platter", "Salmon sashimi", "Beef Yaki Udon"));
        List<String> t232 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t233 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t234 = new ArrayList<>(List.of("Beef Yaki Udon", "Tuna Salmon Dynamite Roll", "Chocolate Cake", "Kani Salad", "Beef Yaki Udon", "Chocolate Cake", "Salmon sashimi"));
        List<String> t235 = new ArrayList<>(List.of("Kani Salad", "Teriyakidon", "Sprite"));
        List<String> t236 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Beef Yaki Udon"));
        List<String> t237 = new ArrayList<>(List.of("Deluxe Sushi Platter"));
        List<String> t238 = new ArrayList<>(List.of("Chocolate Cake", "Deluxe Sushi Platter", "Teriyakidon", "Deluxe Sushi Platter", "Sprite"));
        List<String> t239 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Salmon sashimi", "Salmon sashimi", "Beef Yaki Udon", "Salmon sashimi"));
        List<String> t240 = new ArrayList<>(List.of("Salmon sashimi", "Beef Yaki Udon", "Sprite", "Deluxe Sushi Platter", "Teriyakidon", "Tuna Salmon Dynamite Roll"));
        List<String> t241 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Salmon sashimi", "Beef Yaki Udon", "Sprite", "Tuna Salmon Dynamite Roll", "Salmon sashimi"));
        List<String> t242 = new ArrayList<>(List.of("Salmon sashimi", "Beef Yaki Udon"));
        List<String> t243 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Beef Yaki Udon", "Beef Yaki Udon"));
        List<String> t244 = new ArrayList<>(List.of("Chocolate Cake", "Kani Salad", "Beef Yaki Udon"));
        List<String> t245 = new ArrayList<>(List.of("Chocolate Cake", "Kani Salad", "Deluxe Sushi Platter", "Tuna Salmon Dynamite Roll", "Salmon sashimi", "Teriyakidon"));
        List<String> t246 = new ArrayList<>(List.of("Beef Yaki Udon", "Beef Yaki Udon", "Salmon sashimi"));
        List<String> t247 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Chocolate Cake", "Kani Salad"));
        List<String> t248 = new ArrayList<>(List.of("Kani Salad", "Teriyakidon", "Kani Salad", "Beef Yaki Udon", "Beef Yaki Udon", "Salmon sashimi", "Deluxe Sushi Platter"));
        List<String> t249 = new ArrayList<>(List.of("Kani Salad", "Salmon sashimi", "Tuna Salmon Dynamite Roll", "Salmon sashimi", "Beef Yaki Udon", "Salmon sashimi", "Teriyakidon"));
        List<String> t250 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Sprite", "Teriyakidon", "Beef Yaki Udon"));
        List<String> t251 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Teriyakidon", "Teriyakidon", "Sprite", "Kani Salad", "Salmon sashimi"));
        List<String> t252 = new ArrayList<>(List.of("Deluxe Sushi Platter"));
        List<String> t253 = new ArrayList<>(List.of("Sprite", "Salmon sashimi", "Deluxe Sushi Platter", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll", "Beef Yaki Udon", "Sprite"));
        List<String> t254 = new ArrayList<>(List.of("Salmon sashimi", "Chocolate Cake", "Salmon sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t255 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Sprite", "Beef Yaki Udon", "Beef Yaki Udon", "Chocolate Cake", "Tuna Salmon Dynamite Roll"));
        List<String> t256 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Deluxe Sushi Platter", "Salmon sashimi", "Teriyakidon"));
        List<String> t257 = new ArrayList<>(List.of("Salmon sashimi", "Beef Yaki Udon", "Kani Salad"));
        List<String> t258 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Salmon sashimi"));
        List<String> t259 = new ArrayList<>(List.of("Salmon sashimi", "Kani Salad"));
        List<String> t260 = new ArrayList<>(List.of("Salmon sashimi", "Teriyakidon", "Sprite", "Sprite", "Kani Salad"));
        List<String> t261 = new ArrayList<>(List.of("Teriyakidon", "Beef Yaki Udon", "Chocolate Cake", "Deluxe Sushi Platter", "Deluxe Sushi Platter"));
        List<String> t262 = new ArrayList<>(List.of("Sprite", "Sprite", "Sprite"));
        List<String> t263 = new ArrayList<>(List.of("Salmon sashimi", "Chocolate Cake", "Deluxe Sushi Platter", "Teriyakidon", "Kani Salad", "Teriyakidon", "Kani Salad"));
        List<String> t264 = new ArrayList<>(List.of("Sprite", "Salmon sashimi"));
        List<String> t265 = new ArrayList<>(List.of("Teriyakidon", "Tuna Salmon Dynamite Roll"));
        List<String> t266 = new ArrayList<>(List.of("Beef Yaki Udon", "Kani Salad"));
        List<String> t267 = new ArrayList<>(List.of("Salmon sashimi", "Beef Yaki Udon"));
        List<String> t268 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t269 = new ArrayList<>(List.of("Chocolate Cake", "Deluxe Sushi Platter", "Salmon sashimi", "Teriyakidon", "Beef Yaki Udon"));
        List<String> t270 = new ArrayList<>(List.of("Kani Salad", "Salmon sashimi", "Salmon sashimi", "Teriyakidon", "Tuna Salmon Dynamite Roll", "Teriyakidon"));
        List<String> t271 = new ArrayList<>(List.of("Deluxe Sushi Platter"));
        List<String> t272 = new ArrayList<>(List.of("Teriyakidon", "Deluxe Sushi Platter", "Teriyakidon"));
        List<String> t273 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Sprite", "Sprite", "Beef Yaki Udon", "Teriyakidon"));
        List<String> t274 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Chocolate Cake", "Beef Yaki Udon", "Teriyakidon"));
        List<String> t275 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Tuna Salmon Dynamite Roll"));
        List<String> t276 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Salmon sashimi", "Teriyakidon", "Salmon sashimi", "Chocolate Cake", "Kani Salad"));
        List<String> t277 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Kani Salad", "Beef Yaki Udon", "Tuna Salmon Dynamite Roll", "Teriyakidon", "Chocolate Cake"));
        List<String> t278 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Beef Yaki Udon"));
        List<String> t279 = new ArrayList<>(List.of("Teriyakidon", "Sprite", "Chocolate Cake", "Chocolate Cake", "Salmon sashimi", "Chocolate Cake", "Chocolate Cake"));
        List<String> t280 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Teriyakidon", "Deluxe Sushi Platter"));
        List<String> t281 = new ArrayList<>(List.of("Salmon sashimi", "Beef Yaki Udon"));
        List<String> t282 = new ArrayList<>(List.of("Kani Salad", "Kani Salad", "Salmon sashimi"));
        List<String> t283 = new ArrayList<>(List.of("Beef Yaki Udon", "Beef Yaki Udon", "Sprite", "Teriyakidon", "Chocolate Cake", "Beef Yaki Udon"));
        List<String> t284 = new ArrayList<>(List.of("Beef Yaki Udon", "Salmon sashimi"));
        List<String> t285 = new ArrayList<>(List.of("Sprite", "Chocolate Cake", "Teriyakidon", "Chocolate Cake", "Teriyakidon"));
        List<String> t286 = new ArrayList<>(List.of("Teriyakidon", "Salmon sashimi"));
        List<String> t287 = new ArrayList<>(List.of("Salmon sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t288 = new ArrayList<>(List.of("Salmon sashimi", "Deluxe Sushi Platter", "Beef Yaki Udon", "Kani Salad"));
        List<String> t289 = new ArrayList<>(List.of("Kani Salad", "Teriyakidon", "Salmon sashimi"));
        List<String> t290 = new ArrayList<>(List.of("Beef Yaki Udon", "Teriyakidon", "Salmon sashimi", "Teriyakidon", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll"));
        List<String> t291 = new ArrayList<>(List.of("Salmon sashimi", "Sprite", "Salmon sashimi", "Chocolate Cake", "Salmon sashimi"));
        List<String> t292 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Kani Salad", "Tuna Salmon Dynamite Roll"));
        List<String> t293 = new ArrayList<>(List.of("Chocolate Cake", "Kani Salad"));
        List<String> t294 = new ArrayList<>(List.of("Salmon sashimi", "Deluxe Sushi Platter", "Sprite", "Salmon sashimi", "Salmon sashimi", "Chocolate Cake"));
        List<String> t295 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter", "Deluxe Sushi Platter", "Tuna Salmon Dynamite Roll"));
        List<String> t296 = new ArrayList<>(List.of("Salmon sashimi", "Sprite", "Tuna Salmon Dynamite Roll"));
        List<String> t297 = new ArrayList<>(List.of("Beef Yaki Udon", "Sprite", "Chocolate Cake", "Sprite", "Salmon sashimi"));
        List<String> t298 = new ArrayList<>(List.of("Salmon sashimi", "Sprite", "Teriyakidon", "Deluxe Sushi Platter", "Deluxe Sushi Platter"));
        List<String> t299 = new ArrayList<>(List.of("Beef Yaki Udon", "Sprite"));
        List<String> t300 = new ArrayList<>(List.of("Salmon sashimi", "Tuna Salmon Dynamite Roll", "Chocolate Cake"));
        List<String> t301 = new ArrayList<>(List.of("Salmon sashimi", "Chocolate Cake", "Salmon sashimi"));
        List<String> t302 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Sprite", "Chocolate Cake", "Salmon sashimi", "Salmon sashimi", "Deluxe Sushi Platter"));
        List<String> t303 = new ArrayList<>(List.of("Salmon sashimi", "Beef Yaki Udon"));
        List<String> t304 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Chocolate Cake", "Beef Yaki Udon", "Teriyakidon", "Chocolate Cake", "Sprite"));
        List<String> t305 = new ArrayList<>(List.of("Teriyakidon", "Beef Yaki Udon", "Kani Salad", "Salmon sashimi", "Deluxe Sushi Platter"));
        List<String> t306 = new ArrayList<>(List.of("Sprite", "Chocolate Cake", "Chocolate Cake", "Tuna Salmon Dynamite Roll", "Salmon sashimi"));
        List<String> t307 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Beef Yaki Udon", "Kani Salad", "Salmon sashimi", "Salmon sashimi"));
        List<String> t308 = new ArrayList<>(List.of("Salmon sashimi", "Kani Salad"));
        List<String> t309 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Chocolate Cake"));
        List<String> t310 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Salmon sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t311 = new ArrayList<>(List.of("Deluxe Sushi Platter"));
        List<String> t312 = new ArrayList<>(List.of("Teriyakidon", "Salmon sashimi", "Beef Yaki Udon"));
        List<String> t313 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Tuna Salmon Dynamite Roll"));
        List<String> t314 = new ArrayList<>(List.of("Sprite", "Salmon sashimi", "Deluxe Sushi Platter", "Salmon sashimi"));
        List<String> t315 = new ArrayList<>(List.of("Salmon sashimi", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll", "Salmon sashimi"));
        List<String> t316 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Teriyakidon"));
        List<String> t317 = new ArrayList<>(List.of("Kani Salad", "Chocolate Cake", "Tuna Salmon Dynamite Roll", "Teriyakidon"));
        List<String> t318 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Salmon sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t319 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Teriyakidon"));
        List<String> t320 = new ArrayList<>(List.of("Kani Salad", "Salmon sashimi", "Chocolate Cake", "Beef Yaki Udon"));
        List<String> t321 = new ArrayList<>(List.of("Beef Yaki Udon", "Teriyakidon", "Chocolate Cake", "Deluxe Sushi Platter"));
        List<String> t322 = new ArrayList<>(List.of("Salmon sashimi", "Chocolate Cake", "Sprite"));
        List<String> t323 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll"));
        List<String> t324 = new ArrayList<>(List.of("Salmon sashimi", "Teriyakidon", "Teriyakidon"));
        List<String> t325 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Sprite", "Salmon sashimi", "Kani Salad", "Kani Salad"));
        List<String> t326 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Kani Salad"));
        List<String> t327 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Sprite", "Sprite", "Kani Salad", "Chocolate Cake"));
        List<String> t328 = new ArrayList<>(List.of("Salmon sashimi", "Kani Salad"));
        List<String> t329 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Salmon sashimi"));
        List<String> t330 = new ArrayList<>(List.of("Chocolate Cake", "Deluxe Sushi Platter", "Salmon sashimi"));
        List<String> t331 = new ArrayList<>(List.of("Salmon sashimi", "Tuna Salmon Dynamite Roll", "Beef Yaki Udon", "Chocolate Cake", "Salmon sashimi"));
        List<String> t332 = new ArrayList<>(List.of("Kani Salad", "Salmon sashimi", "Deluxe Sushi Platter", "Teriyakidon"));
        List<String> t333 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Salmon sashimi", "Sprite", "Tuna Salmon Dynamite Roll"));
        List<String> t334 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Teriyakidon", "Salmon sashimi", "Beef Yaki Udon", "Teriyakidon", "Sprite"));
        List<String> t335 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Teriyakidon", "Beef Yaki Udon", "Deluxe Sushi Platter", "Beef Yaki Udon"));
        List<String> t336 = new ArrayList<>(List.of("Kani Salad", "Salmon sashimi"));
        List<String> t337 = new ArrayList<>(List.of("Salmon sashimi", "Sprite"));
        List<String> t338 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Chocolate Cake", "Salmon sashimi"));
        List<String> t339 = new ArrayList<>(List.of("Teriyakidon"));
        List<String> t340 = new ArrayList<>(List.of("Sprite", "Salmon sashimi", "Deluxe Sushi Platter", "Deluxe Sushi Platter"));
        List<String> t341 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Tuna Salmon Dynamite Roll"));
        List<String> t342 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Salmon sashimi"));
        List<String> t343 = new ArrayList<>(List.of("Sprite", "Sprite", "Salmon sashimi", "Tuna Salmon Dynamite Roll", "Chocolate Cake", "Kani Salad"));
        List<String> t344 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t345 = new ArrayList<>(List.of("Beef Yaki Udon", "Deluxe Sushi Platter"));
        List<String> t346 = new ArrayList<>(List.of("Salmon sashimi", "Chocolate Cake", "Chocolate Cake", "Kani Salad"));
        List<String> t347 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t348 = new ArrayList<>(List.of("Salmon sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t349 = new ArrayList<>(List.of("Teriyakidon", "Deluxe Sushi Platter", "Teriyakidon", "Kani Salad"));
        List<String> t350 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t351 = new ArrayList<>(List.of("Teriyakidon"));
        List<String> t352 = new ArrayList<>(List.of("Chocolate Cake", "Beef Yaki Udon", "Salmon sashimi", "Salmon sashimi", "Salmon sashimi", "Deluxe Sushi Platter", "Kani Salad"));
        List<String> t353 = new ArrayList<>(List.of("Teriyakidon", "Kani Salad", "Deluxe Sushi Platter", "Deluxe Sushi Platter"));
        List<String> t354 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Beef Yaki Udon", "Chocolate Cake", "Tuna Salmon Dynamite Roll", "Beef Yaki Udon", "Salmon sashimi"));
        List<String> t355 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Beef Yaki Udon"));
        List<String> t356 = new ArrayList<>(List.of("Kani Salad", "Salmon sashimi"));
        List<String> t357 = new ArrayList<>(List.of("Beef Yaki Udon", "Beef Yaki Udon"));
        List<String> t358 = new ArrayList<>(List.of("Salmon sashimi", "Kani Salad", "Beef Yaki Udon", "Beef Yaki Udon"));
        List<String> t359 = new ArrayList<>(List.of("Beef Yaki Udon", "Salmon sashimi", "Beef Yaki Udon"));
        List<String> t360 = new ArrayList<>(List.of("Beef Yaki Udon", "Tuna Salmon Dynamite Roll", "Sprite", "Beef Yaki Udon", "Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter", "Sprite"));
        List<String> t361 = new ArrayList<>(List.of("Teriyakidon"));
        List<String> t362 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Kani Salad", "Tuna Salmon Dynamite Roll", "Kani Salad"));
        List<String> t363 = new ArrayList<>(List.of("Teriyakidon"));
        List<String> t364 = new ArrayList<>(List.of("Beef Yaki Udon", "Chocolate Cake", "Beef Yaki Udon", "Salmon sashimi", "Salmon sashimi"));
        List<String> t365 = new ArrayList<>(List.of("Teriyakidon", "Kani Salad", "Kani Salad", "Deluxe Sushi Platter", "Deluxe Sushi Platter"));
        List<String> t366 = new ArrayList<>(List.of("Teriyakidon", "Salmon sashimi", "Deluxe Sushi Platter", "Sprite", "Tuna Salmon Dynamite Roll"));
        List<String> t367 = new ArrayList<>(List.of("Teriyakidon", "Chocolate Cake", "Sprite"));
        List<String> t368 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t369 = new ArrayList<>(List.of("Salmon sashimi", "Kani Salad", "Salmon sashimi", "Salmon sashimi", "Salmon sashimi"));
        List<String> t370 = new ArrayList<>(List.of("Kani Salad", "Sprite", "Salmon sashimi", "Chocolate Cake", "Beef Yaki Udon", "Sprite", "Salmon sashimi"));
        List<String> t371 = new ArrayList<>(List.of("Beef Yaki Udon", "Salmon sashimi", "Sprite", "Beef Yaki Udon"));
        List<String> t372 = new ArrayList<>(List.of("Beef Yaki Udon", "Tuna Salmon Dynamite Roll", "Salmon sashimi", "Beef Yaki Udon", "Sprite", "Chocolate Cake", "Tuna Salmon Dynamite Roll"));
        List<String> t373 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t374 = new ArrayList<>(List.of("Teriyakidon", "Deluxe Sushi Platter"));
        List<String> t375 = new ArrayList<>(List.of("Sprite", "Chocolate Cake", "Salmon sashimi", "Deluxe Sushi Platter", "Sprite", "Salmon sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t376 = new ArrayList<>(List.of("Beef Yaki Udon", "Kani Salad", "Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter", "Sprite", "Deluxe Sushi Platter"));
        List<String> t377 = new ArrayList<>(List.of("Beef Yaki Udon", "Kani Salad", "Sprite"));
        List<String> t378 = new ArrayList<>(List.of("Beef Yaki Udon", "Kani Salad"));
        List<String> t379 = new ArrayList<>(List.of("Beef Yaki Udon", "Tuna Salmon Dynamite Roll"));
        List<String> t380 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll", "Teriyakidon", "Kani Salad", "Kani Salad"));
        List<String> t381 = new ArrayList<>(List.of("Beef Yaki Udon", "Kani Salad"));
        List<String> t382 = new ArrayList<>(List.of("Kani Salad", "Tuna Salmon Dynamite Roll"));
        List<String> t383 = new ArrayList<>(List.of("Kani Salad", "Salmon sashimi", "Salmon sashimi", "Salmon sashimi", "Deluxe Sushi Platter", "Tuna Salmon Dynamite Roll", "Chocolate Cake"));
        List<String> t384 = new ArrayList<>(List.of("Sprite", "Deluxe Sushi Platter", "Chocolate Cake", "Kani Salad", "Deluxe Sushi Platter", "Chocolate Cake", "Salmon sashimi"));
        List<String> t385 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi", "Teriyakidon", "Salmon sashimi", "Kani Salad", "Deluxe Sushi Platter", "Deluxe Sushi Platter"));
        List<String> t386 = new ArrayList<>(List.of("Sprite", "Chocolate Cake"));
        List<String> t387 = new ArrayList<>(List.of("Kani Salad", "Salmon sashimi"));
        List<String> t388 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Deluxe Sushi Platter"));
        List<String> t389 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Kani Salad", "Salmon sashimi"));
        List<String> t390 = new ArrayList<>(List.of("Kani Salad", "Deluxe Sushi Platter", "Salmon sashimi", "Teriyakidon", "Teriyakidon", "Kani Salad", "Teriyakidon"));
        List<String> t391 = new ArrayList<>(List.of("Salmon sashimi", "Sprite", "Tuna Salmon Dynamite Roll", "Salmon sashimi", "Teriyakidon"));
        List<String> t392 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter"));
        List<String> t393 = new ArrayList<>(List.of("Beef Yaki Udon", "Deluxe Sushi Platter"));
        List<String> t394 = new ArrayList<>(List.of("Teriyakidon", "Salmon sashimi", "Tuna Salmon Dynamite Roll", "Chocolate Cake", "Tuna Salmon Dynamite Roll"));
        List<String> t395 = new ArrayList<>(List.of("Teriyakidon", "Teriyakidon", "Kani Salad", "Salmon sashimi", "Salmon sashimi", "Salmon sashimi", "Deluxe Sushi Platter"));
        List<String> t396 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t397 = new ArrayList<>(List.of("Sprite", "Sprite", "Salmon sashimi", "Sprite", "Salmon sashimi", "Kani Salad"));
        List<String> t398 = new ArrayList<>(List.of("Salmon sashimi", "Teriyakidon", "Chocolate Cake"));
        List<String> t399 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll"));
        List<String> t400 = new ArrayList<>(List.of("Sprite"));
        List<String> t401 = new ArrayList<>(List.of("Sprite", "Tuna Salmon Dynamite Roll", "Salmon sashimi", "Kani Salad"));
        List<String> t402 = new ArrayList<>(List.of("Chocolate Cake", "Sprite", "Deluxe Sushi Platter"));
        List<String> t403 = new ArrayList<>(List.of("Kani Salad", "Salmon sashimi", "Chocolate Cake", "Kani Salad", "Salmon sashimi"));
        List<String> t404 = new ArrayList<>(List.of("Kani Salad", "Chocolate Cake", "Beef Yaki Udon", "Tuna Salmon Dynamite Roll"));
        List<String> t405 = new ArrayList<>(List.of("Sprite", "Salmon sashimi"));
        List<String> t406 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll", "Salmon sashimi"));
        List<String> t407 = new ArrayList<>(List.of("Salmon sashimi", "Deluxe Sushi Platter", "Beef Yaki Udon", "Salmon sashimi"));
        List<String> t408 = new ArrayList<>(List.of("Chocolate Cake", "Teriyakidon", "Chocolate Cake"));
        List<String> t409 = new ArrayList<>(List.of("Beef Yaki Udon", "Salmon sashimi", "Salmon sashimi", "Chocolate Cake"));
        List<String> t410 = new ArrayList<>(List.of("Beef Yaki Udon", "Salmon sashimi", "Tuna Salmon Dynamite Roll", "Salmon sashimi"));
        List<String> t411 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Sprite", "Deluxe Sushi Platter", "Salmon sashimi", "Kani Salad", "Kani Salad"));
        List<String> t412 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll"));
        List<String> t413 = new ArrayList<>(List.of("Teriyakidon", "Tuna Salmon Dynamite Roll", "Salmon sashimi", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll", "Teriyakidon", "Salmon sashimi"));
        List<String> t414 = new ArrayList<>(List.of("Teriyakidon", "Salmon sashimi", "Chocolate Cake", "Chocolate Cake", "Salmon sashimi"));
        List<String> t415 = new ArrayList<>(List.of("Sprite", "Salmon sashimi", "Chocolate Cake"));
        List<String> t416 = new ArrayList<>(List.of("Beef Yaki Udon", "Salmon sashimi"));
        List<String> t417 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Kani Salad"));
        List<String> t418 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter", "Tuna Salmon Dynamite Roll", "Chocolate Cake", "Chocolate Cake"));
        List<String> t419 = new ArrayList<>(List.of("Beef Yaki Udon", "Tuna Salmon Dynamite Roll", "Teriyakidon"));
        List<String> t420 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Teriyakidon", "Chocolate Cake", "Beef Yaki Udon", "Beef Yaki Udon"));
        List<String> t421 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Salmon sashimi", "Chocolate Cake", "Chocolate Cake", "Kani Salad"));
        List<String> t422 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Salmon sashimi", "Beef Yaki Udon", "Deluxe Sushi Platter"));
        List<String> t423 = new ArrayList<>(List.of("Salmon sashimi", "Kani Salad"));
        List<String> t424 = new ArrayList<>(List.of("Salmon sashimi"));
        List<String> t425 = new ArrayList<>(List.of("Chocolate Cake", "Beef Yaki Udon"));
        List<String> t426 = new ArrayList<>(List.of("Teriyakidon", "Kani Salad", "Tuna Salmon Dynamite Roll", "Sprite", "Sprite", "Salmon sashimi", "Sprite"));
        List<String> t427 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Teriyakidon", "Salmon sashimi", "Deluxe Sushi Platter", "Beef Yaki Udon", "Salmon sashimi", "Kani Salad"));
        List<String> t428 = new ArrayList<>(List.of("Salmon sashimi", "Sprite", "Sprite", "Teriyakidon"));
        List<String> t429 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Beef Yaki Udon"));
        List<String> t430 = new ArrayList<>(List.of("Kani Salad", "Beef Yaki Udon", "Salmon sashimi"));
        List<String> t431 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Tuna Salmon Dynamite Roll", "Chocolate Cake", "Teriyakidon", "Chocolate Cake"));
        List<String> t432 = new ArrayList<>(List.of("Chocolate Cake", "Deluxe Sushi Platter", "Kani Salad"));
        List<String> t433 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Sprite"));
        List<String> t434 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Salmon Dynamite Roll", "Kani Salad", "Kani Salad", "Chocolate Cake", "Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter"));
        List<String> t435 = new ArrayList<>(List.of("Teriyakidon", "Sprite", "Kani Salad", "Beef Yaki Udon", "Chocolate Cake"));
        List<String> t436 = new ArrayList<>(List.of("Chocolate Cake", "Sprite", "Teriyakidon", "Beef Yaki Udon", "Beef Yaki Udon", "Beef Yaki Udon", "Teriyakidon"));
        List<String> t437 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Beef Yaki Udon"));
        List<String> t438 = new ArrayList<>(List.of("Chocolate Cake", "Tuna Salmon Dynamite Roll", "Sprite", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll"));
        List<String> t439 = new ArrayList<>(List.of("Kani Salad", "Deluxe Sushi Platter"));
        List<String> t440 = new ArrayList<>(List.of("Sprite", "Kani Salad"));
        List<String> t441 = new ArrayList<>(List.of("Teriyakidon"));
        List<String> t442 = new ArrayList<>(List.of("Salmon sashimi", "Chocolate Cake"));
        List<String> t443 = new ArrayList<>(List.of("Beef Yaki Udon", "Salmon sashimi", "Chocolate Cake"));
        List<String> t444 = new ArrayList<>(List.of("Salmon sashimi", "Sprite"));
        List<String> t445 = new ArrayList<>(List.of("Salmon sashimi", "Deluxe Sushi Platter"));
        List<String> t446 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll"));
        List<String> t447 = new ArrayList<>(List.of("Beef Yaki Udon", "Beef Yaki Udon", "Deluxe Sushi Platter", "Chocolate Cake", "Deluxe Sushi Platter"));
        List<String> t448 = new ArrayList<>(List.of("Teriyakidon", "Beef Yaki Udon", "Teriyakidon"));
        List<String> t449 = new ArrayList<>(List.of("Salmon sashimi", "Sprite", "Kani Salad", "Tuna Salmon Dynamite Roll", "Teriyakidon", "Beef Yaki Udon", "Salmon sashimi"));
        List<String> t450 = new ArrayList<>(List.of("Kani Salad"));
        List<String> t451 = new ArrayList<>(List.of("Teriyakidon", "Deluxe Sushi Platter", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll", "Sprite", "Salmon sashimi"));
        List<String> t452 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t453 = new ArrayList<>(List.of("Salmon sashimi", "Deluxe Sushi Platter"));
        List<String> t454 = new ArrayList<>(List.of("Kani Salad", "Chocolate Cake", "Tuna Salmon Dynamite Roll", "Beef Yaki Udon", "Salmon sashimi", "Salmon sashimi"));
        List<String> t455 = new ArrayList<>(List.of("Salmon sashimi", "Deluxe Sushi Platter", "Salmon sashimi", "Chocolate Cake", "Salmon sashimi", "Beef Yaki Udon"));
        List<String> t456 = new ArrayList<>(List.of("Kani Salad", "Tuna Salmon Dynamite Roll", "Sprite", "Beef Yaki Udon", "Salmon sashimi", "Beef Yaki Udon", "Tuna Salmon Dynamite Roll"));
        List<String> t457 = new ArrayList<>(List.of("Kani Salad", "Tuna Salmon Dynamite Roll"));
        List<String> t458 = new ArrayList<>(List.of("Beef Yaki Udon", "Kani Salad"));
        List<String> t459 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll", "Kani Salad", "Teriyakidon", "Kani Salad", "Deluxe Sushi Platter", "Chocolate Cake"));
        List<String> t460 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Salmon sashimi"));
        List<String> t461 = new ArrayList<>(List.of("Chocolate Cake", "Beef Yaki Udon", "Salmon sashimi", "Salmon sashimi", "Salmon sashimi"));
        List<String> t462 = new ArrayList<>(List.of("Teriyakidon", "Sprite"));
        List<String> t463 = new ArrayList<>(List.of("Teriyakidon", "Sprite", "Chocolate Cake"));
        List<String> t464 = new ArrayList<>(List.of("Kani Salad", "Chocolate Cake", "Sprite"));
        List<String> t465 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t466 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Salmon sashimi", "Salmon sashimi", "Sprite", "Tuna Salmon Dynamite Roll", "Kani Salad"));
        List<String> t467 = new ArrayList<>(List.of("Salmon sashimi", "Deluxe Sushi Platter"));
        List<String> t468 = new ArrayList<>(List.of("Kani Salad", "Teriyakidon", "Sprite", "Beef Yaki Udon", "Teriyakidon"));
        List<String> t469 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Chocolate Cake", "Salmon sashimi", "Chocolate Cake", "Teriyakidon"));
        List<String> t470 = new ArrayList<>(List.of("Salmon sashimi", "Kani Salad"));
        List<String> t471 = new ArrayList<>(List.of("Salmon sashimi", "Tuna Salmon Dynamite Roll"));
        List<String> t472 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Kani Salad"));
        List<String> t473 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Salmon sashimi", "Teriyakidon", "Chocolate Cake", "Sprite"));
        List<String> t474 = new ArrayList<>(List.of("Teriyakidon"));
        List<String> t475 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Sprite", "Beef Yaki Udon"));
        List<String> t476 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Teriyakidon"));
        List<String> t477 = new ArrayList<>(List.of("Beef Yaki Udon", "Salmon sashimi", "Teriyakidon", "Chocolate Cake", "Kani Salad"));
        List<String> t478 = new ArrayList<>(List.of("Sprite", "Chocolate Cake", "Kani Salad", "Deluxe Sushi Platter", "Tuna Salmon Dynamite Roll"));
        List<String> t479 = new ArrayList<>(List.of("Kani Salad", "Beef Yaki Udon", "Deluxe Sushi Platter", "Deluxe Sushi Platter", "Salmon sashimi", "Deluxe Sushi Platter", "Tuna Salmon Dynamite Roll"));
        List<String> t480 = new ArrayList<>(List.of("Salmon sashimi", "Chocolate Cake", "Salmon sashimi", "Deluxe Sushi Platter", "Beef Yaki Udon"));
        List<String> t481 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi"));
        List<String> t482 = new ArrayList<>(List.of("Salmon sashimi", "Tuna Salmon Dynamite Roll", "Sprite", "Sprite", "Chocolate Cake", "Beef Yaki Udon", "Salmon sashimi"));
        List<String> t483 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Sprite", "Chocolate Cake", "Tuna Salmon Dynamite Roll", "Salmon sashimi", "Tuna Salmon Dynamite Roll", "Salmon sashimi"));
        List<String> t484 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Salmon sashimi", "Beef Yaki Udon"));
        List<String> t485 = new ArrayList<>(List.of("Salmon sashimi", "Chocolate Cake", "Sprite", "Salmon sashimi", "Salmon sashimi", "Teriyakidon"));
        List<String> t486 = new ArrayList<>(List.of("Beef Yaki Udon", "Beef Yaki Udon", "Sprite", "Deluxe Sushi Platter", "Sprite", "Salmon sashimi"));
        List<String> t487 = new ArrayList<>(List.of("Salmon sashimi", "Deluxe Sushi Platter", "Deluxe Sushi Platter", "Salmon sashimi", "Sprite"));
        List<String> t488 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Teriyakidon", "Sprite", "Tuna Salmon Dynamite Roll"));
        List<String> t489 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll", "Beef Yaki Udon"));
        List<String> t490 = new ArrayList<>(List.of("Salmon sashimi", "Teriyakidon", "Tuna Salmon Dynamite Roll", "Beef Yaki Udon", "Salmon sashimi", "Salmon sashimi", "Chocolate Cake"));
        List<String> t491 = new ArrayList<>(List.of("Chocolate Cake", "Kani Salad", "Kani Salad", "Chocolate Cake", "Chocolate Cake"));
        List<String> t492 = new ArrayList<>(List.of("Deluxe Sushi Platter", "Kani Salad"));
        List<String> t493 = new ArrayList<>(List.of("Beef Yaki Udon", "Salmon sashimi"));
        List<String> t494 = new ArrayList<>(List.of("Kani Salad", "Deluxe Sushi Platter", "Chocolate Cake", "Beef Yaki Udon"));
        List<String> t495 = new ArrayList<>(List.of("Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter", "Chocolate Cake", "Kani Salad", "Sprite", "Deluxe Sushi Platter"));
        List<String> t496 = new ArrayList<>(List.of("Kani Salad", "Tuna Salmon Dynamite Roll", "Teriyakidon", "Chocolate Cake", "Beef Yaki Udon"));
        List<String> t497 = new ArrayList<>(List.of("Salmon sashimi", "Tuna Salmon Dynamite Roll", "Deluxe Sushi Platter", "Salmon sashimi", "Salmon sashimi", "Kani Salad", "Sprite"));
        List<String> t498 = new ArrayList<>(List.of("Chocolate Cake", "Salmon sashimi"));
        List<String> t499 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Tuna Salmon Dynamite Roll", "Tuna Salmon Dynamite Roll"));
        List<String> t500 = new ArrayList<>(List.of("Salmon sashimi", "Salmon sashimi", "Salmon sashimi", "Tuna Salmon Dynamite Roll", "Chocolate Cake", "Tuna Salmon Dynamite Roll"));

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
