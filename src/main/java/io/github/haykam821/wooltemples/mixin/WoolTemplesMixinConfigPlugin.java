package io.github.haykam821.wooltemples.mixin;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import com.google.common.base.Predicates;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.SemanticVersion;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.VersionParsingException;
import net.fabricmc.loader.api.metadata.version.VersionPredicate;

public class WoolTemplesMixinConfigPlugin implements IMixinConfigPlugin {
	private static final String MIXIN_CLASS_PREFIX = "io.github.haykam821.wooltemples.mixin.";
	private static final String MIXIN_CLASS_1_15 = MIXIN_CLASS_PREFIX + "DesertTempleGeneratorMixin115";
	private static final String MIXIN_CLASS_1_16 = MIXIN_CLASS_PREFIX + "DesertTempleGeneratorMixin116";
	private static final String MIXIN_CLASS_1_18 = MIXIN_CLASS_PREFIX + "DesertTempleGeneratorMixin118";
	private static final String MIXIN_CLASS_1_19 = MIXIN_CLASS_PREFIX + "DesertTempleGeneratorMixin119";
	private static final String MIXIN_CLASS_1_19_2 = MIXIN_CLASS_PREFIX + "DesertTempleGeneratorMixin1192";

	private static final Predicate<Version> IS_1_16 = createVersionCompatibility(">=1.16-alpha.20.13.a");
	private static final Predicate<Version> IS_1_18 = createVersionCompatibility(">=1.18-alpha.21.38.a");
	private static final Predicate<Version> IS_1_19 = createVersionCompatibility(">=1.19-alpha.22.14.a");
	private static final Predicate<Version> IS_1_19_2 = createVersionCompatibility(">=1.19.4-alpha.23.7.a");

	@Override
	public void onLoad(String mixinPackage) {
		return;
	}

	@Override
	public String getRefMapperConfig() {
		return null;
	}

	@Override
	public boolean shouldApplyMixin(String targetClass, String mixinClass) {
		if (mixinClass.equals(MIXIN_CLASS_1_15)) {
			return !IS_1_16.test(getMinecraftVersion());
		} else if (mixinClass.equals(MIXIN_CLASS_1_16)) {
			return IS_1_16.test(getMinecraftVersion()) && !IS_1_18.test(getMinecraftVersion());
		} else if (mixinClass.equals(MIXIN_CLASS_1_18)) {
			return IS_1_18.test(getMinecraftVersion()) && !IS_1_19.test(getMinecraftVersion());
		} else if (mixinClass.equals(MIXIN_CLASS_1_19)) {
			return IS_1_19.test(getMinecraftVersion());
		} else if (mixinClass.equals(MIXIN_CLASS_1_19_2)) {
			return IS_1_19_2.test(getMinecraftVersion());
		}
		
		return true;
	}

	@Override
	public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
		return;
	}

	@Override
	public List<String> getMixins() {
		return null;
	}

	@Override
	public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
		return;
	}

	@Override
	public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
		return;
	}

	private static Version getMinecraftVersion() {
		Optional<ModContainer> container = FabricLoader.getInstance().getModContainer("minecraft");

		if (container.isPresent()) {
			Version version = container.get().getMetadata().getVersion();
			if (version instanceof SemanticVersion) {
				return version;
			}
		}

		return null;
	}

	private static Predicate<Version> createVersionCompatibility(String versionRange) {
		try {
			return VersionPredicate.parse(versionRange);
		} catch (VersionParsingException exception) {
			return Predicates.alwaysFalse();
		}
	}	
}