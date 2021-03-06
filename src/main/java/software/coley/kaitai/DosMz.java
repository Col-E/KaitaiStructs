// This is a generated file! Please edit source .ksy file and use kaitai-struct-compiler to rebuild

package software.coley.kaitai;

import io.kaitai.struct.ByteBufferKaitaiStream;
import io.kaitai.struct.KaitaiStream;
import io.kaitai.struct.KaitaiStruct;

import java.io.IOException;
import java.util.ArrayList;


/**
 * DOS MZ file format is a traditional format for executables in MS-DOS
 * environment. Many modern formats (i.e. Windows PE) still maintain
 * compatibility stub with this format.
 * <p>
 * As opposed to .com file format (which basically sports one 64K code
 * segment of raw CPU instructions), DOS MZ .exe file format allowed
 * more flexible memory management, loading of larger programs and
 * added support for relocations.
 */
@SuppressWarnings("unused")
public class DosMz extends KaitaiStruct {
	public DosMz(KaitaiStream _io) {
		this(_io, null, null);
	}

	public DosMz(KaitaiStream _io, KaitaiStruct _parent) {
		this(_io, _parent, null);
	}

	public DosMz(KaitaiStream _io, KaitaiStruct _parent, DosMz _root) {
		super(_io);
		this._parent = _parent;
		this._root = _root == null ? this : _root;
		_read();
	}

	private void _read() {
		this.hdr = new MzHeader(this._io, this, _root);
		this.mzHeader2 = this._io.readBytes((hdr().ofsRelocations() - 28));
		relocations = new ArrayList<>(((Number) (hdr().numRelocations())).intValue());
		for (int i = 0; i < hdr().numRelocations(); i++) {
			this.relocations.add(new Relocation(this._io, this, _root));
		}
		this.body = this._io.readBytesFull();
	}

	public static class MzHeader extends KaitaiStruct {
		public MzHeader(KaitaiStream _io) {
			this(_io, null, null);
		}

		public MzHeader(KaitaiStream _io, DosMz _parent) {
			this(_io, _parent, null);
		}

		public MzHeader(KaitaiStream _io, DosMz _parent, DosMz _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.magic = this._io.readU2le();
			this.lastPageExtraBytes = this._io.readU2le();
			this.numPages = this._io.readU2le();
			this.numRelocations = this._io.readU2le();
			this.headerSize = this._io.readU2le();
			this.minAllocation = this._io.readU2le();
			this.maxAllocation = this._io.readU2le();
			this.initialSs = this._io.readU2le();
			this.initialSp = this._io.readU2le();
			this.checksum = this._io.readU2le();
			this.initialIp = this._io.readU2le();
			this.initialCs = this._io.readU2le();
			this.ofsRelocations = this._io.readU2le();
			this.overlayId = this._io.readU2le();
		}

		private int magic;
		private int lastPageExtraBytes;
		private int numPages;
		private int numRelocations;
		private int headerSize;
		private int minAllocation;
		private int maxAllocation;
		private int initialSs;
		private int initialSp;
		private int checksum;
		private int initialIp;
		private int initialCs;
		private int ofsRelocations;
		private int overlayId;
		private final DosMz _root;
		private final DosMz _parent;

		public int magic() {
			return magic;
		}

		public int lastPageExtraBytes() {
			return lastPageExtraBytes;
		}

		public int numPages() {
			return numPages;
		}

		public int numRelocations() {
			return numRelocations;
		}

		public int headerSize() {
			return headerSize;
		}

		public int minAllocation() {
			return minAllocation;
		}

		public int maxAllocation() {
			return maxAllocation;
		}

		public int initialSs() {
			return initialSs;
		}

		public int initialSp() {
			return initialSp;
		}

		public int checksum() {
			return checksum;
		}

		public int initialIp() {
			return initialIp;
		}

		public int initialCs() {
			return initialCs;
		}

		public int ofsRelocations() {
			return ofsRelocations;
		}

		public int overlayId() {
			return overlayId;
		}

		public DosMz _root() {
			return _root;
		}

		public DosMz _parent() {
			return _parent;
		}
	}

	public static class Relocation extends KaitaiStruct {
		public Relocation(KaitaiStream _io) {
			this(_io, null, null);
		}

		public Relocation(KaitaiStream _io, DosMz _parent) {
			this(_io, _parent, null);
		}

		public Relocation(KaitaiStream _io, DosMz _parent, DosMz _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.ofs = this._io.readU2le();
			this.seg = this._io.readU2le();
		}

		private int ofs;
		private int seg;
		private final DosMz _root;
		private final DosMz _parent;

		public int ofs() {
			return ofs;
		}

		public int seg() {
			return seg;
		}

		public DosMz _root() {
			return _root;
		}

		public DosMz _parent() {
			return _parent;
		}
	}

	private MzHeader hdr;
	private byte[] mzHeader2;
	private ArrayList<Relocation> relocations;
	private byte[] body;
	private final DosMz _root;
	private final KaitaiStruct _parent;

	public MzHeader hdr() {
		return hdr;
	}

	public byte[] mzHeader2() {
		return mzHeader2;
	}

	public ArrayList<Relocation> relocations() {
		return relocations;
	}

	public byte[] body() {
		return body;
	}

	public DosMz _root() {
		return _root;
	}

	public KaitaiStruct _parent() {
		return _parent;
	}
}
