package com.wabizabi.wazabipos.Utilities.Testing;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class DataSetX implements DataSet {
    public static void insertInto(List<List<String>> transactionsTB){
        List<String> t1 = new ArrayList<>(List.of("Tendon"));
        List<String> t2 = new ArrayList<>(List.of("All Fried Sushi Platter", "Sprite", "Chocolate Cake"));
        List<String> t3 = new ArrayList<>(List.of("Sprite", "Tendon", "All Fried Sushi Platter"));
        List<String> t4 = new ArrayList<>(List.of("Tako", "Krazy Volcano"));
        List<String> t5 = new ArrayList<>(List.of("Sprite", "Sprite", "Krazy Volcano", "All Fried Sushi Platter", "Sprite"));
        List<String> t6 = new ArrayList<>(List.of("Tako"));
        List<String> t7 = new ArrayList<>(List.of("Krazy Volcano", "All Fried Sushi Platter", "Chocolate Cake", "Tendon"));
        List<String> t8 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tako"));
        List<String> t9 = new ArrayList<>(List.of("Tako", "Tako", "Tako", "Tendon", "Krazy Volcano", "All Fried Sushi Platter"));
        List<String> t10 = new ArrayList<>(List.of("Tendon"));
        List<String> t11 = new ArrayList<>(List.of("Tendon"));
        List<String> t12 = new ArrayList<>(List.of("Tendon", "All Fried Sushi Platter", "Kani Salad", "Tako", "Sprite", "Chocolate Cake", "Krazy Volcano"));
        List<String> t13 = new ArrayList<>(List.of("All Fried Sushi Platter", "All Fried Sushi Platter"));
        List<String> t14 = new ArrayList<>(List.of("Tendon", "Tako", "Miso Ramen", "Sprite", "Tendon", "Tako"));
        List<String> t15 = new ArrayList<>(List.of("Tako", "Krazy Volcano", "Chocolate Cake"));
        List<String> t16 = new ArrayList<>(List.of("Tako", "Sprite", "Miso Ramen", "Tendon", "Sprite", "Kani Salad"));
        List<String> t17 = new ArrayList<>(List.of("Sprite", "Krazy Volcano", "All Fried Sushi Platter"));
        List<String> t18 = new ArrayList<>(List.of("Sprite", "All Fried Sushi Platter"));
        List<String> t19 = new ArrayList<>(List.of("Kani Salad", "All Fried Sushi Platter", "Tako", "Krazy Volcano"));
        List<String> t20 = new ArrayList<>(List.of("Miso Ramen", "Chocolate Cake", "Kani Salad", "Miso Ramen", "Tendon", "Tako"));
        List<String> t21 = new ArrayList<>(List.of("Tako", "Miso Ramen", "Tako", "All Fried Sushi Platter", "Chocolate Cake"));
        List<String> t22 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t23 = new ArrayList<>(List.of("Tako", "Sprite", "Tako", "Tendon", "Tako", "All Fried Sushi Platter"));
        List<String> t24 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t25 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Tako", "All Fried Sushi Platter", "Tendon"));
        List<String> t26 = new ArrayList<>(List.of("Tendon", "All Fried Sushi Platter", "Krazy Volcano"));
        List<String> t27 = new ArrayList<>(List.of("Kani Salad", "Tako"));
        List<String> t28 = new ArrayList<>(List.of("Miso Ramen", "Krazy Volcano", "Tako", "Tako", "Tendon", "Miso Ramen", "Tako"));
        List<String> t29 = new ArrayList<>(List.of("Kani Salad"));
        List<String> t30 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tako"));
        List<String> t31 = new ArrayList<>(List.of("Kani Salad", "Krazy Volcano", "Tako", "Kani Salad"));
        List<String> t32 = new ArrayList<>(List.of("Krazy Volcano", "Tako"));
        List<String> t33 = new ArrayList<>(List.of("Tako", "Miso Ramen"));
        List<String> t34 = new ArrayList<>(List.of("Tako", "Krazy Volcano"));
        List<String> t35 = new ArrayList<>(List.of("Tako", "Krazy Volcano", "Tendon", "Sprite", "All Fried Sushi Platter"));
        List<String> t36 = new ArrayList<>(List.of("Tako", "Miso Ramen", "Tendon", "Tendon"));
        List<String> t37 = new ArrayList<>(List.of("Tako", "Kani Salad", "Tako", "Tako", "All Fried Sushi Platter", "Kani Salad", "Sprite"));
        List<String> t38 = new ArrayList<>(List.of("Miso Ramen", "Miso Ramen", "Kani Salad", "Tako", "Miso Ramen", "Chocolate Cake", "Sprite"));
        List<String> t39 = new ArrayList<>(List.of("Sprite", "Tako", "Chocolate Cake"));
        List<String> t40 = new ArrayList<>(List.of("Sprite", "Tendon", "Miso Ramen", "Tako", "Miso Ramen", "Tako"));
        List<String> t41 = new ArrayList<>(List.of("Tako", "All Fried Sushi Platter", "Sprite", "Sprite", "Sprite"));
        List<String> t42 = new ArrayList<>(List.of("All Fried Sushi Platter", "Miso Ramen", "Kani Salad", "Tako", "Tako"));
        List<String> t43 = new ArrayList<>(List.of("Kani Salad", "Sprite", "Chocolate Cake", "Krazy Volcano", "Sprite"));
        List<String> t44 = new ArrayList<>(List.of("Tendon", "All Fried Sushi Platter", "Chocolate Cake", "All Fried Sushi Platter", "All Fried Sushi Platter"));
        List<String> t45 = new ArrayList<>(List.of("Tako", "Miso Ramen"));
        List<String> t46 = new ArrayList<>(List.of("Sprite", "Sprite", "Tako"));
        List<String> t47 = new ArrayList<>(List.of("Kani Salad", "Sprite", "Tako"));
        List<String> t48 = new ArrayList<>(List.of("Kani Salad", "All Fried Sushi Platter"));
        List<String> t49 = new ArrayList<>(List.of("Tako", "Tako", "Tako"));
        List<String> t50 = new ArrayList<>(List.of("Krazy Volcano"));
        List<String> t51 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t52 = new ArrayList<>(List.of("Tako", "All Fried Sushi Platter", "Sprite", "Tako"));
        List<String> t53 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t54 = new ArrayList<>(List.of("Chocolate Cake", "Kani Salad", "Tendon", "Sprite", "Krazy Volcano"));
        List<String> t55 = new ArrayList<>(List.of("Kani Salad"));
        List<String> t56 = new ArrayList<>(List.of("Tendon", "Krazy Volcano", "Chocolate Cake"));
        List<String> t57 = new ArrayList<>(List.of("Kani Salad", "Miso Ramen", "Tako", "Krazy Volcano", "Tendon", "Chocolate Cake", "Tako"));
        List<String> t58 = new ArrayList<>(List.of("Tako", "Krazy Volcano"));
        List<String> t59 = new ArrayList<>(List.of("Sprite", "All Fried Sushi Platter", "Chocolate Cake", "Miso Ramen"));
        List<String> t60 = new ArrayList<>(List.of("Kani Salad", "Kani Salad"));
        List<String> t61 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tako", "Tako", "Kani Salad", "Sprite", "Kani Salad", "Miso Ramen"));
        List<String> t62 = new ArrayList<>(List.of("Tako", "Tako", "Tako", "Tendon"));
        List<String> t63 = new ArrayList<>(List.of("Kani Salad", "Tendon", "Tako", "Sprite", "Kani Salad"));
        List<String> t64 = new ArrayList<>(List.of("Krazy Volcano", "Miso Ramen", "Sprite"));
        List<String> t65 = new ArrayList<>(List.of("Tako", "Miso Ramen", "Sprite", "Sprite"));
        List<String> t66 = new ArrayList<>(List.of("All Fried Sushi Platter"));
        List<String> t67 = new ArrayList<>(List.of("Tako", "Sprite"));
        List<String> t68 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t69 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t70 = new ArrayList<>(List.of("Kani Salad"));
        List<String> t71 = new ArrayList<>(List.of("Tako", "Krazy Volcano"));
        List<String> t72 = new ArrayList<>(List.of("Miso Ramen", "Krazy Volcano", "Tendon", "Sprite"));
        List<String> t73 = new ArrayList<>(List.of("All Fried Sushi Platter", "All Fried Sushi Platter", "Tako", "Chocolate Cake", "Tako"));
        List<String> t74 = new ArrayList<>(List.of("Tako", "Tako", "Krazy Volcano", "Tako", "Krazy Volcano", "Krazy Volcano", "Chocolate Cake"));
        List<String> t75 = new ArrayList<>(List.of("Miso Ramen", "Sprite"));
        List<String> t76 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Tako"));
        List<String> t77 = new ArrayList<>(List.of("Miso Ramen", "Tendon", "Sprite", "Miso Ramen"));
        List<String> t78 = new ArrayList<>(List.of("All Fried Sushi Platter", "Sprite", "Kani Salad", "Miso Ramen"));
        List<String> t79 = new ArrayList<>(List.of("Tako", "Tako", "Tendon", "Tako"));
        List<String> t80 = new ArrayList<>(List.of("Tako", "Tendon", "Chocolate Cake"));
        List<String> t81 = new ArrayList<>(List.of("Sprite", "Tako", "Sprite", "Sprite", "Chocolate Cake", "Kani Salad", "Tendon"));
        List<String> t82 = new ArrayList<>(List.of("Chocolate Cake", "Miso Ramen", "Miso Ramen", "Chocolate Cake", "Kani Salad", "Krazy Volcano"));
        List<String> t83 = new ArrayList<>(List.of("Tako", "Sprite", "Krazy Volcano", "Tako", "Tako", "Tako", "Kani Salad"));
        List<String> t84 = new ArrayList<>(List.of("Tendon", "Tako"));
        List<String> t85 = new ArrayList<>(List.of("All Fried Sushi Platter", "Sprite", "Tako", "All Fried Sushi Platter"));
        List<String> t86 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t87 = new ArrayList<>(List.of("Tako", "Kani Salad", "Tako", "Tendon", "Sprite", "Tendon", "Krazy Volcano"));
        List<String> t88 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tako"));
        List<String> t89 = new ArrayList<>(List.of("All Fried Sushi Platter", "Krazy Volcano"));
        List<String> t90 = new ArrayList<>(List.of("Sprite"));
        List<String> t91 = new ArrayList<>(List.of("Tako", "All Fried Sushi Platter"));
        List<String> t92 = new ArrayList<>(List.of("Tendon", "Chocolate Cake", "Sprite", "Chocolate Cake", "Chocolate Cake"));
        List<String> t93 = new ArrayList<>(List.of("Tendon"));
        List<String> t94 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tako"));
        List<String> t95 = new ArrayList<>(List.of("Krazy Volcano", "Chocolate Cake", "Tako", "Krazy Volcano", "Tendon"));
        List<String> t96 = new ArrayList<>(List.of("Kani Salad", "Sprite"));
        List<String> t97 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t98 = new ArrayList<>(List.of("Krazy Volcano"));
        List<String> t99 = new ArrayList<>(List.of("Krazy Volcano", "Sprite", "Kani Salad"));
        List<String> t100 = new ArrayList<>(List.of("Tako", "Tendon", "Kani Salad", "Tendon", "Chocolate Cake", "Tako", "Tako"));
        List<String> t101 = new ArrayList<>(List.of("Krazy Volcano", "Kani Salad"));
        List<String> t102 = new ArrayList<>(List.of("Sprite", "Tako", "Miso Ramen"));
        List<String> t103 = new ArrayList<>(List.of("All Fried Sushi Platter", "All Fried Sushi Platter", "Sprite", "Tendon", "Kani Salad", "Tako", "Tendon"));
        List<String> t104 = new ArrayList<>(List.of("Miso Ramen", "All Fried Sushi Platter", "Miso Ramen", "Tako"));
        List<String> t105 = new ArrayList<>(List.of("Krazy Volcano", "Tendon", "Sprite", "Miso Ramen"));
        List<String> t106 = new ArrayList<>(List.of("Miso Ramen", "Kani Salad"));
        List<String> t107 = new ArrayList<>(List.of("Sprite", "Krazy Volcano", "Kani Salad"));
        List<String> t108 = new ArrayList<>(List.of("Tako", "Kani Salad", "Krazy Volcano", "Tako", "Krazy Volcano"));
        List<String> t109 = new ArrayList<>(List.of("Tako", "Tako", "Tako", "Kani Salad", "Kani Salad", "Kani Salad"));
        List<String> t110 = new ArrayList<>(List.of("Krazy Volcano", "Chocolate Cake", "Krazy Volcano"));
        List<String> t111 = new ArrayList<>(List.of("Tako", "Krazy Volcano"));
        List<String> t112 = new ArrayList<>(List.of("Tendon", "Krazy Volcano", "Tako", "Miso Ramen", "Krazy Volcano", "Sprite"));
        List<String> t113 = new ArrayList<>(List.of("Tako", "Chocolate Cake"));
        List<String> t114 = new ArrayList<>(List.of("Tako"));
        List<String> t115 = new ArrayList<>(List.of("All Fried Sushi Platter", "Kani Salad"));
        List<String> t116 = new ArrayList<>(List.of("Krazy Volcano", "Krazy Volcano", "Sprite", "Tako", "Tendon"));
        List<String> t117 = new ArrayList<>(List.of("Krazy Volcano", "Krazy Volcano", "Tako"));
        List<String> t118 = new ArrayList<>(List.of("Krazy Volcano", "Miso Ramen", "Tako", "Miso Ramen", "Sprite"));
        List<String> t119 = new ArrayList<>(List.of("Tendon", "Tako", "Miso Ramen", "All Fried Sushi Platter"));
        List<String> t120 = new ArrayList<>(List.of("All Fried Sushi Platter", "Miso Ramen", "Tako"));
        List<String> t121 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tako", "Chocolate Cake", "Chocolate Cake", "Tako", "Miso Ramen"));
        List<String> t122 = new ArrayList<>(List.of("Krazy Volcano", "Tako", "Kani Salad", "Kani Salad", "Miso Ramen", "All Fried Sushi Platter"));
        List<String> t123 = new ArrayList<>(List.of("Krazy Volcano", "Miso Ramen"));
        List<String> t124 = new ArrayList<>(List.of("Kani Salad"));
        List<String> t125 = new ArrayList<>(List.of("Krazy Volcano", "Chocolate Cake", "Tako", "All Fried Sushi Platter", "Chocolate Cake"));
        List<String> t126 = new ArrayList<>(List.of("Krazy Volcano", "Krazy Volcano", "Chocolate Cake", "Tako", "Tako"));
        List<String> t127 = new ArrayList<>(List.of("Tako", "Tako", "Miso Ramen", "Miso Ramen"));
        List<String> t128 = new ArrayList<>(List.of("Krazy Volcano"));
        List<String> t129 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t130 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tako", "Kani Salad", "Tendon", "All Fried Sushi Platter", "Sprite"));
        List<String> t131 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t132 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "Miso Ramen", "Miso Ramen"));
        List<String> t133 = new ArrayList<>(List.of("Krazy Volcano"));
        List<String> t134 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tendon", "All Fried Sushi Platter", "Kani Salad", "Sprite"));
        List<String> t135 = new ArrayList<>(List.of("Tako", "Sprite", "Krazy Volcano", "Krazy Volcano", "Tako", "Tako", "Kani Salad"));
        List<String> t136 = new ArrayList<>(List.of("Tako"));
        List<String> t137 = new ArrayList<>(List.of("Sprite", "Tako", "Chocolate Cake", "Sprite", "Miso Ramen", "Tako"));
        List<String> t138 = new ArrayList<>(List.of("Sprite", "Krazy Volcano", "Kani Salad"));
        List<String> t139 = new ArrayList<>(List.of("Tendon", "Sprite", "Tako", "Tendon"));
        List<String> t140 = new ArrayList<>(List.of("Krazy Volcano", "Tendon", "Chocolate Cake", "Sprite"));
        List<String> t141 = new ArrayList<>(List.of("Krazy Volcano", "Krazy Volcano", "Kani Salad", "Krazy Volcano", "Sprite", "Krazy Volcano", "Chocolate Cake"));
        List<String> t142 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "Miso Ramen", "Krazy Volcano", "Miso Ramen"));
        List<String> t143 = new ArrayList<>(List.of("Krazy Volcano", "All Fried Sushi Platter", "Tako", "Tako", "Chocolate Cake", "Miso Ramen"));
        List<String> t144 = new ArrayList<>(List.of("Sprite", "All Fried Sushi Platter", "Tendon", "Krazy Volcano"));
        List<String> t145 = new ArrayList<>(List.of("All Fried Sushi Platter", "Sprite", "Chocolate Cake"));
        List<String> t146 = new ArrayList<>(List.of("Chocolate Cake", "Sprite", "Tendon", "Sprite", "Tako", "Sprite", "Tako"));
        List<String> t147 = new ArrayList<>(List.of("Krazy Volcano", "Tako"));
        List<String> t148 = new ArrayList<>(List.of("Miso Ramen", "Kani Salad", "Tako", "Tako", "All Fried Sushi Platter", "Krazy Volcano", "Miso Ramen"));
        List<String> t149 = new ArrayList<>(List.of("All Fried Sushi Platter", "All Fried Sushi Platter", "Chocolate Cake", "Kani Salad", "Chocolate Cake"));
        List<String> t150 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tako", "Tendon"));
        List<String> t151 = new ArrayList<>(List.of("Tako", "All Fried Sushi Platter"));
        List<String> t152 = new ArrayList<>(List.of("Kani Salad", "Krazy Volcano"));
        List<String> t153 = new ArrayList<>(List.of("Miso Ramen", "Miso Ramen"));
        List<String> t154 = new ArrayList<>(List.of("Tendon", "Chocolate Cake", "Tendon", "Tendon"));
        List<String> t155 = new ArrayList<>(List.of("Krazy Volcano", "Chocolate Cake", "Kani Salad"));
        List<String> t156 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tako", "Krazy Volcano", "Tako", "Kani Salad", "Krazy Volcano", "Krazy Volcano"));
        List<String> t157 = new ArrayList<>(List.of("Miso Ramen"));
        List<String> t158 = new ArrayList<>(List.of("Sprite"));
        List<String> t159 = new ArrayList<>(List.of("Miso Ramen"));
        List<String> t160 = new ArrayList<>(List.of("Miso Ramen", "Miso Ramen", "Tendon"));
        List<String> t161 = new ArrayList<>(List.of("Krazy Volcano", "Krazy Volcano"));
        List<String> t162 = new ArrayList<>(List.of("Tendon", "Kani Salad", "Chocolate Cake", "Kani Salad", "Tako"));
        List<String> t163 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t164 = new ArrayList<>(List.of("All Fried Sushi Platter", "Kani Salad", "Tako", "Tendon"));
        List<String> t165 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tako", "Tako"));
        List<String> t166 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tako"));
        List<String> t167 = new ArrayList<>(List.of("All Fried Sushi Platter", "All Fried Sushi Platter", "Tendon", "Miso Ramen", "Sprite", "Tako"));
        List<String> t168 = new ArrayList<>(List.of("Tako", "Miso Ramen", "Tendon", "Tako", "Krazy Volcano", "Chocolate Cake", "Miso Ramen"));
        List<String> t169 = new ArrayList<>(List.of("Tendon", "Chocolate Cake", "Kani Salad", "Krazy Volcano", "Miso Ramen", "Tako", "Miso Ramen"));
        List<String> t170 = new ArrayList<>(List.of("Miso Ramen", "Krazy Volcano", "All Fried Sushi Platter", "Krazy Volcano", "Krazy Volcano"));
        List<String> t171 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tako"));
        List<String> t172 = new ArrayList<>(List.of("Sprite", "Sprite"));
        List<String> t173 = new ArrayList<>(List.of("All Fried Sushi Platter"));
        List<String> t174 = new ArrayList<>(List.of("Kani Salad", "Kani Salad"));
        List<String> t175 = new ArrayList<>(List.of("Kani Salad", "Chocolate Cake", "Miso Ramen", "Kani Salad", "Miso Ramen", "Krazy Volcano"));
        List<String> t176 = new ArrayList<>(List.of("Sprite", "All Fried Sushi Platter", "Miso Ramen", "All Fried Sushi Platter"));
        List<String> t177 = new ArrayList<>(List.of("Tako", "Sprite", "Tako", "Miso Ramen", "Krazy Volcano", "Miso Ramen"));
        List<String> t178 = new ArrayList<>(List.of("Tako", "Sprite"));
        List<String> t179 = new ArrayList<>(List.of("Chocolate Cake", "Krazy Volcano"));
        List<String> t180 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t181 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Sprite", "Sprite", "Tako", "Sprite"));
        List<String> t182 = new ArrayList<>(List.of("Tako", "All Fried Sushi Platter", "Tako"));
        List<String> t183 = new ArrayList<>(List.of("Miso Ramen", "Sprite", "Kani Salad", "Tendon", "Miso Ramen", "Krazy Volcano"));
        List<String> t184 = new ArrayList<>(List.of("Tako"));
        List<String> t185 = new ArrayList<>(List.of("Krazy Volcano", "Miso Ramen", "Tako"));
        List<String> t186 = new ArrayList<>(List.of("Tako", "Krazy Volcano"));
        List<String> t187 = new ArrayList<>(List.of("Kani Salad", "Kani Salad", "All Fried Sushi Platter", "Tako"));
        List<String> t188 = new ArrayList<>(List.of("All Fried Sushi Platter", "Miso Ramen"));
        List<String> t189 = new ArrayList<>(List.of("Sprite", "All Fried Sushi Platter", "Kani Salad", "Sprite", "Tako"));
        List<String> t190 = new ArrayList<>(List.of("Tako", "Miso Ramen", "Tako", "Tendon", "Sprite"));
        List<String> t191 = new ArrayList<>(List.of("Sprite", "Tako", "Tendon", "Sprite"));
        List<String> t192 = new ArrayList<>(List.of("Miso Ramen", "Kani Salad", "Miso Ramen", "Sprite", "Tako", "Krazy Volcano"));
        List<String> t193 = new ArrayList<>(List.of("Tako", "Sprite", "Tendon"));
        List<String> t194 = new ArrayList<>(List.of("All Fried Sushi Platter", "Sprite", "Tendon", "Chocolate Cake", "Sprite", "Miso Ramen"));
        List<String> t195 = new ArrayList<>(List.of("Krazy Volcano", "Kani Salad", "All Fried Sushi Platter", "Krazy Volcano", "Miso Ramen", "Tako", "Tako"));
        List<String> t196 = new ArrayList<>(List.of("Kani Salad", "Kani Salad", "Chocolate Cake", "Sprite", "Tako"));
        List<String> t197 = new ArrayList<>(List.of("Kani Salad", "Chocolate Cake"));
        List<String> t198 = new ArrayList<>(List.of("Miso Ramen", "Tendon", "Tako", "Krazy Volcano"));
        List<String> t199 = new ArrayList<>(List.of("Sprite", "Chocolate Cake", "Miso Ramen"));
        List<String> t200 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "Kani Salad", "Kani Salad", "Miso Ramen"));
        List<String> t201 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Miso Ramen", "Chocolate Cake"));
        List<String> t202 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t203 = new ArrayList<>(List.of("Chocolate Cake", "Miso Ramen", "Sprite"));
        List<String> t204 = new ArrayList<>(List.of("All Fried Sushi Platter", "Miso Ramen"));
        List<String> t205 = new ArrayList<>(List.of("Miso Ramen"));
        List<String> t206 = new ArrayList<>(List.of("Kani Salad", "Tako", "Kani Salad", "Krazy Volcano"));
        List<String> t207 = new ArrayList<>(List.of("Krazy Volcano", "Chocolate Cake", "Tako", "Tako", "Tako", "Tendon", "Chocolate Cake"));
        List<String> t208 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t209 = new ArrayList<>(List.of("Tako", "Miso Ramen"));
        List<String> t210 = new ArrayList<>(List.of("Sprite", "Tendon", "Tako", "Chocolate Cake", "Chocolate Cake", "Tako"));
        List<String> t211 = new ArrayList<>(List.of("Kani Salad", "Tako", "Tako"));
        List<String> t212 = new ArrayList<>(List.of("Sprite", "Sprite", "Miso Ramen", "Tako"));
        List<String> t213 = new ArrayList<>(List.of("All Fried Sushi Platter"));
        List<String> t214 = new ArrayList<>(List.of("Tendon", "Sprite", "Sprite", "Sprite", "Kani Salad", "Chocolate Cake", "Chocolate Cake"));
        List<String> t215 = new ArrayList<>(List.of("Chocolate Cake", "All Fried Sushi Platter"));
        List<String> t216 = new ArrayList<>(List.of("Tendon", "Kani Salad"));
        List<String> t217 = new ArrayList<>(List.of("Krazy Volcano", "Krazy Volcano", "All Fried Sushi Platter", "Miso Ramen", "All Fried Sushi Platter"));
        List<String> t218 = new ArrayList<>(List.of("Tako", "Miso Ramen"));
        List<String> t219 = new ArrayList<>(List.of("Tako", "Miso Ramen"));
        List<String> t220 = new ArrayList<>(List.of("Miso Ramen", "Kani Salad", "Tako", "Krazy Volcano", "Tako", "Tako", "Miso Ramen"));
        List<String> t221 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tendon", "All Fried Sushi Platter", "Sprite", "Tendon"));
        List<String> t222 = new ArrayList<>(List.of("All Fried Sushi Platter", "Kani Salad"));
        List<String> t223 = new ArrayList<>(List.of("All Fried Sushi Platter", "Sprite", "Chocolate Cake", "Krazy Volcano"));
        List<String> t224 = new ArrayList<>(List.of("Tendon", "Tendon", "Kani Salad", "Sprite", "Chocolate Cake", "Tako", "Tako"));
        List<String> t225 = new ArrayList<>(List.of("Kani Salad", "All Fried Sushi Platter"));
        List<String> t226 = new ArrayList<>(List.of("Miso Ramen", "Miso Ramen"));
        List<String> t227 = new ArrayList<>(List.of("Miso Ramen", "Tako"));
        List<String> t228 = new ArrayList<>(List.of("All Fried Sushi Platter", "Miso Ramen"));
        List<String> t229 = new ArrayList<>(List.of("Miso Ramen", "Krazy Volcano", "Kani Salad"));
        List<String> t230 = new ArrayList<>(List.of("Kani Salad"));
        List<String> t231 = new ArrayList<>(List.of("Tako", "Tendon", "Tako", "Miso Ramen", "Tako", "All Fried Sushi Platter"));
        List<String> t232 = new ArrayList<>(List.of("Tendon", "Miso Ramen", "Tendon", "Tako", "Kani Salad"));
        List<String> t233 = new ArrayList<>(List.of("Tako", "Sprite", "Krazy Volcano", "Tako", "Tako", "Tako"));
        List<String> t234 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "All Fried Sushi Platter", "Krazy Volcano"));
        List<String> t235 = new ArrayList<>(List.of("Miso Ramen", "Krazy Volcano", "Tendon", "Miso Ramen", "Chocolate Cake", "Kani Salad"));
        List<String> t236 = new ArrayList<>(List.of("Tako", "Tendon"));
        List<String> t237 = new ArrayList<>(List.of("Kani Salad", "Tako", "Chocolate Cake", "Tako"));
        List<String> t238 = new ArrayList<>(List.of("Miso Ramen", "Chocolate Cake", "Krazy Volcano", "Tako", "Krazy Volcano", "Krazy Volcano"));
        List<String> t239 = new ArrayList<>(List.of("Miso Ramen", "All Fried Sushi Platter"));
        List<String> t240 = new ArrayList<>(List.of("Tendon", "Miso Ramen", "Sprite", "Tako", "Sprite", "Miso Ramen", "Tako"));
        List<String> t241 = new ArrayList<>(List.of("Tako", "Sprite", "Sprite", "Tendon", "Tako", "All Fried Sushi Platter"));
        List<String> t242 = new ArrayList<>(List.of("Tako", "Sprite"));
        List<String> t243 = new ArrayList<>(List.of("Chocolate Cake", "Miso Ramen", "Tendon"));
        List<String> t244 = new ArrayList<>(List.of("Tendon", "Tako"));
        List<String> t245 = new ArrayList<>(List.of("Tendon", "Tako", "Tako", "Krazy Volcano", "Kani Salad"));
        List<String> t246 = new ArrayList<>(List.of("Krazy Volcano", "Tako"));
        List<String> t247 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Sprite", "Krazy Volcano"));
        List<String> t248 = new ArrayList<>(List.of("Miso Ramen", "Chocolate Cake", "All Fried Sushi Platter"));
        List<String> t249 = new ArrayList<>(List.of("All Fried Sushi Platter", "Krazy Volcano", "Tako", "Tako", "Tako", "Tendon", "All Fried Sushi Platter"));
        List<String> t250 = new ArrayList<>(List.of("Chocolate Cake", "Kani Salad"));
        List<String> t251 = new ArrayList<>(List.of("Kani Salad", "All Fried Sushi Platter", "Krazy Volcano", "Sprite", "Tendon", "Kani Salad"));
        List<String> t252 = new ArrayList<>(List.of("Tako", "Miso Ramen"));
        List<String> t253 = new ArrayList<>(List.of("Miso Ramen", "All Fried Sushi Platter"));
        List<String> t254 = new ArrayList<>(List.of("Tako"));
        List<String> t255 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t256 = new ArrayList<>(List.of("Miso Ramen", "Miso Ramen"));
        List<String> t257 = new ArrayList<>(List.of("Kani Salad", "Miso Ramen"));
        List<String> t258 = new ArrayList<>(List.of("Sprite", "Sprite", "Tendon"));
        List<String> t259 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tako", "Krazy Volcano", "Tendon", "Kani Salad", "Sprite"));
        List<String> t260 = new ArrayList<>(List.of("Krazy Volcano", "Tako"));
        List<String> t261 = new ArrayList<>(List.of("Krazy Volcano", "Krazy Volcano", "Krazy Volcano", "Tendon"));
        List<String> t262 = new ArrayList<>(List.of("Tako", "Miso Ramen", "Miso Ramen"));
        List<String> t263 = new ArrayList<>(List.of("Kani Salad"));
        List<String> t264 = new ArrayList<>(List.of("Tako", "Miso Ramen", "Tendon", "Chocolate Cake", "Tendon", "Miso Ramen"));
        List<String> t265 = new ArrayList<>(List.of("Miso Ramen"));
        List<String> t266 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tako"));
        List<String> t267 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Krazy Volcano"));
        List<String> t268 = new ArrayList<>(List.of("Chocolate Cake", "Miso Ramen", "Sprite", "Miso Ramen", "Sprite", "Chocolate Cake"));
        List<String> t269 = new ArrayList<>(List.of("Tako", "Tendon", "Sprite", "Kani Salad", "Tako", "Sprite", "Sprite"));
        List<String> t270 = new ArrayList<>(List.of("Miso Ramen", "Krazy Volcano"));
        List<String> t271 = new ArrayList<>(List.of("Chocolate Cake", "All Fried Sushi Platter", "Chocolate Cake", "Miso Ramen", "Tako", "Tendon", "Sprite"));
        List<String> t272 = new ArrayList<>(List.of("Tako", "Chocolate Cake"));
        List<String> t273 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Tako", "Tako", "Krazy Volcano", "Krazy Volcano"));
        List<String> t274 = new ArrayList<>(List.of("Sprite", "Krazy Volcano", "Sprite", "Tendon", "Kani Salad", "Chocolate Cake", "Tako"));
        List<String> t275 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Tako", "Miso Ramen", "Tako", "Tako"));
        List<String> t276 = new ArrayList<>(List.of("Chocolate Cake", "Tako"));
        List<String> t277 = new ArrayList<>(List.of("Tako", "Krazy Volcano"));
        List<String> t278 = new ArrayList<>(List.of("Miso Ramen", "Tako", "Tendon", "Krazy Volcano", "Tako", "Tako", "Sprite"));
        List<String> t279 = new ArrayList<>(List.of("Miso Ramen", "Tako", "Tendon", "Chocolate Cake", "Tako"));
        List<String> t280 = new ArrayList<>(List.of("Chocolate Cake", "Tendon", "Tako"));
        List<String> t281 = new ArrayList<>(List.of("Krazy Volcano", "Krazy Volcano"));
        List<String> t282 = new ArrayList<>(List.of("Kani Salad", "Kani Salad"));
        List<String> t283 = new ArrayList<>(List.of("Tako", "Tako", "All Fried Sushi Platter"));
        List<String> t284 = new ArrayList<>(List.of("Kani Salad", "Kani Salad", "Kani Salad", "Krazy Volcano", "Tendon", "Tendon"));
        List<String> t285 = new ArrayList<>(List.of("Krazy Volcano", "Tako", "All Fried Sushi Platter", "Tendon"));
        List<String> t286 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t287 = new ArrayList<>(List.of("Chocolate Cake", "Tendon", "Miso Ramen", "Kani Salad", "Chocolate Cake"));
        List<String> t288 = new ArrayList<>(List.of("Miso Ramen", "Miso Ramen", "All Fried Sushi Platter", "Tendon", "Kani Salad", "Miso Ramen"));
        List<String> t289 = new ArrayList<>(List.of("Kani Salad", "Kani Salad"));
        List<String> t290 = new ArrayList<>(List.of("Tako"));
        List<String> t291 = new ArrayList<>(List.of("Tako", "Tako", "Miso Ramen", "Chocolate Cake", "Sprite"));
        List<String> t292 = new ArrayList<>(List.of("Krazy Volcano", "Tako", "Tako", "Tako", "Miso Ramen", "Tendon"));
        List<String> t293 = new ArrayList<>(List.of("Miso Ramen", "Tako", "Tako"));
        List<String> t294 = new ArrayList<>(List.of("All Fried Sushi Platter", "Chocolate Cake", "Miso Ramen", "Sprite", "Sprite"));
        List<String> t295 = new ArrayList<>(List.of("Tako", "Tendon", "All Fried Sushi Platter", "Tako", "Chocolate Cake", "Tako"));
        List<String> t296 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Chocolate Cake", "Krazy Volcano", "Tako", "Tako"));
        List<String> t297 = new ArrayList<>(List.of("Sprite", "Tako", "Miso Ramen", "Miso Ramen"));
        List<String> t298 = new ArrayList<>(List.of("Tako", "Miso Ramen"));
        List<String> t299 = new ArrayList<>(List.of("Miso Ramen", "Kani Salad"));
        List<String> t300 = new ArrayList<>(List.of("Sprite"));
        List<String> t301 = new ArrayList<>(List.of("Chocolate Cake", "All Fried Sushi Platter", "Sprite", "All Fried Sushi Platter", "Kani Salad"));
        List<String> t302 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "Kani Salad"));
        List<String> t303 = new ArrayList<>(List.of("Tako"));
        List<String> t304 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "Tako", "Tako", "Sprite", "Miso Ramen", "Kani Salad"));
        List<String> t305 = new ArrayList<>(List.of("Sprite"));
        List<String> t306 = new ArrayList<>(List.of("Tako", "Tendon", "All Fried Sushi Platter"));
        List<String> t307 = new ArrayList<>(List.of("Krazy Volcano"));
        List<String> t308 = new ArrayList<>(List.of("Krazy Volcano", "Tako"));
        List<String> t309 = new ArrayList<>(List.of("All Fried Sushi Platter", "Kani Salad", "All Fried Sushi Platter", "Sprite", "All Fried Sushi Platter"));
        List<String> t310 = new ArrayList<>(List.of("Sprite", "Tako", "Sprite", "Tendon", "Kani Salad", "Kani Salad"));
        List<String> t311 = new ArrayList<>(List.of("Kani Salad"));
        List<String> t312 = new ArrayList<>(List.of("Sprite", "Tako", "Tako", "Krazy Volcano", "Kani Salad"));
        List<String> t313 = new ArrayList<>(List.of("Krazy Volcano", "All Fried Sushi Platter"));
        List<String> t314 = new ArrayList<>(List.of("Tendon", "Tako", "Kani Salad", "Sprite", "Chocolate Cake"));
        List<String> t315 = new ArrayList<>(List.of("Tendon", "Tako"));
        List<String> t316 = new ArrayList<>(List.of("Krazy Volcano", "Tako", "Tako", "Miso Ramen", "Chocolate Cake"));
        List<String> t317 = new ArrayList<>(List.of("Tendon", "Kani Salad"));
        List<String> t318 = new ArrayList<>(List.of("Kani Salad", "Chocolate Cake", "Tako", "All Fried Sushi Platter", "Miso Ramen", "Sprite"));
        List<String> t319 = new ArrayList<>(List.of("Tako", "Kani Salad", "Kani Salad", "All Fried Sushi Platter", "Tendon", "Sprite", "Tako"));
        List<String> t320 = new ArrayList<>(List.of("Tendon", "Tako", "Krazy Volcano", "Tako", "Chocolate Cake"));
        List<String> t321 = new ArrayList<>(List.of("Chocolate Cake", "Miso Ramen", "Chocolate Cake", "Kani Salad", "Chocolate Cake"));
        List<String> t322 = new ArrayList<>(List.of("Kani Salad", "Tako", "Chocolate Cake", "Tendon", "Kani Salad", "Sprite", "Tako"));
        List<String> t323 = new ArrayList<>(List.of("Chocolate Cake", "Tendon", "All Fried Sushi Platter", "Miso Ramen", "All Fried Sushi Platter", "Kani Salad", "Tendon"));
        List<String> t324 = new ArrayList<>(List.of("Tendon", "Sprite"));
        List<String> t325 = new ArrayList<>(List.of("Miso Ramen", "Krazy Volcano"));
        List<String> t326 = new ArrayList<>(List.of("Tako", "Tendon", "Krazy Volcano", "Kani Salad", "Krazy Volcano"));
        List<String> t327 = new ArrayList<>(List.of("All Fried Sushi Platter", "Sprite", "Kani Salad", "Krazy Volcano"));
        List<String> t328 = new ArrayList<>(List.of("Sprite", "Tendon", "Sprite", "All Fried Sushi Platter", "Tako", "Tendon", "Miso Ramen"));
        List<String> t329 = new ArrayList<>(List.of("Tako", "Kani Salad"));
        List<String> t330 = new ArrayList<>(List.of("All Fried Sushi Platter"));
        List<String> t331 = new ArrayList<>(List.of("Krazy Volcano", "Chocolate Cake", "Tako", "Kani Salad", "Tendon", "Krazy Volcano", "Tako"));
        List<String> t332 = new ArrayList<>(List.of("Krazy Volcano", "Miso Ramen", "Miso Ramen", "Miso Ramen", "Chocolate Cake"));
        List<String> t333 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tako"));
        List<String> t334 = new ArrayList<>(List.of("All Fried Sushi Platter", "Miso Ramen", "Tako", "Kani Salad", "Kani Salad"));
        List<String> t335 = new ArrayList<>(List.of("Tako", "All Fried Sushi Platter"));
        List<String> t336 = new ArrayList<>(List.of("Tako", "Tako", "All Fried Sushi Platter", "All Fried Sushi Platter", "Sprite", "Tako", "Chocolate Cake"));
        List<String> t337 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Chocolate Cake", "Miso Ramen", "Sprite"));
        List<String> t338 = new ArrayList<>(List.of("Miso Ramen"));
        List<String> t339 = new ArrayList<>(List.of("Tendon", "Krazy Volcano", "Tako", "Kani Salad", "Tako", "Krazy Volcano", "Tako"));
        List<String> t340 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t341 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "Tako", "Miso Ramen", "Tendon", "Sprite", "Tako"));
        List<String> t342 = new ArrayList<>(List.of("All Fried Sushi Platter", "Sprite", "Kani Salad", "Tako"));
        List<String> t343 = new ArrayList<>(List.of("Kani Salad", "Tako", "Miso Ramen"));
        List<String> t344 = new ArrayList<>(List.of("Krazy Volcano", "Tako"));
        List<String> t345 = new ArrayList<>(List.of("Sprite", "All Fried Sushi Platter", "Tako", "Sprite", "Kani Salad"));
        List<String> t346 = new ArrayList<>(List.of("Miso Ramen", "Miso Ramen"));
        List<String> t347 = new ArrayList<>(List.of("Tako", "Miso Ramen", "Sprite", "Krazy Volcano"));
        List<String> t348 = new ArrayList<>(List.of("Chocolate Cake", "Tendon"));
        List<String> t349 = new ArrayList<>(List.of("Tendon", "Tako", "Chocolate Cake"));
        List<String> t350 = new ArrayList<>(List.of("Kani Salad", "All Fried Sushi Platter"));
        List<String> t351 = new ArrayList<>(List.of("Tako"));
        List<String> t352 = new ArrayList<>(List.of("Kani Salad", "All Fried Sushi Platter", "Tako", "Chocolate Cake", "Chocolate Cake"));
        List<String> t353 = new ArrayList<>(List.of("Tako", "Tako", "All Fried Sushi Platter", "Sprite", "Tendon", "Krazy Volcano", "Kani Salad"));
        List<String> t354 = new ArrayList<>(List.of("Kani Salad", "Sprite", "Sprite", "Sprite"));
        List<String> t355 = new ArrayList<>(List.of("Miso Ramen", "Miso Ramen", "Krazy Volcano", "Sprite"));
        List<String> t356 = new ArrayList<>(List.of("Miso Ramen"));
        List<String> t357 = new ArrayList<>(List.of("Tendon", "Chocolate Cake", "Tendon", "Tako", "Tako", "Tendon", "Tendon"));
        List<String> t358 = new ArrayList<>(List.of("All Fried Sushi Platter", "Chocolate Cake", "Krazy Volcano"));
        List<String> t359 = new ArrayList<>(List.of("Sprite", "Tako"));
        List<String> t360 = new ArrayList<>(List.of("Tako", "Tako", "Tako", "Chocolate Cake", "Tako", "Miso Ramen"));
        List<String> t361 = new ArrayList<>(List.of("All Fried Sushi Platter", "All Fried Sushi Platter", "Chocolate Cake", "Kani Salad", "Tendon", "Tendon"));
        List<String> t362 = new ArrayList<>(List.of("Tako", "Kani Salad", "All Fried Sushi Platter"));
        List<String> t363 = new ArrayList<>(List.of("All Fried Sushi Platter", "Krazy Volcano", "All Fried Sushi Platter", "Tako", "Miso Ramen", "All Fried Sushi Platter"));
        List<String> t364 = new ArrayList<>(List.of("Miso Ramen", "Kani Salad", "Chocolate Cake", "Miso Ramen", "All Fried Sushi Platter", "Miso Ramen"));
        List<String> t365 = new ArrayList<>(List.of("Tako", "Kani Salad"));
        List<String> t366 = new ArrayList<>(List.of("Tako", "Tako", "Krazy Volcano"));
        List<String> t367 = new ArrayList<>(List.of("Tako", "Miso Ramen", "Miso Ramen", "Krazy Volcano"));
        List<String> t368 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tako"));
        List<String> t369 = new ArrayList<>(List.of("Tendon", "Tendon", "Tako", "Kani Salad", "Kani Salad", "All Fried Sushi Platter", "Tako"));
        List<String> t370 = new ArrayList<>(List.of("Sprite"));
        List<String> t371 = new ArrayList<>(List.of("Tendon", "Tendon", "Sprite"));
        List<String> t372 = new ArrayList<>(List.of("Chocolate Cake", "Tako"));
        List<String> t373 = new ArrayList<>(List.of("Tendon", "Tako", "Krazy Volcano", "Kani Salad", "Tako"));
        List<String> t374 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "All Fried Sushi Platter"));
        List<String> t375 = new ArrayList<>(List.of("Miso Ramen"));
        List<String> t376 = new ArrayList<>(List.of("Chocolate Cake", "Krazy Volcano", "Kani Salad", "Tako", "Tako", "Kani Salad", "Tako"));
        List<String> t377 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tako", "Tako", "Miso Ramen"));
        List<String> t378 = new ArrayList<>(List.of("Miso Ramen", "All Fried Sushi Platter", "Tendon", "Krazy Volcano", "Miso Ramen", "Tako"));
        List<String> t379 = new ArrayList<>(List.of("Tendon", "Sprite", "All Fried Sushi Platter", "Kani Salad", "Tako"));
        List<String> t380 = new ArrayList<>(List.of("Tendon"));
        List<String> t381 = new ArrayList<>(List.of("Tako", "Krazy Volcano", "Chocolate Cake", "Tako"));
        List<String> t382 = new ArrayList<>(List.of("Krazy Volcano", "Sprite", "Chocolate Cake", "Tako", "Tendon"));
        List<String> t383 = new ArrayList<>(List.of("Tako", "Kani Salad"));
        List<String> t384 = new ArrayList<>(List.of("Miso Ramen", "Tako", "Chocolate Cake", "Kani Salad", "Tendon"));
        List<String> t385 = new ArrayList<>(List.of("Tako", "Kani Salad", "Krazy Volcano", "Kani Salad"));
        List<String> t386 = new ArrayList<>(List.of("Sprite", "Kani Salad", "Chocolate Cake", "Krazy Volcano", "Miso Ramen"));
        List<String> t387 = new ArrayList<>(List.of("Kani Salad", "Krazy Volcano", "Kani Salad", "Kani Salad", "Tako"));
        List<String> t388 = new ArrayList<>(List.of("Sprite", "Krazy Volcano", "Tako", "Miso Ramen", "All Fried Sushi Platter"));
        List<String> t389 = new ArrayList<>(List.of("Miso Ramen", "Kani Salad", "Tendon", "Tako", "Tako", "Tendon", "All Fried Sushi Platter"));
        List<String> t390 = new ArrayList<>(List.of("All Fried Sushi Platter"));
        List<String> t391 = new ArrayList<>(List.of("Tako", "Kani Salad", "Miso Ramen", "Kani Salad"));
        List<String> t392 = new ArrayList<>(List.of("Tako", "Krazy Volcano", "Tako"));
        List<String> t393 = new ArrayList<>(List.of("Tako", "All Fried Sushi Platter"));
        List<String> t394 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t395 = new ArrayList<>(List.of("Tako"));
        List<String> t396 = new ArrayList<>(List.of("Tendon", "Tako", "Tako", "Sprite", "Tako", "Chocolate Cake"));
        List<String> t397 = new ArrayList<>(List.of("Tako", "Krazy Volcano", "Tako", "Miso Ramen", "Miso Ramen"));
        List<String> t398 = new ArrayList<>(List.of("Tako", "Krazy Volcano", "All Fried Sushi Platter", "Miso Ramen"));
        List<String> t399 = new ArrayList<>(List.of("Tendon", "Sprite", "Chocolate Cake", "Tako", "Sprite", "Miso Ramen", "All Fried Sushi Platter"));
        List<String> t400 = new ArrayList<>(List.of("Miso Ramen", "Sprite", "Chocolate Cake"));
        List<String> t401 = new ArrayList<>(List.of("Chocolate Cake", "Tendon", "Krazy Volcano"));
        List<String> t402 = new ArrayList<>(List.of("All Fried Sushi Platter", "Kani Salad"));
        List<String> t403 = new ArrayList<>(List.of("Kani Salad", "Sprite", "Chocolate Cake", "Sprite", "Miso Ramen", "Krazy Volcano", "Tako"));
        List<String> t404 = new ArrayList<>(List.of("Kani Salad", "All Fried Sushi Platter"));
        List<String> t405 = new ArrayList<>(List.of("Tako", "Tako", "Miso Ramen", "All Fried Sushi Platter", "Tako"));
        List<String> t406 = new ArrayList<>(List.of("Tendon", "Sprite", "Kani Salad"));
        List<String> t407 = new ArrayList<>(List.of("Krazy Volcano", "Kani Salad", "Tendon"));
        List<String> t408 = new ArrayList<>(List.of("Krazy Volcano", "All Fried Sushi Platter", "Krazy Volcano", "Krazy Volcano"));
        List<String> t409 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tendon", "Krazy Volcano"));
        List<String> t410 = new ArrayList<>(List.of("Tendon", "Chocolate Cake", "Kani Salad", "Sprite", "Sprite", "Sprite"));
        List<String> t411 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Tako", "All Fried Sushi Platter"));
        List<String> t412 = new ArrayList<>(List.of("Krazy Volcano", "All Fried Sushi Platter", "Miso Ramen"));
        List<String> t413 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tendon", "All Fried Sushi Platter", "Miso Ramen"));
        List<String> t414 = new ArrayList<>(List.of("Sprite", "All Fried Sushi Platter", "All Fried Sushi Platter"));
        List<String> t415 = new ArrayList<>(List.of("Tako"));
        List<String> t416 = new ArrayList<>(List.of("Chocolate Cake", "Tendon", "Sprite", "Tako"));
        List<String> t417 = new ArrayList<>(List.of("Chocolate Cake", "Krazy Volcano", "All Fried Sushi Platter"));
        List<String> t418 = new ArrayList<>(List.of("Tako", "Krazy Volcano"));
        List<String> t419 = new ArrayList<>(List.of("Kani Salad", "All Fried Sushi Platter"));
        List<String> t420 = new ArrayList<>(List.of("Krazy Volcano", "All Fried Sushi Platter"));
        List<String> t421 = new ArrayList<>(List.of("Kani Salad", "Kani Salad"));
        List<String> t422 = new ArrayList<>(List.of("Tako", "Tako", "All Fried Sushi Platter", "Tako", "Tako", "Miso Ramen", "All Fried Sushi Platter"));
        List<String> t423 = new ArrayList<>(List.of("Sprite"));
        List<String> t424 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Tendon", "Chocolate Cake", "Sprite"));
        List<String> t425 = new ArrayList<>(List.of("Sprite", "Miso Ramen", "Kani Salad", "Chocolate Cake", "Tako", "Sprite"));
        List<String> t426 = new ArrayList<>(List.of("Kani Salad", "Miso Ramen"));
        List<String> t427 = new ArrayList<>(List.of("Tendon", "Tendon", "Tendon"));
        List<String> t428 = new ArrayList<>(List.of("Kani Salad", "Kani Salad"));
        List<String> t429 = new ArrayList<>(List.of("Chocolate Cake"));
        List<String> t430 = new ArrayList<>(List.of("Kani Salad", "Kani Salad", "Sprite", "Chocolate Cake", "Kani Salad"));
        List<String> t431 = new ArrayList<>(List.of("Tako", "Krazy Volcano", "Miso Ramen", "Tako", "Sprite", "Chocolate Cake", "Chocolate Cake"));
        List<String> t432 = new ArrayList<>(List.of("All Fried Sushi Platter"));
        List<String> t433 = new ArrayList<>(List.of("Tendon"));
        List<String> t434 = new ArrayList<>(List.of("Tako", "Krazy Volcano"));
        List<String> t435 = new ArrayList<>(List.of("Tendon", "Kani Salad"));
        List<String> t436 = new ArrayList<>(List.of("Tako", "All Fried Sushi Platter"));
        List<String> t437 = new ArrayList<>(List.of("Tendon", "Kani Salad", "Miso Ramen"));
        List<String> t438 = new ArrayList<>(List.of("Tako", "Chocolate Cake"));
        List<String> t439 = new ArrayList<>(List.of("Krazy Volcano", "Krazy Volcano"));
        List<String> t440 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t441 = new ArrayList<>(List.of("Tako", "Tako", "Tako", "Miso Ramen", "Tako", "All Fried Sushi Platter"));
        List<String> t442 = new ArrayList<>(List.of("Krazy Volcano"));
        List<String> t443 = new ArrayList<>(List.of("Kani Salad", "Tako", "Tako", "Chocolate Cake", "All Fried Sushi Platter", "Tendon", "Tako"));
        List<String> t444 = new ArrayList<>(List.of("Tako"));
        List<String> t445 = new ArrayList<>(List.of("Sprite", "Tako", "Tako", "Tako", "Tendon", "Kani Salad", "Chocolate Cake"));
        List<String> t446 = new ArrayList<>(List.of("Miso Ramen"));
        List<String> t447 = new ArrayList<>(List.of("Miso Ramen", "Tako"));
        List<String> t448 = new ArrayList<>(List.of("Tendon", "All Fried Sushi Platter", "Sprite", "All Fried Sushi Platter", "Tendon", "Tako"));
        List<String> t449 = new ArrayList<>(List.of("Tako"));
        List<String> t450 = new ArrayList<>(List.of("Kani Salad", "All Fried Sushi Platter"));
        List<String> t451 = new ArrayList<>(List.of("Tako", "All Fried Sushi Platter", "Kani Salad", "Miso Ramen", "Miso Ramen"));
        List<String> t452 = new ArrayList<>(List.of("Tendon", "Tako", "Kani Salad"));
        List<String> t453 = new ArrayList<>(List.of("All Fried Sushi Platter", "All Fried Sushi Platter", "Chocolate Cake", "Kani Salad", "Tako"));
        List<String> t454 = new ArrayList<>(List.of("All Fried Sushi Platter", "Tako"));
        List<String> t455 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "Kani Salad", "Miso Ramen"));
        List<String> t456 = new ArrayList<>(List.of("All Fried Sushi Platter", "Krazy Volcano"));
        List<String> t457 = new ArrayList<>(List.of("Tako", "Miso Ramen", "Tendon"));
        List<String> t458 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Krazy Volcano", "Miso Ramen"));
        List<String> t459 = new ArrayList<>(List.of("Kani Salad", "Krazy Volcano", "Miso Ramen", "Tendon"));
        List<String> t460 = new ArrayList<>(List.of("Tendon", "Tendon"));
        List<String> t461 = new ArrayList<>(List.of("Sprite", "Kani Salad"));
        List<String> t462 = new ArrayList<>(List.of("Miso Ramen", "Krazy Volcano"));
        List<String> t463 = new ArrayList<>(List.of("Kani Salad", "Tendon", "Krazy Volcano", "Krazy Volcano"));
        List<String> t464 = new ArrayList<>(List.of("Tako", "Kani Salad", "Krazy Volcano", "All Fried Sushi Platter", "Tako", "Chocolate Cake", "Tako"));
        List<String> t465 = new ArrayList<>(List.of("Chocolate Cake", "Chocolate Cake", "Tako", "Tendon", "Tako", "Tako", "Tako"));
        List<String> t466 = new ArrayList<>(List.of("Tako", "Kani Salad", "Tako", "Miso Ramen"));
        List<String> t467 = new ArrayList<>(List.of("All Fried Sushi Platter"));
        List<String> t468 = new ArrayList<>(List.of("Tako", "Sprite", "Krazy Volcano", "Miso Ramen"));
        List<String> t469 = new ArrayList<>(List.of("Tako", "Krazy Volcano", "All Fried Sushi Platter"));
        List<String> t470 = new ArrayList<>(List.of("Kani Salad"));
        List<String> t471 = new ArrayList<>(List.of("Sprite", "All Fried Sushi Platter", "Tendon"));
        List<String> t472 = new ArrayList<>(List.of("Tendon", "Krazy Volcano", "Kani Salad", "Tako"));
        List<String> t473 = new ArrayList<>(List.of("Tako", "All Fried Sushi Platter"));
        List<String> t474 = new ArrayList<>(List.of("Chocolate Cake", "Tendon", "Tako", "Chocolate Cake", "Tako"));
        List<String> t475 = new ArrayList<>(List.of("All Fried Sushi Platter", "Krazy Volcano"));
        List<String> t476 = new ArrayList<>(List.of("Tako", "Sprite", "Tako", "Tendon", "Tendon", "Tendon", "Kani Salad"));
        List<String> t477 = new ArrayList<>(List.of("Tako", "Sprite", "All Fried Sushi Platter", "Tako", "All Fried Sushi Platter"));
        List<String> t478 = new ArrayList<>(List.of("All Fried Sushi Platter", "Sprite", "Sprite", "Sprite", "All Fried Sushi Platter", "Tako", "Miso Ramen"));
        List<String> t479 = new ArrayList<>(List.of("Krazy Volcano", "Miso Ramen"));
        List<String> t480 = new ArrayList<>(List.of("All Fried Sushi Platter", "Kani Salad", "Miso Ramen", "All Fried Sushi Platter", "Sprite", "Sprite"));
        List<String> t481 = new ArrayList<>(List.of("Sprite"));
        List<String> t482 = new ArrayList<>(List.of("Krazy Volcano", "Tako", "Sprite", "Miso Ramen", "Miso Ramen", "All Fried Sushi Platter", "Krazy Volcano"));
        List<String> t483 = new ArrayList<>(List.of("Krazy Volcano", "Kani Salad"));
        List<String> t484 = new ArrayList<>(List.of("Tako", "Tako"));
        List<String> t485 = new ArrayList<>(List.of("Tako", "Krazy Volcano", "Tako", "Miso Ramen", "Tako", "Tako", "Tako"));
        List<String> t486 = new ArrayList<>(List.of("Chocolate Cake", "Tendon", "Miso Ramen", "Sprite", "Sprite", "Krazy Volcano"));
        List<String> t487 = new ArrayList<>(List.of("Miso Ramen", "Kani Salad", "Sprite", "Krazy Volcano", "Tako"));
        List<String> t488 = new ArrayList<>(List.of("Tako", "Tako", "All Fried Sushi Platter", "Sprite", "Kani Salad", "Krazy Volcano"));
        List<String> t489 = new ArrayList<>(List.of("Tako", "Chocolate Cake"));
        List<String> t490 = new ArrayList<>(List.of("Tako"));
        List<String> t491 = new ArrayList<>(List.of("Tako", "Chocolate Cake", "All Fried Sushi Platter", "Krazy Volcano", "Tako", "Tako", "Sprite"));
        List<String> t492 = new ArrayList<>(List.of("Sprite", "Tako"));
        List<String> t493 = new ArrayList<>(List.of("Sprite", "All Fried Sushi Platter", "Kani Salad"));
        List<String> t494 = new ArrayList<>(List.of("Miso Ramen", "Chocolate Cake"));
        List<String> t495 = new ArrayList<>(List.of("Tako"));
        List<String> t496 = new ArrayList<>(List.of("Chocolate Cake", "Tako", "Sprite", "Miso Ramen"));
        List<String> t497 = new ArrayList<>(List.of("Miso Ramen", "Miso Ramen", "Tako", "All Fried Sushi Platter", "Miso Ramen"));
        List<String> t498 = new ArrayList<>(List.of("Sprite", "All Fried Sushi Platter", "Sprite"));
        List<String> t499 = new ArrayList<>(List.of("Tako", "Sprite", "Tako", "Chocolate Cake", "Tendon", "Miso Ramen"));
        List<String> t500 = new ArrayList<>(List.of("Tako", "Tako", "Krazy Volcano", "Chocolate Cake", "Tako"));

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
