/*
 * Copyright 2015 Skymind,Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.nd4j.linalg.api.ops.impl.scalar;

import org.nd4j.linalg.api.complex.IComplexNumber;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.BaseScalarOp;
import org.nd4j.linalg.api.ops.Op;

/**
 *  Scalar muliplication
 *  @author Adam Gibson
 */
public class ScalarMultiplication extends BaseScalarOp {
    public ScalarMultiplication(INDArray x, INDArray y, int n, Number num) {
        super(x, y, n, num);
    }

    public ScalarMultiplication(INDArray x, Number num) {
        super(x, num);
    }

    public ScalarMultiplication(INDArray x, INDArray y, int n, IComplexNumber num) {
        super(x, y, n, num);
    }

    public ScalarMultiplication(INDArray x, IComplexNumber num) {
        super(x, num);
    }

    @Override
    public String name() {
        return "scalar_mul";
    }

    @Override
    public IComplexNumber op(IComplexNumber origin, double other, Object[] extraArgs) {
        if(complexNumber != null)
            return origin .mul(complexNumber);
        return complexNumber.mul(num);
    }

    @Override
    public IComplexNumber op(IComplexNumber origin, float other, Object[] extraArgs) {
        if(complexNumber != null)
            return origin .mul(complexNumber);
        return complexNumber.mul(num);
    }

    @Override
    public IComplexNumber op(IComplexNumber origin, IComplexNumber other, Object[] extraArgs) {
        if(complexNumber != null)
            return origin .mul(complexNumber);
        return complexNumber.mul(num);
    }

    @Override
    public float op(float origin, float other, Object[] extraArgs) {
        return (float) (origin * num.floatValue());
    }

    @Override
    public double op(double origin, double other, Object[] extraArgs) {
        return origin * num.doubleValue();
    }

    @Override
    public double op(double origin, Object[] extraArgs) {
        return origin * num.doubleValue();
    }

    @Override
    public float op(float origin, Object[] extraArgs) {
        return (float) (origin * num.floatValue());
    }

    @Override
    public IComplexNumber op(IComplexNumber origin, Object[] extraArgs) {
        if(complexNumber != null)
            return origin .mul(complexNumber);
        return complexNumber.mul(num);
    }

    @Override
    public Op opForDimension(int index, int dimension) {
        if(num != null)
            return new ScalarMultiplication(x.vectorAlongDimension(index,dimension),num);
        else
            return new ScalarMultiplication(x.vectorAlongDimension(index, dimension),complexNumber);
    }
}