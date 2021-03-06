/*
 * Copyright 2009 Phil Burk, Mobileer Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jsyn.unitgen;

import com.jsyn.ports.UnitInputPort;
import com.jsyn.ports.UnitOutputPort;

/**
 * <pre>
 * output = (inputA * inputB) + inputC
 * </pre>
 * 
 * @author Phil Burk (C) 2009 Mobileer Inc
 * @version 016
 * @see Multiply
 * @see Add
 */
public class MultiplyAdd extends UnitGenerator {
    public UnitInputPort inputA;
    public UnitInputPort inputB;
    public UnitInputPort inputC;
    public UnitOutputPort output;

    /* Define Unit Ports used by connect() and set(). */
    public MultiplyAdd() {
        addPort(inputA = new UnitInputPort("InputA"));
        addPort(inputB = new UnitInputPort("InputB"));
        addPort(inputC = new UnitInputPort("InputC"));
        addPort(output = new UnitOutputPort("Output"));
    }

    @Override
    public void generate(int start, int limit) {
        double[] aValues = inputA.getValues();
        double[] bValues = inputB.getValues();
        double[] cValues = inputC.getValues();
        double[] outputs = output.getValues();
        for (int i = start; i < limit; i++) {
            outputs[i] = (aValues[i] * bValues[i]) + cValues[i];
        }
    }

}
