// This is a generated file! Please edit source .ksy file and use kaitai-struct-compiler to rebuild
package software.coley.kaitai;

import io.kaitai.struct.ByteBufferKaitaiStream;
import io.kaitai.struct.KaitaiStream;
import io.kaitai.struct.KaitaiStruct;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class MachO extends KaitaiStruct {
	public enum MagicType {
		FAT_LE(3199925962L),
		FAT_BE(3405691582L),
		MACHO_LE_X86(3472551422L),
		MACHO_LE_X64(3489328638L),
		MACHO_BE_X86(4277009102L),
		MACHO_BE_X64(4277009103L);

		private final long id;

		MagicType(long id) {
			this.id = id;
		}

		public long id() {
			return id;
		}

		private static final Map<Long, MagicType> byId = new HashMap<>(6);

		static {
			for (MagicType e : MagicType.values())
				byId.put(e.id(), e);
		}

		public static MagicType byId(long id) {
			return byId.get(id);
		}
	}

	public enum CpuType {
		VAX(1),
		ROMP(2),
		NS32032(4),
		NS32332(5),
		I386(7),
		MIPS(8),
		NS32532(9),
		HPPA(11),
		ARM(12),
		MC88000(13),
		SPARC(14),
		I860(15),
		I860_LITTLE(16),
		RS6000(17),
		POWERPC(18),
		ABI64(16777216),
		X86_64(16777223),
		ARM64(16777228),
		POWERPC64(16777234),
		ANY(4294967295L);

		private final long id;

		CpuType(long id) {
			this.id = id;
		}

		public long id() {
			return id;
		}

		private static final Map<Long, CpuType> byId = new HashMap<>(20);

		static {
			for (CpuType e : CpuType.values())
				byId.put(e.id(), e);
		}

		public static CpuType byId(long id) {
			return byId.get(id);
		}
	}

	public enum FileType {
		OBJECT(1),
		EXECUTE(2),
		FVMLIB(3),
		CORE(4),
		PRELOAD(5),
		DYLIB(6),
		DYLINKER(7),
		BUNDLE(8),
		DYLIB_STUB(9),
		DSYM(10),
		KEXT_BUNDLE(11);

		private final long id;

		FileType(long id) {
			this.id = id;
		}

		public long id() {
			return id;
		}

		private static final Map<Long, FileType> byId = new HashMap<>(11);

		static {
			for (FileType e : FileType.values())
				byId.put(e.id(), e);
		}

		public static FileType byId(long id) {
			return byId.get(id);
		}
	}

	public enum LoadCommandType {
		SEGMENT(1),
		SYMTAB(2),
		SYMSEG(3),
		THREAD(4),
		UNIX_THREAD(5),
		LOAD_FVM_LIB(6),
		ID_FVM_LIB(7),
		IDENT(8),
		FVM_FILE(9),
		PREPAGE(10),
		DYSYMTAB(11),
		LOAD_DYLIB(12),
		ID_DYLIB(13),
		LOAD_DYLINKER(14),
		ID_DYLINKER(15),
		PREBOUND_DYLIB(16),
		ROUTINES(17),
		SUB_FRAMEWORK(18),
		SUB_UMBRELLA(19),
		SUB_CLIENT(20),
		SUB_LIBRARY(21),
		TWOLEVEL_HINTS(22),
		PREBIND_CKSUM(23),
		SEGMENT_64(25),
		ROUTINES_64(26),
		UUID(27),
		CODE_SIGNATURE(29),
		SEGMENT_SPLIT_INFO(30),
		LAZY_LOAD_DYLIB(32),
		ENCRYPTION_INFO(33),
		DYLD_INFO(34),
		VERSION_MIN_MACOSX(36),
		VERSION_MIN_IPHONEOS(37),
		FUNCTION_STARTS(38),
		DYLD_ENVIRONMENT(39),
		DATA_IN_CODE(41),
		SOURCE_VERSION(42),
		DYLIB_CODE_SIGN_DRS(43),
		ENCRYPTION_INFO_64(44),
		LINKER_OPTION(45),
		LINKER_OPTIMIZATION_HINT(46),
		VERSION_MIN_TVOS(47),
		VERSION_MIN_WATCHOS(48),
		BUILD_VERSION(50),
		REQ_DYLD(2147483648L),
		LOAD_WEAK_DYLIB(2147483672L),
		RPATH(2147483676L),
		REEXPORT_DYLIB(2147483679L),
		DYLD_INFO_ONLY(2147483682L),
		LOAD_UPWARD_DYLIB(2147483683L),
		MAIN(2147483688L);

		private final long id;

		LoadCommandType(long id) {
			this.id = id;
		}

		public long id() {
			return id;
		}

		private static final Map<Long, LoadCommandType> byId = new HashMap<>(51);

		static {
			for (LoadCommandType e : LoadCommandType.values())
				byId.put(e.id(), e);
		}

		public static LoadCommandType byId(long id) {
			return byId.get(id);
		}
	}

	public MachO(KaitaiStream _io) {
		this(_io, null, null);
	}

	public MachO(KaitaiStream _io, KaitaiStruct _parent) {
		this(_io, _parent, null);
	}

	public MachO(KaitaiStream _io, KaitaiStruct _parent, MachO _root) {
		super(_io);
		this._parent = _parent;
		this._root = _root == null ? this : _root;
		_read();
	}

	private void _read() {
		this.magic = MagicType.byId(this._io.readU4be());
		this.header = new MachHeader(this._io, this, _root);
		loadCommands = new ArrayList<>(((Number) (header().ncmds())).intValue());
		for (int i = 0; i < header().ncmds(); i++) {
			this.loadCommands.add(new LoadCommand(this._io, this, _root));
		}
	}

	public static class RpathCommand extends KaitaiStruct {
		public RpathCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public RpathCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public RpathCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.pathOffset = this._io.readU4le();
			this.path = new String(this._io.readBytesTerm(0, false, true, true), StandardCharsets.UTF_8);
		}

		private long pathOffset;
		private String path;
		private final MachO _root;
		private final MachO.LoadCommand _parent;

		public long pathOffset() {
			return pathOffset;
		}

		public String path() {
			return path;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}
	}

	public static class Uleb128 extends KaitaiStruct {
		public Uleb128(KaitaiStream _io) {
			this(_io, null, null);
		}

		public Uleb128(KaitaiStream _io, KaitaiStruct _parent) {
			this(_io, _parent, null);
		}

		public Uleb128(KaitaiStream _io, KaitaiStruct _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.b1 = this._io.readU1();
			if ((b1() & 128) != 0) {
				this.b2 = this._io.readU1();
			}
			if ((b2() & 128) != 0) {
				this.b3 = this._io.readU1();
			}
			if ((b3() & 128) != 0) {
				this.b4 = this._io.readU1();
			}
			if ((b4() & 128) != 0) {
				this.b5 = this._io.readU1();
			}
			if ((b5() & 128) != 0) {
				this.b6 = this._io.readU1();
			}
			if ((b6() & 128) != 0) {
				this.b7 = this._io.readU1();
			}
			if ((b7() & 128) != 0) {
				this.b8 = this._io.readU1();
			}
			if ((b8() & 128) != 0) {
				this.b9 = this._io.readU1();
			}
			if ((b9() & 128) != 0) {
				this.b10 = this._io.readU1();
			}
		}

		private Integer value;

		public Integer value() {
			if (this.value != null)
				return this.value;
			this.value = ((KaitaiStream.mod(b1(), 128) << 0) + ((b1() & 128) == 0 ? 0 : ((KaitaiStream.mod(b2(), 128) << 7) + ((b2() & 128) == 0 ? 0 : ((KaitaiStream.mod(b3(), 128) << 14) + ((b3() & 128) == 0 ? 0 : ((KaitaiStream.mod(b4(), 128) << 21) + ((b4() & 128) == 0 ? 0 : ((KaitaiStream.mod(b5(), 128) << 28) + ((b5() & 128) == 0 ? 0 : ((KaitaiStream.mod(b6(), 128) << 35) + ((b6() & 128) == 0 ? 0 : ((KaitaiStream.mod(b7(), 128) << 42) + ((b7() & 128) == 0 ? 0 : ((KaitaiStream.mod(b8(), 128) << 49) + ((b8() & 128) == 0 ? 0 : ((KaitaiStream.mod(b9(), 128) << 56) + ((b8() & 128) == 0 ? 0 : (KaitaiStream.mod(b10(), 128) << 63)))))))))))))))))));
			return this.value;
		}

		private int b1;
		private Integer b2;
		private Integer b3;
		private Integer b4;
		private Integer b5;
		private Integer b6;
		private Integer b7;
		private Integer b8;
		private Integer b9;
		private Integer b10;
		private final MachO _root;
		private final KaitaiStruct _parent;

		public int b1() {
			return b1;
		}

		public Integer b2() {
			return b2;
		}

		public Integer b3() {
			return b3;
		}

		public Integer b4() {
			return b4;
		}

		public Integer b5() {
			return b5;
		}

		public Integer b6() {
			return b6;
		}

		public Integer b7() {
			return b7;
		}

		public Integer b8() {
			return b8;
		}

		public Integer b9() {
			return b9;
		}

		public Integer b10() {
			return b10;
		}

		public MachO _root() {
			return _root;
		}

		public KaitaiStruct _parent() {
			return _parent;
		}
	}

	public static class SourceVersionCommand extends KaitaiStruct {
		public SourceVersionCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public SourceVersionCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public SourceVersionCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.version = this._io.readU8le();
		}

		private long version;
		private final MachO _root;
		private final MachO.LoadCommand _parent;

		public long version() {
			return version;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}
	}

	public static class CsBlob extends KaitaiStruct {
		public enum CsMagic {
			BLOB_WRAPPER(4208855809L),
			REQUIREMENT(4208856064L),
			REQUIREMENTS(4208856065L),
			CODE_DIRECTORY(4208856066L),
			EMBEDDED_SIGNATURE(4208856256L),
			DETACHED_SIGNATURE(4208856257L),
			ENTITLEMENT(4208882033L);

			private final long id;

			CsMagic(long id) {
				this.id = id;
			}

			public long id() {
				return id;
			}

			private static final Map<Long, CsMagic> byId = new HashMap<>(7);

			static {
				for (CsMagic e : CsMagic.values())
					byId.put(e.id(), e);
			}

			public static CsMagic byId(long id) {
				return byId.get(id);
			}
		}

		public CsBlob(KaitaiStream _io) {
			this(_io, null, null);
		}

		public CsBlob(KaitaiStream _io, KaitaiStruct _parent) {
			this(_io, _parent, null);
		}

		public CsBlob(KaitaiStream _io, KaitaiStruct _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.magic = CsMagic.byId(this._io.readU4be());
			this.length = this._io.readU4be();
			{
				CsMagic on = magic();
				if (on != null) {
					switch (magic()) {
						case REQUIREMENT: {
							this._raw_body = this._io.readBytes((length() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new Requirement(_io__raw_body, this, _root);
							break;
						}
						case CODE_DIRECTORY: {
							this._raw_body = this._io.readBytes((length() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new CodeDirectory(_io__raw_body, this, _root);
							break;
						}
						case ENTITLEMENT: {
							this._raw_body = this._io.readBytes((length() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new Entitlement(_io__raw_body, this, _root);
							break;
						}
						case REQUIREMENTS: {
							this._raw_body = this._io.readBytes((length() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new Requirements(_io__raw_body, this, _root);
							break;
						}
						case BLOB_WRAPPER: {
							this._raw_body = this._io.readBytes((length() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new BlobWrapper(_io__raw_body, this, _root);
							break;
						}
						case EMBEDDED_SIGNATURE:
						case DETACHED_SIGNATURE: {
							this._raw_body = this._io.readBytes((length() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new SuperBlob(_io__raw_body, this, _root);
							break;
						}
						default: {
							this.body = this._io.readBytes((length() - 8));
							break;
						}
					}
				} else {
					this.body = this._io.readBytes((length() - 8));
				}
			}
		}

		public static class Entitlement extends KaitaiStruct {
			public Entitlement(KaitaiStream _io) {
				this(_io, null, null);
			}

			public Entitlement(KaitaiStream _io, MachO.CsBlob _parent) {
				this(_io, _parent, null);
			}

			public Entitlement(KaitaiStream _io, MachO.CsBlob _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.data = this._io.readBytesFull();
			}

			private byte[] data;
			private final MachO _root;
			private final MachO.CsBlob _parent;

			public byte[] data() {
				return data;
			}

			public MachO _root() {
				return _root;
			}

			public MachO.CsBlob _parent() {
				return _parent;
			}
		}

		public static class CodeDirectory extends KaitaiStruct {
			public CodeDirectory(KaitaiStream _io) {
				this(_io, null, null);
			}

			public CodeDirectory(KaitaiStream _io, MachO.CsBlob _parent) {
				this(_io, _parent, null);
			}

			public CodeDirectory(KaitaiStream _io, MachO.CsBlob _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.version = this._io.readU4be();
				this.flags = this._io.readU4be();
				this.hashOffset = this._io.readU4be();
				this.identOffset = this._io.readU4be();
				this.nSpecialSlots = this._io.readU4be();
				this.nCodeSlots = this._io.readU4be();
				this.codeLimit = this._io.readU4be();
				this.hashSize = this._io.readU1();
				this.hashType = this._io.readU1();
				this.spare1 = this._io.readU1();
				this.pageSize = this._io.readU1();
				this.spare2 = this._io.readU4be();
				if (version() >= 131328) {
					this.scatterOffset = this._io.readU4be();
				}
				if (version() >= 131584) {
					this.teamIdOffset = this._io.readU4be();
				}
			}

			private String ident;

			public String ident() {
				if (this.ident != null)
					return this.ident;
				long _pos = this._io.pos();
				this._io.seek((identOffset() - 8));
				this.ident = new String(this._io.readBytesTerm(0, false, true, true), StandardCharsets.UTF_8);
				this._io.seek(_pos);
				return this.ident;
			}

			private String teamId;

			public String teamId() {
				if (this.teamId != null)
					return this.teamId;
				long _pos = this._io.pos();
				this._io.seek((teamIdOffset() - 8));
				this.teamId = new String(this._io.readBytesTerm(0, false, true, true), StandardCharsets.UTF_8);
				this._io.seek(_pos);
				return this.teamId;
			}

			private ArrayList<byte[]> hashes;

			public ArrayList<byte[]> hashes() {
				if (this.hashes != null)
					return this.hashes;
				long _pos = this._io.pos();
				this._io.seek(((hashOffset() - 8) - (hashSize() * nSpecialSlots())));
				hashes = new ArrayList<>(((Number) ((nSpecialSlots() + nCodeSlots()))).intValue());
				for (int i = 0; i < (nSpecialSlots() + nCodeSlots()); i++) {
					this.hashes.add(this._io.readBytes(hashSize()));
				}
				this._io.seek(_pos);
				return this.hashes;
			}

			private long version;
			private long flags;
			private long hashOffset;
			private long identOffset;
			private long nSpecialSlots;
			private long nCodeSlots;
			private long codeLimit;
			private int hashSize;
			private int hashType;
			private int spare1;
			private int pageSize;
			private long spare2;
			private Long scatterOffset;
			private Long teamIdOffset;
			private final MachO _root;
			private final MachO.CsBlob _parent;

			public long version() {
				return version;
			}

			public long flags() {
				return flags;
			}

			public long hashOffset() {
				return hashOffset;
			}

			public long identOffset() {
				return identOffset;
			}

			public long nSpecialSlots() {
				return nSpecialSlots;
			}

			public long nCodeSlots() {
				return nCodeSlots;
			}

			public long codeLimit() {
				return codeLimit;
			}

			public int hashSize() {
				return hashSize;
			}

			public int hashType() {
				return hashType;
			}

			public int spare1() {
				return spare1;
			}

			public int pageSize() {
				return pageSize;
			}

			public long spare2() {
				return spare2;
			}

			public Long scatterOffset() {
				return scatterOffset;
			}

			public Long teamIdOffset() {
				return teamIdOffset;
			}

			public MachO _root() {
				return _root;
			}

			public MachO.CsBlob _parent() {
				return _parent;
			}
		}

		public static class Data extends KaitaiStruct {
			public Data(KaitaiStream _io) {
				this(_io, null, null);
			}

			public Data(KaitaiStream _io, KaitaiStruct _parent) {
				this(_io, _parent, null);
			}

			public Data(KaitaiStream _io, KaitaiStruct _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.length = this._io.readU4be();
				this.value = this._io.readBytes(length());
				this.padding = this._io.readBytes((4 - (length() & 3)));
			}

			private long length;
			private byte[] value;
			private byte[] padding;
			private final MachO _root;
			private final KaitaiStruct _parent;

			public long length() {
				return length;
			}

			public byte[] value() {
				return value;
			}

			public byte[] padding() {
				return padding;
			}

			public MachO _root() {
				return _root;
			}

			public KaitaiStruct _parent() {
				return _parent;
			}
		}

		public static class SuperBlob extends KaitaiStruct {
			public SuperBlob(KaitaiStream _io) {
				this(_io, null, null);
			}

			public SuperBlob(KaitaiStream _io, MachO.CsBlob _parent) {
				this(_io, _parent, null);
			}

			public SuperBlob(KaitaiStream _io, MachO.CsBlob _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.count = this._io.readU4be();
				blobs = new ArrayList<>(((Number) (count())).intValue());
				for (int i = 0; i < count(); i++) {
					this.blobs.add(new BlobIndex(this._io, this, _root));
				}
			}

			private long count;
			private ArrayList<BlobIndex> blobs;
			private final MachO _root;
			private final MachO.CsBlob _parent;

			public long count() {
				return count;
			}

			public ArrayList<BlobIndex> blobs() {
				return blobs;
			}

			public MachO _root() {
				return _root;
			}

			public MachO.CsBlob _parent() {
				return _parent;
			}
		}

		public static class Expr extends KaitaiStruct {
			public enum OpEnum {
				FALSE(0),
				TRUE(1),
				IDENT(2),
				APPLE_ANCHOR(3),
				ANCHOR_HASH(4),
				INFO_KEY_VALUE(5),
				AND_OP(6),
				OR_OP(7),
				CD_HASH(8),
				NOT_OP(9),
				INFO_KEY_FIELD(10),
				CERT_FIELD(11),
				TRUSTED_CERT(12),
				TRUSTED_CERTS(13),
				CERT_GENERIC(14),
				APPLE_GENERIC_ANCHOR(15),
				ENTITLEMENT_FIELD(16);

				private final long id;

				OpEnum(long id) {
					this.id = id;
				}

				public long id() {
					return id;
				}

				private static final Map<Long, OpEnum> byId = new HashMap<>(17);

				static {
					for (OpEnum e : OpEnum.values())
						byId.put(e.id(), e);
				}

				public static OpEnum byId(long id) {
					return byId.get(id);
				}
			}

			public enum CertSlot {
				LEFT_CERT(0),
				ANCHOR_CERT(4294967295L);

				private final long id;

				CertSlot(long id) {
					this.id = id;
				}

				public long id() {
					return id;
				}

				private static final Map<Long, CertSlot> byId = new HashMap<>(2);

				static {
					for (CertSlot e : CertSlot.values())
						byId.put(e.id(), e);
				}

				public static CertSlot byId(long id) {
					return byId.get(id);
				}
			}

			public Expr(KaitaiStream _io) {
				this(_io, null, null);
			}

			public Expr(KaitaiStream _io, KaitaiStruct _parent) {
				this(_io, _parent, null);
			}

			public Expr(KaitaiStream _io, KaitaiStruct _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.op = OpEnum.byId(this._io.readU4be());
				{
					OpEnum on = op();
					if (on != null) {
						switch (op()) {
							case IDENT: {
								this.data = new IdentExpr(this._io, this, _root);
								break;
							}
							case OR_OP: {
								this.data = new OrExpr(this._io, this, _root);
								break;
							}
							case INFO_KEY_VALUE:
							case CD_HASH: {
								this.data = new Data(this._io, this, _root);
								break;
							}
							case ANCHOR_HASH: {
								this.data = new AnchorHashExpr(this._io, this, _root);
								break;
							}
							case INFO_KEY_FIELD: {
								this.data = new InfoKeyFieldExpr(this._io, this, _root);
								break;
							}
							case NOT_OP: {
								this.data = new Expr(this._io, this, _root);
								break;
							}
							case ENTITLEMENT_FIELD: {
								this.data = new EntitlementFieldExpr(this._io, this, _root);
								break;
							}
							case TRUSTED_CERT: {
								this.data = new CertSlotExpr(this._io, this, _root);
								break;
							}
							case AND_OP: {
								this.data = new AndExpr(this._io, this, _root);
								break;
							}
							case CERT_GENERIC: {
								this.data = new CertGenericExpr(this._io, this, _root);
								break;
							}
							case CERT_FIELD: {
								this.data = new CertFieldExpr(this._io, this, _root);
								break;
							}
							case APPLE_GENERIC_ANCHOR: {
								this.data = new AppleGenericAnchorExpr(this._io, this, _root);
								break;
							}
						}
					}
				}
			}

			public static class InfoKeyFieldExpr extends KaitaiStruct {
				public InfoKeyFieldExpr(KaitaiStream _io) {
					this(_io, null, null);
				}

				public InfoKeyFieldExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent) {
					this(_io, _parent, null);
				}

				public InfoKeyFieldExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent, MachO _root) {
					super(_io);
					this._parent = _parent;
					this._root = _root;
					_read();
				}

				private void _read() {
					this.data = new Data(this._io, this, _root);
					this.match = new Match(this._io, this, _root);
				}

				private Data data;
				private Match match;
				private final MachO _root;
				private final MachO.CsBlob.Expr _parent;

				public Data data() {
					return data;
				}

				public Match match() {
					return match;
				}

				public MachO _root() {
					return _root;
				}

				public MachO.CsBlob.Expr _parent() {
					return _parent;
				}
			}

			public static class CertSlotExpr extends KaitaiStruct {
				public CertSlotExpr(KaitaiStream _io) {
					this(_io, null, null);
				}

				public CertSlotExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent) {
					this(_io, _parent, null);
				}

				public CertSlotExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent, MachO _root) {
					super(_io);
					this._parent = _parent;
					this._root = _root;
					_read();
				}

				private void _read() {
					this.value = MachO.CsBlob.Expr.CertSlot.byId(this._io.readU4be());
				}

				private CertSlot value;
				private final MachO _root;
				private final MachO.CsBlob.Expr _parent;

				public CertSlot value() {
					return value;
				}

				public MachO _root() {
					return _root;
				}

				public MachO.CsBlob.Expr _parent() {
					return _parent;
				}
			}

			public static class CertGenericExpr extends KaitaiStruct {
				public CertGenericExpr(KaitaiStream _io) {
					this(_io, null, null);
				}

				public CertGenericExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent) {
					this(_io, _parent, null);
				}

				public CertGenericExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent, MachO _root) {
					super(_io);
					this._parent = _parent;
					this._root = _root;
					_read();
				}

				private void _read() {
					this.certSlot = MachO.CsBlob.Expr.CertSlot.byId(this._io.readU4be());
					this.data = new Data(this._io, this, _root);
					this.match = new Match(this._io, this, _root);
				}

				private CertSlot certSlot;
				private Data data;
				private Match match;
				private final MachO _root;
				private final MachO.CsBlob.Expr _parent;

				public CertSlot certSlot() {
					return certSlot;
				}

				public Data data() {
					return data;
				}

				public Match match() {
					return match;
				}

				public MachO _root() {
					return _root;
				}

				public MachO.CsBlob.Expr _parent() {
					return _parent;
				}
			}

			public static class IdentExpr extends KaitaiStruct {
				public IdentExpr(KaitaiStream _io) {
					this(_io, null, null);
				}

				public IdentExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent) {
					this(_io, _parent, null);
				}

				public IdentExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent, MachO _root) {
					super(_io);
					this._parent = _parent;
					this._root = _root;
					_read();
				}

				private void _read() {
					this.identifier = new Data(this._io, this, _root);
				}

				private Data identifier;
				private final MachO _root;
				private final MachO.CsBlob.Expr _parent;

				public Data identifier() {
					return identifier;
				}

				public MachO _root() {
					return _root;
				}

				public MachO.CsBlob.Expr _parent() {
					return _parent;
				}
			}

			public static class CertFieldExpr extends KaitaiStruct {
				public CertFieldExpr(KaitaiStream _io) {
					this(_io, null, null);
				}

				public CertFieldExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent) {
					this(_io, _parent, null);
				}

				public CertFieldExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent, MachO _root) {
					super(_io);
					this._parent = _parent;
					this._root = _root;
					_read();
				}

				private void _read() {
					this.certSlot = MachO.CsBlob.Expr.CertSlot.byId(this._io.readU4be());
					this.data = new Data(this._io, this, _root);
					this.match = new Match(this._io, this, _root);
				}

				private CertSlot certSlot;
				private Data data;
				private Match match;
				private final MachO _root;
				private final MachO.CsBlob.Expr _parent;

				public CertSlot certSlot() {
					return certSlot;
				}

				public Data data() {
					return data;
				}

				public Match match() {
					return match;
				}

				public MachO _root() {
					return _root;
				}

				public MachO.CsBlob.Expr _parent() {
					return _parent;
				}
			}

			public static class AnchorHashExpr extends KaitaiStruct {
				public AnchorHashExpr(KaitaiStream _io) {
					this(_io, null, null);
				}

				public AnchorHashExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent) {
					this(_io, _parent, null);
				}

				public AnchorHashExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent, MachO _root) {
					super(_io);
					this._parent = _parent;
					this._root = _root;
					_read();
				}

				private void _read() {
					this.certSlot = MachO.CsBlob.Expr.CertSlot.byId(this._io.readU4be());
					this.data = new Data(this._io, this, _root);
				}

				private CertSlot certSlot;
				private Data data;
				private final MachO _root;
				private final MachO.CsBlob.Expr _parent;

				public CertSlot certSlot() {
					return certSlot;
				}

				public Data data() {
					return data;
				}

				public MachO _root() {
					return _root;
				}

				public MachO.CsBlob.Expr _parent() {
					return _parent;
				}
			}

			public static class AppleGenericAnchorExpr extends KaitaiStruct {
				public AppleGenericAnchorExpr(KaitaiStream _io) {
					this(_io, null, null);
				}

				public AppleGenericAnchorExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent) {
					this(_io, _parent, null);
				}

				public AppleGenericAnchorExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent, MachO _root) {
					super(_io);
					this._parent = _parent;
					this._root = _root;
					_read();
				}

				private void _read() {
				}

				private String value;

				public String value() {
					if (this.value != null)
						return this.value;
					this.value = "anchor apple generic";
					return this.value;
				}

				private final MachO _root;
				private final MachO.CsBlob.Expr _parent;

				public MachO _root() {
					return _root;
				}

				public MachO.CsBlob.Expr _parent() {
					return _parent;
				}
			}

			public static class EntitlementFieldExpr extends KaitaiStruct {
				public EntitlementFieldExpr(KaitaiStream _io) {
					this(_io, null, null);
				}

				public EntitlementFieldExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent) {
					this(_io, _parent, null);
				}

				public EntitlementFieldExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent, MachO _root) {
					super(_io);
					this._parent = _parent;
					this._root = _root;
					_read();
				}

				private void _read() {
					this.data = new Data(this._io, this, _root);
					this.match = new Match(this._io, this, _root);
				}

				private Data data;
				private Match match;
				private final MachO _root;
				private final MachO.CsBlob.Expr _parent;

				public Data data() {
					return data;
				}

				public Match match() {
					return match;
				}

				public MachO _root() {
					return _root;
				}

				public MachO.CsBlob.Expr _parent() {
					return _parent;
				}
			}

			public static class AndExpr extends KaitaiStruct {
				public AndExpr(KaitaiStream _io) {
					this(_io, null, null);
				}

				public AndExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent) {
					this(_io, _parent, null);
				}

				public AndExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent, MachO _root) {
					super(_io);
					this._parent = _parent;
					this._root = _root;
					_read();
				}

				private void _read() {
					this.left = new Expr(this._io, this, _root);
					this.right = new Expr(this._io, this, _root);
				}

				private Expr left;
				private Expr right;
				private final MachO _root;
				private final MachO.CsBlob.Expr _parent;

				public Expr left() {
					return left;
				}

				public Expr right() {
					return right;
				}

				public MachO _root() {
					return _root;
				}

				public MachO.CsBlob.Expr _parent() {
					return _parent;
				}
			}

			public static class OrExpr extends KaitaiStruct {
				public OrExpr(KaitaiStream _io) {
					this(_io, null, null);
				}

				public OrExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent) {
					this(_io, _parent, null);
				}

				public OrExpr(KaitaiStream _io, MachO.CsBlob.Expr _parent, MachO _root) {
					super(_io);
					this._parent = _parent;
					this._root = _root;
					_read();
				}

				private void _read() {
					this.left = new Expr(this._io, this, _root);
					this.right = new Expr(this._io, this, _root);
				}

				private Expr left;
				private Expr right;
				private final MachO _root;
				private final MachO.CsBlob.Expr _parent;

				public Expr left() {
					return left;
				}

				public Expr right() {
					return right;
				}

				public MachO _root() {
					return _root;
				}

				public MachO.CsBlob.Expr _parent() {
					return _parent;
				}
			}

			private OpEnum op;
			private KaitaiStruct data;
			private final MachO _root;
			private final KaitaiStruct _parent;

			public OpEnum op() {
				return op;
			}

			public KaitaiStruct data() {
				return data;
			}

			public MachO _root() {
				return _root;
			}

			public KaitaiStruct _parent() {
				return _parent;
			}
		}

		public static class BlobIndex extends KaitaiStruct {
			public enum CsslotType {
				CODE_DIRECTORY(0),
				INFO_SLOT(1),
				REQUIREMENTS(2),
				RESOURCE_DIR(3),
				APPLICATION(4),
				ENTITLEMENTS(5),
				ALTERNATE_CODE_DIRECTORIES(4096),
				SIGNATURE_SLOT(65536);

				private final long id;

				CsslotType(long id) {
					this.id = id;
				}

				public long id() {
					return id;
				}

				private static final Map<Long, CsslotType> byId = new HashMap<>(8);

				static {
					for (CsslotType e : CsslotType.values())
						byId.put(e.id(), e);
				}

				public static CsslotType byId(long id) {
					return byId.get(id);
				}
			}

			public BlobIndex(KaitaiStream _io) {
				this(_io, null, null);
			}

			public BlobIndex(KaitaiStream _io, MachO.CsBlob.SuperBlob _parent) {
				this(_io, _parent, null);
			}

			public BlobIndex(KaitaiStream _io, MachO.CsBlob.SuperBlob _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.type = CsslotType.byId(this._io.readU4be());
				this.offset = this._io.readU4be();
			}

			private CsBlob blob;

			public CsBlob blob() {
				if (this.blob != null)
					return this.blob;
				KaitaiStream io = _parent()._io();
				long _pos = io.pos();
				io.seek((offset() - 8));
				this._raw_blob = io.readBytesFull();
				KaitaiStream _io__raw_blob = new ByteBufferKaitaiStream(_raw_blob);
				this.blob = new CsBlob(_io__raw_blob, this, _root);
				io.seek(_pos);
				return this.blob;
			}

			private CsslotType type;
			private long offset;
			private final MachO _root;
			private final MachO.CsBlob.SuperBlob _parent;
			private byte[] _raw_blob;

			public CsslotType type() {
				return type;
			}

			public long offset() {
				return offset;
			}

			public MachO _root() {
				return _root;
			}

			public MachO.CsBlob.SuperBlob _parent() {
				return _parent;
			}

			public byte[] _raw_blob() {
				return _raw_blob;
			}
		}

		public static class Match extends KaitaiStruct {
			public enum Op {
				EXISTS(0),
				EQUAL(1),
				CONTAINS(2),
				BEGINS_WITH(3),
				ENDS_WITH(4),
				LESS_THAN(5),
				GREATER_THAN(6),
				LESS_EQUAL(7),
				GREATER_EQUAL(8);

				private final long id;

				Op(long id) {
					this.id = id;
				}

				public long id() {
					return id;
				}

				private static final Map<Long, Op> byId = new HashMap<>(9);

				static {
					for (Op e : Op.values())
						byId.put(e.id(), e);
				}

				public static Op byId(long id) {
					return byId.get(id);
				}
			}

			public Match(KaitaiStream _io) {
				this(_io, null, null);
			}

			public Match(KaitaiStream _io, KaitaiStruct _parent) {
				this(_io, _parent, null);
			}

			public Match(KaitaiStream _io, KaitaiStruct _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.matchOp = Op.byId(this._io.readU4be());
				if (matchOp() != Op.EXISTS) {
					this.data = new Data(this._io, this, _root);
				}
			}

			private Op matchOp;
			private Data data;
			private final MachO _root;
			private final KaitaiStruct _parent;

			public Op matchOp() {
				return matchOp;
			}

			public Data data() {
				return data;
			}

			public MachO _root() {
				return _root;
			}

			public KaitaiStruct _parent() {
				return _parent;
			}
		}

		public static class Requirement extends KaitaiStruct {
			public Requirement(KaitaiStream _io) {
				this(_io, null, null);
			}

			public Requirement(KaitaiStream _io, MachO.CsBlob _parent) {
				this(_io, _parent, null);
			}

			public Requirement(KaitaiStream _io, MachO.CsBlob _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.kind = this._io.readU4be();
				this.expr = new Expr(this._io, this, _root);
			}

			private long kind;
			private Expr expr;
			private final MachO _root;
			private final MachO.CsBlob _parent;

			public long kind() {
				return kind;
			}

			public Expr expr() {
				return expr;
			}

			public MachO _root() {
				return _root;
			}

			public MachO.CsBlob _parent() {
				return _parent;
			}
		}

		public static class Requirements extends KaitaiStruct {
			public Requirements(KaitaiStream _io) {
				this(_io, null, null);
			}

			public Requirements(KaitaiStream _io, MachO.CsBlob _parent) {
				this(_io, _parent, null);
			}

			public Requirements(KaitaiStream _io, MachO.CsBlob _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.count = this._io.readU4be();
				items = new ArrayList<>(((Number) (count())).intValue());
				for (int i = 0; i < count(); i++) {
					this.items.add(new RequirementsBlobIndex(this._io, this, _root));
				}
			}

			private long count;
			private ArrayList<RequirementsBlobIndex> items;
			private final MachO _root;
			private final MachO.CsBlob _parent;

			public long count() {
				return count;
			}

			public ArrayList<RequirementsBlobIndex> items() {
				return items;
			}

			public MachO _root() {
				return _root;
			}

			public MachO.CsBlob _parent() {
				return _parent;
			}
		}

		public static class BlobWrapper extends KaitaiStruct {
			public BlobWrapper(KaitaiStream _io) {
				this(_io, null, null);
			}

			public BlobWrapper(KaitaiStream _io, MachO.CsBlob _parent) {
				this(_io, _parent, null);
			}

			public BlobWrapper(KaitaiStream _io, MachO.CsBlob _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.data = this._io.readBytesFull();
			}

			private byte[] data;
			private final MachO _root;
			private final MachO.CsBlob _parent;

			public byte[] data() {
				return data;
			}

			public MachO _root() {
				return _root;
			}

			public MachO.CsBlob _parent() {
				return _parent;
			}
		}

		public static class RequirementsBlobIndex extends KaitaiStruct {
			public enum RequirementType {
				HOST(1),
				GUEST(2),
				DESIGNATED(3),
				LIBRARY(4);

				private final long id;

				RequirementType(long id) {
					this.id = id;
				}

				public long id() {
					return id;
				}

				private static final Map<Long, RequirementType> byId = new HashMap<>(4);

				static {
					for (RequirementType e : RequirementType.values())
						byId.put(e.id(), e);
				}

				public static RequirementType byId(long id) {
					return byId.get(id);
				}
			}

			public RequirementsBlobIndex(KaitaiStream _io) {
				this(_io, null, null);
			}

			public RequirementsBlobIndex(KaitaiStream _io, MachO.CsBlob.Requirements _parent) {
				this(_io, _parent, null);
			}

			public RequirementsBlobIndex(KaitaiStream _io, MachO.CsBlob.Requirements _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.type = RequirementType.byId(this._io.readU4be());
				this.offset = this._io.readU4be();
			}

			private CsBlob value;

			public CsBlob value() {
				if (this.value != null)
					return this.value;
				long _pos = this._io.pos();
				this._io.seek((offset() - 8));
				this.value = new CsBlob(this._io, this, _root);
				this._io.seek(_pos);
				return this.value;
			}

			private RequirementType type;
			private long offset;
			private final MachO _root;
			private final MachO.CsBlob.Requirements _parent;

			public RequirementType type() {
				return type;
			}

			public long offset() {
				return offset;
			}

			public MachO _root() {
				return _root;
			}

			public MachO.CsBlob.Requirements _parent() {
				return _parent;
			}
		}

		private CsMagic magic;
		private long length;
		private Object body;
		private final MachO _root;
		private final KaitaiStruct _parent;
		private byte[] _raw_body;

		public CsMagic magic() {
			return magic;
		}

		public long length() {
			return length;
		}

		public Object body() {
			return body;
		}

		public MachO _root() {
			return _root;
		}

		public KaitaiStruct _parent() {
			return _parent;
		}

		public byte[] _raw_body() {
			return _raw_body;
		}
	}

	public static class BuildVersionCommand extends KaitaiStruct {
		public BuildVersionCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public BuildVersionCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public BuildVersionCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.platform = this._io.readU4le();
			this.minos = this._io.readU4le();
			this.sdk = this._io.readU4le();
			this.ntools = this._io.readU4le();
			tools = new ArrayList<>(((Number) (ntools())).intValue());
			for (int i = 0; i < ntools(); i++) {
				this.tools.add(new BuildToolVersion(this._io, this, _root));
			}
		}

		public static class BuildToolVersion extends KaitaiStruct {
			public BuildToolVersion(KaitaiStream _io) {
				this(_io, null, null);
			}

			public BuildToolVersion(KaitaiStream _io, MachO.BuildVersionCommand _parent) {
				this(_io, _parent, null);
			}

			public BuildToolVersion(KaitaiStream _io, MachO.BuildVersionCommand _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.tool = this._io.readU4le();
				this.version = this._io.readU4le();
			}

			private long tool;
			private long version;
			private final MachO _root;
			private final MachO.BuildVersionCommand _parent;

			public long tool() {
				return tool;
			}

			public long version() {
				return version;
			}

			public MachO _root() {
				return _root;
			}

			public MachO.BuildVersionCommand _parent() {
				return _parent;
			}
		}

		private long platform;
		private long minos;
		private long sdk;
		private long ntools;
		private ArrayList<BuildToolVersion> tools;
		private final MachO _root;
		private final MachO.LoadCommand _parent;

		public long platform() {
			return platform;
		}

		public long minos() {
			return minos;
		}

		public long sdk() {
			return sdk;
		}

		public long ntools() {
			return ntools;
		}

		public ArrayList<BuildToolVersion> tools() {
			return tools;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}
	}

	public static class RoutinesCommand extends KaitaiStruct {
		public RoutinesCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public RoutinesCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public RoutinesCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.initAddress = this._io.readU4le();
			this.initModule = this._io.readU4le();
			this.reserved = this._io.readBytes(24);
		}

		private long initAddress;
		private long initModule;
		private byte[] reserved;
		private final MachO _root;
		private final MachO.LoadCommand _parent;

		public long initAddress() {
			return initAddress;
		}

		public long initModule() {
			return initModule;
		}

		public byte[] reserved() {
			return reserved;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}
	}

	public static class MachoFlags extends KaitaiStruct {

		public MachoFlags(KaitaiStream _io, long value) {
			this(_io, null, null, value);
		}

		public MachoFlags(KaitaiStream _io, MachO.MachHeader _parent, long value) {
			this(_io, _parent, null, value);
		}

		public MachoFlags(KaitaiStream _io, MachO.MachHeader _parent, MachO _root, long value) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			this.value = value;
			_read();
		}

		private void _read() {
		}

		private Boolean subsectionsViaSymbols;

		/**
		 * safe to divide up the sections into sub-sections via symbols for dead code stripping
		 */
		public Boolean subsectionsViaSymbols() {
			if (this.subsectionsViaSymbols != null)
				return this.subsectionsViaSymbols;
			this.subsectionsViaSymbols = (value() & 8192) != 0;
			return this.subsectionsViaSymbols;
		}

		private Boolean deadStrippableDylib;

		public Boolean deadStrippableDylib() {
			if (this.deadStrippableDylib != null)
				return this.deadStrippableDylib;
			this.deadStrippableDylib = (value() & 4194304) != 0;
			return this.deadStrippableDylib;
		}

		private Boolean weakDefines;

		/**
		 * the final linked image contains external weak symbols
		 */
		public Boolean weakDefines() {
			if (this.weakDefines != null)
				return this.weakDefines;
			this.weakDefines = (value() & 32768) != 0;
			return this.weakDefines;
		}

		private Boolean prebound;

		/**
		 * the file has its dynamic undefined references prebound.
		 */
		public Boolean prebound() {
			if (this.prebound != null)
				return this.prebound;
			this.prebound = (value() & 16) != 0;
			return this.prebound;
		}

		private Boolean allModsBound;

		/**
		 * indicates that this binary binds to all two-level namespace modules of its dependent libraries. only used when MH_PREBINDABLE and MH_TWOLEVEL are both set.
		 */
		public Boolean allModsBound() {
			if (this.allModsBound != null)
				return this.allModsBound;
			this.allModsBound = (value() & 4096) != 0;
			return this.allModsBound;
		}

		private Boolean hasTlvDescriptors;

		public Boolean hasTlvDescriptors() {
			if (this.hasTlvDescriptors != null)
				return this.hasTlvDescriptors;
			this.hasTlvDescriptors = (value() & 8388608) != 0;
			return this.hasTlvDescriptors;
		}

		private Boolean forceFlat;

		/**
		 * the executable is forcing all images to use flat name space bindings
		 */
		public Boolean forceFlat() {
			if (this.forceFlat != null)
				return this.forceFlat;
			this.forceFlat = (value() & 256) != 0;
			return this.forceFlat;
		}

		private Boolean rootSafe;

		/**
		 * When this bit is set, the binary declares it is safe for use in processes with uid zero
		 */
		public Boolean rootSafe() {
			if (this.rootSafe != null)
				return this.rootSafe;
			this.rootSafe = (value() & 262144) != 0;
			return this.rootSafe;
		}

		private Boolean noUndefs;

		/**
		 * the object file has no undefined references
		 */
		public Boolean noUndefs() {
			if (this.noUndefs != null)
				return this.noUndefs;
			this.noUndefs = (value() & 1) != 0;
			return this.noUndefs;
		}

		private Boolean setuidSafe;

		/**
		 * When this bit is set, the binary declares it is safe for use in processes when issetugid() is true
		 */
		public Boolean setuidSafe() {
			if (this.setuidSafe != null)
				return this.setuidSafe;
			this.setuidSafe = (value() & 524288) != 0;
			return this.setuidSafe;
		}

		private Boolean noHeapExecution;

		public Boolean noHeapExecution() {
			if (this.noHeapExecution != null)
				return this.noHeapExecution;
			this.noHeapExecution = (value() & 16777216) != 0;
			return this.noHeapExecution;
		}

		private Boolean noReexportedDylibs;

		/**
		 * When this bit is set on a dylib, the static linker does not need to examine dependent dylibs to see if any are re-exported
		 */
		public Boolean noReexportedDylibs() {
			if (this.noReexportedDylibs != null)
				return this.noReexportedDylibs;
			this.noReexportedDylibs = (value() & 1048576) != 0;
			return this.noReexportedDylibs;
		}

		private Boolean noMultiDefs;

		/**
		 * this umbrella guarantees no multiple defintions of symbols in its sub-images so the two-level namespace hints can always be used.
		 */
		public Boolean noMultiDefs() {
			if (this.noMultiDefs != null)
				return this.noMultiDefs;
			this.noMultiDefs = (value() & 512) != 0;
			return this.noMultiDefs;
		}

		private Boolean appExtensionSafe;

		public Boolean appExtensionSafe() {
			if (this.appExtensionSafe != null)
				return this.appExtensionSafe;
			this.appExtensionSafe = (value() & 33554432) != 0;
			return this.appExtensionSafe;
		}

		private Boolean prebindable;

		/**
		 * the binary is not prebound but can have its prebinding redone. only used when MH_PREBOUND is not set.
		 */
		public Boolean prebindable() {
			if (this.prebindable != null)
				return this.prebindable;
			this.prebindable = (value() & 2048) != 0;
			return this.prebindable;
		}

		private Boolean incrLink;

		/**
		 * the object file is the output of an incremental link against a base file and can't be link edited again
		 */
		public Boolean incrLink() {
			if (this.incrLink != null)
				return this.incrLink;
			this.incrLink = (value() & 2) != 0;
			return this.incrLink;
		}

		private Boolean bindAtLoad;

		/**
		 * the object file's undefined references are bound by the dynamic linker when loaded.
		 */
		public Boolean bindAtLoad() {
			if (this.bindAtLoad != null)
				return this.bindAtLoad;
			this.bindAtLoad = (value() & 8) != 0;
			return this.bindAtLoad;
		}

		private Boolean canonical;

		/**
		 * the binary has been canonicalized via the unprebind operation
		 */
		public Boolean canonical() {
			if (this.canonical != null)
				return this.canonical;
			this.canonical = (value() & 16384) != 0;
			return this.canonical;
		}

		private Boolean twoLevel;

		/**
		 * the image is using two-level name space bindings
		 */
		public Boolean twoLevel() {
			if (this.twoLevel != null)
				return this.twoLevel;
			this.twoLevel = (value() & 128) != 0;
			return this.twoLevel;
		}

		private Boolean splitSegs;

		/**
		 * the file has its read-only and read-write segments split
		 */
		public Boolean splitSegs() {
			if (this.splitSegs != null)
				return this.splitSegs;
			this.splitSegs = (value() & 32) != 0;
			return this.splitSegs;
		}

		private Boolean lazyInit;

		/**
		 * the shared library init routine is to be run lazily via catching memory faults to its writeable segments (obsolete)
		 */
		public Boolean lazyInit() {
			if (this.lazyInit != null)
				return this.lazyInit;
			this.lazyInit = (value() & 64) != 0;
			return this.lazyInit;
		}

		private Boolean allowStackExecution;

		/**
		 * When this bit is set, all stacks in the task will be given stack execution privilege.  Only used in MH_EXECUTE filetypes.
		 */
		public Boolean allowStackExecution() {
			if (this.allowStackExecution != null)
				return this.allowStackExecution;
			this.allowStackExecution = (value() & 131072) != 0;
			return this.allowStackExecution;
		}

		private Boolean bindsToWeak;

		/**
		 * the final linked image uses weak symbols
		 */
		public Boolean bindsToWeak() {
			if (this.bindsToWeak != null)
				return this.bindsToWeak;
			this.bindsToWeak = (value() & 65536) != 0;
			return this.bindsToWeak;
		}

		private Boolean noFixPrebinding;

		/**
		 * do not have dyld notify the prebinding agent about this executable
		 */
		public Boolean noFixPrebinding() {
			if (this.noFixPrebinding != null)
				return this.noFixPrebinding;
			this.noFixPrebinding = (value() & 1024) != 0;
			return this.noFixPrebinding;
		}

		private Boolean dyldLink;

		/**
		 * the object file is input for the dynamic linker and can't be staticly link edited again
		 */
		public Boolean dyldLink() {
			if (this.dyldLink != null)
				return this.dyldLink;
			this.dyldLink = (value() & 4) != 0;
			return this.dyldLink;
		}

		private Boolean pie;

		/**
		 * When this bit is set, the OS will load the main executable at a random address. Only used in MH_EXECUTE filetypes.
		 */
		public Boolean pie() {
			if (this.pie != null)
				return this.pie;
			this.pie = (value() & 2097152) != 0;
			return this.pie;
		}

		private final long value;
		private final MachO _root;
		private final MachO.MachHeader _parent;

		public long value() {
			return value;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.MachHeader _parent() {
			return _parent;
		}
	}

	public static class RoutinesCommand64 extends KaitaiStruct {
		public RoutinesCommand64(KaitaiStream _io) {
			this(_io, null, null);
		}

		public RoutinesCommand64(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public RoutinesCommand64(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.initAddress = this._io.readU8le();
			this.initModule = this._io.readU8le();
			this.reserved = this._io.readBytes(48);
		}

		private long initAddress;
		private long initModule;
		private byte[] reserved;
		private final MachO _root;
		private final MachO.LoadCommand _parent;

		public long initAddress() {
			return initAddress;
		}

		public long initModule() {
			return initModule;
		}

		public byte[] reserved() {
			return reserved;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}
	}

	public static class LinkerOptionCommand extends KaitaiStruct {
		public LinkerOptionCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public LinkerOptionCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public LinkerOptionCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.numStrings = this._io.readU4le();
			strings = new ArrayList<>(((Number) (numStrings())).intValue());
			for (int i = 0; i < numStrings(); i++) {
				this.strings.add(new String(this._io.readBytesTerm(0, false, true, true), StandardCharsets.UTF_8));
			}
		}

		private long numStrings;
		private ArrayList<String> strings;
		private final MachO _root;
		private final MachO.LoadCommand _parent;

		public long numStrings() {
			return numStrings;
		}

		public ArrayList<String> strings() {
			return strings;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}
	}

	public static class SegmentCommand64 extends KaitaiStruct {
		public SegmentCommand64(KaitaiStream _io) {
			this(_io, null, null);
		}

		public SegmentCommand64(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public SegmentCommand64(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.segname = new String(KaitaiStream.bytesStripRight(this._io.readBytes(16), (byte) 0), StandardCharsets.US_ASCII);
			this.vmaddr = this._io.readU8le();
			this.vmsize = this._io.readU8le();
			this.fileoff = this._io.readU8le();
			this.filesize = this._io.readU8le();
			this.maxprot = new VmProt(this._io, this, _root);
			this.initprot = new VmProt(this._io, this, _root);
			this.nsects = this._io.readU4le();
			this.flags = this._io.readU4le();
			sections = new ArrayList<>(((Number) (nsects())).intValue());
			for (int i = 0; i < nsects(); i++) {
				this.sections.add(new Section64(this._io, this, _root));
			}
		}

		public static class Section64 extends KaitaiStruct {
			public Section64(KaitaiStream _io) {
				this(_io, null, null);
			}

			public Section64(KaitaiStream _io, MachO.SegmentCommand64 _parent) {
				this(_io, _parent, null);
			}

			public Section64(KaitaiStream _io, MachO.SegmentCommand64 _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.sectName = new String(KaitaiStream.bytesStripRight(this._io.readBytes(16), (byte) 0), StandardCharsets.US_ASCII);
				this.segName = new String(KaitaiStream.bytesStripRight(this._io.readBytes(16), (byte) 0), StandardCharsets.US_ASCII);
				this.addr = this._io.readU8le();
				this.size = this._io.readU8le();
				this.offset = this._io.readU4le();
				this.align = this._io.readU4le();
				this.reloff = this._io.readU4le();
				this.nreloc = this._io.readU4le();
				this.flags = this._io.readU4le();
				this.reserved1 = this._io.readU4le();
				this.reserved2 = this._io.readU4le();
				this.reserved3 = this._io.readU4le();
			}

			public static class CfStringList extends KaitaiStruct {
				public CfStringList(KaitaiStream _io) {
					this(_io, null, null);
				}

				public CfStringList(KaitaiStream _io, MachO.SegmentCommand64.Section64 _parent) {
					this(_io, _parent, null);
				}

				public CfStringList(KaitaiStream _io, MachO.SegmentCommand64.Section64 _parent, MachO _root) {
					super(_io);
					this._parent = _parent;
					this._root = _root;
					_read();
				}

				private void _read() {
					this.items = new ArrayList<>();
					{
						int i = 0;
						while (!this._io.isEof()) {
							this.items.add(new CfString(this._io, this, _root));
							i++;
						}
					}
				}

				private ArrayList<CfString> items;
				private final MachO _root;
				private final MachO.SegmentCommand64.Section64 _parent;

				public ArrayList<CfString> items() {
					return items;
				}

				public MachO _root() {
					return _root;
				}

				public MachO.SegmentCommand64.Section64 _parent() {
					return _parent;
				}
			}

			public static class CfString extends KaitaiStruct {
				public CfString(KaitaiStream _io) {
					this(_io, null, null);
				}

				public CfString(KaitaiStream _io, MachO.SegmentCommand64.Section64.CfStringList _parent) {
					this(_io, _parent, null);
				}

				public CfString(KaitaiStream _io, MachO.SegmentCommand64.Section64.CfStringList _parent, MachO _root) {
					super(_io);
					this._parent = _parent;
					this._root = _root;
					_read();
				}

				private void _read() {
					this.isa = this._io.readU8le();
					this.info = this._io.readU8le();
					this.data = this._io.readU8le();
					this.length = this._io.readU8le();
				}

				private long isa;
				private long info;
				private long data;
				private long length;
				private final MachO _root;
				private final MachO.SegmentCommand64.Section64.CfStringList _parent;

				public long isa() {
					return isa;
				}

				public long info() {
					return info;
				}

				public long data() {
					return data;
				}

				public long length() {
					return length;
				}

				public MachO _root() {
					return _root;
				}

				public MachO.SegmentCommand64.Section64.CfStringList _parent() {
					return _parent;
				}
			}

			public static class EhFrameItem extends KaitaiStruct {
				public EhFrameItem(KaitaiStream _io) {
					this(_io, null, null);
				}

				public EhFrameItem(KaitaiStream _io, MachO.SegmentCommand64.Section64.EhFrame _parent) {
					this(_io, _parent, null);
				}

				public EhFrameItem(KaitaiStream _io, MachO.SegmentCommand64.Section64.EhFrame _parent, MachO _root) {
					super(_io);
					this._parent = _parent;
					this._root = _root;
					_read();
				}

				private void _read() {
					this.length = this._io.readU4le();
					if (length() == 4294967295L) {
						this.length64 = this._io.readU8le();
					}
					this.id = this._io.readU4le();
					if (length() > 0) {
						if (id() == 0) {
							this._raw_body = this._io.readBytes((length() - 4));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new Cie(_io__raw_body, this, _root);
						} else {
							this.body = this._io.readBytes((length() - 4));
						}
					}
				}

				public static class CharChain extends KaitaiStruct {
					public CharChain(KaitaiStream _io) {
						this(_io, null, null);
					}

					public CharChain(KaitaiStream _io, KaitaiStruct _parent) {
						this(_io, _parent, null);
					}

					public CharChain(KaitaiStream _io, KaitaiStruct _parent, MachO _root) {
						super(_io);
						this._parent = _parent;
						this._root = _root;
						_read();
					}

					private void _read() {
						this.chr = this._io.readU1();
						if (chr() != 0) {
							this.next = new CharChain(this._io, this, _root);
						}
					}

					private int chr;
					private CharChain next;
					private final MachO _root;
					private final KaitaiStruct _parent;

					public int chr() {
						return chr;
					}

					public CharChain next() {
						return next;
					}

					public MachO _root() {
						return _root;
					}

					public KaitaiStruct _parent() {
						return _parent;
					}
				}

				public static class Cie extends KaitaiStruct {
					public Cie(KaitaiStream _io) {
						this(_io, null, null);
					}

					public Cie(KaitaiStream _io, MachO.SegmentCommand64.Section64.EhFrameItem _parent) {
						this(_io, _parent, null);
					}

					public Cie(KaitaiStream _io, MachO.SegmentCommand64.Section64.EhFrameItem _parent, MachO _root) {
						super(_io);
						this._parent = _parent;
						this._root = _root;
						_read();
					}

					private void _read() {
						this.version = this._io.readU1();
						this.augStr = new CharChain(this._io, this, _root);
						this.codeAlignmentFactor = new Uleb128(this._io, this, _root);
						this.dataAlignmentFactor = new Uleb128(this._io, this, _root);
						this.returnAddressRegister = this._io.readU1();
						if (augStr().chr() == 122) {
							this.augmentation = new AugmentationEntry(this._io, this, _root);
						}
					}

					private int version;
					private CharChain augStr;
					private Uleb128 codeAlignmentFactor;
					private Uleb128 dataAlignmentFactor;
					private int returnAddressRegister;
					private AugmentationEntry augmentation;
					private final MachO _root;
					private final MachO.SegmentCommand64.Section64.EhFrameItem _parent;

					public int version() {
						return version;
					}

					public CharChain augStr() {
						return augStr;
					}

					public Uleb128 codeAlignmentFactor() {
						return codeAlignmentFactor;
					}

					public Uleb128 dataAlignmentFactor() {
						return dataAlignmentFactor;
					}

					public int returnAddressRegister() {
						return returnAddressRegister;
					}

					public AugmentationEntry augmentation() {
						return augmentation;
					}

					public MachO _root() {
						return _root;
					}

					public MachO.SegmentCommand64.Section64.EhFrameItem _parent() {
						return _parent;
					}
				}

				public static class AugmentationEntry extends KaitaiStruct {
					public AugmentationEntry(KaitaiStream _io) {
						this(_io, null, null);
					}

					public AugmentationEntry(KaitaiStream _io, MachO.SegmentCommand64.Section64.EhFrameItem.Cie _parent) {
						this(_io, _parent, null);
					}

					public AugmentationEntry(KaitaiStream _io, MachO.SegmentCommand64.Section64.EhFrameItem.Cie _parent, MachO _root) {
						super(_io);
						this._parent = _parent;
						this._root = _root;
						_read();
					}

					private void _read() {
						this.length = new Uleb128(this._io, this, _root);
						if (_parent().augStr().next().chr() == 82) {
							this.fdePointerEncoding = this._io.readU1();
						}
					}

					private Uleb128 length;
					private Integer fdePointerEncoding;
					private final MachO _root;
					private final MachO.SegmentCommand64.Section64.EhFrameItem.Cie _parent;

					public Uleb128 length() {
						return length;
					}

					public Integer fdePointerEncoding() {
						return fdePointerEncoding;
					}

					public MachO _root() {
						return _root;
					}

					public MachO.SegmentCommand64.Section64.EhFrameItem.Cie _parent() {
						return _parent;
					}
				}

				private long length;
				private Long length64;
				private long id;
				private Object body;
				private final MachO _root;
				private final MachO.SegmentCommand64.Section64.EhFrame _parent;
				private byte[] _raw_body;

				public long length() {
					return length;
				}

				public Long length64() {
					return length64;
				}

				public long id() {
					return id;
				}

				public Object body() {
					return body;
				}

				public MachO _root() {
					return _root;
				}

				public MachO.SegmentCommand64.Section64.EhFrame _parent() {
					return _parent;
				}

				public byte[] _raw_body() {
					return _raw_body;
				}
			}

			public static class EhFrame extends KaitaiStruct {
				public EhFrame(KaitaiStream _io) {
					this(_io, null, null);
				}

				public EhFrame(KaitaiStream _io, MachO.SegmentCommand64.Section64 _parent) {
					this(_io, _parent, null);
				}

				public EhFrame(KaitaiStream _io, MachO.SegmentCommand64.Section64 _parent, MachO _root) {
					super(_io);
					this._parent = _parent;
					this._root = _root;
					_read();
				}

				private void _read() {
					this.items = new ArrayList<>();
					{
						int i = 0;
						while (!this._io.isEof()) {
							this.items.add(new EhFrameItem(this._io, this, _root));
							i++;
						}
					}
				}

				private ArrayList<EhFrameItem> items;
				private final MachO _root;
				private final MachO.SegmentCommand64.Section64 _parent;

				public ArrayList<EhFrameItem> items() {
					return items;
				}

				public MachO _root() {
					return _root;
				}

				public MachO.SegmentCommand64.Section64 _parent() {
					return _parent;
				}
			}

			public static class PointerList extends KaitaiStruct {
				public PointerList(KaitaiStream _io) {
					this(_io, null, null);
				}

				public PointerList(KaitaiStream _io, MachO.SegmentCommand64.Section64 _parent) {
					this(_io, _parent, null);
				}

				public PointerList(KaitaiStream _io, MachO.SegmentCommand64.Section64 _parent, MachO _root) {
					super(_io);
					this._parent = _parent;
					this._root = _root;
					_read();
				}

				private void _read() {
					this.items = new ArrayList<>();
					{
						int i = 0;
						while (!this._io.isEof()) {
							this.items.add(this._io.readU8le());
							i++;
						}
					}
				}

				private ArrayList<Long> items;
				private final MachO _root;
				private final MachO.SegmentCommand64.Section64 _parent;

				public ArrayList<Long> items() {
					return items;
				}

				public MachO _root() {
					return _root;
				}

				public MachO.SegmentCommand64.Section64 _parent() {
					return _parent;
				}
			}

			public static class StringList extends KaitaiStruct {
				public StringList(KaitaiStream _io) {
					this(_io, null, null);
				}

				public StringList(KaitaiStream _io, MachO.SegmentCommand64.Section64 _parent) {
					this(_io, _parent, null);
				}

				public StringList(KaitaiStream _io, MachO.SegmentCommand64.Section64 _parent, MachO _root) {
					super(_io);
					this._parent = _parent;
					this._root = _root;
					_read();
				}

				private void _read() {
					this.strings = new ArrayList<>();
					{
						int i = 0;
						while (!this._io.isEof()) {
							this.strings.add(new String(this._io.readBytesTerm(0, false, true, true), StandardCharsets.US_ASCII));
							i++;
						}
					}
				}

				private ArrayList<String> strings;
				private final MachO _root;
				private final MachO.SegmentCommand64.Section64 _parent;

				public ArrayList<String> strings() {
					return strings;
				}

				public MachO _root() {
					return _root;
				}

				public MachO.SegmentCommand64.Section64 _parent() {
					return _parent;
				}
			}

			private Object data;

			public Object data() {
				if (this.data != null)
					return this.data;
				KaitaiStream io = _root._io();
				long _pos = io.pos();
				io.seek(offset());
				switch (sectName()) {
					case "__objc_nlclslist":
					case "__objc_superrefs":
					case "__got":
					case "__objc_protorefs":
					case "__objc_classrefs":
					case "__objc_imageinfo":
					case "__objc_protolist":
					case "__objc_classlist":
					case "__objc_selrefs":
					case "__la_symbol_ptr":
					case "__nl_symbol_ptr": {
						this._raw_data = io.readBytes(size());
						KaitaiStream _io__raw_data = new ByteBufferKaitaiStream(_raw_data);
						this.data = new PointerList(_io__raw_data, this, _root);
						break;
					}
					case "__objc_methname":
					case "__objc_classname":
					case "__objc_methtype":
					case "__cstring": {
						this._raw_data = io.readBytes(size());
						KaitaiStream _io__raw_data = new ByteBufferKaitaiStream(_raw_data);
						this.data = new StringList(_io__raw_data, this, _root);
						break;
					}
					case "__cfstring": {
						this._raw_data = io.readBytes(size());
						KaitaiStream _io__raw_data = new ByteBufferKaitaiStream(_raw_data);
						this.data = new CfStringList(_io__raw_data, this, _root);
						break;
					}
					case "__eh_frame": {
						this._raw_data = io.readBytes(size());
						KaitaiStream _io__raw_data = new ByteBufferKaitaiStream(_raw_data);
						this.data = new EhFrame(_io__raw_data, this, _root);
						break;
					}
					default: {
						this.data = io.readBytes(size());
						break;
					}
				}
				io.seek(_pos);
				return this.data;
			}

			private String sectName;
			private String segName;
			private long addr;
			private long size;
			private long offset;
			private long align;
			private long reloff;
			private long nreloc;
			private long flags;
			private long reserved1;
			private long reserved2;
			private long reserved3;
			private final MachO _root;
			private final MachO.SegmentCommand64 _parent;
			private byte[] _raw_data;

			public String sectName() {
				return sectName;
			}

			public String segName() {
				return segName;
			}

			public long addr() {
				return addr;
			}

			public long size() {
				return size;
			}

			public long offset() {
				return offset;
			}

			public long align() {
				return align;
			}

			public long reloff() {
				return reloff;
			}

			public long nreloc() {
				return nreloc;
			}

			public long flags() {
				return flags;
			}

			public long reserved1() {
				return reserved1;
			}

			public long reserved2() {
				return reserved2;
			}

			public long reserved3() {
				return reserved3;
			}

			public MachO _root() {
				return _root;
			}

			public MachO.SegmentCommand64 _parent() {
				return _parent;
			}

			public byte[] _raw_data() {
				return _raw_data;
			}
		}

		private String segname;
		private long vmaddr;
		private long vmsize;
		private long fileoff;
		private long filesize;
		private VmProt maxprot;
		private VmProt initprot;
		private long nsects;
		private long flags;
		private ArrayList<Section64> sections;
		private final MachO _root;
		private final MachO.LoadCommand _parent;

		public String segname() {
			return segname;
		}

		public long vmaddr() {
			return vmaddr;
		}

		public long vmsize() {
			return vmsize;
		}

		public long fileoff() {
			return fileoff;
		}

		public long filesize() {
			return filesize;
		}

		public VmProt maxprot() {
			return maxprot;
		}

		public VmProt initprot() {
			return initprot;
		}

		public long nsects() {
			return nsects;
		}

		public long flags() {
			return flags;
		}

		public ArrayList<Section64> sections() {
			return sections;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}
	}

	public static class VmProt extends KaitaiStruct {
		public VmProt(KaitaiStream _io) {
			this(_io, null, null);
		}

		public VmProt(KaitaiStream _io, KaitaiStruct _parent) {
			this(_io, _parent, null);
		}

		public VmProt(KaitaiStream _io, KaitaiStruct _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.stripRead = this._io.readBitsIntBe(1) != 0;
			this.isMask = this._io.readBitsIntBe(1) != 0;
			this.reserved0 = this._io.readBitsIntBe(1) != 0;
			this.copy = this._io.readBitsIntBe(1) != 0;
			this.noChange = this._io.readBitsIntBe(1) != 0;
			this.execute = this._io.readBitsIntBe(1) != 0;
			this.write = this._io.readBitsIntBe(1) != 0;
			this.read = this._io.readBitsIntBe(1) != 0;
			this.reserved1 = this._io.readBitsIntBe(24);
		}

		private boolean stripRead;
		private boolean isMask;
		private boolean reserved0;
		private boolean copy;
		private boolean noChange;
		private boolean execute;
		private boolean write;
		private boolean read;
		private long reserved1;
		private final MachO _root;
		private final KaitaiStruct _parent;

		/**
		 * Special marker to support execute-only protection.
		 */
		public boolean stripRead() {
			return stripRead;
		}

		/**
		 * Indicates to use value as a mask against the actual protection bits.
		 */
		public boolean isMask() {
			return isMask;
		}

		/**
		 * Reserved (unused) bit.
		 */
		public boolean reserved0() {
			return reserved0;
		}

		/**
		 * Used when write permission can not be obtained, to mark the entry as COW.
		 */
		public boolean copy() {
			return copy;
		}

		/**
		 * Used only by memory_object_lock_request to indicate no change to page locks.
		 */
		public boolean noChange() {
			return noChange;
		}

		/**
		 * Execute permission.
		 */
		public boolean execute() {
			return execute;
		}

		/**
		 * Write permission.
		 */
		public boolean write() {
			return write;
		}

		/**
		 * Read permission.
		 */
		public boolean read() {
			return read;
		}

		/**
		 * Reserved (unused) bits.
		 */
		public long reserved1() {
			return reserved1;
		}

		public MachO _root() {
			return _root;
		}

		public KaitaiStruct _parent() {
			return _parent;
		}
	}

	public static class DysymtabCommand extends KaitaiStruct {
		public DysymtabCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public DysymtabCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public DysymtabCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.iLocalSym = this._io.readU4le();
			this.nLocalSym = this._io.readU4le();
			this.iExtDefSym = this._io.readU4le();
			this.nExtDefSym = this._io.readU4le();
			this.iUndefSym = this._io.readU4le();
			this.nUndefSym = this._io.readU4le();
			this.tocOff = this._io.readU4le();
			this.nToc = this._io.readU4le();
			this.modTabOff = this._io.readU4le();
			this.nModTab = this._io.readU4le();
			this.extRefSymOff = this._io.readU4le();
			this.nExtRefSyms = this._io.readU4le();
			this.indirectSymOff = this._io.readU4le();
			this.nIndirectSyms = this._io.readU4le();
			this.extRelOff = this._io.readU4le();
			this.nExtRel = this._io.readU4le();
			this.locRelOff = this._io.readU4le();
			this.nLocRel = this._io.readU4le();
		}

		private ArrayList<Long> indirectSymbols;

		public ArrayList<Long> indirectSymbols() {
			if (this.indirectSymbols != null)
				return this.indirectSymbols;
			KaitaiStream io = _root._io();
			long _pos = io.pos();
			io.seek(indirectSymOff());
			indirectSymbols = new ArrayList<>(((Number) (nIndirectSyms())).intValue());
			for (int i = 0; i < nIndirectSyms(); i++) {
				this.indirectSymbols.add(io.readU4le());
			}
			io.seek(_pos);
			return this.indirectSymbols;
		}

		private long iLocalSym;
		private long nLocalSym;
		private long iExtDefSym;
		private long nExtDefSym;
		private long iUndefSym;
		private long nUndefSym;
		private long tocOff;
		private long nToc;
		private long modTabOff;
		private long nModTab;
		private long extRefSymOff;
		private long nExtRefSyms;
		private long indirectSymOff;
		private long nIndirectSyms;
		private long extRelOff;
		private long nExtRel;
		private long locRelOff;
		private long nLocRel;
		private final MachO _root;
		private final MachO.LoadCommand _parent;

		public long iLocalSym() {
			return iLocalSym;
		}

		public long nLocalSym() {
			return nLocalSym;
		}

		public long iExtDefSym() {
			return iExtDefSym;
		}

		public long nExtDefSym() {
			return nExtDefSym;
		}

		public long iUndefSym() {
			return iUndefSym;
		}

		public long nUndefSym() {
			return nUndefSym;
		}

		public long tocOff() {
			return tocOff;
		}

		public long nToc() {
			return nToc;
		}

		public long modTabOff() {
			return modTabOff;
		}

		public long nModTab() {
			return nModTab;
		}

		public long extRefSymOff() {
			return extRefSymOff;
		}

		public long nExtRefSyms() {
			return nExtRefSyms;
		}

		public long indirectSymOff() {
			return indirectSymOff;
		}

		public long nIndirectSyms() {
			return nIndirectSyms;
		}

		public long extRelOff() {
			return extRelOff;
		}

		public long nExtRel() {
			return nExtRel;
		}

		public long locRelOff() {
			return locRelOff;
		}

		public long nLocRel() {
			return nLocRel;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}
	}

	public static class MachHeader extends KaitaiStruct {
		public MachHeader(KaitaiStream _io) {
			this(_io, null, null);
		}

		public MachHeader(KaitaiStream _io, MachO _parent) {
			this(_io, _parent, null);
		}

		public MachHeader(KaitaiStream _io, MachO _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.cputype = MachO.CpuType.byId(this._io.readU4le());
			this.cpusubtype = this._io.readU4le();
			this.filetype = MachO.FileType.byId(this._io.readU4le());
			this.ncmds = this._io.readU4le();
			this.sizeofcmds = this._io.readU4le();
			this.flags = this._io.readU4le();
			if (((_root.magic() == MachO.MagicType.MACHO_BE_X64) || (_root.magic() == MachO.MagicType.MACHO_LE_X64))) {
				this.reserved = this._io.readU4le();
			}
		}

		private MachoFlags flagsObj;

		public MachoFlags flagsObj() {
			if (this.flagsObj != null)
				return this.flagsObj;
			this.flagsObj = new MachoFlags(this._io, this, _root, flags());
			return this.flagsObj;
		}

		private CpuType cputype;
		private long cpusubtype;
		private FileType filetype;
		private long ncmds;
		private long sizeofcmds;
		private long flags;
		private Long reserved;
		private final MachO _root;
		private final MachO _parent;

		public CpuType cputype() {
			return cputype;
		}

		public long cpusubtype() {
			return cpusubtype;
		}

		public FileType filetype() {
			return filetype;
		}

		public long ncmds() {
			return ncmds;
		}

		public long sizeofcmds() {
			return sizeofcmds;
		}

		public long flags() {
			return flags;
		}

		public Long reserved() {
			return reserved;
		}

		public MachO _root() {
			return _root;
		}

		public MachO _parent() {
			return _parent;
		}
	}

	public static class LinkeditDataCommand extends KaitaiStruct {
		public LinkeditDataCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public LinkeditDataCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public LinkeditDataCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.dataOff = this._io.readU4le();
			this.dataSize = this._io.readU4le();
		}

		private long dataOff;
		private long dataSize;
		private final MachO _root;
		private final MachO.LoadCommand _parent;

		public long dataOff() {
			return dataOff;
		}

		public long dataSize() {
			return dataSize;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}
	}

	public static class SubCommand extends KaitaiStruct {
		public SubCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public SubCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public SubCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.name = new LcStr(this._io, this, _root);
		}

		private LcStr name;
		private final MachO _root;
		private final MachO.LoadCommand _parent;

		public LcStr name() {
			return name;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}
	}

	public static class TwolevelHintsCommand extends KaitaiStruct {
		public TwolevelHintsCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public TwolevelHintsCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public TwolevelHintsCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.offset = this._io.readU4le();
			this.numHints = this._io.readU4le();
		}

		private long offset;
		private long numHints;
		private final MachO _root;
		private final MachO.LoadCommand _parent;

		public long offset() {
			return offset;
		}

		public long numHints() {
			return numHints;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}
	}

	public static class Version extends KaitaiStruct {
		public Version(KaitaiStream _io) {
			this(_io, null, null);
		}

		public Version(KaitaiStream _io, MachO.VersionMinCommand _parent) {
			this(_io, _parent, null);
		}

		public Version(KaitaiStream _io, MachO.VersionMinCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.p1 = this._io.readU1();
			this.minor = this._io.readU1();
			this.major = this._io.readU1();
			this.release = this._io.readU1();
		}

		private int p1;
		private int minor;
		private int major;
		private int release;
		private final MachO _root;
		private final MachO.VersionMinCommand _parent;

		public int p1() {
			return p1;
		}

		public int minor() {
			return minor;
		}

		public int major() {
			return major;
		}

		public int release() {
			return release;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.VersionMinCommand _parent() {
			return _parent;
		}
	}

	public static class EncryptionInfoCommand extends KaitaiStruct {
		public EncryptionInfoCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public EncryptionInfoCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public EncryptionInfoCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.cryptoff = this._io.readU4le();
			this.cryptsize = this._io.readU4le();
			this.cryptid = this._io.readU4le();
			if (((_root.magic() == MachO.MagicType.MACHO_BE_X64) || (_root.magic() == MachO.MagicType.MACHO_LE_X64))) {
				this.pad = this._io.readU4le();
			}
		}

		private long cryptoff;
		private long cryptsize;
		private long cryptid;
		private Long pad;
		private final MachO _root;
		private final MachO.LoadCommand _parent;

		public long cryptoff() {
			return cryptoff;
		}

		public long cryptsize() {
			return cryptsize;
		}

		public long cryptid() {
			return cryptid;
		}

		public Long pad() {
			return pad;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}
	}

	public static class CodeSignatureCommand extends KaitaiStruct {
		public CodeSignatureCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public CodeSignatureCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public CodeSignatureCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.dataOff = this._io.readU4le();
			this.dataSize = this._io.readU4le();
		}

		private CsBlob codeSignature;

		public CsBlob codeSignature() {
			if (this.codeSignature != null)
				return this.codeSignature;
			KaitaiStream io = _root._io();
			long _pos = io.pos();
			io.seek(dataOff());
			this._raw_codeSignature = io.readBytes(dataSize());
			KaitaiStream _io__raw_codeSignature = new ByteBufferKaitaiStream(_raw_codeSignature);
			this.codeSignature = new CsBlob(_io__raw_codeSignature, this, _root);
			io.seek(_pos);
			return this.codeSignature;
		}

		private long dataOff;
		private long dataSize;
		private final MachO _root;
		private final MachO.LoadCommand _parent;
		private byte[] _raw_codeSignature;

		public long dataOff() {
			return dataOff;
		}

		public long dataSize() {
			return dataSize;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}

		public byte[] _raw_codeSignature() {
			return _raw_codeSignature;
		}
	}

	public static class DyldInfoCommand extends KaitaiStruct {
		public enum BindOpcode {
			DONE(0),
			SET_DYLIB_ORDINAL_IMMEDIATE(16),
			SET_DYLIB_ORDINAL_ULEB(32),
			SET_DYLIB_SPECIAL_IMMEDIATE(48),
			SET_SYMBOL_TRAILING_FLAGS_IMMEDIATE(64),
			SET_TYPE_IMMEDIATE(80),
			SET_APPEND_SLEB(96),
			SET_SEGMENT_AND_OFFSET_ULEB(112),
			ADD_ADDRESS_ULEB(128),
			DO_BIND(144),
			DO_BIND_ADD_ADDRESS_ULEB(160),
			DO_BIND_ADD_ADDRESS_IMMEDIATE_SCALED(176),
			DO_BIND_ULEB_TIMES_SKIPPING_ULEB(192);

			private final long id;

			BindOpcode(long id) {
				this.id = id;
			}

			public long id() {
				return id;
			}

			private static final Map<Long, BindOpcode> byId = new HashMap<>(13);

			static {
				for (BindOpcode e : BindOpcode.values())
					byId.put(e.id(), e);
			}

			public static BindOpcode byId(long id) {
				return byId.get(id);
			}
		}

		public DyldInfoCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public DyldInfoCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public DyldInfoCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.rebaseOff = this._io.readU4le();
			this.rebaseSize = this._io.readU4le();
			this.bindOff = this._io.readU4le();
			this.bindSize = this._io.readU4le();
			this.weakBindOff = this._io.readU4le();
			this.weakBindSize = this._io.readU4le();
			this.lazyBindOff = this._io.readU4le();
			this.lazyBindSize = this._io.readU4le();
			this.exportOff = this._io.readU4le();
			this.exportSize = this._io.readU4le();
		}

		public static class BindItem extends KaitaiStruct {
			public BindItem(KaitaiStream _io) {
				this(_io, null, null);
			}

			public BindItem(KaitaiStream _io, KaitaiStruct _parent) {
				this(_io, _parent, null);
			}

			public BindItem(KaitaiStream _io, KaitaiStruct _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.opcodeAndImmediate = this._io.readU1();
				if (((opcode() == MachO.DyldInfoCommand.BindOpcode.SET_DYLIB_ORDINAL_ULEB) || (opcode() == MachO.DyldInfoCommand.BindOpcode.SET_APPEND_SLEB) || (opcode() == MachO.DyldInfoCommand.BindOpcode.SET_SEGMENT_AND_OFFSET_ULEB) || (opcode() == MachO.DyldInfoCommand.BindOpcode.ADD_ADDRESS_ULEB) || (opcode() == MachO.DyldInfoCommand.BindOpcode.DO_BIND_ADD_ADDRESS_ULEB) || (opcode() == MachO.DyldInfoCommand.BindOpcode.DO_BIND_ULEB_TIMES_SKIPPING_ULEB))) {
					this.uleb = new Uleb128(this._io, this, _root);
				}
				if (opcode() == MachO.DyldInfoCommand.BindOpcode.DO_BIND_ULEB_TIMES_SKIPPING_ULEB) {
					this.skip = new Uleb128(this._io, this, _root);
				}
				if (opcode() == MachO.DyldInfoCommand.BindOpcode.SET_SYMBOL_TRAILING_FLAGS_IMMEDIATE) {
					this.symbol = new String(this._io.readBytesTerm(0, false, true, true), StandardCharsets.US_ASCII);
				}
			}

			private BindOpcode opcode;

			public BindOpcode opcode() {
				if (this.opcode != null)
					return this.opcode;
				this.opcode = MachO.DyldInfoCommand.BindOpcode.byId((opcodeAndImmediate() & 240));
				return this.opcode;
			}

			private Integer immediate;

			public Integer immediate() {
				if (this.immediate != null)
					return this.immediate;
				this.immediate = (opcodeAndImmediate() & 15);
				return this.immediate;
			}

			private int opcodeAndImmediate;
			private Uleb128 uleb;
			private Uleb128 skip;
			private String symbol;
			private final MachO _root;
			private final KaitaiStruct _parent;

			public int opcodeAndImmediate() {
				return opcodeAndImmediate;
			}

			public Uleb128 uleb() {
				return uleb;
			}

			public Uleb128 skip() {
				return skip;
			}

			public String symbol() {
				return symbol;
			}

			public MachO _root() {
				return _root;
			}

			public KaitaiStruct _parent() {
				return _parent;
			}
		}

		public static class RebaseData extends KaitaiStruct {
			public enum Opcode {
				DONE(0),
				SET_TYPE_IMMEDIATE(16),
				SET_SEGMENT_AND_OFFSET_ULEB(32),
				ADD_ADDRESS_ULEB(48),
				ADD_ADDRESS_IMMEDIATE_SCALED(64),
				DO_REBASE_IMMEDIATE_TIMES(80),
				DO_REBASE_ULEB_TIMES(96),
				DO_REBASE_ADD_ADDRESS_ULEB(112),
				DO_REBASE_ULEB_TIMES_SKIPPING_ULEB(128);

				private final long id;

				Opcode(long id) {
					this.id = id;
				}

				public long id() {
					return id;
				}

				private static final Map<Long, Opcode> byId = new HashMap<>(9);

				static {
					for (Opcode e : Opcode.values())
						byId.put(e.id(), e);
				}

				public static Opcode byId(long id) {
					return byId.get(id);
				}
			}

			public RebaseData(KaitaiStream _io) {
				this(_io, null, null);
			}

			public RebaseData(KaitaiStream _io, MachO.DyldInfoCommand _parent) {
				this(_io, _parent, null);
			}

			public RebaseData(KaitaiStream _io, MachO.DyldInfoCommand _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.items = new ArrayList<>();
				{
					RebaseItem _it;
					int i = 0;
					do {
						_it = new RebaseItem(this._io, this, _root);
						this.items.add(_it);
						i++;
					} while (!(_it.opcode() == Opcode.DONE));
				}
			}

			public static class RebaseItem extends KaitaiStruct {
				public RebaseItem(KaitaiStream _io) {
					this(_io, null, null);
				}

				public RebaseItem(KaitaiStream _io, MachO.DyldInfoCommand.RebaseData _parent) {
					this(_io, _parent, null);
				}

				public RebaseItem(KaitaiStream _io, MachO.DyldInfoCommand.RebaseData _parent, MachO _root) {
					super(_io);
					this._parent = _parent;
					this._root = _root;
					_read();
				}

				private void _read() {
					this.opcodeAndImmediate = this._io.readU1();
					if (((opcode() == MachO.DyldInfoCommand.RebaseData.Opcode.SET_SEGMENT_AND_OFFSET_ULEB) || (opcode() == MachO.DyldInfoCommand.RebaseData.Opcode.ADD_ADDRESS_ULEB) || (opcode() == MachO.DyldInfoCommand.RebaseData.Opcode.DO_REBASE_ULEB_TIMES) || (opcode() == MachO.DyldInfoCommand.RebaseData.Opcode.DO_REBASE_ADD_ADDRESS_ULEB) || (opcode() == MachO.DyldInfoCommand.RebaseData.Opcode.DO_REBASE_ULEB_TIMES_SKIPPING_ULEB))) {
						this.uleb = new Uleb128(this._io, this, _root);
					}
					if (opcode() == MachO.DyldInfoCommand.RebaseData.Opcode.DO_REBASE_ULEB_TIMES_SKIPPING_ULEB) {
						this.skip = new Uleb128(this._io, this, _root);
					}
				}

				private Opcode opcode;

				public Opcode opcode() {
					if (this.opcode != null)
						return this.opcode;
					this.opcode = MachO.DyldInfoCommand.RebaseData.Opcode.byId((opcodeAndImmediate() & 240));
					return this.opcode;
				}

				private Integer immediate;

				public Integer immediate() {
					if (this.immediate != null)
						return this.immediate;
					this.immediate = (opcodeAndImmediate() & 15);
					return this.immediate;
				}

				private int opcodeAndImmediate;
				private Uleb128 uleb;
				private Uleb128 skip;
				private final MachO _root;
				private final MachO.DyldInfoCommand.RebaseData _parent;

				public int opcodeAndImmediate() {
					return opcodeAndImmediate;
				}

				public Uleb128 uleb() {
					return uleb;
				}

				public Uleb128 skip() {
					return skip;
				}

				public MachO _root() {
					return _root;
				}

				public MachO.DyldInfoCommand.RebaseData _parent() {
					return _parent;
				}
			}

			private ArrayList<RebaseItem> items;
			private final MachO _root;
			private final MachO.DyldInfoCommand _parent;

			public ArrayList<RebaseItem> items() {
				return items;
			}

			public MachO _root() {
				return _root;
			}

			public MachO.DyldInfoCommand _parent() {
				return _parent;
			}
		}

		public static class ExportNode extends KaitaiStruct {
			public ExportNode(KaitaiStream _io) {
				this(_io, null, null);
			}

			public ExportNode(KaitaiStream _io, KaitaiStruct _parent) {
				this(_io, _parent, null);
			}

			public ExportNode(KaitaiStream _io, KaitaiStruct _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.terminalSize = new Uleb128(this._io, this, _root);
				this.childrenCount = this._io.readU1();
				children = new ArrayList<>(((Number) (childrenCount())).intValue());
				for (int i = 0; i < childrenCount(); i++) {
					this.children.add(new Child(this._io, this, _root));
				}
				this.terminal = this._io.readBytes(terminalSize().value());
			}

			public static class Child extends KaitaiStruct {
				public Child(KaitaiStream _io) {
					this(_io, null, null);
				}

				public Child(KaitaiStream _io, MachO.DyldInfoCommand.ExportNode _parent) {
					this(_io, _parent, null);
				}

				public Child(KaitaiStream _io, MachO.DyldInfoCommand.ExportNode _parent, MachO _root) {
					super(_io);
					this._parent = _parent;
					this._root = _root;
					_read();
				}

				private void _read() {
					this.name = new String(this._io.readBytesTerm(0, false, true, true), StandardCharsets.US_ASCII);
					this.nodeOffset = new Uleb128(this._io, this, _root);
				}

				private ExportNode value;

				public ExportNode value() {
					if (this.value != null)
						return this.value;
					long _pos = this._io.pos();
					this._io.seek(nodeOffset().value());
					this.value = new ExportNode(this._io, this, _root);
					this._io.seek(_pos);
					return this.value;
				}

				private String name;
				private Uleb128 nodeOffset;
				private final MachO _root;
				private final MachO.DyldInfoCommand.ExportNode _parent;

				public String name() {
					return name;
				}

				public Uleb128 nodeOffset() {
					return nodeOffset;
				}

				public MachO _root() {
					return _root;
				}

				public MachO.DyldInfoCommand.ExportNode _parent() {
					return _parent;
				}
			}

			private Uleb128 terminalSize;
			private int childrenCount;
			private ArrayList<Child> children;
			private byte[] terminal;
			private final MachO _root;
			private final KaitaiStruct _parent;

			public Uleb128 terminalSize() {
				return terminalSize;
			}

			public int childrenCount() {
				return childrenCount;
			}

			public ArrayList<Child> children() {
				return children;
			}

			public byte[] terminal() {
				return terminal;
			}

			public MachO _root() {
				return _root;
			}

			public KaitaiStruct _parent() {
				return _parent;
			}
		}

		public static class BindData extends KaitaiStruct {
			public BindData(KaitaiStream _io) {
				this(_io, null, null);
			}

			public BindData(KaitaiStream _io, MachO.DyldInfoCommand _parent) {
				this(_io, _parent, null);
			}

			public BindData(KaitaiStream _io, MachO.DyldInfoCommand _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.items = new ArrayList<>();
				{
					BindItem _it;
					int i = 0;
					do {
						_it = new BindItem(this._io, this, _root);
						this.items.add(_it);
						i++;
					} while (!(_it.opcode() == MachO.DyldInfoCommand.BindOpcode.DONE));
				}
			}

			private ArrayList<BindItem> items;
			private final MachO _root;
			private final MachO.DyldInfoCommand _parent;

			public ArrayList<BindItem> items() {
				return items;
			}

			public MachO _root() {
				return _root;
			}

			public MachO.DyldInfoCommand _parent() {
				return _parent;
			}
		}

		public static class LazyBindData extends KaitaiStruct {
			public LazyBindData(KaitaiStream _io) {
				this(_io, null, null);
			}

			public LazyBindData(KaitaiStream _io, MachO.DyldInfoCommand _parent) {
				this(_io, _parent, null);
			}

			public LazyBindData(KaitaiStream _io, MachO.DyldInfoCommand _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.items = new ArrayList<>();
				{
					int i = 0;
					while (!this._io.isEof()) {
						this.items.add(new BindItem(this._io, this, _root));
						i++;
					}
				}
			}

			private ArrayList<BindItem> items;
			private final MachO _root;
			private final MachO.DyldInfoCommand _parent;

			public ArrayList<BindItem> items() {
				return items;
			}

			public MachO _root() {
				return _root;
			}

			public MachO.DyldInfoCommand _parent() {
				return _parent;
			}
		}

		private RebaseData rebase;

		public RebaseData rebase() {
			if (this.rebase != null)
				return this.rebase;
			KaitaiStream io = _root._io();
			long _pos = io.pos();
			io.seek(rebaseOff());
			this._raw_rebase = io.readBytes(rebaseSize());
			KaitaiStream _io__raw_rebase = new ByteBufferKaitaiStream(_raw_rebase);
			this.rebase = new RebaseData(_io__raw_rebase, this, _root);
			io.seek(_pos);
			return this.rebase;
		}

		private BindData bind;

		public BindData bind() {
			if (this.bind != null)
				return this.bind;
			KaitaiStream io = _root._io();
			long _pos = io.pos();
			io.seek(bindOff());
			this._raw_bind = io.readBytes(bindSize());
			KaitaiStream _io__raw_bind = new ByteBufferKaitaiStream(_raw_bind);
			this.bind = new BindData(_io__raw_bind, this, _root);
			io.seek(_pos);
			return this.bind;
		}

		private LazyBindData lazyBind;

		public LazyBindData lazyBind() {
			if (this.lazyBind != null)
				return this.lazyBind;
			KaitaiStream io = _root._io();
			long _pos = io.pos();
			io.seek(lazyBindOff());
			this._raw_lazyBind = io.readBytes(lazyBindSize());
			KaitaiStream _io__raw_lazyBind = new ByteBufferKaitaiStream(_raw_lazyBind);
			this.lazyBind = new LazyBindData(_io__raw_lazyBind, this, _root);
			io.seek(_pos);
			return this.lazyBind;
		}

		private ExportNode exports;

		public ExportNode exports() {
			if (this.exports != null)
				return this.exports;
			KaitaiStream io = _root._io();
			long _pos = io.pos();
			io.seek(exportOff());
			this._raw_exports = io.readBytes(exportSize());
			KaitaiStream _io__raw_exports = new ByteBufferKaitaiStream(_raw_exports);
			this.exports = new ExportNode(_io__raw_exports, this, _root);
			io.seek(_pos);
			return this.exports;
		}

		private long rebaseOff;
		private long rebaseSize;
		private long bindOff;
		private long bindSize;
		private long weakBindOff;
		private long weakBindSize;
		private long lazyBindOff;
		private long lazyBindSize;
		private long exportOff;
		private long exportSize;
		private final MachO _root;
		private final MachO.LoadCommand _parent;
		private byte[] _raw_rebase;
		private byte[] _raw_bind;
		private byte[] _raw_lazyBind;
		private byte[] _raw_exports;

		public long rebaseOff() {
			return rebaseOff;
		}

		public long rebaseSize() {
			return rebaseSize;
		}

		public long bindOff() {
			return bindOff;
		}

		public long bindSize() {
			return bindSize;
		}

		public long weakBindOff() {
			return weakBindOff;
		}

		public long weakBindSize() {
			return weakBindSize;
		}

		public long lazyBindOff() {
			return lazyBindOff;
		}

		public long lazyBindSize() {
			return lazyBindSize;
		}

		public long exportOff() {
			return exportOff;
		}

		public long exportSize() {
			return exportSize;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}

		public byte[] _raw_rebase() {
			return _raw_rebase;
		}

		public byte[] _raw_bind() {
			return _raw_bind;
		}

		public byte[] _raw_lazyBind() {
			return _raw_lazyBind;
		}

		public byte[] _raw_exports() {
			return _raw_exports;
		}
	}

	public static class DylinkerCommand extends KaitaiStruct {
		public DylinkerCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public DylinkerCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public DylinkerCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.name = new LcStr(this._io, this, _root);
		}

		private LcStr name;
		private final MachO _root;
		private final MachO.LoadCommand _parent;

		public LcStr name() {
			return name;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}
	}

	public static class DylibCommand extends KaitaiStruct {
		public DylibCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public DylibCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public DylibCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.nameOffset = this._io.readU4le();
			this.timestamp = this._io.readU4le();
			this.currentVersion = this._io.readU4le();
			this.compatibilityVersion = this._io.readU4le();
			this.name = new String(this._io.readBytesTerm(0, false, true, true), StandardCharsets.UTF_8);
		}

		private long nameOffset;
		private long timestamp;
		private long currentVersion;
		private long compatibilityVersion;
		private String name;
		private final MachO _root;
		private final MachO.LoadCommand _parent;

		public long nameOffset() {
			return nameOffset;
		}

		public long timestamp() {
			return timestamp;
		}

		public long currentVersion() {
			return currentVersion;
		}

		public long compatibilityVersion() {
			return compatibilityVersion;
		}

		public String name() {
			return name;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}
	}

	public static class SegmentCommand extends KaitaiStruct {
		public SegmentCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public SegmentCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public SegmentCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.segname = new String(KaitaiStream.bytesStripRight(this._io.readBytes(16), (byte) 0), StandardCharsets.US_ASCII);
			this.vmaddr = this._io.readU4le();
			this.vmsize = this._io.readU4le();
			this.fileoff = this._io.readU4le();
			this.filesize = this._io.readU4le();
			this.maxprot = new VmProt(this._io, this, _root);
			this.initprot = new VmProt(this._io, this, _root);
			this.nsects = this._io.readU4le();
			this.flags = this._io.readU4le();
			sections = new ArrayList<>(((Number) (nsects())).intValue());
			for (int i = 0; i < nsects(); i++) {
				this.sections.add(new Section(this._io, this, _root));
			}
		}

		public static class Section extends KaitaiStruct {
			public Section(KaitaiStream _io) {
				this(_io, null, null);
			}

			public Section(KaitaiStream _io, MachO.SegmentCommand _parent) {
				this(_io, _parent, null);
			}

			public Section(KaitaiStream _io, MachO.SegmentCommand _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.sectName = new String(KaitaiStream.bytesStripRight(this._io.readBytes(16), (byte) 0), StandardCharsets.US_ASCII);
				this.segName = new String(KaitaiStream.bytesStripRight(this._io.readBytes(16), (byte) 0), StandardCharsets.US_ASCII);
				this.addr = this._io.readU4le();
				this.size = this._io.readU4le();
				this.offset = this._io.readU4le();
				this.align = this._io.readU4le();
				this.reloff = this._io.readU4le();
				this.nreloc = this._io.readU4le();
				this.flags = this._io.readU4le();
				this.reserved1 = this._io.readU4le();
				this.reserved2 = this._io.readU4le();
			}

			private byte[] data;

			public byte[] data() {
				if (this.data != null)
					return this.data;
				KaitaiStream io = _root._io();
				long _pos = io.pos();
				io.seek(offset());
				this.data = io.readBytes(size());
				io.seek(_pos);
				return this.data;
			}

			private String sectName;
			private String segName;
			private long addr;
			private long size;
			private long offset;
			private long align;
			private long reloff;
			private long nreloc;
			private long flags;
			private long reserved1;
			private long reserved2;
			private final MachO _root;
			private final MachO.SegmentCommand _parent;

			public String sectName() {
				return sectName;
			}

			public String segName() {
				return segName;
			}

			public long addr() {
				return addr;
			}

			public long size() {
				return size;
			}

			public long offset() {
				return offset;
			}

			public long align() {
				return align;
			}

			public long reloff() {
				return reloff;
			}

			public long nreloc() {
				return nreloc;
			}

			public long flags() {
				return flags;
			}

			public long reserved1() {
				return reserved1;
			}

			public long reserved2() {
				return reserved2;
			}

			public MachO _root() {
				return _root;
			}

			public MachO.SegmentCommand _parent() {
				return _parent;
			}
		}

		private String segname;
		private long vmaddr;
		private long vmsize;
		private long fileoff;
		private long filesize;
		private VmProt maxprot;
		private VmProt initprot;
		private long nsects;
		private long flags;
		private ArrayList<Section> sections;
		private final MachO _root;
		private final MachO.LoadCommand _parent;

		public String segname() {
			return segname;
		}

		public long vmaddr() {
			return vmaddr;
		}

		public long vmsize() {
			return vmsize;
		}

		public long fileoff() {
			return fileoff;
		}

		public long filesize() {
			return filesize;
		}

		public VmProt maxprot() {
			return maxprot;
		}

		public VmProt initprot() {
			return initprot;
		}

		public long nsects() {
			return nsects;
		}

		public long flags() {
			return flags;
		}

		public ArrayList<Section> sections() {
			return sections;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}
	}

	public static class LcStr extends KaitaiStruct {
		public LcStr(KaitaiStream _io) {
			this(_io, null, null);
		}

		public LcStr(KaitaiStream _io, KaitaiStruct _parent) {
			this(_io, _parent, null);
		}

		public LcStr(KaitaiStream _io, KaitaiStruct _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.length = this._io.readU4le();
			this.value = new String(this._io.readBytesTerm(0, false, true, true), StandardCharsets.UTF_8);
		}

		private long length;
		private String value;
		private final MachO _root;
		private final KaitaiStruct _parent;

		public long length() {
			return length;
		}

		public String value() {
			return value;
		}

		public MachO _root() {
			return _root;
		}

		public KaitaiStruct _parent() {
			return _parent;
		}
	}

	public static class LoadCommand extends KaitaiStruct {
		public LoadCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public LoadCommand(KaitaiStream _io, MachO _parent) {
			this(_io, _parent, null);
		}

		public LoadCommand(KaitaiStream _io, MachO _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.type = MachO.LoadCommandType.byId(this._io.readU4le());
			this.size = this._io.readU4le();
			{
				LoadCommandType on = type();
				if (on != null) {
					switch (type()) {
						case ID_DYLINKER:
						case LOAD_DYLINKER:
						case DYLD_ENVIRONMENT: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new DylinkerCommand(_io__raw_body, this, _root);
							break;
						}
						case REEXPORT_DYLIB:
						case LAZY_LOAD_DYLIB:
						case LOAD_WEAK_DYLIB:
						case ID_DYLIB:
						case LOAD_UPWARD_DYLIB:
						case LOAD_DYLIB: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new DylibCommand(_io__raw_body, this, _root);
							break;
						}
						case BUILD_VERSION: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new BuildVersionCommand(_io__raw_body, this, _root);
							break;
						}
						case SOURCE_VERSION: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new SourceVersionCommand(_io__raw_body, this, _root);
							break;
						}
						case FUNCTION_STARTS:
						case DATA_IN_CODE:
						case LINKER_OPTIMIZATION_HINT:
						case DYLIB_CODE_SIGN_DRS:
						case SEGMENT_SPLIT_INFO: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new LinkeditDataCommand(_io__raw_body, this, _root);
							break;
						}
						case RPATH: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new RpathCommand(_io__raw_body, this, _root);
							break;
						}
						case SUB_FRAMEWORK:
						case SUB_CLIENT:
						case SUB_UMBRELLA:
						case SUB_LIBRARY: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new SubCommand(_io__raw_body, this, _root);
							break;
						}
						case ROUTINES: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new RoutinesCommand(_io__raw_body, this, _root);
							break;
						}
						case DYLD_INFO_ONLY:
						case DYLD_INFO: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new DyldInfoCommand(_io__raw_body, this, _root);
							break;
						}
						case MAIN: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new EntryPointCommand(_io__raw_body, this, _root);
							break;
						}
						case ENCRYPTION_INFO:
						case ENCRYPTION_INFO_64: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new EncryptionInfoCommand(_io__raw_body, this, _root);
							break;
						}
						case DYSYMTAB: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new DysymtabCommand(_io__raw_body, this, _root);
							break;
						}
						case TWOLEVEL_HINTS: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new TwolevelHintsCommand(_io__raw_body, this, _root);
							break;
						}
						case LINKER_OPTION: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new LinkerOptionCommand(_io__raw_body, this, _root);
							break;
						}
						case VERSION_MIN_TVOS:
						case VERSION_MIN_MACOSX:
						case VERSION_MIN_IPHONEOS:
						case VERSION_MIN_WATCHOS: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new VersionMinCommand(_io__raw_body, this, _root);
							break;
						}
						case SEGMENT_64: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new SegmentCommand64(_io__raw_body, this, _root);
							break;
						}
						case SEGMENT: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new SegmentCommand(_io__raw_body, this, _root);
							break;
						}
						case ROUTINES_64: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new RoutinesCommand64(_io__raw_body, this, _root);
							break;
						}
						case SYMTAB: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new SymtabCommand(_io__raw_body, this, _root);
							break;
						}
						case CODE_SIGNATURE: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new CodeSignatureCommand(_io__raw_body, this, _root);
							break;
						}
						case UUID: {
							this._raw_body = this._io.readBytes((size() - 8));
							KaitaiStream _io__raw_body = new ByteBufferKaitaiStream(_raw_body);
							this.body = new UuidCommand(_io__raw_body, this, _root);
							break;
						}
						default: {
							this.body = this._io.readBytes((size() - 8));
							break;
						}
					}
				} else {
					this.body = this._io.readBytes((size() - 8));
				}
			}
		}

		private LoadCommandType type;
		private long size;
		private Object body;
		private final MachO _root;
		private final MachO _parent;
		private byte[] _raw_body;

		public LoadCommandType type() {
			return type;
		}

		public long size() {
			return size;
		}

		public Object body() {
			return body;
		}

		public MachO _root() {
			return _root;
		}

		public MachO _parent() {
			return _parent;
		}

		public byte[] _raw_body() {
			return _raw_body;
		}
	}

	public static class UuidCommand extends KaitaiStruct {
		public UuidCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public UuidCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public UuidCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.uuid = this._io.readBytes(16);
		}

		private byte[] uuid;
		private final MachO _root;
		private final MachO.LoadCommand _parent;

		public byte[] uuid() {
			return uuid;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}
	}

	public static class SymtabCommand extends KaitaiStruct {
		public SymtabCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public SymtabCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public SymtabCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.symOff = this._io.readU4le();
			this.nSyms = this._io.readU4le();
			this.strOff = this._io.readU4le();
			this.strSize = this._io.readU4le();
		}

		public static class StrTable extends KaitaiStruct {
			public StrTable(KaitaiStream _io) {
				this(_io, null, null);
			}

			public StrTable(KaitaiStream _io, MachO.SymtabCommand _parent) {
				this(_io, _parent, null);
			}

			public StrTable(KaitaiStream _io, MachO.SymtabCommand _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.unknown = this._io.readU4le();
				this.items = new ArrayList<>();
				{
					String _it;
					int i = 0;
					do {
						_it = new String(this._io.readBytesTerm(0, false, true, false), StandardCharsets.UTF_8);
						this.items.add(_it);
						i++;
					} while (!(_it.equals("")));
				}
			}

			private long unknown;
			private ArrayList<String> items;
			private final MachO _root;
			private final MachO.SymtabCommand _parent;

			public long unknown() {
				return unknown;
			}

			public ArrayList<String> items() {
				return items;
			}

			public MachO _root() {
				return _root;
			}

			public MachO.SymtabCommand _parent() {
				return _parent;
			}
		}

		public static class Nlist64 extends KaitaiStruct {
			public Nlist64(KaitaiStream _io) {
				this(_io, null, null);
			}

			public Nlist64(KaitaiStream _io, MachO.SymtabCommand _parent) {
				this(_io, _parent, null);
			}

			public Nlist64(KaitaiStream _io, MachO.SymtabCommand _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.un = this._io.readU4le();
				this.type = this._io.readU1();
				this.sect = this._io.readU1();
				this.desc = this._io.readU2le();
				this.value = this._io.readU8le();
			}

			private String name;

			public String name() {
				if (this.name != null)
					return this.name;
				if (un() != 0) {
					long _pos = this._io.pos();
					this._io.seek((_parent().strOff() + un()));
					this.name = new String(this._io.readBytesTerm(0, false, true, true), StandardCharsets.UTF_8);
					this._io.seek(_pos);
				}
				return this.name;
			}

			private long un;
			private int type;
			private int sect;
			private int desc;
			private long value;
			private final MachO _root;
			private final MachO.SymtabCommand _parent;

			public long un() {
				return un;
			}

			public int type() {
				return type;
			}

			public int sect() {
				return sect;
			}

			public int desc() {
				return desc;
			}

			public long value() {
				return value;
			}

			public MachO _root() {
				return _root;
			}

			public MachO.SymtabCommand _parent() {
				return _parent;
			}
		}

		public static class Nlist extends KaitaiStruct {
			public Nlist(KaitaiStream _io) {
				this(_io, null, null);
			}

			public Nlist(KaitaiStream _io, MachO.SymtabCommand _parent) {
				this(_io, _parent, null);
			}

			public Nlist(KaitaiStream _io, MachO.SymtabCommand _parent, MachO _root) {
				super(_io);
				this._parent = _parent;
				this._root = _root;
				_read();
			}

			private void _read() {
				this.un = this._io.readU4le();
				this.type = this._io.readU1();
				this.sect = this._io.readU1();
				this.desc = this._io.readU2le();
				this.value = this._io.readU4le();
			}

			private String name;

			public String name() {
				if (this.name != null)
					return this.name;
				if (un() != 0) {
					long _pos = this._io.pos();
					this._io.seek((_parent().strOff() + un()));
					this.name = new String(this._io.readBytesTerm(0, false, true, true), StandardCharsets.UTF_8);
					this._io.seek(_pos);
				}
				return this.name;
			}

			private long un;
			private int type;
			private int sect;
			private int desc;
			private long value;
			private final MachO _root;
			private final MachO.SymtabCommand _parent;

			public long un() {
				return un;
			}

			public int type() {
				return type;
			}

			public int sect() {
				return sect;
			}

			public int desc() {
				return desc;
			}

			public long value() {
				return value;
			}

			public MachO _root() {
				return _root;
			}

			public MachO.SymtabCommand _parent() {
				return _parent;
			}
		}

		private ArrayList<KaitaiStruct> symbols;

		public ArrayList<KaitaiStruct> symbols() {
			if (this.symbols != null)
				return this.symbols;
			KaitaiStream io = _root._io();
			long _pos = io.pos();
			io.seek(symOff());
			symbols = new ArrayList<>(((Number) (nSyms())).intValue());
			for (int i = 0; i < nSyms(); i++) {
				{
					MagicType on = _root.magic();
					if (on != null) {
						switch (_root.magic()) {
							case MACHO_LE_X64:
							case MACHO_BE_X64: {
								this.symbols.add(new Nlist64(io, this, _root));
								break;
							}
							case MACHO_LE_X86:
							case MACHO_BE_X86: {
								this.symbols.add(new Nlist(io, this, _root));
								break;
							}
						}
					}
				}
			}
			io.seek(_pos);
			return this.symbols;
		}

		private StrTable strs;

		public StrTable strs() {
			if (this.strs != null)
				return this.strs;
			KaitaiStream io = _root._io();
			long _pos = io.pos();
			io.seek(strOff());
			this._raw_strs = io.readBytes(strSize());
			KaitaiStream _io__raw_strs = new ByteBufferKaitaiStream(_raw_strs);
			this.strs = new StrTable(_io__raw_strs, this, _root);
			io.seek(_pos);
			return this.strs;
		}

		private long symOff;
		private long nSyms;
		private long strOff;
		private long strSize;
		private final MachO _root;
		private final MachO.LoadCommand _parent;
		private byte[] _raw_strs;

		public long symOff() {
			return symOff;
		}

		public long nSyms() {
			return nSyms;
		}

		public long strOff() {
			return strOff;
		}

		public long strSize() {
			return strSize;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}

		public byte[] _raw_strs() {
			return _raw_strs;
		}
	}

	public static class VersionMinCommand extends KaitaiStruct {
		public VersionMinCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public VersionMinCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public VersionMinCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.version = new Version(this._io, this, _root);
			this.sdk = new Version(this._io, this, _root);
		}

		private Version version;
		private Version sdk;
		private final MachO _root;
		private final MachO.LoadCommand _parent;

		public Version version() {
			return version;
		}

		public Version sdk() {
			return sdk;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}
	}

	public static class EntryPointCommand extends KaitaiStruct {
		public EntryPointCommand(KaitaiStream _io) {
			this(_io, null, null);
		}

		public EntryPointCommand(KaitaiStream _io, MachO.LoadCommand _parent) {
			this(_io, _parent, null);
		}

		public EntryPointCommand(KaitaiStream _io, MachO.LoadCommand _parent, MachO _root) {
			super(_io);
			this._parent = _parent;
			this._root = _root;
			_read();
		}

		private void _read() {
			this.entryOff = this._io.readU8le();
			this.stackSize = this._io.readU8le();
		}

		private long entryOff;
		private long stackSize;
		private final MachO _root;
		private final MachO.LoadCommand _parent;

		public long entryOff() {
			return entryOff;
		}

		public long stackSize() {
			return stackSize;
		}

		public MachO _root() {
			return _root;
		}

		public MachO.LoadCommand _parent() {
			return _parent;
		}
	}

	private MagicType magic;
	private MachHeader header;
	private ArrayList<LoadCommand> loadCommands;
	private final MachO _root;
	private final KaitaiStruct _parent;

	public MagicType magic() {
		return magic;
	}

	public MachHeader header() {
		return header;
	}

	public ArrayList<LoadCommand> loadCommands() {
		return loadCommands;
	}

	public MachO _root() {
		return _root;
	}

	public KaitaiStruct _parent() {
		return _parent;
	}
}
