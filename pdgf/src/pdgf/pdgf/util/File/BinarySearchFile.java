/*******************************************************************************
 * Copyright (c) 2011, Chair of Distributed Information Systems, University of Passau. 
 * All rights reserved. 
 * 
 * Redistribution and use in source and binary forms, with or without modification, 
 * are permitted provided that the following conditions are met: 
 * 
 * 1. Redistributions of source code must retain the above copyright notice, 
 *     this list of conditions and the following disclaimer. 
 * 
 * 2. Redistributions in binary form must reproduce the above copyright 
 *     notice, this list of conditions and the following disclaimer in the 
 *     documentation and/or other materials provided with the distribution. 
 * 
 * 3. Neither the name of the University of Passau nor the names of its 
 *     contributors may be used to endorse or promote products derived 
 *     from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED 
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A 
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE REGENTS OR 
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY 
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT 
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE 
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH 
 * DAMAGE.
 ******************************************************************************/
package pdgf.util.File;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.MappedByteBuffer;
//import java.nio.channels.FileChannel;
//
//import pdgf.util.Constants;
//import sun.misc.SoftCache;

/**
 * Not implemented yet
 * 
 * @author Michael Frank
 * @version 1.0 19.12.2009
 * 
 */
public class BinarySearchFile {
}

//
//
// extends LineAccessFile {
// private SoftCache cache = new SoftCache();
//
// public BinarySearchFile(File fileName) throws FileNotFoundException {
// super(fileName);
// // TODO Auto-generated constructor stub
// }
//
// @Override
// public char[] getLine(long lineNo) {
// // TODO Auto-generated method stub
// return null;
// }
//
// @Override
// public long getLineCount() {
// // TODO Auto-generated method stub
// return 0;
// }
//
// private void readFile(String filename) throws IOException {
//
// /*
// * InputStream rs = Class.class.getResourceAsStream(resourceName);
// * BufferedReader in = new BufferedReader(new InputStreamReader(rs,
// * "UTF-8"));
// */
// MappedByteBuffer b = (MappedByteBuffer) cache.get(filename);
// if (b == null) {
// b = newCacheEntry(filename);
// }
// }
//
// private MappedByteBuffer newCacheEntry(String filename) throws IOException {
// File f = new File(filename);
//
// MappedByteBuffer b = null;
// checkFile(f);
// if (f.length() > Constants.MAX_CACHABLE_FILE_SIZE) {
// // TODO we have a Problem! no cost free getLine(int lineno) funktion
// // for textfiles! another fileformat with fixed "max linsizes" and
// // padding must be introduced -> write tool for this!
//
// } else {
// b = getFileByteBuf(f);
// cache.put(filename, b);
// }
// return b;
// }
//
// private MappedByteBuffer getFileByteBuf(File f) throws IOException {
// FileChannel fc = null;
// MappedByteBuffer mbb = null;
// try {
// fc = (new FileInputStream(f)).getChannel();
//
// } catch (FileNotFoundException e) {
// // should not happen because of checkFile(f);
// e.printStackTrace();
// }
// mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
//
// return mbb;
// }
//
// }
