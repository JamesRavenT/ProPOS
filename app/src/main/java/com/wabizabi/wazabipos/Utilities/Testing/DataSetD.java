package com.wabizabi.wazabipos.Utilities.Testing;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class DataSetD implements DataSet {
    public static void insertInto(List<List<String>> transactionsTB){

        List<String> t1 = new ArrayList<>(List.of("WZ Sushi Platter", "Salad Wrap"));
        List<String> t2 = new ArrayList<>(List.of("Ika", "Ika", "Ika", "Katsudon", "Coke"));
        List<String> t3 = new ArrayList<>(List.of("Ika", "Katsudon", "Chocolate Cake", "Ika", "Ika", "Ika"));
        List<String> t4 = new ArrayList<>(List.of("Coke", "Coke", "Salad Wrap"));
        List<String> t5 = new ArrayList<>(List.of("Ika", "WZ Sushi Platter", "Krazy Volcano", "Krazy Volcano", "WZ Sushi Platter", "Tantanmen"));
        List<String> t6 = new ArrayList<>(List.of("Ika", "Krazy Volcano", "Tantanmen", "Krazy Volcano", "Katsudon", "Krazy Volcano"));
        List<String> t7 = new ArrayList<>(List.of("Coke", "Ika", "WZ Sushi Platter", "Ika", "WZ Sushi Platter", "Coke"));
        List<String> t8 = new ArrayList<>(List.of("Ika", "Krazy Volcano", "WZ Sushi Platter", "Katsudon", "Katsudon", "Katsudon", "Tantanmen"));
        List<String> t9 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t10 = new ArrayList<>(List.of("Ika", "Salad Wrap", "Ika", "Katsudon", "Salad Wrap"));
        List<String> t11 = new ArrayList<>(List.of("Tantanmen", "WZ Sushi Platter"));
        List<String> t12 = new ArrayList<>(List.of("Chocolate Cake", "Krazy Volcano", "Ika", "Krazy Volcano", "Krazy Volcano", "Krazy Volcano", "Salad Wrap"));
        List<String> t13 = new ArrayList<>(List.of("Katsudon", "Ika", "Krazy Volcano", "Salad Wrap", "Ika"));
        List<String> t14 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen", "Chocolate Cake", "Chocolate Cake", "Ika", "Krazy Volcano", "Katsudon"));
        List<String> t15 = new ArrayList<>(List.of("Ika", "Krazy Volcano", "Coke", "Tantanmen", "Tantanmen", "Salad Wrap", "WZ Sushi Platter"));
        List<String> t16 = new ArrayList<>(List.of("Ika", "Tantanmen", "Coke", "Krazy Volcano", "Tantanmen", "Ika"));
        List<String> t17 = new ArrayList<>(List.of("Salad Wrap"));
        List<String> t18 = new ArrayList<>(List.of("Ika", "Tantanmen", "Coke", "Krazy Volcano"));
        List<String> t19 = new ArrayList<>(List.of("Tantanmen", "Salad Wrap", "Katsudon"));
        List<String> t20 = new ArrayList<>(List.of("Katsudon", "Salad Wrap", "Chocolate Cake"));
        List<String> t21 = new ArrayList<>(List.of("Salad Wrap", "WZ Sushi Platter", "Krazy Volcano", "Krazy Volcano", "Coke"));
        List<String> t22 = new ArrayList<>(List.of("WZ Sushi Platter", "Krazy Volcano"));
        List<String> t23 = new ArrayList<>(List.of("Tantanmen", "Ika", "Krazy Volcano", "Chocolate Cake", "Chocolate Cake", "Chocolate Cake"));
        List<String> t24 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t25 = new ArrayList<>(List.of("Ika", "Salad Wrap"));
        List<String> t26 = new ArrayList<>(List.of("Salad Wrap", "Salad Wrap", "WZ Sushi Platter", "Chocolate Cake"));
        List<String> t27 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t28 = new ArrayList<>(List.of("Tantanmen", "Katsudon", "Salad Wrap", "Ika"));
        List<String> t29 = new ArrayList<>(List.of("Krazy Volcano", "Katsudon", "Chocolate Cake"));
        List<String> t30 = new ArrayList<>(List.of("Ika", "Tantanmen", "Ika", "Coke", "Salad Wrap", "Coke"));
        List<String> t31 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t32 = new ArrayList<>(List.of("Krazy Volcano", "Salad Wrap"));
        List<String> t33 = new ArrayList<>(List.of("Ika"));
        List<String> t34 = new ArrayList<>(List.of("Ika", "Krazy Volcano", "Salad Wrap", "Krazy Volcano", "Salad Wrap", "Coke", "WZ Sushi Platter"));
        List<String> t35 = new ArrayList<>(List.of("Katsudon", "Salad Wrap"));
        List<String> t36 = new ArrayList<>(List.of("Tantanmen", "Chocolate Cake", "Ika", "Ika", "Tantanmen"));
        List<String> t37 = new ArrayList<>(List.of("Coke", "WZ Sushi Platter", "Coke", "Tantanmen", "Tantanmen", "Ika", "Katsudon"));
        List<String> t38 = new ArrayList<>(List.of("Coke", "Tantanmen", "Katsudon", "Krazy Volcano"));
        List<String> t39 = new ArrayList<>(List.of("Ika", "WZ Sushi Platter", "Tantanmen", "Ika"));
        List<String> t40 = new ArrayList<>(List.of("Ika", "Ika", "Katsudon", "Krazy Volcano", "WZ Sushi Platter", "Chocolate Cake", "WZ Sushi Platter"));
        List<String> t41 = new ArrayList<>(List.of("Coke", "WZ Sushi Platter"));
        List<String> t42 = new ArrayList<>(List.of("Coke", "Ika", "Tantanmen", "Coke", "Coke", "Chocolate Cake"));
        List<String> t43 = new ArrayList<>(List.of("Katsudon"));
        List<String> t44 = new ArrayList<>(List.of("Katsudon", "Katsudon", "Chocolate Cake", "Coke", "Krazy Volcano", "WZ Sushi Platter", "Krazy Volcano"));
        List<String> t45 = new ArrayList<>(List.of("Ika", "Ika"));
        List<String> t46 = new ArrayList<>(List.of("Ika", "Coke", "Ika", "WZ Sushi Platter", "WZ Sushi Platter", "Ika"));
        List<String> t47 = new ArrayList<>(List.of("WZ Sushi Platter", "Krazy Volcano"));
        List<String> t48 = new ArrayList<>(List.of("Katsudon", "Salad Wrap", "Ika", "Chocolate Cake"));
        List<String> t49 = new ArrayList<>(List.of("Katsudon", "Katsudon"));
        List<String> t50 = new ArrayList<>(List.of("Chocolate Cake", "Ika", "Tantanmen", "Salad Wrap", "Ika", "Krazy Volcano"));
        List<String> t51 = new ArrayList<>(List.of("Chocolate Cake", "Tantanmen", "Ika", "WZ Sushi Platter"));
        List<String> t52 = new ArrayList<>(List.of("Ika", "Ika", "Katsudon", "Ika", "Katsudon", "Ika"));
        List<String> t53 = new ArrayList<>(List.of("Chocolate Cake", "Ika", "Salad Wrap", "Ika", "Salad Wrap", "Katsudon"));
        List<String> t54 = new ArrayList<>(List.of("Ika", "Krazy Volcano", "Ika"));
        List<String> t55 = new ArrayList<>(List.of("Krazy Volcano", "Ika", "Krazy Volcano"));
        List<String> t56 = new ArrayList<>(List.of("Tantanmen"));
        List<String> t57 = new ArrayList<>(List.of("Chocolate Cake", "Salad Wrap", "WZ Sushi Platter", "Ika", "Chocolate Cake", "Ika"));
        List<String> t58 = new ArrayList<>(List.of("Katsudon", "WZ Sushi Platter", "Katsudon", "WZ Sushi Platter", "Coke", "Ika"));
        List<String> t59 = new ArrayList<>(List.of("Katsudon", "Ika", "Coke"));
        List<String> t60 = new ArrayList<>(List.of("Ika", "WZ Sushi Platter"));
        List<String> t61 = new ArrayList<>(List.of("Ika", "Ika"));
        List<String> t62 = new ArrayList<>(List.of("Salad Wrap", "Krazy Volcano"));
        List<String> t63 = new ArrayList<>(List.of("Ika", "Salad Wrap"));
        List<String> t64 = new ArrayList<>(List.of("Salad Wrap", "Salad Wrap", "Tantanmen"));
        List<String> t65 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t66 = new ArrayList<>(List.of("Tantanmen"));
        List<String> t67 = new ArrayList<>(List.of("Coke"));
        List<String> t68 = new ArrayList<>(List.of("WZ Sushi Platter", "Ika", "Salad Wrap", "Tantanmen", "Coke", "Katsudon", "Coke"));
        List<String> t69 = new ArrayList<>(List.of("Ika"));
        List<String> t70 = new ArrayList<>(List.of("Krazy Volcano", "Coke", "Coke", "Ika"));
        List<String> t71 = new ArrayList<>(List.of("Ika", "Krazy Volcano"));
        List<String> t72 = new ArrayList<>(List.of("Krazy Volcano", "Salad Wrap", "Ika", "Chocolate Cake"));
        List<String> t73 = new ArrayList<>(List.of("Salad Wrap"));
        List<String> t74 = new ArrayList<>(List.of("WZ Sushi Platter", "Ika"));
        List<String> t75 = new ArrayList<>(List.of("Ika"));
        List<String> t76 = new ArrayList<>(List.of("Krazy Volcano", "Coke"));
        List<String> t77 = new ArrayList<>(List.of("Coke", "Chocolate Cake", "Ika"));
        List<String> t78 = new ArrayList<>(List.of("Katsudon", "WZ Sushi Platter", "Ika", "Ika", "Coke", "Chocolate Cake"));
        List<String> t79 = new ArrayList<>(List.of("Chocolate Cake", "Katsudon", "Ika", "Katsudon", "Coke", "WZ Sushi Platter", "Ika"));
        List<String> t80 = new ArrayList<>(List.of("Salad Wrap", "Ika", "Krazy Volcano", "Tantanmen", "Katsudon", "Tantanmen"));
        List<String> t81 = new ArrayList<>(List.of("Krazy Volcano", "Krazy Volcano", "Ika", "Katsudon", "Ika", "Coke", "Krazy Volcano"));
        List<String> t82 = new ArrayList<>(List.of("Krazy Volcano", "Salad Wrap", "Chocolate Cake"));
        List<String> t83 = new ArrayList<>(List.of("Coke", "Katsudon", "WZ Sushi Platter", "Coke", "Krazy Volcano", "Ika"));
        List<String> t84 = new ArrayList<>(List.of("Coke"));
        List<String> t85 = new ArrayList<>(List.of("Krazy Volcano", "WZ Sushi Platter", "Ika", "Coke", "Coke", "Katsudon"));
        List<String> t86 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t87 = new ArrayList<>(List.of("Chocolate Cake", "Ika"));
        List<String> t88 = new ArrayList<>(List.of("Katsudon", "Salad Wrap", "Salad Wrap", "Katsudon", "Ika"));
        List<String> t89 = new ArrayList<>(List.of("Salad Wrap", "Ika", "Tantanmen", "Tantanmen", "Ika"));
        List<String> t90 = new ArrayList<>(List.of("Salad Wrap", "Coke", "Ika", "Chocolate Cake", "WZ Sushi Platter"));
        List<String> t91 = new ArrayList<>(List.of("Tantanmen", "Tantanmen"));
        List<String> t92 = new ArrayList<>(List.of("Krazy Volcano", "Tantanmen", "WZ Sushi Platter", "Coke", "Chocolate Cake"));
        List<String> t93 = new ArrayList<>(List.of("Salad Wrap", "Ika"));
        List<String> t94 = new ArrayList<>(List.of("Ika", "Katsudon"));
        List<String> t95 = new ArrayList<>(List.of("WZ Sushi Platter", "Coke", "Tantanmen", "WZ Sushi Platter", "Krazy Volcano", "WZ Sushi Platter", "Salad Wrap"));
        List<String> t96 = new ArrayList<>(List.of("Chocolate Cake", "Ika", "Chocolate Cake"));
        List<String> t97 = new ArrayList<>(List.of("Ika", "Salad Wrap"));
        List<String> t98 = new ArrayList<>(List.of("Katsudon", "Ika", "WZ Sushi Platter", "Ika", "WZ Sushi Platter", "Salad Wrap", "WZ Sushi Platter"));
        List<String> t99 = new ArrayList<>(List.of("Ika", "Chocolate Cake", "Ika", "Tantanmen", "Chocolate Cake", "Salad Wrap"));
        List<String> t100 = new ArrayList<>(List.of("Coke"));
        List<String> t101 = new ArrayList<>(List.of("Salad Wrap", "Ika", "Salad Wrap", "Salad Wrap"));
        List<String> t102 = new ArrayList<>(List.of("Chocolate Cake", "Ika", "Salad Wrap", "Katsudon", "Salad Wrap", "Chocolate Cake"));
        List<String> t103 = new ArrayList<>(List.of("Chocolate Cake", "WZ Sushi Platter", "Coke", "Coke", "Chocolate Cake", "Salad Wrap", "Ika"));
        List<String> t104 = new ArrayList<>(List.of("Tantanmen", "Krazy Volcano", "Krazy Volcano", "Chocolate Cake", "Krazy Volcano", "Ika", "Chocolate Cake"));
        List<String> t105 = new ArrayList<>(List.of("Chocolate Cake", "Katsudon", "Ika", "Ika"));
        List<String> t106 = new ArrayList<>(List.of("Krazy Volcano", "Katsudon", "Ika", "Katsudon", "Krazy Volcano", "WZ Sushi Platter", "Ika"));
        List<String> t107 = new ArrayList<>(List.of("Ika", "Chocolate Cake", "Ika", "Ika"));
        List<String> t108 = new ArrayList<>(List.of("Tantanmen", "Tantanmen"));
        List<String> t109 = new ArrayList<>(List.of("Tantanmen", "Tantanmen"));
        List<String> t110 = new ArrayList<>(List.of("Tantanmen", "Ika"));
        List<String> t111 = new ArrayList<>(List.of("Coke", "Ika", "Salad Wrap", "Chocolate Cake"));
        List<String> t112 = new ArrayList<>(List.of("Salad Wrap", "Ika", "Katsudon"));
        List<String> t113 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter", "Ika", "Tantanmen", "Krazy Volcano", "Coke", "Salad Wrap"));
        List<String> t114 = new ArrayList<>(List.of("Krazy Volcano", "Katsudon", "Coke", "Krazy Volcano"));
        List<String> t115 = new ArrayList<>(List.of("Coke", "WZ Sushi Platter", "Ika", "Katsudon"));
        List<String> t116 = new ArrayList<>(List.of("Coke", "Coke", "Coke", "Ika"));
        List<String> t117 = new ArrayList<>(List.of("Ika"));
        List<String> t118 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Katsudon", "Ika"));
        List<String> t119 = new ArrayList<>(List.of("Chocolate Cake", "Salad Wrap", "WZ Sushi Platter"));
        List<String> t120 = new ArrayList<>(List.of("Salad Wrap", "Krazy Volcano", "Krazy Volcano"));
        List<String> t121 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t122 = new ArrayList<>(List.of("Tantanmen"));
        List<String> t123 = new ArrayList<>(List.of("Tantanmen", "Ika", "Chocolate Cake", "Katsudon"));
        List<String> t124 = new ArrayList<>(List.of("Salad Wrap", "Katsudon", "Salad Wrap", "Ika", "Katsudon"));
        List<String> t125 = new ArrayList<>(List.of("Salad Wrap", "Chocolate Cake", "Krazy Volcano", "Katsudon", "Coke", "Salad Wrap"));
        List<String> t126 = new ArrayList<>(List.of("Krazy Volcano"));
        List<String> t127 = new ArrayList<>(List.of("Tantanmen"));
        List<String> t128 = new ArrayList<>(List.of("Chocolate Cake", "Ika", "Coke", "Tantanmen"));
        List<String> t129 = new ArrayList<>(List.of("Krazy Volcano", "Ika", "WZ Sushi Platter", "Ika"));
        List<String> t130 = new ArrayList<>(List.of("WZ Sushi Platter", "Ika", "Chocolate Cake", "WZ Sushi Platter", "Coke", "Chocolate Cake", "Tantanmen"));
        List<String> t131 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Coke", "Chocolate Cake", "Salad Wrap", "Katsudon", "Ika"));
        List<String> t132 = new ArrayList<>(List.of("Krazy Volcano", "Ika", "WZ Sushi Platter", "Krazy Volcano"));
        List<String> t133 = new ArrayList<>(List.of("Salad Wrap", "Katsudon", "Tantanmen", "Tantanmen", "Tantanmen"));
        List<String> t134 = new ArrayList<>(List.of("Ika", "WZ Sushi Platter", "Coke", "WZ Sushi Platter"));
        List<String> t135 = new ArrayList<>(List.of("Salad Wrap", "WZ Sushi Platter", "Krazy Volcano", "Salad Wrap", "Tantanmen", "Salad Wrap", "WZ Sushi Platter"));
        List<String> t136 = new ArrayList<>(List.of("Tantanmen", "Coke", "Ika", "Krazy Volcano", "Ika"));
        List<String> t137 = new ArrayList<>(List.of("Chocolate Cake", "WZ Sushi Platter", "Ika", "Salad Wrap", "Ika", "Salad Wrap"));
        List<String> t138 = new ArrayList<>(List.of("Tantanmen", "Ika", "Tantanmen", "Ika"));
        List<String> t139 = new ArrayList<>(List.of("Ika", "Katsudon", "Chocolate Cake"));
        List<String> t140 = new ArrayList<>(List.of("Coke", "Coke", "Ika", "WZ Sushi Platter"));
        List<String> t141 = new ArrayList<>(List.of("Tantanmen", "WZ Sushi Platter", "WZ Sushi Platter", "Tantanmen", "WZ Sushi Platter", "WZ Sushi Platter", "Ika"));
        List<String> t142 = new ArrayList<>(List.of("Ika", "Ika", "Coke", "Ika", "Tantanmen", "Coke"));
        List<String> t143 = new ArrayList<>(List.of("Krazy Volcano", "Ika", "Tantanmen", "Ika", "Ika", "Chocolate Cake"));
        List<String> t144 = new ArrayList<>(List.of("Coke", "Tantanmen", "WZ Sushi Platter", "Ika", "Salad Wrap", "Coke"));
        List<String> t145 = new ArrayList<>(List.of("Chocolate Cake", "Katsudon", "Ika", "Ika"));
        List<String> t146 = new ArrayList<>(List.of("Chocolate Cake", "Ika", "Ika", "Tantanmen", "Chocolate Cake", "Chocolate Cake"));
        List<String> t147 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter", "Ika", "Coke", "Salad Wrap", "Salad Wrap", "Chocolate Cake"));
        List<String> t148 = new ArrayList<>(List.of("Coke", "Salad Wrap"));
        List<String> t149 = new ArrayList<>(List.of("Salad Wrap", "Ika", "Krazy Volcano", "Krazy Volcano"));
        List<String> t150 = new ArrayList<>(List.of("Ika", "Krazy Volcano"));
        List<String> t151 = new ArrayList<>(List.of("Tantanmen", "WZ Sushi Platter", "Katsudon", "Chocolate Cake", "Tantanmen", "Krazy Volcano", "Chocolate Cake"));
        List<String> t152 = new ArrayList<>(List.of("Ika", "Salad Wrap", "Salad Wrap", "Salad Wrap", "Ika"));
        List<String> t153 = new ArrayList<>(List.of("Chocolate Cake", "Tantanmen", "Ika", "WZ Sushi Platter", "Ika"));
        List<String> t154 = new ArrayList<>(List.of("Krazy Volcano", "Salad Wrap", "Tantanmen", "Coke", "Salad Wrap", "Katsudon", "Tantanmen"));
        List<String> t155 = new ArrayList<>(List.of("Ika", "Ika"));
        List<String> t156 = new ArrayList<>(List.of("Krazy Volcano", "Ika", "Ika", "Ika"));
        List<String> t157 = new ArrayList<>(List.of("Krazy Volcano", "Tantanmen", "Salad Wrap", "Ika", "WZ Sushi Platter", "Ika", "Coke"));
        List<String> t158 = new ArrayList<>(List.of("Ika", "Chocolate Cake", "Ika", "Tantanmen", "Coke", "Katsudon"));
        List<String> t159 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t160 = new ArrayList<>(List.of("Tantanmen", "Salad Wrap"));
        List<String> t161 = new ArrayList<>(List.of("Krazy Volcano", "Ika", "Salad Wrap", "Salad Wrap", "Salad Wrap"));
        List<String> t162 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t163 = new ArrayList<>(List.of("WZ Sushi Platter", "Chocolate Cake", "Ika", "Salad Wrap"));
        List<String> t164 = new ArrayList<>(List.of("Coke"));
        List<String> t165 = new ArrayList<>(List.of("Coke", "Salad Wrap", "Ika", "Chocolate Cake", "Ika", "Salad Wrap", "Ika"));
        List<String> t166 = new ArrayList<>(List.of("Tantanmen", "Tantanmen", "Tantanmen", "Salad Wrap", "Coke", "Coke"));
        List<String> t167 = new ArrayList<>(List.of("Ika", "Coke", "Ika"));
        List<String> t168 = new ArrayList<>(List.of("Ika", "Chocolate Cake", "Ika", "Tantanmen", "Krazy Volcano"));
        List<String> t169 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t170 = new ArrayList<>(List.of("Katsudon", "WZ Sushi Platter", "Katsudon"));
        List<String> t171 = new ArrayList<>(List.of("WZ Sushi Platter", "Krazy Volcano", "Ika"));
        List<String> t172 = new ArrayList<>(List.of("Ika", "WZ Sushi Platter"));
        List<String> t173 = new ArrayList<>(List.of("Salad Wrap", "Salad Wrap"));
        List<String> t174 = new ArrayList<>(List.of("Coke", "Tantanmen", "Tantanmen", "Tantanmen", "Katsudon", "Krazy Volcano", "Coke"));
        List<String> t175 = new ArrayList<>(List.of("Ika", "Ika", "Katsudon", "Chocolate Cake", "Chocolate Cake", "Salad Wrap", "Ika"));
        List<String> t176 = new ArrayList<>(List.of("Ika", "Ika", "Chocolate Cake", "Chocolate Cake", "Ika"));
        List<String> t177 = new ArrayList<>(List.of("Ika", "WZ Sushi Platter", "WZ Sushi Platter", "Tantanmen"));
        List<String> t178 = new ArrayList<>(List.of("Katsudon", "Ika", "WZ Sushi Platter"));
        List<String> t179 = new ArrayList<>(List.of("Salad Wrap", "Ika", "Coke", "WZ Sushi Platter"));
        List<String> t180 = new ArrayList<>(List.of("Coke", "Ika", "Katsudon", "Chocolate Cake", "Krazy Volcano", "Salad Wrap", "Katsudon"));
        List<String> t181 = new ArrayList<>(List.of("Salad Wrap", "WZ Sushi Platter", "Coke", "WZ Sushi Platter", "Krazy Volcano"));
        List<String> t182 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter", "Salad Wrap", "Krazy Volcano"));
        List<String> t183 = new ArrayList<>(List.of("Ika", "Chocolate Cake", "Tantanmen", "WZ Sushi Platter", "Salad Wrap", "Coke"));
        List<String> t184 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Ika", "Salad Wrap", "Salad Wrap", "Chocolate Cake"));
        List<String> t185 = new ArrayList<>(List.of("Ika"));
        List<String> t186 = new ArrayList<>(List.of("Salad Wrap", "Tantanmen", "Katsudon", "Coke", "Salad Wrap", "Katsudon", "Coke"));
        List<String> t187 = new ArrayList<>(List.of("Tantanmen", "WZ Sushi Platter", "Ika"));
        List<String> t188 = new ArrayList<>(List.of("Coke", "Tantanmen", "Chocolate Cake", "Ika", "Ika", "Salad Wrap", "Katsudon"));
        List<String> t189 = new ArrayList<>(List.of("Ika", "Tantanmen", "Tantanmen", "Krazy Volcano", "Tantanmen"));
        List<String> t190 = new ArrayList<>(List.of("Ika", "Katsudon", "Ika", "Coke", "Ika", "Katsudon", "Salad Wrap"));
        List<String> t191 = new ArrayList<>(List.of("Ika", "Ika"));
        List<String> t192 = new ArrayList<>(List.of("WZ Sushi Platter", "Krazy Volcano"));
        List<String> t193 = new ArrayList<>(List.of("Salad Wrap"));
        List<String> t194 = new ArrayList<>(List.of("Katsudon", "Salad Wrap", "Ika", "Tantanmen", "WZ Sushi Platter", "Ika"));
        List<String> t195 = new ArrayList<>(List.of("Tantanmen", "Krazy Volcano"));
        List<String> t196 = new ArrayList<>(List.of("Ika", "WZ Sushi Platter", "Chocolate Cake", "Ika", "Coke"));
        List<String> t197 = new ArrayList<>(List.of("Krazy Volcano", "WZ Sushi Platter"));
        List<String> t198 = new ArrayList<>(List.of("Tantanmen", "WZ Sushi Platter", "Krazy Volcano", "Salad Wrap", "Chocolate Cake"));
        List<String> t199 = new ArrayList<>(List.of("Katsudon"));
        List<String> t200 = new ArrayList<>(List.of("Ika", "Katsudon", "Chocolate Cake", "Ika", "Coke", "Coke"));
        List<String> t201 = new ArrayList<>(List.of("Salad Wrap", "Krazy Volcano", "Krazy Volcano", "Tantanmen", "Krazy Volcano", "WZ Sushi Platter", "Ika"));
        List<String> t202 = new ArrayList<>(List.of("Ika", "Tantanmen"));
        List<String> t203 = new ArrayList<>(List.of("Ika", "Tantanmen", "Coke", "WZ Sushi Platter"));
        List<String> t204 = new ArrayList<>(List.of("Coke", "Coke", "Chocolate Cake"));
        List<String> t205 = new ArrayList<>(List.of("WZ Sushi Platter", "Ika"));
        List<String> t206 = new ArrayList<>(List.of("Coke", "Coke", "Katsudon"));
        List<String> t207 = new ArrayList<>(List.of("Chocolate Cake", "Salad Wrap", "Salad Wrap", "Coke", "Tantanmen"));
        List<String> t208 = new ArrayList<>(List.of("Katsudon"));
        List<String> t209 = new ArrayList<>(List.of("Ika", "WZ Sushi Platter", "WZ Sushi Platter", "Salad Wrap", "Krazy Volcano", "WZ Sushi Platter", "Ika"));
        List<String> t210 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen"));
        List<String> t211 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t212 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen"));
        List<String> t213 = new ArrayList<>(List.of("Ika", "Krazy Volcano", "Salad Wrap"));
        List<String> t214 = new ArrayList<>(List.of("Salad Wrap", "Ika", "WZ Sushi Platter", "Chocolate Cake", "Ika", "Krazy Volcano", "Ika"));
        List<String> t215 = new ArrayList<>(List.of("Coke", "Ika", "Krazy Volcano", "Krazy Volcano"));
        List<String> t216 = new ArrayList<>(List.of("Tantanmen", "Chocolate Cake", "Katsudon", "Salad Wrap", "Salad Wrap", "Coke", "Tantanmen"));
        List<String> t217 = new ArrayList<>(List.of("WZ Sushi Platter", "Ika", "Ika", "Ika"));
        List<String> t218 = new ArrayList<>(List.of("Ika", "Chocolate Cake", "Ika", "Ika", "Katsudon"));
        List<String> t219 = new ArrayList<>(List.of("Ika", "Tantanmen", "Chocolate Cake"));
        List<String> t220 = new ArrayList<>(List.of("Ika", "Coke", "Salad Wrap"));
        List<String> t221 = new ArrayList<>(List.of("Ika", "Coke", "Chocolate Cake", "Katsudon", "Ika", "Katsudon", "Krazy Volcano"));
        List<String> t222 = new ArrayList<>(List.of("Salad Wrap", "Ika", "Krazy Volcano"));
        List<String> t223 = new ArrayList<>(List.of("Krazy Volcano", "Chocolate Cake", "Ika", "Salad Wrap", "Chocolate Cake", "Tantanmen", "Coke"));
        List<String> t224 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake"));
        List<String> t225 = new ArrayList<>(List.of("WZ Sushi Platter", "Ika", "Ika", "Coke", "Chocolate Cake", "Ika", "Ika"));
        List<String> t226 = new ArrayList<>(List.of("Coke"));
        List<String> t227 = new ArrayList<>(List.of("Chocolate Cake", "Coke", "Katsudon", "WZ Sushi Platter", "Katsudon"));
        List<String> t228 = new ArrayList<>(List.of("Tantanmen", "Ika"));
        List<String> t229 = new ArrayList<>(List.of("Krazy Volcano", "WZ Sushi Platter", "Ika", "Ika", "Katsudon", "WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t230 = new ArrayList<>(List.of("Krazy Volcano", "Chocolate Cake", "Katsudon", "Ika", "Ika", "Ika"));
        List<String> t231 = new ArrayList<>(List.of("Krazy Volcano", "Ika"));
        List<String> t232 = new ArrayList<>(List.of("Ika"));
        List<String> t233 = new ArrayList<>(List.of("Ika", "Salad Wrap", "Katsudon", "Ika", "Tantanmen", "Ika"));
        List<String> t234 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t235 = new ArrayList<>(List.of("Krazy Volcano"));
        List<String> t236 = new ArrayList<>(List.of("Tantanmen", "Tantanmen", "Ika", "Ika", "Tantanmen", "Krazy Volcano"));
        List<String> t237 = new ArrayList<>(List.of("Krazy Volcano", "Salad Wrap"));
        List<String> t238 = new ArrayList<>(List.of("Salad Wrap", "Ika", "Ika", "Chocolate Cake", "Ika", "Krazy Volcano"));
        List<String> t239 = new ArrayList<>(List.of("Tantanmen", "Tantanmen", "Ika", "Ika", "Krazy Volcano"));
        List<String> t240 = new ArrayList<>(List.of("Salad Wrap", "Krazy Volcano", "Salad Wrap", "Ika"));
        List<String> t241 = new ArrayList<>(List.of("Coke", "Krazy Volcano", "Chocolate Cake", "Katsudon"));
        List<String> t242 = new ArrayList<>(List.of("Tantanmen", "Chocolate Cake", "Ika", "Coke", "Krazy Volcano"));
        List<String> t243 = new ArrayList<>(List.of("Salad Wrap", "Katsudon"));
        List<String> t244 = new ArrayList<>(List.of("Katsudon", "Krazy Volcano", "Coke", "Tantanmen", "Chocolate Cake", "Chocolate Cake"));
        List<String> t245 = new ArrayList<>(List.of("Salad Wrap", "Ika"));
        List<String> t246 = new ArrayList<>(List.of("Katsudon", "Katsudon", "Coke", "Coke"));
        List<String> t247 = new ArrayList<>(List.of("Ika", "Krazy Volcano", "Tantanmen"));
        List<String> t248 = new ArrayList<>(List.of("Krazy Volcano", "Chocolate Cake", "Salad Wrap", "Chocolate Cake"));
        List<String> t249 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen"));
        List<String> t250 = new ArrayList<>(List.of("Ika", "Chocolate Cake", "Ika"));
        List<String> t251 = new ArrayList<>(List.of("Katsudon", "Krazy Volcano"));
        List<String> t252 = new ArrayList<>(List.of("Ika", "Tantanmen", "Salad Wrap", "Tantanmen", "WZ Sushi Platter"));
        List<String> t253 = new ArrayList<>(List.of("Ika", "Salad Wrap"));
        List<String> t254 = new ArrayList<>(List.of("Tantanmen", "Chocolate Cake", "Tantanmen", "Coke"));
        List<String> t255 = new ArrayList<>(List.of("Ika", "Coke", "Coke", "WZ Sushi Platter", "WZ Sushi Platter", "Ika"));
        List<String> t256 = new ArrayList<>(List.of("WZ Sushi Platter", "Salad Wrap", "WZ Sushi Platter", "Tantanmen", "Ika"));
        List<String> t257 = new ArrayList<>(List.of("Krazy Volcano", "Ika"));
        List<String> t258 = new ArrayList<>(List.of("Coke"));
        List<String> t259 = new ArrayList<>(List.of("Tantanmen", "Krazy Volcano", "Ika", "Ika", "Tantanmen", "WZ Sushi Platter"));
        List<String> t260 = new ArrayList<>(List.of("Tantanmen", "Katsudon", "Coke", "WZ Sushi Platter"));
        List<String> t261 = new ArrayList<>(List.of("Krazy Volcano", "Ika", "Ika", "Coke", "Salad Wrap"));
        List<String> t262 = new ArrayList<>(List.of("WZ Sushi Platter", "Salad Wrap", "Krazy Volcano", "Tantanmen", "Krazy Volcano"));
        List<String> t263 = new ArrayList<>(List.of("Salad Wrap", "Chocolate Cake"));
        List<String> t264 = new ArrayList<>(List.of("Katsudon"));
        List<String> t265 = new ArrayList<>(List.of("Ika", "Salad Wrap", "Krazy Volcano", "Katsudon", "WZ Sushi Platter", "Krazy Volcano"));
        List<String> t266 = new ArrayList<>(List.of("Salad Wrap", "Ika"));
        List<String> t267 = new ArrayList<>(List.of("Katsudon", "WZ Sushi Platter"));
        List<String> t268 = new ArrayList<>(List.of("Chocolate Cake", "WZ Sushi Platter"));
        List<String> t269 = new ArrayList<>(List.of("Tantanmen", "Salad Wrap"));
        List<String> t270 = new ArrayList<>(List.of("Ika", "Tantanmen", "Krazy Volcano", "Tantanmen"));
        List<String> t271 = new ArrayList<>(List.of("Salad Wrap", "Katsudon", "Ika", "Katsudon", "Tantanmen", "Ika"));
        List<String> t272 = new ArrayList<>(List.of("Salad Wrap", "Tantanmen"));
        List<String> t273 = new ArrayList<>(List.of("Katsudon"));
        List<String> t274 = new ArrayList<>(List.of("Chocolate Cake", "WZ Sushi Platter", "WZ Sushi Platter", "WZ Sushi Platter", "Coke", "Coke"));
        List<String> t275 = new ArrayList<>(List.of("Katsudon", "WZ Sushi Platter"));
        List<String> t276 = new ArrayList<>(List.of("Salad Wrap"));
        List<String> t277 = new ArrayList<>(List.of("Salad Wrap", "Chocolate Cake"));
        List<String> t278 = new ArrayList<>(List.of("Chocolate Cake", "Ika", "Salad Wrap", "Chocolate Cake", "Salad Wrap"));
        List<String> t279 = new ArrayList<>(List.of("Krazy Volcano", "Ika"));
        List<String> t280 = new ArrayList<>(List.of("Chocolate Cake", "Ika", "Tantanmen", "Tantanmen"));
        List<String> t281 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t282 = new ArrayList<>(List.of("Tantanmen", "Chocolate Cake", "Salad Wrap", "Tantanmen", "Tantanmen", "Ika", "Ika"));
        List<String> t283 = new ArrayList<>(List.of("Krazy Volcano", "Krazy Volcano", "Tantanmen", "Chocolate Cake", "WZ Sushi Platter", "Tantanmen"));
        List<String> t284 = new ArrayList<>(List.of("Salad Wrap", "Ika", "WZ Sushi Platter", "Salad Wrap", "Katsudon"));
        List<String> t285 = new ArrayList<>(List.of("Coke", "WZ Sushi Platter", "Tantanmen", "Ika"));
        List<String> t286 = new ArrayList<>(List.of("Coke", "Krazy Volcano", "Salad Wrap", "Ika"));
        List<String> t287 = new ArrayList<>(List.of("Ika", "Chocolate Cake"));
        List<String> t288 = new ArrayList<>(List.of("Salad Wrap", "Salad Wrap"));
        List<String> t289 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t290 = new ArrayList<>(List.of("Krazy Volcano", "Ika", "Salad Wrap", "Ika"));
        List<String> t291 = new ArrayList<>(List.of("Salad Wrap"));
        List<String> t292 = new ArrayList<>(List.of("Tantanmen", "WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t293 = new ArrayList<>(List.of("WZ Sushi Platter", "Ika", "Coke", "Coke"));
        List<String> t294 = new ArrayList<>(List.of("Krazy Volcano", "Ika"));
        List<String> t295 = new ArrayList<>(List.of("Krazy Volcano", "Salad Wrap"));
        List<String> t296 = new ArrayList<>(List.of("Krazy Volcano", "Ika"));
        List<String> t297 = new ArrayList<>(List.of("Ika", "Krazy Volcano", "Katsudon"));
        List<String> t298 = new ArrayList<>(List.of("Ika"));
        List<String> t299 = new ArrayList<>(List.of("WZ Sushi Platter", "Ika"));
        List<String> t300 = new ArrayList<>(List.of("Ika", "Coke", "Ika"));
        List<String> t301 = new ArrayList<>(List.of("WZ Sushi Platter", "Katsudon", "Ika", "Krazy Volcano"));
        List<String> t302 = new ArrayList<>(List.of("WZ Sushi Platter", "Katsudon", "Krazy Volcano", "Ika", "Krazy Volcano"));
        List<String> t303 = new ArrayList<>(List.of("Ika", "Coke", "Ika", "Coke", "Krazy Volcano", "Coke", "Salad Wrap"));
        List<String> t304 = new ArrayList<>(List.of("Krazy Volcano", "Salad Wrap"));
        List<String> t305 = new ArrayList<>(List.of("Ika", "Ika", "Salad Wrap", "WZ Sushi Platter", "Coke", "WZ Sushi Platter", "Krazy Volcano"));
        List<String> t306 = new ArrayList<>(List.of("Ika", "Ika", "WZ Sushi Platter", "Krazy Volcano"));
        List<String> t307 = new ArrayList<>(List.of("Chocolate Cake", "Krazy Volcano", "Ika", "Ika", "Salad Wrap"));
        List<String> t308 = new ArrayList<>(List.of("Katsudon", "WZ Sushi Platter", "Tantanmen"));
        List<String> t309 = new ArrayList<>(List.of("Ika", "Chocolate Cake", "Salad Wrap", "Coke"));
        List<String> t310 = new ArrayList<>(List.of("Ika", "Coke", "Katsudon", "Tantanmen", "Ika"));
        List<String> t311 = new ArrayList<>(List.of("Chocolate Cake", "Coke", "Tantanmen", "Ika", "Katsudon"));
        List<String> t312 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter", "Tantanmen", "Salad Wrap"));
        List<String> t313 = new ArrayList<>(List.of("WZ Sushi Platter", "Ika"));
        List<String> t314 = new ArrayList<>(List.of("Tantanmen", "Chocolate Cake", "Ika"));
        List<String> t315 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t316 = new ArrayList<>(List.of("Katsudon", "Ika", "Krazy Volcano", "Salad Wrap", "Chocolate Cake", "WZ Sushi Platter", "Tantanmen"));
        List<String> t317 = new ArrayList<>(List.of("Krazy Volcano", "Ika", "Coke", "Ika", "WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t318 = new ArrayList<>(List.of("Katsudon", "Krazy Volcano", "Tantanmen", "Coke"));
        List<String> t319 = new ArrayList<>(List.of("Coke", "Krazy Volcano", "Krazy Volcano", "Chocolate Cake"));
        List<String> t320 = new ArrayList<>(List.of("Ika", "Tantanmen"));
        List<String> t321 = new ArrayList<>(List.of("WZ Sushi Platter", "Katsudon"));
        List<String> t322 = new ArrayList<>(List.of("Krazy Volcano"));
        List<String> t323 = new ArrayList<>(List.of("Katsudon", "WZ Sushi Platter", "Krazy Volcano", "Katsudon", "Salad Wrap", "Krazy Volcano", "Coke"));
        List<String> t324 = new ArrayList<>(List.of("Tantanmen", "Krazy Volcano"));
        List<String> t325 = new ArrayList<>(List.of("Krazy Volcano", "Krazy Volcano"));
        List<String> t326 = new ArrayList<>(List.of("Katsudon", "Ika", "Salad Wrap", "Tantanmen"));
        List<String> t327 = new ArrayList<>(List.of("Krazy Volcano"));
        List<String> t328 = new ArrayList<>(List.of("Ika", "Tantanmen", "Katsudon", "WZ Sushi Platter"));
        List<String> t329 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t330 = new ArrayList<>(List.of("Chocolate Cake", "Salad Wrap", "Salad Wrap", "Tantanmen", "Krazy Volcano", "WZ Sushi Platter", "Katsudon"));
        List<String> t331 = new ArrayList<>(List.of("Salad Wrap", "WZ Sushi Platter", "Coke", "Krazy Volcano", "Coke", "Salad Wrap"));
        List<String> t332 = new ArrayList<>(List.of("Chocolate Cake", "Krazy Volcano", "Krazy Volcano"));
        List<String> t333 = new ArrayList<>(List.of("Salad Wrap"));
        List<String> t334 = new ArrayList<>(List.of("Salad Wrap", "Coke", "Krazy Volcano", "WZ Sushi Platter", "Salad Wrap"));
        List<String> t335 = new ArrayList<>(List.of("Tantanmen", "Tantanmen"));
        List<String> t336 = new ArrayList<>(List.of("Chocolate Cake", "Katsudon", "Tantanmen"));
        List<String> t337 = new ArrayList<>(List.of("Ika", "Salad Wrap"));
        List<String> t338 = new ArrayList<>(List.of("Ika", "Salad Wrap"));
        List<String> t339 = new ArrayList<>(List.of("Krazy Volcano", "Krazy Volcano"));
        List<String> t340 = new ArrayList<>(List.of("Ika", "Ika"));
        List<String> t341 = new ArrayList<>(List.of("Krazy Volcano", "Chocolate Cake", "Krazy Volcano", "Tantanmen", "Katsudon"));
        List<String> t342 = new ArrayList<>(List.of("Tantanmen"));
        List<String> t343 = new ArrayList<>(List.of("Ika", "Ika"));
        List<String> t344 = new ArrayList<>(List.of("WZ Sushi Platter", "Krazy Volcano", "WZ Sushi Platter", "WZ Sushi Platter", "WZ Sushi Platter", "Tantanmen"));
        List<String> t345 = new ArrayList<>(List.of("Ika", "Salad Wrap", "Coke", "Salad Wrap", "Chocolate Cake", "Krazy Volcano"));
        List<String> t346 = new ArrayList<>(List.of("Salad Wrap", "Katsudon", "Katsudon", "Krazy Volcano"));
        List<String> t347 = new ArrayList<>(List.of("Chocolate Cake", "Katsudon", "Ika", "Ika", "Salad Wrap", "Salad Wrap", "Ika"));
        List<String> t348 = new ArrayList<>(List.of("Salad Wrap", "Chocolate Cake", "Salad Wrap", "Ika", "Chocolate Cake", "Ika", "Krazy Volcano"));
        List<String> t349 = new ArrayList<>(List.of("Coke", "Katsudon"));
        List<String> t350 = new ArrayList<>(List.of("Coke", "WZ Sushi Platter"));
        List<String> t351 = new ArrayList<>(List.of("Katsudon", "Krazy Volcano", "Salad Wrap", "Katsudon", "Coke"));
        List<String> t352 = new ArrayList<>(List.of("WZ Sushi Platter", "Ika"));
        List<String> t353 = new ArrayList<>(List.of("Ika", "Salad Wrap", "Ika", "Chocolate Cake", "Chocolate Cake", "Tantanmen"));
        List<String> t354 = new ArrayList<>(List.of("Ika", "Chocolate Cake", "Krazy Volcano", "Katsudon", "Coke", "Ika"));
        List<String> t355 = new ArrayList<>(List.of("WZ Sushi Platter", "Ika", "Salad Wrap"));
        List<String> t356 = new ArrayList<>(List.of("Ika", "Tantanmen"));
        List<String> t357 = new ArrayList<>(List.of("Salad Wrap", "Katsudon", "Tantanmen", "Coke", "Katsudon"));
        List<String> t358 = new ArrayList<>(List.of("Coke"));
        List<String> t359 = new ArrayList<>(List.of("Ika", "Tantanmen", "WZ Sushi Platter"));
        List<String> t360 = new ArrayList<>(List.of("Salad Wrap", "Chocolate Cake", "WZ Sushi Platter", "Ika", "Salad Wrap"));
        List<String> t361 = new ArrayList<>(List.of("Krazy Volcano", "WZ Sushi Platter"));
        List<String> t362 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen", "Coke", "WZ Sushi Platter"));
        List<String> t363 = new ArrayList<>(List.of("Coke", "Katsudon", "Salad Wrap", "Ika"));
        List<String> t364 = new ArrayList<>(List.of("Tantanmen", "Chocolate Cake", "WZ Sushi Platter", "Coke", "Tantanmen"));
        List<String> t365 = new ArrayList<>(List.of("Ika", "Tantanmen", "WZ Sushi Platter", "Ika", "Ika"));
        List<String> t366 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t367 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t368 = new ArrayList<>(List.of("Coke", "WZ Sushi Platter", "Ika", "Katsudon", "Ika", "WZ Sushi Platter"));
        List<String> t369 = new ArrayList<>(List.of("Tantanmen", "Ika"));
        List<String> t370 = new ArrayList<>(List.of("Salad Wrap", "WZ Sushi Platter", "Krazy Volcano", "Ika", "Ika", "Ika"));
        List<String> t371 = new ArrayList<>(List.of("Katsudon", "Tantanmen", "Ika"));
        List<String> t372 = new ArrayList<>(List.of("Ika", "Chocolate Cake"));
        List<String> t373 = new ArrayList<>(List.of("Ika"));
        List<String> t374 = new ArrayList<>(List.of("Katsudon", "Katsudon", "Coke", "Ika", "Tantanmen", "Krazy Volcano", "Katsudon"));
        List<String> t375 = new ArrayList<>(List.of("Tantanmen", "Ika", "Katsudon", "Chocolate Cake", "Tantanmen", "WZ Sushi Platter"));
        List<String> t376 = new ArrayList<>(List.of("WZ Sushi Platter", "Ika", "Tantanmen", "Chocolate Cake", "Katsudon", "Chocolate Cake"));
        List<String> t377 = new ArrayList<>(List.of("Coke", "WZ Sushi Platter", "Ika", "Chocolate Cake", "WZ Sushi Platter"));
        List<String> t378 = new ArrayList<>(List.of("Ika", "Ika"));
        List<String> t379 = new ArrayList<>(List.of("Salad Wrap", "Tantanmen", "Krazy Volcano", "Ika", "Ika"));
        List<String> t380 = new ArrayList<>(List.of("Ika", "Coke", "Ika", "Ika", "Krazy Volcano", "Chocolate Cake", "Krazy Volcano"));
        List<String> t381 = new ArrayList<>(List.of("WZ Sushi Platter", "Salad Wrap"));
        List<String> t382 = new ArrayList<>(List.of("Chocolate Cake", "Tantanmen", "Coke", "Chocolate Cake"));
        List<String> t383 = new ArrayList<>(List.of("Coke", "Coke", "Coke", "Katsudon"));
        List<String> t384 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter", "Katsudon", "Tantanmen"));
        List<String> t385 = new ArrayList<>(List.of("Coke", "Tantanmen", "WZ Sushi Platter", "Krazy Volcano", "Ika", "Coke", "Ika"));
        List<String> t386 = new ArrayList<>(List.of("Salad Wrap", "Coke", "Coke", "Ika", "Salad Wrap"));
        List<String> t387 = new ArrayList<>(List.of("Katsudon"));
        List<String> t388 = new ArrayList<>(List.of("Krazy Volcano", "Ika", "WZ Sushi Platter", "Ika"));
        List<String> t389 = new ArrayList<>(List.of("Ika", "Katsudon", "Krazy Volcano", "Ika", "Salad Wrap"));
        List<String> t390 = new ArrayList<>(List.of("Krazy Volcano", "WZ Sushi Platter"));
        List<String> t391 = new ArrayList<>(List.of("Salad Wrap", "WZ Sushi Platter"));
        List<String> t392 = new ArrayList<>(List.of("Coke"));
        List<String> t393 = new ArrayList<>(List.of("Coke", "Salad Wrap", "Ika", "Tantanmen", "Krazy Volcano", "Coke"));
        List<String> t394 = new ArrayList<>(List.of("Ika"));
        List<String> t395 = new ArrayList<>(List.of("Katsudon", "Ika"));
        List<String> t396 = new ArrayList<>(List.of("Coke", "Tantanmen", "Ika", "WZ Sushi Platter", "Salad Wrap"));
        List<String> t397 = new ArrayList<>(List.of("Katsudon", "Katsudon", "Tantanmen", "Chocolate Cake", "Krazy Volcano"));
        List<String> t398 = new ArrayList<>(List.of("Salad Wrap", "Tantanmen", "WZ Sushi Platter", "Chocolate Cake", "Ika", "Krazy Volcano"));
        List<String> t399 = new ArrayList<>(List.of("Salad Wrap", "Tantanmen", "Salad Wrap", "Chocolate Cake"));
        List<String> t400 = new ArrayList<>(List.of("Salad Wrap", "Coke"));
        List<String> t401 = new ArrayList<>(List.of("WZ Sushi Platter", "Chocolate Cake", "Tantanmen", "Ika", "Katsudon", "Krazy Volcano", "Salad Wrap"));
        List<String> t402 = new ArrayList<>(List.of("Salad Wrap", "Krazy Volcano", "WZ Sushi Platter"));
        List<String> t403 = new ArrayList<>(List.of("Chocolate Cake", "WZ Sushi Platter", "Krazy Volcano", "Salad Wrap", "Ika", "Ika"));
        List<String> t404 = new ArrayList<>(List.of("Katsudon", "Ika", "WZ Sushi Platter", "Ika", "Ika", "Salad Wrap"));
        List<String> t405 = new ArrayList<>(List.of("Salad Wrap", "Ika"));
        List<String> t406 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen", "Ika", "WZ Sushi Platter", "Ika", "Chocolate Cake"));
        List<String> t407 = new ArrayList<>(List.of("Ika"));
        List<String> t408 = new ArrayList<>(List.of("Salad Wrap"));
        List<String> t409 = new ArrayList<>(List.of("Chocolate Cake", "Tantanmen", "WZ Sushi Platter"));
        List<String> t410 = new ArrayList<>(List.of("Katsudon", "Coke", "Chocolate Cake", "Tantanmen", "Salad Wrap", "Ika"));
        List<String> t411 = new ArrayList<>(List.of("Coke", "Salad Wrap", "Krazy Volcano", "Chocolate Cake", "Ika"));
        List<String> t412 = new ArrayList<>(List.of("WZ Sushi Platter", "Tantanmen", "Coke", "Katsudon"));
        List<String> t413 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t414 = new ArrayList<>(List.of("Ika", "WZ Sushi Platter"));
        List<String> t415 = new ArrayList<>(List.of("Coke", "Coke"));
        List<String> t416 = new ArrayList<>(List.of("Ika", "WZ Sushi Platter", "Chocolate Cake", "Coke", "WZ Sushi Platter"));
        List<String> t417 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t418 = new ArrayList<>(List.of("Krazy Volcano", "Salad Wrap", "Salad Wrap", "Krazy Volcano"));
        List<String> t419 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Salad Wrap"));
        List<String> t420 = new ArrayList<>(List.of("Krazy Volcano", "Ika", "Chocolate Cake", "Chocolate Cake", "Chocolate Cake", "Ika", "Coke"));
        List<String> t421 = new ArrayList<>(List.of("Ika", "Tantanmen", "WZ Sushi Platter", "Ika", "Katsudon", "Ika"));
        List<String> t422 = new ArrayList<>(List.of("Katsudon", "Katsudon", "Salad Wrap"));
        List<String> t423 = new ArrayList<>(List.of("Katsudon", "Ika", "Ika", "Ika", "Krazy Volcano", "Krazy Volcano"));
        List<String> t424 = new ArrayList<>(List.of("Katsudon", "Chocolate Cake", "Coke", "Chocolate Cake", "Katsudon", "Coke"));
        List<String> t425 = new ArrayList<>(List.of("Salad Wrap"));
        List<String> t426 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t427 = new ArrayList<>(List.of("Ika", "Ika"));
        List<String> t428 = new ArrayList<>(List.of("Salad Wrap", "Katsudon", "Tantanmen", "Ika", "Katsudon"));
        List<String> t429 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t430 = new ArrayList<>(List.of("Tantanmen", "Chocolate Cake"));
        List<String> t431 = new ArrayList<>(List.of("Krazy Volcano", "Tantanmen"));
        List<String> t432 = new ArrayList<>(List.of("Tantanmen", "Krazy Volcano", "Tantanmen", "Salad Wrap", "Ika"));
        List<String> t433 = new ArrayList<>(List.of("Coke"));
        List<String> t434 = new ArrayList<>(List.of("Coke", "Katsudon"));
        List<String> t435 = new ArrayList<>(List.of("Krazy Volcano", "Katsudon", "Chocolate Cake"));
        List<String> t436 = new ArrayList<>(List.of("WZ Sushi Platter", "Salad Wrap", "Ika", "Krazy Volcano", "Ika", "Katsudon"));
        List<String> t437 = new ArrayList<>(List.of("Salad Wrap"));
        List<String> t438 = new ArrayList<>(List.of("Salad Wrap", "Ika", "WZ Sushi Platter"));
        List<String> t439 = new ArrayList<>(List.of("Ika", "WZ Sushi Platter"));
        List<String> t440 = new ArrayList<>(List.of("Krazy Volcano", "Chocolate Cake", "Krazy Volcano"));
        List<String> t441 = new ArrayList<>(List.of("Coke", "Krazy Volcano", "Ika", "Krazy Volcano", "Ika"));
        List<String> t442 = new ArrayList<>(List.of("Katsudon", "Coke", "Katsudon"));
        List<String> t443 = new ArrayList<>(List.of("Ika"));
        List<String> t444 = new ArrayList<>(List.of("Katsudon", "Ika", "Ika", "Chocolate Cake", "Tantanmen", "Ika"));
        List<String> t445 = new ArrayList<>(List.of("Tantanmen", "Ika"));
        List<String> t446 = new ArrayList<>(List.of("Katsudon"));
        List<String> t447 = new ArrayList<>(List.of("Tantanmen", "Krazy Volcano"));
        List<String> t448 = new ArrayList<>(List.of("WZ Sushi Platter", "Katsudon", "Ika", "Tantanmen"));
        List<String> t449 = new ArrayList<>(List.of("WZ Sushi Platter"));
        List<String> t450 = new ArrayList<>(List.of("Ika", "WZ Sushi Platter", "WZ Sushi Platter", "Chocolate Cake", "Krazy Volcano"));
        List<String> t451 = new ArrayList<>(List.of("Ika", "WZ Sushi Platter"));
        List<String> t452 = new ArrayList<>(List.of("Tantanmen", "Coke", "Salad Wrap", "WZ Sushi Platter", "Katsudon", "Salad Wrap"));
        List<String> t453 = new ArrayList<>(List.of("WZ Sushi Platter", "Ika", "Krazy Volcano", "WZ Sushi Platter", "Salad Wrap"));
        List<String> t454 = new ArrayList<>(List.of("WZ Sushi Platter", "Chocolate Cake"));
        List<String> t455 = new ArrayList<>(List.of("Coke", "Chocolate Cake", "Ika"));
        List<String> t456 = new ArrayList<>(List.of("Ika", "Tantanmen", "WZ Sushi Platter", "Coke", "Chocolate Cake", "Salad Wrap", "Salad Wrap"));
        List<String> t457 = new ArrayList<>(List.of("Coke", "Katsudon", "Tantanmen", "Tantanmen"));
        List<String> t458 = new ArrayList<>(List.of("Ika", "Ika"));
        List<String> t459 = new ArrayList<>(List.of("Ika", "Krazy Volcano", "Katsudon", "Ika"));
        List<String> t460 = new ArrayList<>(List.of("WZ Sushi Platter", "Krazy Volcano"));
        List<String> t461 = new ArrayList<>(List.of("Krazy Volcano", "Tantanmen", "Krazy Volcano", "Krazy Volcano", "Chocolate Cake", "WZ Sushi Platter"));
        List<String> t462 = new ArrayList<>(List.of("Ika", "Ika"));
        List<String> t463 = new ArrayList<>(List.of("Ika", "WZ Sushi Platter"));
        List<String> t464 = new ArrayList<>(List.of("Salad Wrap", "Krazy Volcano", "Ika", "Tantanmen", "Ika", "WZ Sushi Platter"));
        List<String> t465 = new ArrayList<>(List.of("Ika", "Krazy Volcano"));
        List<String> t466 = new ArrayList<>(List.of("Coke", "Tantanmen"));
        List<String> t467 = new ArrayList<>(List.of("Chocolate Cake", "Katsudon", "Tantanmen", "Chocolate Cake", "Chocolate Cake", "Krazy Volcano"));
        List<String> t468 = new ArrayList<>(List.of("Ika", "Chocolate Cake", "Salad Wrap", "Katsudon"));
        List<String> t469 = new ArrayList<>(List.of("Krazy Volcano", "Coke", "Salad Wrap", "Coke"));
        List<String> t470 = new ArrayList<>(List.of("Chocolate Cake", "Ika", "Salad Wrap", "Tantanmen", "Coke", "Salad Wrap"));
        List<String> t471 = new ArrayList<>(List.of("Krazy Volcano", "WZ Sushi Platter", "Tantanmen", "Krazy Volcano", "Ika"));
        List<String> t472 = new ArrayList<>(List.of("Ika", "Katsudon", "Coke", "Krazy Volcano", "Katsudon", "Krazy Volcano", "Tantanmen"));
        List<String> t473 = new ArrayList<>(List.of("Katsudon", "Ika", "Krazy Volcano", "Ika", "WZ Sushi Platter", "Ika"));
        List<String> t474 = new ArrayList<>(List.of("Katsudon", "WZ Sushi Platter", "Katsudon"));
        List<String> t475 = new ArrayList<>(List.of("WZ Sushi Platter", "Krazy Volcano"));
        List<String> t476 = new ArrayList<>(List.of("Coke", "Katsudon", "WZ Sushi Platter"));
        List<String> t477 = new ArrayList<>(List.of("Ika", "Salad Wrap"));
        List<String> t478 = new ArrayList<>(List.of("Krazy Volcano", "Salad Wrap", "Tantanmen", "Tantanmen", "WZ Sushi Platter"));
        List<String> t479 = new ArrayList<>(List.of("Katsudon", "Krazy Volcano", "Katsudon", "Coke", "Krazy Volcano", "Katsudon"));
        List<String> t480 = new ArrayList<>(List.of("Katsudon", "Krazy Volcano", "Krazy Volcano"));
        List<String> t481 = new ArrayList<>(List.of("Krazy Volcano", "Krazy Volcano"));
        List<String> t482 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Ika"));
        List<String> t483 = new ArrayList<>(List.of("Katsudon", "Tantanmen", "Katsudon", "Ika"));
        List<String> t484 = new ArrayList<>(List.of("Ika", "Ika", "Katsudon", "Salad Wrap"));
        List<String> t485 = new ArrayList<>(List.of("Ika", "WZ Sushi Platter", "Krazy Volcano"));
        List<String> t486 = new ArrayList<>(List.of("Ika", "Ika", "Chocolate Cake", "Ika", "Ika", "Krazy Volcano"));
        List<String> t487 = new ArrayList<>(List.of("Salad Wrap", "Salad Wrap"));
        List<String> t488 = new ArrayList<>(List.of("Chocolate Cake", "Ika", "Tantanmen", "Chocolate Cake"));
        List<String> t489 = new ArrayList<>(List.of("WZ Sushi Platter", "WZ Sushi Platter"));
        List<String> t490 = new ArrayList<>(List.of("Ika", "Ika"));
        List<String> t491 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake"));
        List<String> t492 = new ArrayList<>(List.of("Tantanmen", "Katsudon", "Krazy Volcano"));
        List<String> t493 = new ArrayList<>(List.of("WZ Sushi Platter", "Katsudon"));
        List<String> t494 = new ArrayList<>(List.of("Ika", "Ika"));
        List<String> t495 = new ArrayList<>(List.of("Salad Wrap", "Salad Wrap"));
        List<String> t496 = new ArrayList<>(List.of("Katsudon"));
        List<String> t497 = new ArrayList<>(List.of("Coke", "Ika", "Chocolate Cake", "Krazy Volcano", "Ika"));
        List<String> t498 = new ArrayList<>(List.of("Coke", "Ika"));
        List<String> t499 = new ArrayList<>(List.of("Tantanmen", "Tantanmen", "Tantanmen", "Chocolate Cake"));
        List<String> t500 = new ArrayList<>(List.of("Katsudon", "WZ Sushi Platter", "Salad Wrap", "WZ Sushi Platter", "WZ Sushi Platter", "Katsudon"));

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
