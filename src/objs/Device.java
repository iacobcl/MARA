/*
#  Licensed to the Apache Software Foundation (ASF) under one
#  or more contributor license agreements.  See the NOTICE file
#  distributed with this work for additional information
#  regarding copyright ownership.  The ASF licenses this file
#  to you under the Apache License, Version 2.0 (the
#  "License"); you may not use this file except in compliance
#  with the License.  You may obtain a copy of the License at
#
#  http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing,
#  software distributed under the License is distributed on an
#  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
#  KIND, either express or implied.  See the License for the
#  specific language governing permissions and limitations
#  under the License.

/**
@author Claudia Iacob
**/
package objs;

public class Device {
//This constructor creates a Device object with three attributes. 
    private String device;
    private int count;
    private double perc;

    /**
     * Creates a new Device object with given parameters.
     *
     * @param device a String input naming a device.
     * @param count an Integer input
     * @param perc
     */
    public Device(String device, int count, double perc) {
        super();
        this.device = device;
        this.count = count;
        this.perc = perc;
    }

    /**
     * Returns device as a String.
     *
     * @return device
     */

    public String getDevice() {
        return device;
    }

    /**
     * Sets the current Device objects name to the entered parameter.
     *
     * @param device the String name of the new Device object.
     */
    public void setDevice(String device) {
        this.device = device;
    }

    
    public int getCount() {
        return count;
    }
